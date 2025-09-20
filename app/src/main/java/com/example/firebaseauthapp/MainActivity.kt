package com.example.firebaseauthapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseauthapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    private var isLoginMode = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        // Verificar se usuário já está logado
        if (auth.currentUser != null) {
            goToHome()
        }

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.loginButton.setOnClickListener {
            val email = binding.emailInput.text.toString().trim()
            val password = binding.passwordInput.text.toString()

            if (validateInput(email, password)) {
                if (isLoginMode) {
                    loginUser(email, password)
                } else {
                    registerUser(email, password)
                }
            }
        }

        binding.registerButton.setOnClickListener {
            toggleMode()
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            showToast("Digite um email")
            return false
        }
        if (password.length < 6) {
            showToast("Senha deve ter pelo menos 6 caracteres")
            return false
        }
        return true
    }

    private fun loginUser(email: String, password: String) {
        showLoading(true)

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                showLoading(false)
                if (task.isSuccessful) {
                    showToast("Login realizado com sucesso!")
                    goToHome()
                } else {
                    showToast("Erro no login: ${task.exception?.message}")
                }
            }
    }

    private fun registerUser(email: String, password: String) {
        showLoading(true)

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                showLoading(false)
                if (task.isSuccessful) {
                    showToast("Conta criada com sucesso!")
                    goToHome()
                } else {
                    showToast("Erro ao criar conta: ${task.exception?.message}")
                }
            }
    }

    private fun toggleMode() {
        isLoginMode = !isLoginMode
        if (isLoginMode) {
            binding.titleText.text = "Login"
            binding.loginButton.text = "Entrar"
            binding.registerButton.text = "Criar Conta"
        } else {
            binding.titleText.text = "Criar Conta"
            binding.loginButton.text = "Registrar"
            binding.registerButton.text = "Já tenho conta"
        }
    }

    private fun showLoading(show: Boolean) {
        binding.progressBar.visibility = if (show) View.VISIBLE else View.GONE
        binding.loginButton.isEnabled = !show
        binding.registerButton.isEnabled = !show
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun goToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
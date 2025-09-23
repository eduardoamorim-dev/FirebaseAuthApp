# Firebase Auth App

Aplicação Android desenvolvida em Kotlin para demonstrar autenticação de usuários utilizando Firebase Authentication.

## Descrição

Este projeto implementa um sistema básico de autenticação permitindo que os usuários criem contas e façam login utilizando email e senha através do Firebase Authentication.


## Demo

<p align="center">
  <img src="https://github.com/user-attachments/assets/e86fb904-e12c-4f98-8172-991b7d2d84af" alt="Imagem 1" width="30%">
  <img src="https://github.com/user-attachments/assets/748144f0-c119-459f-82d0-f4372d06e184" alt="Imagem 2" width="30%">
  <img src="https://github.com/user-attachments/assets/04174ea4-bb68-4e54-8627-83e150a4c08a" alt="Imagem 3" width="30%">
</p>


## Funcionalidades

- Criação de conta com email e senha
- Login de usuários existentes
- Validação de entrada (email obrigatório, senha mínima de 6 caracteres)
- Tela inicial protegida que mostra o email do usuário logado
- Logout com retorno à tela de login
- Interface que alterna entre modo login e registro

## Tecnologias Utilizadas

- **Linguagem**: Kotlin
- **Plataforma**: Android (API 24+)
- **Autenticação**: Firebase Authentication
- **Interface**: View Binding
- **Arquitetura**: Activities com navegação simples

## Estrutura do Projeto

```
app/src/main/java/com/example/firebaseauthapp/
├── MainActivity.kt          # Tela de login/registro
└── HomeActivity.kt          # Tela inicial após login

app/src/main/res/layout/
├── activity_main.xml        # Layout da tela de login
└── activity_home.xml        # Layout da tela inicial
```

## Configuração

### Pré-requisitos

- Android Studio
- SDK Android 24 ou superior
- Conta Firebase
- Arquivo `google-services.json` configurado no projeto

### Como executar

1. Clone o repositório
2. Abra o projeto no Android Studio
3. Configure o Firebase:
   - Crie um projeto no Firebase Console
   - Adicione um app Android ao projeto
   - Baixe o arquivo `google-services.json`
   - Coloque o arquivo na pasta `app/`
4. Execute o projeto em um dispositivo ou emulador

## Uso

1. **Primeira vez**: Clique em "Criar Conta" para alternar para o modo de registro
2. **Registro**: Digite email e senha (mínimo 6 caracteres) e clique em "Registrar"
3. **Login**: Digite suas credenciais e clique em "Entrar"
4. **Tela inicial**: Visualize seu email e use o botão "Sair" para fazer logout

## Validações

- Email não pode estar vazio
- Senha deve ter pelo menos 6 caracteres
- Exibição de mensagens de erro em caso de falha na autenticação

## Autor

Eduardo Amorim

## Notas

Projeto desenvolvido para fins acadêmicos demonstrando integração básica com Firebase Authentication.

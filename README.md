# 🚀 Trabalho Final API - E-commerce REST

API REST desenvolvida em Java com Spring Boot para gerenciamento de um sistema de e-commerce, contendo funcionalidades completas de:

* Cadastro de clientes
* Integração com ViaCEP
* Cadastro de produtos e categorias
* Criação e gerenciamento de pedidos
* Controle de estoque
* Rastreamento de pedidos
* Envio automático de e-mails
* Tratamento global de exceções
* Documentação Swagger/OpenAPI

---

# 📚 Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Hibernate
* Hibernate Envers
* Spring Validation
* JavaMailSender
* Swagger / OpenAPI
* Lombok
* Maven

---

# 🛠️ Funcionalidades

## 👤 Cliente & Endereço

* Cadastro de clientes
* Atualização de clientes
* Busca de clientes
* Integração automática com ViaCEP
* Validação de CPF, e-mail e telefone
* Envio automático de e-mail ao cadastrar/alterar cliente

---

## 📦 Produto & Categoria

* Cadastro de categorias
* Cadastro de produtos
* Relacionamento entre produto e categoria
* Atualização de produtos
* Controle de estoque

---

## 🛒 Pedido & Itens

* Criação de pedidos
* Associação de cliente e produtos
* Atualização de status
* Controle automático de estoque
* Totalização de pedido
* Código de rastreio automático
* Previsão de entrega automática

---

## 🚚 Rastreamento de Pedido

* Busca de pedido pelo código de rastreio
* Consulta do status atual
* Consulta da previsão de entrega

---

## 📧 E-mails Automáticos

* Cadastro realizado
* Alteração de cadastro
* Pedido aprovado
* Pedido atualizado
* Pedido cancelado

---

## ⚠️ Tratamento de Erros

* Exceptions customizadas
* ControllerAdvice global
* Respostas padronizadas
* Tratamento de:

  * CPF duplicado
  * CEP inválido
  * Produto inexistente
  * Estoque insuficiente
  * Pedido não encontrado
  * Cliente não encontrado

---

# 🧩 Estrutura do Projeto

```bash
src/main/java
│
├── controller
├── service
├── repository
├── entity
├── model
├── exception
├── config
└── dto
```

---

# 🔗 Integração ViaCEP

API utilizada:

```bash
https://viacep.com.br/ws/{cep}/json/
```

Ao cadastrar um cliente:

* o CEP é consultado automaticamente;
* o endereço é preenchido automaticamente.

---

# 📧 Configuração de E-mail

O sistema utiliza SMTP do Gmail através do JavaMailSender.

---

# 🔐 Variáveis de Ambiente

## application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=postgres
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=${EMAIL_USERNAME}
spring.mail.password=${EMAIL_PASSWORD}

spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

---

# 🪟 Configurando Variáveis de Ambiente no Windows

## 1. Pesquise:

```bash
Variáveis de Ambiente
```

## 2. Clique em:

```bash
Editar variáveis de ambiente do sistema
```

## 3. Clique em:

```bash
Variáveis de Ambiente
```

## 4. Em “Variáveis do Usuário”, clique em:

```bash
Novo
```

## 5. Crie:

### EMAIL_USERNAME

```bash
seuemail@gmail.com
```

### EMAIL_PASSWORD

```bash
senha_de_app_do_gmail
```

### DB_PASSWORD

```bash
senha_do_postgres
```

## 6. Reinicie a IDE

---

# 🍎 Configurando Variáveis de Ambiente no macOS

Abra o terminal e execute:

```bash
export EMAIL_USERNAME="seuemail@gmail.com"
export EMAIL_PASSWORD="senha_de_app_do_gmail"
export DB_PASSWORD="senha_do_postgres"
```

Depois:

```bash
source ~/.zshrc
```

ou:

```bash
source ~/.bash_profile
```

Reinicie a IDE após configurar.

---

# 🔑 Senha de App do Gmail

Para utilizar o envio de e-mails:

1. Ative a autenticação em 2 fatores na conta Google
2. Vá em:

```bash
Conta Google → Segurança → Senhas de App
```

3. Gere uma senha para:

```bash
Mail
```

4. Utilize a senha gerada na variável:

```bash
EMAIL_PASSWORD
```

---

# 🗄️ Banco de Dados

Banco utilizado:

```bash
PostgreSQL
```

Criar database:

```sql
CREATE DATABASE ecommerce;
```

---

# 📖 Swagger/OpenAPI

Após iniciar o projeto:

```bash
http://localhost:8080/swagger-ui/index.html
```

Documentação completa da API disponível via Swagger UI.

---

# ▶️ Como Executar o Projeto

## 1. Clone o repositório

```bash
git clone https://github.com/natasha-mendonca/Trabalho-Final-API.git
```

---

## 2. Abra na IDE

Recomendado:

* IntelliJ IDEA
* VSCode
* Eclipse

---

## 3. Configure:

* PostgreSQL
* Variáveis de ambiente
* application.properties

---

## 4. Execute a aplicação

Classe principal:

```bash
TrabalhoFinalApiApplication.java
```

---

# 🧪 Exemplos de Funcionalidades

## ✅ Cadastro de Cliente

* integração ViaCEP;
* envio de e-mail automático.

## ✅ Criação de Pedido

* baixa automática de estoque;
* geração automática de rastreio;
* previsão automática de entrega.

## ✅ Rastreamento

```bash
GET /pedido/rastreio/{codigoRastreio}
```

---

# 👨‍💻 Integrantes do Grupo

* Arthur Carvalho
* Luísa Abreu
* Natasha Mendonça
* Pedro Dayer
* Wenderson Azevedo

---

# 📌 Observações

Projeto desenvolvido como Trabalho Final utilizando:

* Java
* Spring Boot
* Arquitetura REST
* Integrações externas
* Boas práticas de backend

---

# 📄 Licença

Projeto acadêmico desenvolvido para fins educacionais.

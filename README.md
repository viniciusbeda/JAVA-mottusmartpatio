# ✅ Mottu Smart Pátio - API

## 📄 Descrição do Projeto

Este projeto consiste em uma API REST desenvolvida em **Java**, utilizando **Spring Boot** com **Spring Data JPA** e **banco de dados H2** em memória.

A API simula o gerenciamento de uma frota de motocicletas para o sistema **Mottu Smart Pátio**, possibilitando:

- Cadastro e listagem de **motos**.
- Registro e consulta de **manutenções** associadas a cada moto.
- Integração com o banco H2 para fácil persistência e consulta dos dados.
- Console administrativo via **H2 Console**.

---

## 👨‍💻 Equipe de Desenvolvimento

- **Vinicius Beda de Oliveira** - RM: 554914
- **Thiago Alves dos Santos** - RM: 556805
- **Humberto de Souza** - RM: 558482

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.2.5
- Spring Data JPA
- Banco de dados H2
- Maven
- Lombok
- Hibernate ORM

---

## 📁 Estrutura das Entidades

### 🏍️ Moto

| Campo  | Tipo   |
| ------ | ------ |
| id     | Long   |
| placa  | String |
| modelo | String |
| status | String |

---

### 🛠️ Manutenção

| Campo     | Tipo      |
| --------- | --------- |
| id        | Long      |
| descricao | String    |
| data      | LocalDate |
| moto      | Moto      |

---

## ⚙️ Como Executar o Projeto

### ✅ Pré-requisitos

- **Java 21** ou superior instalado.
- **Maven** instalado.
- IDE: IntelliJ, Eclipse, VSCode ou outro de sua preferência.

---

### ✅ Passos

1. **Clone o repositório:**

```bash
git clone <url-do-repositório>
cd mottu-api
```

'''

---

## Execute o projeto com Maven:

mvn spring-boot:run
Acesse o sistema:

API: http://localhost:8080

Console do Banco: http://localhost:8080/h2-console

## Configurações H2 Console:

JDBC URL: jdbc:h2:mem:testdb

Username: SA

Password: (deixe em branco)

## 🛠️ Configurações Importantes

## Arquivo: src/main/resources/application.properties

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=SA
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=create
spring.datasource.initialization-mode=always
spring.jpa.defer-datasource-initialization=true

spring.h2.console.enabled=true

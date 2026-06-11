# 🏦 Bank Account Management System

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Backend-brightgreen)
![Spring Security](https://img.shields.io/badge/Spring%20Security-JWT-success)
![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-blue)
![Docker](https://img.shields.io/badge/Docker-Partial%20Setup-2496ED)
![Status](https://img.shields.io/badge/Status-Completed-success)

A secure and scalable **Bank Account Management System** built using **Java Spring Boot**. This backend application provides banking functionalities such as **account holder management, bank account creation, deposits, withdrawals, transaction history, and secure authentication using JWT & Spring Security**.

This project was developed as part of an **internship project** to gain hands-on experience in building secure, real-world backend systems using industry-standard technologies and architecture.

---

# 🚀 Features

## 🔐 Authentication & Security

* JWT Authentication using **Spring Security**
* Role-Based Authorization (`ADMIN`, `USER`)
* Password Encryption using **BCryptPasswordEncoder**
* Secure API Access with Protected Endpoints
* Custom JWT Authentication Filter

---

## 👨‍💼 Admin Features (`/api/admin/**`)

Admin has full system access and can:

* Create Users
* Create Account Holders
* Create Bank Accounts
* Update User Details
* Access All User Data
* Manage Banking Data Across the System

### Smart Entity Creation

Admin can create all related entities in **a single request** using one JSON payload.

For example, while creating a user, the system can automatically:

* Create `User`
* Create `AccountHolder`
* Create `BankAccount`
* Establish all required relationships automatically

Example request:

```json
{
  "username": "John",
  "password": "password123",
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "9876543210",
  "address": "New Delhi, India",
  "accountType": "SAVINGS"
}
```

The system automatically handles entity relationships such as:

```text
User → AccountHolder
BankAccount → AccountHolder
Transaction → BankAccount
```

### Manual Entity Management

Admin can also manage entities manually by creating them separately.

Example workflow:

1. Create `AccountHolder`
2. Create `User` and assign `AccountHolder ID`
3. Create `BankAccount` and assign related IDs
4. Manage transactions separately

This provides flexibility for both **simplified creation** and **manual relationship management**.

---

## 👤 User Features (`/api/user/**`)

Authenticated users can:

* View Their Own Profile
* Check Account Information
* Deposit Money
* Withdraw Money
* View Their Transaction History

### Supported Transactions

✅ Deposit Money
✅ Withdraw Money
❌ Fund Transfer *(Not Implemented Yet)*

---

## ✅ Validation & Exception Handling

* Request Validation using Spring Validation
* Global Exception Handling
* Centralized Error Responses
* Proper HTTP Status Codes

---

# 🛠️ Tech Stack

## Backend

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* JWT Authentication

## Database

* PostgreSQL

## DevOps / Tools

* Docker
* Docker Compose
* pgAdmin
* Maven
* Git & GitHub
* IntelliJ IDEA

---

# 📁 Project Structure

```text
src
└── main
    ├── java
    │   └── com.app.Bank_Account_Management_System
    │       ├── config
    │       ├── controller
    │       ├── dto
    │       ├── exception
    │       ├── model
    │       ├── repository
    │       ├── security
    │       ├── service
    │       └── BankAccountManagementSystemApplication
    │
    └── resources
        ├── static
        └── templates
```

---

# 🔐 API Access Control

### Admin APIs

```text
/api/admin/**
```

Accessible only by users with **ADMIN role**.

### User APIs

```text
/api/user/**
```

Accessible only by authenticated users with **USER role**.

---

# 🗄️ Database Configuration

This project uses **PostgreSQL** as the primary database.

> **Note:**
> H2 dependency and configuration exist in the project but are currently commented out and not used.

---

# 🐳 Docker Support

This project includes **partial Dockerization**.

### Available Docker Containers

✅ PostgreSQL Container
✅ pgAdmin Container

### Not Yet Dockerized

⏳ Spring Boot Application Container

The Spring Boot application is currently running locally and has **not been containerized yet**. Full Dockerization may be added in future updates.

---

# ⚙️ How to Run the Project

## Prerequisites

Make sure the following tools are installed on your system:

### Required Software

* **Java 21** *(Recommended — project is built using Java 21)*
* Maven
* Docker Desktop
* PostgreSQL *(via Docker container)*
* pgAdmin *(via Docker container)*
* Git

> **Important:**
> This project is developed using **Java 21**, so using the same version is highly recommended to avoid compatibility issues.

---

## 1. Clone the Repository

```bash
git clone https://github.com/Chetan95263/Bank-Account-Management-System.git
```

---

## 2. Navigate to Project Directory

```bash
cd Bank-Account-Management-System
```

---

## 3. Start Docker Containers

Before running the Spring Boot application, start the required database containers using Docker Compose.

Run:

```bash
docker-compose up -d
```

This will start:

* PostgreSQL Container
* pgAdmin Container

To verify running containers:

```bash
docker ps
```

---

## 4. Configure Environment Variables

Configure the required environment variables before starting the application.

Example:

```env
JWT_SECRET=your_secret_key
```

Also configure your PostgreSQL credentials in:

```properties
application.yml
```

Ensure the database configuration matches your Docker setup.

---

## 5. Build the Project

### Windows

```bash
mvnw.cmd clean install
```

### Linux / Mac

```bash
./mvnw clean install
```

---

## 6. Run the Spring Boot Application

### Using IntelliJ IDEA

Run:

```text
BankAccountManagementSystemApplication
```

### Using Maven

#### Windows

```bash
mvnw.cmd spring-boot:run
```

#### Linux / Mac

```bash
./mvnw spring-boot:run
```

---

## 7. Verify Application

Once the application starts successfully:

### Spring Boot API

```text
http://localhost:8080
```

### pgAdmin

```text
http://localhost:5050
```

*(Port may vary based on your Docker Compose configuration.)*

---

## 8. Stop Docker Containers

When finished, stop containers using:

```bash
docker-compose down
```

---

# 🔮 Future Improvements

* Fund Transfer Functionality
* Full Dockerization (Spring Boot Container)
* API Rate Limiting


---

# 📌 Project Status

* ✅ Core Features Completed
* ✅ Authentication & Authorization Completed
* ✅ Banking Transactions Implemented
* ✅ PostgreSQL Integration Completed
* ✅ Partial Docker Setup Completed

🚀 **Currently complete and ready for future improvements.**

---

# 🤝 Contribution

This project is currently developed for learning and internship purposes, but suggestions and improvements are always welcome.

---

# 📜 License

This project is developed for **educational and internship purposes**.

# Bank Account Management System

A backend application built using **Java Spring Boot** for managing bank account operations such as account holder management, account creation, transactions, and other banking functionalities.

This project is being developed as part of my internship to improve backend development skills and understand real-world banking system architecture.

---

## 🚀 Features

### Current Features

* Account Holder Management
* REST APIs for CRUD Operations
* Request Validation
* H2 Database Integration
* Layered Architecture (Controller, Service, Repository)

### Upcoming Features

* Bank Account Management
* Deposit & Withdrawal Transactions
* Global Exception Handling
* PostgreSQL Integration
* Docker Support

---

## 🛠️ Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate

### Database

* H2 Database

### Tools

* Maven
* Git & GitHub
* IntelliJ IDEA

---

## 📁 Project Structure

```text
src
 ├── controller
 ├── service
 ├── repository
 ├── entity
 └── dto
```

---

## ⚙️ How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/Chetan95263/Bank-Account-Management-System.git
```

### 2. Navigate to Project Directory

```bash
cd Bank-Account-Management-System
```

### 3. Build the Project

Using Maven Wrapper:

#### Windows

```bash
mvnw.cmd clean install
```

#### Linux / Mac

```bash
./mvnw clean install
```

### 4. Run Spring Boot Application

#### Using IntelliJ IDEA

Open the project and run the main Spring Boot application class.

#### Using Maven

##### Windows

```bash
mvnw.cmd spring-boot:run
```

##### Linux / Mac

```bash
./mvnw spring-boot:run
```

---

## 🗄️ Database

This project currently uses **H2 Database** for development and testing purposes.

You can access the H2 console after running the application:

```text
http://localhost:8080/h2-console
```

---

## 📌 Current Status

🚧 Project is currently under active development as part of an internship project.

### Task Progress

* ✅ Task 1: Account Holder Module
* ⏳ Task 2: Bank Account Module
* ⏳ Task 3: Transaction Module

---

## 🔮 Future Improvements

* PostgreSQL Integration
* Docker Support

---

## 📜 License

This project is developed for educational and internship purposes.

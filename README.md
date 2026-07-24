# 📚 Library Management System

A RESTful Library Management System built using Spring Boot.

This project allows administrators and users to manage books, categories, users, and borrow records securely using JWT Authentication.

The project is Dockerized and uses MySQL as the database.

## 🚀 Features

- User Registration & Login
- JWT Authentication & Authorization
- Role-Based Access Control (ADMIN & USER)
- Book Management (CRUD)
- Category Management (CRUD)
- Borrow & Return Books
- File Upload Support
- Input Validation
- Global Exception Handling
- Pagination & Sorting
- RESTful APIs
- Swagger API Documentation
- Docker & Docker Compose Support
- MySQL Database Integration

## 🛠️ Technologies Used

- Java 21
- Spring Boot 4
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- Docker
- Docker Compose
- Swagger / OpenAPI
- IntelliJ IDEA

## ▶️ How to Run the Project

### Prerequisites

Make sure you have installed:

- Java 21
- Maven
- Docker Desktop
- Git

### Clone the Repository

```bash
git clone https://github.com/your-username/LibraryMS.git
cd LibraryMS
```

### Run with Docker

```bash
docker-compose up --build
```

The application will start on:

```
http://localhost:8080
```

### Swagger API Documentation

Open:

```
http://localhost:8080/swagger-ui/index.html
```

## 📁 Project Structure

```
LibraryMS
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
├── Dockerfile
├── docker-compose.yml
├── pom.xml
├── README.md
└── .gitignore
```

## 👨‍💻 Author

**Adarsh Sonawane**

- Java Backend Developer
- Spring Boot Developer
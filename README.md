# 📚 Library Management System

A production-ready **Library Management System REST API** built with **Spring Boot** following modern backend development practices.

The application provides secure authentication using **JWT**, role-based authorization, book management, category management, borrowing system, file upload support, Swagger documentation, and Docker deployment.

---

# 🚀 Features

### 🔐 Authentication & Security
- JWT Authentication
- Spring Security
- Role-Based Authorization (ADMIN / USER)
- Password Encryption using BCrypt

### 👥 User Management
- User Registration
- User Login
- User CRUD Operations

### 📖 Book Management
- Add Book
- Update Book
- Delete Book
- View Books
- Search Books
- Pagination
- Sorting

### 📂 Category Management
- Create Category
- Update Category
- Delete Category
- View Categories

### 📚 Borrow Management
- Borrow Book
- Return Book
- Borrow History
- Borrow Status Tracking

### 📤 File Upload
- Upload Book Images

### ✅ Validation & Exception Handling
- Bean Validation
- Global Exception Handling
- Custom Exception Classes

### 📄 API Documentation
- Swagger / OpenAPI

### 🐳 Deployment
- Docker
- Docker Compose

---

# 🛠 Tech Stack

| Technology | Version |
|------------|----------|
| Java | 21 |
| Spring Boot | 4 |
| Spring Security | Latest |
| Spring Data JPA | Hibernate |
| MySQL | 8 |
| JWT | JSON Web Token |
| Maven | Latest |
| Docker | Latest |
| Swagger | OpenAPI 3 |
| IntelliJ IDEA | IDE |

---

# 📂 Project Structure

```text
LibraryMS
│
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│
├── Dockerfile
├── docker-compose.yml
├── pom.xml
├── README.md
└── .gitignore
```

---

# ⚙️ Installation

## Clone the Repository

```bash
git clone https://github.com/adarsh8106/LibraryMS.git
```

```bash
cd LibraryMS
```

---

# ▶️ Run using Docker

```bash
docker-compose up --build
```

Application will start at

```
http://localhost:8080
```

---

# 📖 Swagger Documentation

Open your browser

```
http://localhost:8080/swagger-ui/index.html
```

---

# 🔑 Authentication

Login using

```
POST /login
```

Use the returned JWT token in

```
Authorization

Bearer <your_token>
```

to access secured endpoints.

---

# 📌 REST APIs

### Authentication
- POST /login

### Users
- POST /users
- GET /users
- PUT /users/{id}
- DELETE /users/{id}

### Books
- POST /books
- GET /books
- PUT /books/{id}
- DELETE /books/{id}

### Categories
- POST /categories
- GET /categories
- PUT /categories/{id}
- DELETE /categories/{id}

### Borrow
- POST /borrow
- GET /borrow
- PUT /borrow/{id}
- DELETE /borrow/{id}

---

# 🔮 Future Improvements

- Email Notifications
- Book Reservation
- Fine Calculation
- Admin Dashboard
- Unit Testing
- CI/CD Pipeline
- Cloud Deployment (Render / Railway / AWS)

---

# 👨‍💻 Author

**Adarsh Sonawane**

GitHub:
https://github.com/adarsh8106

---

## ⭐ Support

If you like this project, don't forget to ⭐ star the repository.
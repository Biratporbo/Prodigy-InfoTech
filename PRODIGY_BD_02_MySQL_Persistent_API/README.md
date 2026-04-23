<div align="center">

  # 🗄️ Task 02: MySQL Persistent REST API
  
  **An enterprise-grade Backend Web Development project demonstrating Database Persistence, Object-Relational Mapping (ORM), and Automated Schema Migrations.**
  
  ![Java](https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
  ![Spring Boot](https://img.shields.io/badge/Spring_Boot_3-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
  ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
  ![Flyway](https://img.shields.io/badge/Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white)

</div>

---

## 📝 Project Overview

This project was developed as **Task 02** during my Backend Web Development Internship at **Prodigy InfoTech**. 

Building upon the foundational routing from Task 01, this project successfully transitions the application from temporary in-memory storage to a fully persistent, robust **MySQL** relational database. It implements industry-standard tools for database communication and version control.

## ✨ Key Features & Architecture

* **Database Persistence:** Integrated MySQL to ensure user data survives server restarts and crashes.
* **Spring Data JPA (Hibernate):** Utilized advanced ORM to map plain old Java objects (POJOs) directly to database tables, drastically reducing SQL boilerplate code.
* **Automated Database Migrations:** Implemented **Flyway** to strictly version-control database schema changes (e.g., `V1__Create_users_table.sql`). This ensures consistent database structures across all development and production environments.
* **Connection Pooling:** Configured **HikariCP** (Spring Boot's default) for optimized, high-performance database connection management.
* **Environment Configuration:** Abstracted sensitive database credentials using `application.properties` and environment variables.

---

## 🗂️ Database Schema

The API manages a `users` table automatically generated and tracked by Flyway. 

| Column | Data Type | Constraints |
| :--- | :--- | :--- |
| `id` | `INT` | Primary Key, Auto Increment |
| `name` | `VARCHAR(255)` | Not Null |
| `email` | `VARCHAR(255)` | Not Null, Unique |
| `age` | `INT` | Not Null, Check (age >= 0) |

---

## 🛣️ API Endpoints

| HTTP Method | Endpoint | Description | Expected Status |
| :--- | :--- | :--- | :---: |
| `POST` | `/api/users` | Saves a new user to the MySQL Database | `201 Created` |
| `GET` | `/api/users` | Fetches all users from the database | `200 OK` |
| `PUT` | `/api/users/{id}` | Updates a user's record in the database | `200 OK` |
| `DELETE`| `/api/users/{id}` | Permanently removes a user | `204 No Content` |

---

## 🚀 How to Run Locally

### Prerequisites
* **Java 17+** and **Maven** installed.
* **MySQL Server** installed and running on default port `3306`.

### Setup Steps
1. Open MySQL Workbench (or your terminal) and create a blank database:
```sql
    CREATE DATABASE user_db;
```

2. Clone the repository and navigate to this project folder:
```Bash
    cd PRODIGY_BD_02_MySQL_Persistent_API
```

3. Open src/main/resources/application.properties and verify your database credentials:
```Java
    spring.datasource.url=jdbc:mysql://localhost:3306/user_db
    spring.datasource.username=YOUR_MYSQL_USERNAME
    spring.datasource.password=YOUR_MYSQL_PASSWORD
```

4. Run the Spring Boot application:
```Bash
    ./mvnw spring-boot:run
```

5. Flyway will automatically detect the empty database and create the users table for you upon startup! You can now use Postman to send requests to `http://localhost:8080/api/users`.
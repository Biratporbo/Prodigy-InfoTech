<div align="center">

  # 🛠️ Task 01: In-Memory REST API
  
  **A foundational Backend Web Development project demonstrating core RESTful architecture, HTTP methods, and data validation.**
  
  ![Java](https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
  ![Spring Boot](https://img.shields.io/badge/Spring_Boot_3-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
  ![Postman](https://img.shields.io/badge/Tested_with-Postman-FF6C37?style=for-the-badge&logo=postman)

</div>

---

## 📝 Project Overview

This project was developed as **Task 01** during my Backend Web Development Internship at **Prodigy InfoTech**. 

The primary objective of this task was to build a fully functional REST API without relying on an external database. Instead, it utilizes Java's `ConcurrentHashMap` to store data in the server's temporary memory. This approach isolates the learning focus to API routing, HTTP status codes, and data handling.

## ✨ Key Features Implemented

* **Full CRUD Operations:** Create, Read, Update, and Delete user records.
* **Thread-Safe Storage:** Utilized `ConcurrentHashMap` to ensure data integrity during simultaneous API requests.
* **Input Validation:** Integrated `Jakarta Validation` (`@Valid`, `@Email`, `@Min`) to ensure only clean, properly formatted data enters the system.
* **Global Exception Handling:** Implemented a custom `@ControllerAdvice` class to catch validation errors and return structured, readable JSON error responses (e.g., `400 Bad Request`) instead of raw server stack traces.

---

## 🛣️ API Endpoints

The API handles `User` objects, which include an auto-generated ID, Name, Email, and Age.

| HTTP Method | Endpoint | Description | Expected Status |
| :--- | :--- | :--- | :---: |
| `POST` | `/api/users` | Creates a new user | `201 Created` |
| `GET` | `/api/users` | Retrieves a list of all users | `200 OK` |
| `PUT` | `/api/users/{id}` | Updates an existing user by ID | `200 OK` |
| `DELETE`| `/api/users/{id}` | Deletes a user by ID | `204 No Content` |

### Example Request (POST)
```json
{
  "name": "Alice Smith",
  "email": "alice@example.com",
  "age": 28
}
```

---

## 🚀 How to Run Locally

- 1.Ensure you have Java 17+ and Maven installed on your machine.

- 2.Clone the repository and navigate to this specific project folder:

```Bash
`cd PRODIGY_BD_01_In_Memory_API`
```

- 3.Run the Spring Boot application using the Maven wrapper:

```Bash
`./mvnw spring-boot:run`
```

- 4.The server will start on `http://localhost:8080`.

- 5.Use Postman or cURL to interact with the `/api/users` endpoints.

- *(Note: Because this API uses in-memory storage, all data will be cleared whenever the server restarts.)*
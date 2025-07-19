# Quiz Service

This module handles all operations related to quizzes in the QuizApp microservices architecture.

---

## 📘 API Endpoints

### ➕ Create a Quiz
- **Method:** POST  
- **Endpoint:** `/api/quizzes`  
- **Description:** Creates a new quiz.  
- **Request Body:** JSON containing quiz details.

### 📋 Get All Quizzes
- **Method:** GET  
- **Endpoint:** `/api/quizzes`  
- **Description:** Retrieves a list of all quizzes.

### 🔍 Get Quiz by ID
- **Method:** GET  
- **Endpoint:** `/api/quizzes/{id}`  
- **Description:** Retrieves a specific quiz by its ID.

### ✏️ Update a Quiz
- **Method:** PUT  
- **Endpoint:** `/api/quizzes/{id}`  
- **Description:** Updates an existing quiz.  
- **Request Body:** JSON with updated quiz details.

### ❌ Delete a Quiz
- **Method:** DELETE  
- **Endpoint:** `/api/quizzes/{id}`  
- **Description:** Deletes a quiz by its ID.

---

## ⚙️ Configuration

Configuration settings can be found in:  
`src/main/resources/application.properties`

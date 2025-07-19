# Question Service

This module handles all operations related to questions in the QuizApp microservices architecture.

---

## 📘 API Endpoints

### ➕ Create a Question
- **Method:** POST  
- **Endpoint:** `/api/questions`  
- **Description:** Creates a new question.  
- **Request Body:** JSON containing question details.

### 📋 Get All Questions
- **Method:** GET  
- **Endpoint:** `/api/questions`  
- **Description:** Retrieves a list of all questions.

### 🔍 Get Question by ID
- **Method:** GET  
- **Endpoint:** `/api/questions/{id}`  
- **Description:** Retrieves a specific question by its ID.

### ✏️ Update a Question
- **Method:** PUT  
- **Endpoint:** `/api/questions/{id}`  
- **Description:** Updates an existing question.  
- **Request Body:** JSON with updated question details.

### ❌ Delete a Question
- **Method:** DELETE  
- **Endpoint:** `/api/questions/{id}`  
- **Description:** Deletes a question by its ID.

---

## ⚙️ Configuration

Configuration settings can be found in:  
`src/main/resources/application.properties`

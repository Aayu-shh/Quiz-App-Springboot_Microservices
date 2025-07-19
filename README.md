# QuizApp Microservices

QuizApp is a microservices-based application built using **Java**, **Spring Boot**, and **Maven**. It is designed to manage quizzes and questions with a modular architecture, including services for API Gateway, Question Management, Quiz Management, and Service Registry.

---

## 📁 Project Structure

```
quizApp/
├── README.md
├── quiz-service/
│   ├── src/
│   └── pom.xml
├── question-service/
│   ├── src/
│   └── pom.xml
├── eureka-service-registry/
│   ├── src/
│   └── pom.xml
└── api-gateway/
    ├── src/
    └── pom.xml
```

---

## 🧩 Modules

- **API Gateway**  
  Acts as the single entry point for all client requests and routes them to the appropriate microservice.

- **Question Service**  
  Provides CRUD operations for managing quiz questions.

- **Quiz Service**  
  Handles quiz creation, storage, and business logic.

- **Service Registry (Eureka)**  
  Enables service discovery and registration for the microservices.

---

## ✅ Prerequisites

Make sure you have the following installed:

- **Java 17+**
- **Maven 3.8+**
- **Spring Boot 3.x**
- **Eureka Server** (auto-configured in the service-registry module)

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Aayu-shh/quizApp-microservices.git
cd quizApp-microservices
```

### 2. Build All Modules

Navigate to the root folder or each individual module and run:

```bash
mvn clean install
```

### 3. Run the Services (in order)

#### a. Start the Service Registry

```bash
cd eureka-service-registry
mvn spring-boot:run
```

#### b. Start the API Gateway

```bash
cd api-gateway
mvn spring-boot:run
```

#### c. Start the Question Service

```bash
cd question-service
mvn spring-boot:run
```

#### d. Start the Quiz Service

```bash
cd quiz-service
mvn spring-boot:run
```

---

## ⚙️ Configuration

Each service contains its own `application.properties` file located under:

```
src/main/resources/application.properties
```

You can update these files based on your local or cloud environment (e.g., port, Eureka settings, DB config).

---

## 🛠️ Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Cloud** (Eureka, Gateway)
- **OpenFeign Client**
- **Maven**

---

## 📌 Notes

- For local development, default ports are configured to avoid conflicts.
- Services automatically register with Eureka if registry is up and reachable.

---

Feel free to contribute or raise issues via GitHub. Happy coding! 🎯

# 🏥 Medico - Medical Information Management System

## 📌 Project Overview

Medico is a Spring Boot based Medical Information Management System that helps manage medical data such as diseases, symptoms, drugs, and categories through a user-friendly web interface.

The application allows healthcare administrators or medical researchers to organize and maintain disease-related information efficiently.

---

## 🚀 Features

### 📂 Category Management

* Add new disease categories
* View all categories
* Edit category information
* Delete categories

### 🦠 Disease Management

* Add diseases
* Associate diseases with categories
* View disease details
* Update disease information
* Delete diseases

### 🤒 Symptom Management

* Add symptoms
* Associate symptoms with diseases
* View symptom list
* Update symptom details
* Delete symptoms

### 💊 Drug Management

* Add drugs
* Associate drugs with diseases
* View drug information
* Update drug details
* Delete drugs

### 📊 Dashboard

* Centralized navigation
* Modern sidebar layout
* Easy access to all modules

---

## 🏗️ System Architecture

```text
User
  │
  ▼
Thymeleaf UI
  │
  ▼
Controller Layer
  │
  ▼
Service Layer
  │
  ▼
Repository Layer
  │
  ▼
MySQL Database
```

---

## 🛠️ Technology Stack

### Backend

* Java 17
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate

### Frontend

* Thymeleaf
* HTML5
* CSS3
* Bootstrap 5

### Database

* MySQL

### Build Tool

* Maven

### Version Control

* Git
* GitHub

---

## 📁 Project Structure

```text
src
│
├── controller
│   ├── CategoryController
│   ├── DiseaseController
│   ├── SymptomController
│   └── DrugController
│
├── service
│   ├── CategoryService
│   ├── DiseaseService
│   ├── SymptomService
│   └── DrugService
│
├── repository
│   ├── CategoryRepository
│   ├── DiseaseRepository
│   ├── SymptomRepository
│   └── DrugRepository
│
├── entity
│   ├── Category
│   ├── Disease
│   ├── Symptom
│   └── Drug
│
└── templates
    ├── dashboard.html
    ├── categories.html
    ├── diseases.html
    ├── symptom-list.html
    └── drugs.html
```

---

## 🗄️ Database Design

### Category

| Field       | Type   |
| ----------- | ------ |
| id          | Long   |
| name        | String |
| description | String |

### Disease

| Field       | Type     |
| ----------- | -------- |
| id          | Long     |
| diseaseName | String   |
| description | String   |
| category    | Category |

### Symptom

| Field       | Type    |
| ----------- | ------- |
| id          | Long    |
| symptomName | String  |
| description | String  |
| disease     | Disease |

### Drug

| Field    | Type    |
| -------- | ------- |
| id       | Long    |
| drugName | String  |
| dosage   | String  |
| disease  | Disease |

---

## 🔄 Application Workflow

1. Create Categories
2. Add Diseases under Categories
3. Add Symptoms for Diseases
4. Add Drugs for Diseases
5. View and Manage Medical Information from Dashboard

---

## ▶️ How to Run

### Clone Repository

```bash
git clone https://github.com/HimaVachhani/Medico.git
```

### Navigate to Project

```bash
cd Medico
```

### Configure MySQL

Update:

```properties
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/medico
spring.datasource.username=root
spring.datasource.password=your_password
```

### Run Application

```bash
mvn spring-boot:run
```

### Access Application

```text
http://localhost:8080/dashboard
```

---

## 📈 Future Enhancements

* Search functionality
* Pagination
* Spring Security
* JWT Authentication
* Role-Based Access Control
* REST API Documentation
* Flyway Database Migration
* Docker Support
* Microservices Architecture

---

## 👩‍💻 Author

**Hima Vachhani**

Software Engineer | Java Developer

Focused on:

* Java
* Spring Boot
* Microservices
* REST APIs
* MySQL

---

## ⭐ If you found this project useful

Please consider giving the repository a star.

# Spring Boot Task Management API

A simple RESTful API for managing tasks built with Spring Boot.

## Features

- Create, read, update, and delete tasks
- Exception handling with meaningful HTTP responses
- Validation and error responses
- CORS support (if configured)
- Connected to a database (e.g., MySQL, H2)

## Prerequisites

- Java 17+ (or compatible JDK)
- Maven 3.6+
- A running database (MySQL, PostgreSQL, H2, etc.)
- IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)
- Testing rest API (Postman)

## Getting Started

### Clone the repository

```bash
git clone https://github.com/Leader-19/Backend_api_Chipmong_bank
cd Backend_api_Chipmong_bank

### API end point

### Get all the user and use with get method

/api/tasks

### get task by id and use with get method

/api/tasks/{id}

### update method use with method put

/api/tasks/{id}

### create task use with method post

/api/tasks

### delete task use with method delete

/api/tasks/{id}

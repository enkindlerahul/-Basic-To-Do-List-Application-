# ToDo List Application with Spring Boot

Efficiently manage tasks using our Spring Boot ToDo List app. Add, view, and delete tasks via REST API with in-memory database storage. Enjoy smooth task management with error-free interactions and concise API endpoints.

Certainly! Here's a professional README file that summarizes the setup, features, and usage of your Spring Boot ToDo List application:

# Table of Contents

- [Description](#description)
- [Requirements](#requirements)
- [Setup](#setup)
- [Mysql Database](#mysql)
- [Features](#features)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Example Requests](#example-requests)
- [Error Handling](#error-handling)


## Description

This is a basic To-Do List application built using Spring Boot. It allows users to manage tasks by providing features to add, view, and delete tasks. The application uses Mysql database and provides REST API endpoints to interact with tasks.

## Requirements

- Java 1.8 
- Spring Boot
- MySQL database
- Postman (for testing API endpoints)

## Setup

1. Clone or download this repository to your local machine.
2. Set up your MySQL database and update the database configuration in `src/main/resources/application.properties`.

# My Mysql database:
   
# Database Configuration
  spring.datasource.url=jdbc:mysql://localhost:3306/todo_list_db?useSSL=false&serverTimezone=UTC    ----Add your Mysql database
  name my Mysql Database name is -----> todo_list_db

  spring.datasource.username=**** ----------Add your username   

  
  spring.datasource.password=**** ----------Add your passowrd

# Hibernate Configuration
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


4. Open the project in your preferred Java development environment (e.g., IntelliJ IDEA, Eclipse).
5. Build and run the application using Spring Boot's embedded Tomcat server.

## Features

- Add a new task
- View all tasks
- View a specific task by ID
- Delete a task by ID

## Usage

1. Run the application.
2. Use Postman or any API testing tool to interact with the application's endpoints.

## Endpoints

- Add a new task (POST): `http://localhost:8080/tasks`
- View all tasks (GET): `http://localhost:8080/tasks`
- View a specific task by ID (GET): `http://localhost:8080/tasks/{id}`
- Delete a task by ID (DELETE): `http://localhost:8080/tasks/{id}`

## Example Requests

1. **Add a new task** (POST):
   - URL: `http://localhost:8080/tasks`
   - Request Body (JSON):\
   Json Structure
    {
     "title": "Read Book",
    "description": "Read the new novel",
    "completed": true
    }

2. **View all tasks** (GET):
   - URL: `http://localhost:8080/tasks`

3. **View a specific task by ID** (GET):
   - URL: `http://localhost:8080/tasks/{id}`

4. **Delete a task by ID** (DELETE):
   - URL: `http://localhost:8080/tasks/{id}`

## Error Handling

- Invalid input or resource not found errors are handled with appropriate HTTP responses.
- Global error handling is provided to handle unexpected exceptions.


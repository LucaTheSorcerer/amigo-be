# Amigo App Backend

## Overview

This document outlines the backend architecture of the Amigo App, developed with Spring Boot.
It serves as a guide for setup, deployment, and understanding the codebase's structure and features.

## This Project Features

* Spring Boot
* Spring Security for Authentication and Authorization
* JPA (Java Persistence API) with Hiberante and ORM
* Postgres for Database
* Maven for Dependency Management

## Complete List of URL Path from Swagger UI, currently running on localhost

https://localhost:8443/swagger-ui

## Prerequisites

- JDK 21
- Maven
- Git (for version control)
- Docker


## Getting Started

1. Installation

    - Clone the repository: `git clone repository-url`
    - Navigate to the project directory: `cd project-directory`
    - Build the project: `mvn clean verify`
    - Build the Docker image with `docker build . -t amigo-backend`
    - Start the Docker image using Docker Compose: `docker-compose up -d`
    - Build and Start directly with: `docker-compose up --build`

2. Running the application
   - Run the application: `mvn spring-boot:run`
   - Set profile to local
   - The server will start on `http://localhost:8080`


## System Architecture

- **Controller Layer**: Handles HTTP requests, mapping them to service methods.
- **Service Layer**: Contains business logic and calls methods in the repository layer.
- **Repository Layer**: Interface for database operations, using Spring Data JPA.
- **Model Layer**: Entity classes that represent tables in the database.
- **Security Configuration**: Configures authentication and authorization.

## Features

- **User Authentication**: Secure login and registration using Spring Security.
- **Role-Based Access Control**: Differentiating user capabilities based on roles.
- **Data Validation**: Ensuring integrity of incoming data through Spring Validation.
- **Exception Handling**: Centralized exception handling mechanism for cleaner error management.


## Spring Boot for Rapid Development

- **Dependency Injection**: Simplifies the application structure and dependencies.
- **Auto-configuration**: Reduces the need for manual configuration.
- **Embedded Servers**: Easy deployment with embedded Tomcat or Jetty servers.
- **Spring Data JPA**: Simplifies data access layer with repository abstraction.


## Security Measures

- **Spring Security**: Configures authentication and authorization for secure access.
- **JWT for Sessions**: Utilizes JSON Web Tokens for stateless session management.
- **Cross-Origin Resource Sharing (CORS)**: Configures CORS for secure resource sharing between different domains.
- **HTTPS Enforcement**: Encourages or enforces the use of HTTPS to secure data in transit.


## API Documentation

- Swagger/OpenAPI for API documentation, making it easier to understand and use the backend services
# Data-JPA
Spring Data JPA Example – A simple Spring Boot application demonstrating how to use Spring Data JPA with Hibernate to perform CRUD operations on a Student entity. The app automatically maps the Student class to a database table, creates the table at runtime, and inserts sample data using a CommandLineRunner.

# Spring Data JPA Example

## Overview
This is a **Spring Boot** application demonstrating the power and simplicity of **Spring Data JPA**.  
It allows you to perform CRUD (Create, Read, Update, Delete) operations on a `Student` entity, showcasing how Spring Boot, Hibernate, and JPA work together to manage database operations.

The application automatically:

- Maps Java classes (`@Entity`) to database tables.
- Generates tables based on entity definitions.
- Saves sample data into the database at startup using `CommandLineRunner`.
- Uses `JpaRepository` to simplify database interactions without writing SQL queries manually.

---

## Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- H2 Database (in-memory for development)
- Maven

---

## Features

- **Entity Mapping:** The `Student` class is annotated with `@Entity` and mapped to a table named `student`. Each field is mapped to a column with constraints such as `nullable`, `unique`, and `length`.
- **Repository Abstraction:** `StudentRepository` extends `JpaRepository` to provide CRUD operations without needing a manual implementation.
- **Automatic Table Creation:** Hibernate generates the `student` table automatically at runtime.
- **CommandLineRunner:** Inserts sample data after the Spring context is fully initialized.
- **Reflection & Runtime:** Hibernate uses reflection to read entity annotations and generate SQL commands dynamically.

---
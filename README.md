# Library Management System

A console-based Java application to manage library books using MySQL.

## Features
- Add new books
- Issue books to users
- Return books
- View all books

## Technologies Used
- Java
- MySQL
- JDBC

## Setup
1. Create MySQL database and table:

```sql
CREATE DATABASE library_db;
USE library_db;
CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    issued TINYINT(1) DEFAULT 0
);

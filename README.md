# StuJava
Used to store the project done during the period of learning JAVA

## Library Management System
This is a Library Management System developed using the SSM framework (Spring, SpringMVC, MyBatis). The system includes functionalities for managing book categories and book information.

### Development Environment

Operating System: Windows 11
JDK Version: OpenJDK 22.0.1

### Development Tools

IDE: IntelliJ IDEA 2024.1
Web Server: Apache Tomcat 11.0.0-M21
Database: MySQL 8.2.0

### Dependencies

Spring Framework: 6.1.9
SpringMVC
MyBatis: 3.5.16
MyBatis-Spring: 3.0.3
HikariCP (via Spring Boot Starter Data JPA)
JSTL: 1.2
Jakarta Servlet: 6.1.0

### Project Structure

Controller Layer: Handles HTTP requests, calls Service layer methods, and returns views.
Service Layer: Contains business logic, calls Mapper layer methods to interact with the database.
Mapper Layer: Uses MyBatis for CRUD operations with the database.
Model Layer: Defines entity classes such as Book and Category.
View Layer: Uses JSP and JSTL to render dynamic content on web pages.

### Main Features

User Login: Authentication handled by UserController.
Book Management: Add, update, delete, and view books through BookController.
Category Management: Add, update, delete, and view categories through CategoryController.

### Database Design

#### Tables:
categories: Contains category ID, name, and description.
books: Contains book ID, title, author, ISBN, publish year, category name, price, and stock.
users: Contains user ID, username, password, email, role, and is_active status.

#### Foreign Key Relationship:
books table's category_name field references the name field in the categories table.

### Running the Project

#### Setup Database:

Create a MySQL database named librarymanagementsystem.

Use the following SQL scripts to set up tables:
-- Create books table
CREATE TABLE books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(50) NOT NULL,
    publish_year INT NOT NULL,
    category_name VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    CONSTRAINT fk_category FOREIGN KEY (category_name) REFERENCES categories(name)
);

-- Create categories table
CREATE TABLE categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

-- Create users table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    is_active BOOLEAN NOT NULL
);

#### Configure Application:

Ensure that your application properties are set up to connect to the MySQL database.

#### Deploy Application:

Deploy the application on Apache Tomcat.
Access the application at http://localhost:8080

### Project Workflow

#### User Login
The user accesses the login page and authenticates via UserController.

#### Main Interface
After successful login, the user is redirected to the main interface where they can manage books and categories.

#### Book and Category Management
The user can view lists of books and categories, add new entries, update existing ones, and delete entries through the respective controllers and JSP views.

### Contact
e-mail:xingjiabo2024@outlook.com

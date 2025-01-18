# Spring Boot Dashboard-api Project

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)
## Requirements

- [JAVA JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
-  [MYSQL](https://www.mysql.com/)
- A favorite text editor or IDE

## Quick start
 Clone the repository

    https://github.com/Sasatayea/Spring-boot-Dashboard-api.git
 Build the project : Before you build the project, you need to execute the `sql-scripts` file to your database and change database username and password in `application.properties` file.

 Run the project
    
    mvn spring-boot:run

## Dependencies

- Spring Web.
- Spring Boot DevTools.
- Spring Security.
- MySQL Driver.
- Validation

## About the Service

The service is just a simple Admin and User Dashboard REST Service .It uses MYSQL database to store the data. If your database connection properties work, you can call some REST endpoints defined in `\rest\OmdbApiController` adn also in `\rest\UsersRestController` on port 8080.  (see below)
ou can use this sample service to understand the conventions and configurations that allow you to create a DB-backed RESTful service. Once you understand and get comfortable with the sample app you can add your own services following the same patterns as the sample service.

Here is what this little application demonstrates:
- Full integration with the latest Spring Framework: inversion of control, dependency injection, etc.
- Writing a RESTful service using annotation: supports both XML and JSON request / response; simply use desired Accept header in your request
- Exception mapping from application exceptions to the right HTTP response with exception details in the body
- Spring Data Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations.
- Automatic CRUD functionality against the data source using Spring Repository pattern
- Adding Spring security and use `SecurityFilterChain` to manage data operation access.
- Save User Password Encrypted in database using `BCryptPasswordEncoder`

## Swagger-Ui



![alt text](https://i.pinimg.com/736x/eb/80/ce/eb80ceb26863a3be30e5655937f5fd44.jpg "Title")






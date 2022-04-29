# Microservice V4

This project is an example of microservice using Spring Boot, Docker, OpenAPI Generator and JWT. It was used Swagger Codegen to generate documentation.

# Running the application.

### 1. Docker

In the root project folder, run the command:

```shell
<spring-security>$ docker compose up
```

Here is how to check the database

- URL: [http://localhost:8080/?server=mariadb](http://localhost:8080/?server=mariadb)
- Server: mariadb
- Username: root
- Password: example
- Database: example

![Table Customer](files/MariaDB01.png)

### 2. Run application

1. Run the Main class

In each root project folder, run the command:

```shell
<spring-security>$ mvn spring-boot:run
```

### 3. Links

- Database: [http://localhost:8080/?server=mariadb](http://localhost:8080/?server=mariadb)
- Swagger: [http://localhost:8081/swagger](http://localhost:8081/swagger)

# Resources

- https://www.youtube.com/watch?v=VVn9OG9nfH0

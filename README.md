# Spring Security

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

![Table Customer](.files/MariaDB01.png)

### 2. Run application

1. Run the Main class

In each root project folder, run the command:

```shell
<spring-security>$ mvn spring-boot:run
```

### 3. Postman

###### Get token

- POST: [http://localhost:8080/login](http://localhost:8080/login)
- Body:
```json
{
    "username": "ricoribeiro",
    "password": "ricardo123"
}
```
- Response:
```json
{
    "access_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyaWNvcmliZWlybyIsInJvbGVzIjpbIkRFViIsIlFBIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MS9sb2dpbiIsImV4cCI6MTY1MzE2NTM3N30.2U4GLTMmkvqyjCvxwBbdfOwf1aIgb_GyzAuJlxvACCk",
    "refresh_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyaWNvcmliZWlybyIsInJvbGVzIjpbIkRFViIsIlFBIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MS9sb2dpbiIsImV4cCI6MTY1MzE2NTM3N30.2U4GLTMmkvqyjCvxwBbdfOwf1aIgb_GyzAuJlxvACCk"
}
```

###### Any other request

Header:
```properties
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyaWNvcmliZWlybyIsInJvbGVzIjpbIkRFViIsIlFBIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MS9sb2dpbiIsImV4cCI6MTY1MzE2NTM3N30.2U4GLTMmkvqyjCvxwBbdfOwf1aIgb_GyzAuJlxvACCk
```

# Links

- Database: [http://localhost:8080/?server=mariadb](http://localhost:8080/?server=mariadb)
- Swagger: [http://localhost:8081/swagger](http://localhost:8081/swagger)

# Resources

- https://www.youtube.com/watch?v=VVn9OG9nfH0

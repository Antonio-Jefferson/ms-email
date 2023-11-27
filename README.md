# Microservice Email Sender

## Introduction
This project is a microservice designed for sending welcome emails to users upon registration. It communicates with another microservice responsible for user registration. The primary purpose is to welcome users to the platform by triggering the email service when a new user is registered.

## Technologies Used
- Java: Version 17
- Spring Boot:
  - spring-boot-starter-data-jpa
  - spring-boot-starter-amqp
  - spring-boot-starter-mail
  - spring-boot-starter-validation
  - spring-boot-starter-web
  - spring-boot-devtools
- Database: PostgreSQL
- Other Dependencies:
  - Project Lombok (optional, for simplifying code)

## How to Run the Project
Follow these steps to run the project locally:

### Prerequisites
- Java 17 installed
- PostgreSQL database running with appropriate configurations
- RabbitMQ server running for messaging communication

### Steps
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Antonio-Jefferson/ms-email.git
## Configure Database:

1. Open `application.properties` in `src/main/resources` and update the database connection properties.

## Run RabbitMQ Server:

- Ensure that RabbitMQ server is running and accessible.

## Build and Run:
```bash
./mvnw clean install
./mvnw spring-boot:run
````
## Access the Application:

The microservice will be accessible at [http://localhost:8080](http://localhost:8080).

## Testing Email Sending:

Use tools like Postman or Swagger UI to trigger the email sending endpoint.

## Additional Configuration:

### Lombok:

If you are using an IDE, ensure it supports Lombok. If not, you may need to install a Lombok plugin.

# Notes API

A REST API built with Java and Spring Boot.

## Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | /notes | Get all notes |
| POST | /notes | Create a note |
| PUT | /notes/{id} | Update a note |
| DELETE | /notes/{id} | Delete a note |

## Run locally
```bash
./mvnw spring-boot:run
```

## Tech stack
- Java 21
- Spring Boot 3
- Maven

## Roadmap
- [ ] Week 2: Add PostgreSQL database
- [ ] Week 5: Add Python script
- [ ] Week 6: Deploy to AWS
# Notes API

A RESTful API built with Spring Boot for managing notes, with PostgreSQL for data persistence and MongoDB for activity logging.

## Tech Stack

- Java 21 + Spring Boot
- PostgreSQL (via Spring Data JPA)
- MongoDB (activity logging)
- Maven

## Features

- Full CRUD REST API for notes
- PostgreSQL stores all notes
- MongoDB logs every CREATE and DELETE action with a timestamp
- Python script to export notes to CSV

## Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /notes | Get all notes |
| GET | /notes/{id} | Get note by ID |
| POST | /notes | Create a note |
| PUT | /notes/{id} | Update a note |
| DELETE | /notes/{id} | Delete a note |

## Running Locally

**Prerequisites:** Java 21, PostgreSQL, MongoDB, Maven

1. Clone the repo
```bash
   git clone https://github.com/captainameerica/notes-api.git
   cd notes-api
```

2. Create a PostgreSQL database called `notesdb`

3. Update `src/main/resources/application.properties`:
```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/notesdb
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.data.mongodb.uri=mongodb://localhost:27017/notesdb
```

4. Run the app
```bash
   ./mvnw spring-boot:run
```

5. Test it
```bash
   curl http://localhost:8080/notes
```

## Project Structure
src/main/java/com/ameersyed/notes_api/
├── Note.java                  # JPA entity for PostgreSQL
├── NoteController.java        # REST endpoints
├── NoteService.java           # Business logic layer
├── NoteRepository.java        # Spring Data JPA repository
├── ActivityLog.java           # MongoDB document model
├── ActivityLogRepository.java # Spring Data MongoDB repository
└── NotesApiApplication.java   # Entry point

## Python Export Script

With the app running locally:
```bash
pip install requests
python notes_export.py
```
Exports all notes to `notes_summary.csv`.

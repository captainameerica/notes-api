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

# Flashcard Study App

A full-stack flashcard app for creating and studying flashcards, built with a 
Java/Spring Boot backend and a JavaScript frontend.

## Features
- Add flashcards through a web form
- View all saved flashcards
- Backend REST API (GET/POST) built with Spring Boot
- Request logging to track usage

## Tech Stack
- Java 17
- Spring Boot (Spring Web)
- HTML/CSS/JavaScript (vanilla, no framework)
- Maven

## How to Run
1. Clone the repo
2. Run `.\mvnw spring-boot:run` (Windows) or `./mvnw spring-boot:run` (Mac/Linux)
3. Visit `http://localhost:8080` in your browser

## What I Learned
The most difficult part of this project was understanding how a frontend
talks to a backend using JavaScript's fetch() API. Along the way, I learned:

- How REST APIs work, and how to tell Spring Boot that a class should
  handle web requests and return data (using annotations like
  @RestController and @GetMapping)
- The difference between HTTP request types (GET vs. POST) and how to
  trigger different backend behavior based on which one is sent
- How to use Git and GitHub for version control, including committing
  changes in stages rather than all at once


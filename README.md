## ToDoList Application

#Overview
This project is about creating a ToDoList using Java and Spring Boot. 

## Features

- **Task Management:** Add, edit, and delete tasks to keep your todo list up-to-date

- **Status Tracking:** Update task's status as completed or incomplete

- **Data Validation:** Vaidate user's input to ensure that valid input has been made before storing data into database and appropriate error message will be displayed

## Tech Stack

- **Backend:**
  - Java
  - Spring Boot

- **Database:**
  - mysql

## Folder Structure

The project follows a well-organized folder structure to maintain clarity and separation of concerns:

- **`src/`**: Contains the source code for the backend components.
  - **`main/`**: Core application code.
    - **`java/`**: Java source files.
      - **`com.sctp.todoapplication/`**: Main application package.
        - **`controllers/`**: Contains REST controllers.
        - **`models/`**: Defines data models.
        - **`repositories/`**: Manages data access.
        - **`services/`**: Implements business logic.
        - **`exception/`**: Handles exception
    - **`resources/`**: Configuration files, application properties, and static resources.
      - **`application.properties`**: Configures application properties, including the database connection.

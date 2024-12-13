# Movie Application

## Overview

This project is a fully-functional movie application developed using Spring Boot, Hibernate, MySQL, and Angular. The application allows regular users to browse movies, search for one or list movies, show all information about movies and rate each movie. It also allows the Admin to add and delete one or more movies using the OMDB API through the dashboard.

## Features
- **User Management**: All users can log in and navigate to the accessed page based on Role.
- **Admin Dashboard**: Admin can show all movie in local database, show full information of each movie, add one or list by Imdb ID or title, and delete one or more movie by Imdb ID.
- **Pagination for the movies List**: Regular user can show movie cards in pages with ablity to show full information for each movie.
- **Search bar**: Regular user can search for movie by Imdb ID, Title or Year.
- **Rating Button**: Regular user can rate each movie.

## Design

### Database Design

The following diagram represents the Entity-Relationship Diagram (ERD) for the application's database.
![Entity-Relationship Diagram](https://github.com/Ssaif-9/Spring_Movies_App/blob/main/Attachment/ERD.png)

### Project Architecture

The project follows a well-structured architecture pattern:

- **Model-View-Controller (MVC)**: The application separates concerns using the MVC pattern, where:
    - **Model**: Represents the data and business logic (Entities, Services).
    - **View**: The frontend that displays data to the user Angular (HTML, CSS, TypeScript).
    - **Controller**: Manages user requests and responses (Spring Controllers).

- **Client-Server Architecture**: The application uses a client-server architecture, where:
    - The **client** (frontend) interacts with the **server** (backend) to fetch and manipulate data.
    - The **server** (backend) processes requests, communicates with the database, and returns responses.

- **REST API**: The application exposes RESTful endpoints to facilitate communication between the client and server. These endpoints follow standard HTTP methods (GET, POST, PUT, DELETE) for CRUD operations.

## Technologies Used

- **Backend**: Spring Boot, Hibernate, JPA, MySQL, RESTful APIs
- **Frontend**: Angular, HTML, CSS, TypeScript, Bootstrap
- **Database**: MySQL
- **movie API**: [OMDB API](https://www.omdbapi.com/)

- **Tools & Libraries**:
   - Spring Data JPA for database interactions
   - ModelMapper for entity-DTO mapping
   - Bootstrap for responsive design


   
## Setup and Installation

### Prerequisites

- Java 17+
- Maven 3.6+
- MySQL 8.x+
- Angular 16+
- OMDB API credentials (apikey)
- IDE: IntelliJ IDEA / VSCode/ MySQL Workbench  


### Steps
#### for Spring (Backend)
1. Clone the repository:

    ```bash
    git clone https://github.com/Ssaif-9/Spring_Movies_App.git
    cd Spring_Movies_App
    ```

2. Configure the MySQL database:

   Create a database in MySQL:

    ```sql
    CREATE DATABASE account_db;
    ```
    ensure to run SQL Script to can login 

   Update the `application.properties` file with your MySQL credentials:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update    //can use create-drop to automatic first create tables and relations
    ```

4. Install dependencies:

    ```bash
    mvn clean install
    ```

5. Run the application:

    ```bash
    mvn spring-boot:run
    ```

   Access the application:
   Navigate to `http://localhost:8080` to use the application.

### Swagger Documentation
   Also can Access the application through Swagger for more Backend RESTApi
   Navigate to `http://localhost:8080/swagger-ui/index.html#/` to show more backend Exclusive APIs.

#### for Angular (Frontend)
 Install and Start:

    ```bash
    cd movie-frontend
    npm install
    ng serve --open 
    ```

    Access the application:
   Navigate to `http://localhost:4200` to use the application.


# API Endpoints

<details>
<summary>Auth Controller</summary>

### 1. `POST /api/v1/auth/login`
- **Description**: cheak Authontication and authorization.
</details>

<details>
<summary>Admin Controller</summary>

### 1. `GET /api/v1/admin`
- **Description**: List all movies.

### 2. `POST /api/v1/admin/add/imdbId`
- **Description**: Add one movie by imdbId.

### 3. `POST /api/v1/admin/add/title`
- **Description**: Add one movie by title.

### 4. `POST /api/v1/admin/addList/imdbId`
- **Description**: Add List of movies by imdbId.

### 5. `POST /api/v1/admin//delete/imdbId`
- **Description**: Delete one movie by imdbId.

### 6. `POST /api/v1/admin//deleteList/imdbId`
- **Description**: Delete List of movies by imdbId.


</details>

<details>
<summary>User Controller</summary>

### 1. `GET /api/v1/home/all`
- **Description**: List all movies without pages.

### 2. `GET /api/v1/home/"/page/{page}`
- **Description**: List all movies with pages.

### 3. `GET /api/v1/home/search/byTitle/{title}`
- **Description**: Search movie by title.

### 4. `GET /api/v1/home/search/byImdbId/{imdbId}`
- **Description**: Search movie by imdbId.

### 5. `GET /api/v1/"search/byYear/{year}"`
- **Description**: Search movie by year.

### 6. `GET /api/v1/home/gat/allInfo/{imdbId}"`
- **Description**: Catch all movie informations.

### 7. `GET /api/v1/home/gat/rate/{imdbId}"`
- **Description**: Catch user movie rate.

### 8. `GET /api/v1/home/gat/rate/{imdbId}/{rating}"`
- **Description**: rate movie from 1 to 5 star.
</details>


# Preview


![Movie Card](https://github.com/Ssaif-9/Spring_Movies_App/blob/main/Attachment/movieCard.png)


![Dashboard](https://github.com/Ssaif-9/Spring_Movies_App/blob/main/Attachment/dashboard.png)

![Full Information Card](https://github.com/Ssaif-9/Spring_Movies_App/blob/main/Attachment/fullInformation.png)

![Pagination](https://github.com/Ssaif-9/Spring_Movies_App/blob/main/Attachment/pages.png)

![Login Form](https://github.com/Ssaif-9/Spring_Movies_App/blob/main/Attachment/login.png)
![Search Bar](https://github.com/Ssaif-9/Spring_Movies_App/blob/main/Attachment/searchBar.png)

![Add By Imdb Id](https://github.com/Ssaif-9/Spring_Movies_App/blob/main/Attachment/addByImdbId.png)

![Add By Title](https://github.com/Ssaif-9/Spring_Movies_App/blob/main/Attachment/addByTitle.png)

![Delete By Imdb Id](https://github.com/Ssaif-9/Spring_Movies_App/blob/main/Attachment/deleteByImdbId.png)


[Also can watch Video Demo for here..](https://drive.google.com/drive/folders/18IxGJh4YuI7FHYX4J7OyzpriykjeE6Oc?direction=a)


#### For Any Question please communicate with me [Linkedin](https://www.linkedin.com/in/seif-eldin-sultan-90b740233/)

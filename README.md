# Conference Booking Application

This is a **Java-Spring Boot** project that allows users to book tickets for a conference. It handles ticket reservations, stores booking details in an H2 in-memory database, and provides basic data management functionality using JPA

## Features

- Simple command-line ticket booking application
- Keeps track of remaining tickets and prevents overbooking
- Provides confirmation messages for each booking
- Stores booking information in an H2 database

## Requirements

- Java 21 or later
- Maven (ensure Maven is installed and added to your system's path)

## Usage

1. Clone the repository

   ```bash
   git clone https://github.com/rahulkarthickr/conference-booking-app.git
   ```
2. Navigate to the project directory
   
   ```bash
   cd conference-booking-app
   ```
3. Comment out the below lines in `application.properties` and update your database username & password 

   ```bash
   # spring.datasource.username=your-username
   # spring.datasource.password=your-password
   ```
3. Build the project

   ```bash
   mvn clean install
   ```
4. Run the application

   ```bash
   mvn spring-boot:run
   ```
5. Test the application at

   ```bash
   http://localhost:8080/test
   ```
6. Access the database by entering username and password at

   ```bash
   http://localhost:8080/h2-console/
   ```
7. Run the SQL query in the console to verify that the data is being saved

   ```sql
   SELECT * FROM bookings;
   ```
## Contribution

If you encounter any issues or have suggestions for improvements , please open an issue or submit a pull request
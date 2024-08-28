# Employee API Documentation

## Overview
This project provides a simple REST API to manage employee data using Scala and the Scalatra framework. It supports CRUD operations for employees and includes Swagger documentation for easy API exploration.

## Dependencies
- **Scala**: Version 3.3.3
- **Scalatra**: Version 3.1.0
- **Json4s**: Version 4.0.6
- **Jetty**: Version 12.0.10
- **Java**: Version 21

## Project Structure
- **com.example.app.dao**: Contains the data access object (DAO) for employees.
- **com.example.app.model**: Defines the `Employee` model.
- **com.example.app.swagger**: Contains Swagger configuration and API documentation.
- **com.example.app**: Main application and Jetty launcher.
- **controller**: Contains the `EmployeeServlet` that handles API requests.

## API Endpoints

### 1. Get All Employees
- **URL**: `/employees`
- **Method**: `GET`
- **Description**: Retrieves a list of all employees.
- **Response**: A JSON list of `Employee` objects.

### 2. Get Employee By ID
- **URL**: `/employees/:id`
- **Method**: `GET`
- **Description**: Retrieves an employee by their ID.
- **Parameters**:
    - `id`: The ID of the employee to retrieve.
- **Response**: An `Employee` object if found, otherwise a 404 error.

### 3. Create a New Employee
- **URL**: `/employees`
- **Method**: `POST`
- **Description**: Creates a new employee.
- **Request Body**: An `Employee` object in JSON format.
- **Response**: The newly created `Employee` object.

### 4. Update an Existing Employee
- **URL**: `/employees/:id`
- **Method**: `PUT`
- **Description**: Updates an existing employee.
- **Parameters**:
    - `id`: The ID of the employee to update.
- **Request Body**: The updated `Employee` object in JSON format.
- **Response**: The updated `Employee` object if found, otherwise a 404 error.

## Running the Application

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo/employee-api.git
   ```

2. **Build the Project**:
   Ensure you have SBT (Scala Build Tool) installed. Then, navigate to the project directory and run:
   ```bash
   sbt compile
   ```

3. **Run the Application**:
   Start the Jetty server using the provided launcher:
   ```bash
   sbt jetty:start
   ```
   Alternatively, you can use the `JettyLauncher` object directly:
   ```bash
   sbt "runMain com.example.app.JettyLauncher"
   ```

4. **Access the API**:
    - Open your web browser and navigate to `http://localhost:8000/employees` to see the list of employees.
    - Use tools like Postman or cURL to test other endpoints.

## API Documentation
The API documentation is available via Swagger at:
```
http://localhost:8000/api-docs/swagger.json
```



## Contributing
Contributions are welcome. Please submit a pull request with your changes and ensure they follow the existing coding standards.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Contact
For any questions or issues, please contact the development team at [vishals.singh@codionverse.com](mailto:vishals.singh@codionverse.com)
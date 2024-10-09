# AzureDevOps OAS3 Plugin
## Overview

This project is a Java Spring Boot application named "AzureDevOps OAS3 Plugin" (azuredevops-oas3-plugin). 

## Project Structure

```
.
├── Dockerfile
├── HELP.md
├── README.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── krateo
│   │   │       └── gen
│   │   │           └── ws
│   │   │               └── demo_ws
│   │   │                   ├── AzuredevopsPluginApplication.java
│   │   │                   ├── controller
│   │   │                   │   └── PipelinePermissionCli.java
│   │   │                   └── model
│   │   │                       ├── IdentityRef.java
│   │   │                       ├── Permission.java
│   │   │                       ├── PipelinePermission.java
│   │   │                       ├── Resource.java
│   │   │                       └── ResourcePipelinePermissions.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates
│   └── test
│       └── java
│           └── krateo
│               └── gen
│                   └── ws
│                       └── demo_ws
│                           └── AzuredevopsPluginApplicationTests.java
└── swagger.json
```

## Prerequisites

- Java 8 or higher
- Maven
- Docker (optional, for containerization)

## Building the Project

To build the project, run:

```bash
./mvnw clean package
```

This will create a JAR file in the `target` directory.

## Running the Application

You can run the application using:

```bash
java -jar target/azuredevops-oas3-plugin-0.0.1-SNAPSHOT.jar
```

Or using Spring Boot Maven plugin:

```bash
./mvnw spring-boot:run
```

## Docker Support

The project includes a Dockerfile. To build a Docker image:

```bash
docker build -t azuredevops-oas3-plugin .
```

To run the container:

```bash
docker run -p 8080:8080 azuredevops-oas3-plugin
```

## API Documentation

The API is documented using Swagger. You can find the Swagger JSON file at `swagger.json` in the root directory.

## Main Components

1. `AzuredevopsPluginApplication.java`: The main Spring Boot application class.
2. `PipelinePermissionCli.java`: Controller handling pipeline permission operations.
3. Model classes in the `model` package:
   - `IdentityRef.java`
   - `Permission.java`
   - `PipelinePermission.java`
   - `Resource.java`
   - `ResourcePipelinePermissions.java`

## OpenAPI Specification (OAS 3.0)

This project leverages the `springdoc-openapi-starter-webmvc-ui` dependency to automatically generate OpenAPI Specification 3.0 documentation from the webservice code. This feature provides several benefits:

1. **Auto-generated API Documentation**: The OpenAPI specification is automatically generated based on your Spring Boot controllers, models, and annotations.

2. **Swagger UI Integration**: A Swagger UI is automatically made available to visualize and interact with your API's resources.

3. **API First Development**: You can use the generated specification for API-first development practices, enabling better collaboration between frontend and backend teams.

### Accessing the OpenAPI Specification

Once your application is running, you can access the OpenAPI specification in different formats:

- **JSON format**: `http://localhost:8080/v3/api-docs`
- **YAML format**: `http://localhost:8080/v3/api-docs.yaml`

### Swagger UI

The Swagger UI provides a user-friendly interface to explore and test your API endpoints. You can access it at:

`http://localhost:8080/swagger-ui.html`

### Customizing the OpenAPI Generation

You can customize the OpenAPI generation using properties in your `application.properties` file. Some useful properties include:

```properties
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.operationsSorter=method
springdoc.swagger-ui.tagsSorter=alpha
springdoc.swagger-ui.tryItOutEnabled=true
springdoc.swagger-ui.filter=true
```

### Enhancing API Documentation

To enhance your API documentation, you can use OpenAPI annotations in your controller classes and methods. For example:

```java
@RestController
@RequestMapping("/api")
@Tag(name = "Pipeline Permissions", description = "Endpoints for managing pipeline permissions")
public class PipelinePermissionController {

    @Operation(summary = "Get pipeline permissions", description = "Retrieves permissions for a specific pipeline")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved permissions",
                     content = @Content(schema = @Schema(implementation = ResourcePipelinePermissions.class))),
        @ApiResponse(responseCode = "404", description = "Pipeline not found")
    })
    @GetMapping("/permissions/{pipelineId}")
    public ResponseEntity<ResourcePipelinePermissions> getPermissions(@PathVariable String pipelineId) {
        // Method implementation
    }
}
```

### Further Customization

For more advanced customization options and detailed usage, refer to the [springdoc-openapi documentation](https://springdoc.org/).


## Testing

The project includes a test class `AzuredevopsPluginApplicationTests.java`. Run tests using:

```bash
./mvnw test
```

## Configuration

Application configuration can be found in `src/main/resources/application.properties`.

## Acknowledgments

For more detailed information about using this application, please refer to HELP.md in the project root.
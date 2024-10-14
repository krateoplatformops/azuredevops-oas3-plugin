# AzureDevOps OAS3 Plugin

## Overview

This project is a Java Spring Boot application named "AzureDevOps OAS3 Plugin" (azuredevops-oas3-plugin). It is designed to address a specific issue with pipeline permissions in Azure DevOps environments.

### Problem Statement

In the `pipelinePermission` resource, when `authorized` is set to `false`, the API returns `none`. This results in continuous reconciliation due to the difference between the local and remote resources.

### Solution

This web service acts as an intermediary to properly manage pipeline permissions and resolve the reconciliation issue. It ensures that the local and remote resources match even when a pipeline is unauthorized.

In this case, if the resource is set `authorized: false` in the body request, you will receive from AzureDevOps an incomplete response. The web service then fills this response with the request data to ensure consistency between local and remote resources.

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
2. `PipelinePermissionCli.java`: Controller handling pipeline permission operations. This component is crucial for addressing the reconciliation issue.
3. Model classes in the `model` package:
   - `IdentityRef.java`
   - `Permission.java`
   - `PipelinePermission.java`: Represents pipeline permissions and likely includes logic for handling the `authorized` flag.
   - `Resource.java`
   - `ResourcePipelinePermissions.java`: Manages the overall pipeline permissions for resources.

## OpenAPI Specification (OAS 3.0)

This project leverages the `springdoc-openapi-starter-webmvc-ui` dependency to automatically generate OpenAPI Specification 3.0 documentation from the webservice code. 

### Accessing the OpenAPI Specification

Once your application is running, you can access the OpenAPI specification in different formats:

- **JSON format**: `http://localhost:8080/v3/api-docs`
- **YAML format**: `http://localhost:8080/v3/api-docs.yaml`

### Swagger UI

The Swagger UI provides a user-friendly interface to explore and test your API endpoints. You can access it at:

`http://localhost:8080/swagger-ui.html`

## Testing

The project includes a test class `AzuredevopsPluginApplicationTests.java`. Run tests using:

```bash
./mvnw test
```

## Configuration

Application configuration can be found in `src/main/resources/application.properties`.

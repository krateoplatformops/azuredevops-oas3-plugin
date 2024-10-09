# Demo Web Service

## Overview

This project is a Java Spring Boot application named "Demo Web Service" (azuredevops-oas3-plugin). It appears to be focused on managing pipeline permissions, likely for an Azure DevOps-like system.

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

## Testing

The project includes a test class `AzuredevopsPluginApplicationTests.java`. Run tests using:

```bash
./mvnw test
```

## Configuration

Application configuration can be found in `src/main/resources/application.properties`.

## Acknowledgments

For more detailed information about using this application, please refer to HELP.md in the project root.
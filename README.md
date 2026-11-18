# Clientes SOAP Server

## Description

SOAP web service developed with Java 17, Spring Boot 4.1.2, and Apache CXF 4.2.0.

This project demonstrates how to implement and expose a SOAP service using Jakarta XML Web Services (JAX-WS) and a WSDL contract.

The service is designed to be consumed by a separate Spring Boot REST API, demonstrating integration between SOAP and REST architectures.

## Technologies

- Java 17
- Spring Boot 4.1.2
- Apache CXF 4.2.0
- Jakarta XML Web Services (JAX-WS)
- Maven
- SOAP / XML
- WSDL
- Debian Linux 12
- Git

## Architecture

```text
REST API / SOAP Client
          |
          | SOAP Request (XML)
          v
Spring Boot SOAP Server
          |
          v
Apache CXF Endpoint
          |
          v
ClienteSoapServiceImpl
          |
          v
SOAP Response (XML)
```

## Features

- SOAP web service implemented using JAX-WS.
- SOAP endpoint published through Apache CXF.
- WSDL contract exposed automatically.
- Client lookup operation using a numeric identifier.
- Integration with an external REST application.
- Configurable server port and CXF base path.

## SOAP Operation

### consultarCliente

Receives a client identifier and returns a text response.

**Input parameter:**

- `idCliente`: Long

**Example result:**

```text
Cliente encontrado: ID 1001 - Nombre: Juan Pérez
```

The current implementation uses demonstration data rather than a database.

## Configuration

The application uses the following properties:

```properties
server.port=8081
cxf.path=/services
```

The SOAP endpoint is published at:

```text
http://localhost:8081/services/clientes
```

The WSDL is available at:

```text
http://localhost:8081/services/clientes?wsdl
```

Replace `localhost` with the server's hostname or IP address when accessing the service remotely.

## Build and Run

### Requirements

- JDK 17
- Maven
- Network access to the configured SOAP server port

### Compile

```bash
mvn clean compile
```

### Start the application

```bash
mvn spring-boot:run
```

Once the application starts, open the WSDL URL in a browser to verify that the SOAP contract is available.

## Example SOAP Request

```xml
<soapenv:Envelope
    xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
    xmlns:cli="http://soap.quique.cl/clientes">
    <soapenv:Header/>
    <soapenv:Body>
        <cli:consultarCliente>
            <idCliente>1001</idCliente>
        </cli:consultarCliente>
    </soapenv:Body>
</soapenv:Envelope>
```

The exact request structure should be verified against the generated WSDL.

## Project Structure

```text
clientes-soap-server/
├── src/
│   └── main/
│       ├── java/
│       │   └── cl/quique/soap/
│       │       ├── config/
│       │       │   └── SoapConfig.java
│       │       └── service/
│       │           ├── ClienteSoapService.java
│       │           └── ClienteSoapServiceImpl.java
│       └── resources/
│           └── application.properties
├── pom.xml
├── .gitignore
└── README.md
```

## Related Project

This SOAP server is consumed by a separate Spring Boot REST API:

[Clientes REST API](https://github.com/quiquest2406/clientes-rest-api)

The REST application uses Apache CXF to generate a SOAP client from the WSDL and exposes the SOAP operation through a JSON-based REST endpoint.

## Purpose

This project was created as a practical demonstration of:

- Backend development with Java and Spring Boot.
- SOAP web service implementation.
- WSDL-based service contracts.
- Integration between distributed applications.
- REST-to-SOAP communication.
- Development and testing across Windows and Linux environments.
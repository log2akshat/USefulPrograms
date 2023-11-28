# Splunk Configuration with Spring Boot

## Introduction

Splunk is a powerful tool for log analysis and monitoring. This guide provides instructions to enhance your application's logging capabilities by integrating it with Splunk. Leveraging Splunk's features ensures centralized log management and facilitates effective log analysis.

## Prerequisites

Before you begin, ensure the following prerequisites are installed:

- Java Development Kit (JDK)
- Spring Boot application
- Splunk instance (can be installed locally or on a remote server)

## Setup

1. Register on the Splunk portal and download the installer based on your operating system.

2. Splunk typically starts on port `8000`. If you need to change the port, modify the port in the file `${SPLUNK_HOME}/etc/system/local/web.conf`.

3. Access the Splunk web interface, navigate to Settings -> Data inputs -> HTTP Event Collector, and ensure that All Tokens are `Enabled` and the `Default Source Type` is set to `json`.

4. Create a new token by providing a `Name`, `Source name`, and other details. Review your inputs, and a new token will be created.

5. Save the following inputs separately for later use in configuring Splunk with Spring Boot:

    ```yaml
    name: user-microservice-logs
    port: 8088
    source name: user service
    token: ed34b561-65d5-4bba-866a-0a72fb90a763
    source type: log4j
    Index: user_api_dev
    ```

6. In your Spring Boot application, add the following dependencies to the `pom.xml` file:

    ```xml
    <repositories>
        <repository>
            <id>splunk-artifactory</id>
            <name>Splunk Releases</name>
            <url>https://splunk.jfrog.io/splunk/ext-releases-local</url>
        </repository>
    </repositories>
    ```

    Exclude the default logging of `spring-starter-web`:

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <exclusions>
            <exclusion>
                <artifactId>spring-boot-starter-logging</artifactId>
                <groupId>org.springframework.boot</groupId>
            </exclusion>
        </exclusions>
    </dependency>
    ```

    Add Splunk dependencies:

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-log4j2</artifactId>
    </dependency>
    <dependency>
        <groupId>com.splunk.logging</groupId>
        <artifactId>splunk-library-javalogging</artifactId>
        <version>1.8.0</version>
    </dependency>
    ```

7. Create an XML file named `log4j2-spring.xml` under resources with the following contents:

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <Configuration>
        <!-- ... (previous configurations) ... -->
        <Appenders>
            <!-- ... (previous appenders) ... -->
            <SplunkHttp
                    name="splunkhttp"
                    url="https://localhost:8088"
                    token="ed34b561-65d5-4bba-866a-0a72fb90a763"
                    host="localhost"
                    index="user_api_dev"
                    type="raw"
                    source="user service"
                    sourcetype="log4j"
                    messageFormat="text"
                    disableCertificateValidation="true">
                <PatternLayout pattern="%m" />
            </SplunkHttp>
        </Appenders>
        <Loggers>
            <Root level="info">
                <AppenderRef ref="console" />
                <AppenderRef ref="splunkhttp" />
            </Root>
        </Loggers>
    </Configuration>
    ```

    Modify the token and index details under the `SplunkHttp` tag according to the data saved earlier.

8. In your Spring Boot application, create logs using log4j. For example:

    ```java
    Logger logger = LogManager.getLogger(UserController.class);
    // ...
    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegisterRequest request) {
        logger.info("Invoking UserService:registerUser with request: " + request);
        return service.registerUser(request);
    }
    ```

9. Test the logs by triggering the log from a REST client like Postman or a browser.

10. Access the Splunk web, navigate to `Searching and Reporting`, and search with your index name, e.g., `index="user_api_dev"`. This will display the required logs.


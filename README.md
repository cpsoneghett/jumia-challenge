
# Jumia Challenge
This is the project that reads a list of users from a bank and validates their phone numbers.


### Overview
***
This project is a simple project designed to list and categorize country phone numbers. All the data is provided in the file **sample.db** and it must be loaded with SQLite 3 driver.


### Running the application
***

1. With Maven:

For running this way, you must have Maven 3.6.x and Java JDK 11+ installed and all the environment variables set up.

- First of all, clone the repository with the command and then move inside the directory

```
 > git clone https://github.com/cpsoneghett/jumia-challenge.git
```

```
 > cd jumia-challenge
```

- Then, compile and generate the application .war package and, finally, run the package

```
 > mvn clean package
```

```
 > mvn spring-boot:run
```
- To see the page, you can just access the page [http://localhost:8080/customer.xhtml](http://localhost:8080/customer.xhtml).

1. With Docker:

For running this way, you must have Docker installed.

- First of all, the following command is used to build the docker image (attention: must include . at the end)

```
 > docker build -t jumia-app .
```
- Then, the command below will execute the application inside the container, exposing the port 8080 and linking to the application port (which is also 8080 by default)

```
 > docker run -p 8080:8080 -d jumia-app
```
- Running this way, the URI will change a bit, since the tomcat server, at the beggining, exposes a URI context with the same name as the image we created. After the execution inside the container, you can access the page at [http://localhost:8080/jumia-app/customer.xhtml](http://localhost:8080/jumia-app/customer.xhtml).

### About the project
***

To develop this project, it was used:
- Back end: Spring Boot v2.6.1 with Java 11
- Front end: JSF with Primefaces v11.0.0



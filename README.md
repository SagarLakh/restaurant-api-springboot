# restaurant-api-springboot
An api which manages restaurants, developed in spring boot using the layered architecture. It represents the Restaurant domain in a Trip Advisor like context.

Before starting the application, it is necessary to run the following command to generate the jar executable and run all tests:

`./mvnw clean install`

To start the application, make sure the docker daemon is running and go to the docker-compose folder and run the following command: 

`docker compose up`

This command will start up the postgres database and the application. The application will be accessible through the 8080 port.
You can go to the following link to access the Swagger documentation: http://localhost:8080/documentation/swagger-ui/

When developing, to generate a working containerized version you should remove the latest docker app generated for the application. The following command should do the trick:

`docker rmi restaurant-api:latest`

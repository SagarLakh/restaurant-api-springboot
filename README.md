# restaurant-api-springboot
An api which manages restaurants you have visited and comments on them, developed in spring boot using the layered architecture.

To start the application, make sure the docker daemon is running and go to the docker-compose folder and run the following command: 

`docker compose up`

This command will start up the postgres database and the application. The application will be accessible through the 8080 port.

When developing, to generate a working containerized version you should remove the latest docker app generated for the application. The followind command should do the trick:

`docker rmi restaurant-api:latest`

FROM openjdk:16

COPY /target/restaurant-api*.jar app.jar

ENTRYPOINT ["java","-jar", "/app.jar"]
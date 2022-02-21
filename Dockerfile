FROM openjdk:16
#VOLUME /tmp

#RUN groupadd spring && useradd spring -g spring
#USER spring:spring
COPY /target/restaurant-api*.jar app.jar

ENTRYPOINT ["java","-jar", "/app.jar"]
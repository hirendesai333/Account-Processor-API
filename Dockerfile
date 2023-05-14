FROM openjdk:11
ADD target/demo-0.0.1-SNAPSHOT.jar registration-microservice.jar
#EXPOSE 8080
ENTRYPOINT ["java", "-jar", "registration-microservice.jar"]

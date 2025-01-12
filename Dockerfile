FROM openjdk:17-alpine
COPY /target/email.jar email.jar
ENTRYPOINT ["java","-jar", "/email.jar"]
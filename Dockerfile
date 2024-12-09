FROM openjdk:21-slim
COPY target/spring-transcriber-api-0.0.1-SNAPSHOT.jar spring-transcriber-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/spring-transcriber-api.jar"]
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/server-b-1.0-SNAPSHOT.jar app.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "app.jar"]
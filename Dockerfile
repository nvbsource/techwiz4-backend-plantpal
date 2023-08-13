# Stage 1: Build the Spring Boot application with Maven
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Create the final image with the built JAR
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/mobile_backend-0.0.1-SNAPSHOT.jar app.jar
COPY wait-for-it.sh wait-for-it.sh
EXPOSE 8080
CMD ["./wait-for-it.sh","database:3306","--","java", "-jar", "app.jar"]

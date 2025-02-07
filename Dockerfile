# Use a multi-stage build to minimize the final image size

# Stage 1: Build the Spring Boot application using Maven
FROM maven:3.8.6-openjdk-11 AS backend-builder
WORKDIR /app
COPY pom.xml . 
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Final runtime image
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=backend-builder /app/target/*.jar app.jar
# Set the Spring Boot profile and database connection
ENV SPRING_PROFILES_ACTIVE=prod
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "app.jar"] 
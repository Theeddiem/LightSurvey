# Stage 1: Build Vue.js frontend
# FROM node:14 AS frontend-builder
# WORKDIR /frontend
# COPY frontend/package*.json ./
# RUN npm install
# COPY frontend .
# RUN npm run build

# Stage 2: Build the Spring Boot application using Maven
FROM maven:3.8.6-openjdk-11 AS backend-builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
# Copy built Vue.js files to Spring Boot static resources
RUN mvn clean package -DskipTests

# Stage 3: Setup PostgreSQL
FROM postgres:13 AS database
ENV POSTGRES_DB=postgres
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=admin
EXPOSE 5432

# Stage 4: Final runtime image
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=backend-builder /app/target/*.jar app.jar
# Set the Spring Boot profile and database connection
ENV SPRING_PROFILES_ACTIVE=prod
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://database:5432/postgres
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=admin
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "app.jar"]
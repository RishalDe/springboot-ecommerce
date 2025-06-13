# Use a Java 17 image with Maven pre-installed
FROM maven:3.9.4-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy everything to container
COPY . .

# Package the Spring Boot app (skipping tests)
RUN mvn clean package -DskipTests

# Run the app
CMD ["java", "-jar", "target/*.jar"]

# Use an OpenJDK base image
FROM openjdk:20-ea-4-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/clients-management-0.0.1-SNAPSHOT.jar clients-management-0.0.1-SNAPSHOT.jar

# Expose the port your Spring Boot application listens on (change the port number if needed)
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "clients-management-0.0.1-SNAPSHOT.jar"]
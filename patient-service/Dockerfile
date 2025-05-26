# Needs java JDK and maven
# User maven as builder to build the java application
FROM maven:3.9.9-eclipse-temurin-21 AS builder
# Working dir
WORKDIR /app

COPY pom.xml .

# Install the dependencies
RUN mvn dependency:go-offline -B

# Copy all source files under src/ to /app/src folder
COPY src ./src

# Maven clean and build the package to jar(war) file
RUN mvn clean package

# Use openjdk as runner to execute the warn/jar file
FROM openjdk:21-jdk AS runner

WORKDIR /app

# Copy the .jar file from the builder to ./app.jar
COPY --from=builder ./app/target/patient-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4000
ENTRYPOINT ["java", "-jar", "app.jar"]
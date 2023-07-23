FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn clean package

FROM openjdk:17-jdk-slim
WORKDIR /calculator
COPY --from=build /app/target/Calculator-1.0-SNAPSHOT.jar /Calculator.jar
CMD ["java", "-jar", "/Calculator.jar"]


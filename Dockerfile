FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN export PATH=$PATH:/usr/local/openjdk-18/bin && mvn package --quiet

FROM openjdk:18
COPY --from=build /app/target/classes /app
WORKDIR /app
ENTRYPOINT ["java", "main.java.Main"]
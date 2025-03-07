FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    maven \
    && rm -rf /var/lib/apt/lists/*

COPY . .

RUN mvn clean install -U

FROM openjdk:17-jdk-slim

EXPOSE 8081

COPY --from=build target/prontuario-exames-api-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]

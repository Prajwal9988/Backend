# Build Stage
FROM maven:3.9.6-amazoncorretto-21-al2023 AS build
WORKDIR /home/app
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package

# Runtime Stage
FROM openjdk:23-slim-bookworm
EXPOSE 5000
COPY --from=build /home/app/target/kinara-0.0.1-SNAPSHOT.jar /kinara-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/kinara-0.0.1-SNAPSHOT.jar"]

FROM eclipse-temurin:8u402-b06-jre-jammy
LABEL name="Spring Boot Library System"
WORKDIR /app
COPY ./target/crud-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "crud-0.0.1-SNAPSHOT.jar"]
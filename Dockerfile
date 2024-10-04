FROM maven:3.9.9-eclipse-temurin-21-alpine as build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM eclipse-temurin:21-jdk
#COPY --from=build /app/target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/target/app.jar"]

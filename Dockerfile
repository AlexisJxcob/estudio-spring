FROM maven:3.9.11-eclipse-temurin-25 AS build
WORKDIR /app

COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw && ./mvnw -q -DskipTests dependency:go-offline

COPY src src
RUN ./mvnw -q -DskipTests package

FROM eclipse-temurin:25-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENV DB_URL="" \
    DB_USER="" \
    DB_PASS="" \
    TENANT_ID="" \
    CLIENTE_ID="" \
    CLIENTE_SECRET=""

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar app.jar"]
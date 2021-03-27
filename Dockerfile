FROM openjdk:15-jdk as build
WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw package -DskipTests

FROM openjdk:15-alpine as runner
ARG JAR_PATH=/app/target/quarkus-app

COPY --from=build ${DEPENDENCY} /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "quarkus-run.jar"]
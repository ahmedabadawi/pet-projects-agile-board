FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=agile-board-spring-boot-postgres-0-SNAPSHOT.jar
COPY ./target/${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandome", "-jar", "/app.jar"]
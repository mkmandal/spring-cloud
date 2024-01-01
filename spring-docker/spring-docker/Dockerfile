FROM eclipse-temurin:17

LABEL mentainer="mkmandal1123@gmail.com"

WORKDIR /app

COPY target/spring-docker-0.0.1-SNAPSHOT.jar /app/spring-docker.jar

ENTRYPOINT [ "java", "-jar", "spring-docker.jar" ]
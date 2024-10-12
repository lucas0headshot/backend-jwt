FROM maven:3.9.9-eclipse-temurin-23-alpine as build

COPY . /usr/src/mymaven/

WORKDIR /usr/src/mymaven/
RUN mvn clean install -Dmaven.test.skip=true -P prod

EXPOSE 8080
ENTRYPOINT ["java","-jar","target/exemplo-security-api-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]
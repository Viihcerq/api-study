#Etapa: build
FROM maven:3.9.11-eclipse-temurin-17 AS build
WORKDIR /opt/app
COPY . .
RUN mvn clean package -DskipTests

#Etapa 2: runtime
FROM eclipse-temurin:17-jdk
RUN mkdir /opt/app
COPY --from=build /opt/app/target/app.jar /opt/app/app.jar
WORKDIR /opt/app
CMD [ "java", "-jar", "app.jar"]

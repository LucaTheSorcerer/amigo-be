FROM openjdk:21-jdk-oracle

WORKDIR /app
COPY target/amigo_app_v1.jar /tmp/amigo_app_v1.jar
COPY .env /app/.env
EXPOSE 8443

ENTRYPOINT ["java", "-jar", "/tmp/amigo_app_v1.jar"]
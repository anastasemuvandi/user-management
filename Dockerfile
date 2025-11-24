FROM openjdk:26-ea-slim-bookworm

WORKDIR /app

COPY target/product-app-0.0.1.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

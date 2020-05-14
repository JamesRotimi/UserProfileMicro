FROM openjdk:8

RUN mkdir -p /app/
RUN mkdir -p /app/logs/

ADD target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "jar", "/app/app.jar"]

EXPOSE 8080

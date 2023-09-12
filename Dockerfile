FROM openjdk:11
COPY /target/rabbitConsume-0.0.1-SNAPSHOT.jar backend_consume.jar
CMD ["java", "-jar", "backend_consume.jar"]
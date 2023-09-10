FROM openjdk:11
ADD /target/RabbitAppConsume-0.0.1-SNAPSHOT.jar backend_consume.jar
ENTRYPOINT ["java", "-jar", "backend_consume.jar"]
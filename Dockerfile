FROM openjdk:8-jdk-alpine
VOLUME /tmp
#COPY target/app-0.0.1-SNAPSHOT.jar app.jar
COPY build/libs/app-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
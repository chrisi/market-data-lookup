FROM dockerhub.gtidev.net/gtidev/alpine-jre-slim:latest 
ADD demo.jar app.jar
ADD application.properties application.properties
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

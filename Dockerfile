FROM frolvlad/alpine-oraclejdk8:slim
ADD demo.jar app.jar
ADD application.properties application.properties
ENTRYPOINT ["java","-jar","/app.jar"]

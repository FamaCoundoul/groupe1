#decrit les etapes de creation d'une image
FROM openjdk:11-jdk
LABEL maintainer="com.ca.formation"
VOLUME /main-app
ADD target/formation-demo1-0.0.1-SNAPSHOT.jar  app.jar
EXPOSE 8030
ENTRYPOINT ["java","-jar","/app.jar"]

FROM jenkins/jenkins:lts-jdk11
USER root
RUN curl -sSl https://get.docker.com/ |sh
USER jenkins
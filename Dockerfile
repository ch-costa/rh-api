FROM openjdk:11

WORKDIR /opt/rhapi

COPY /target/rh-api*.jar rhapi.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8080

CMD java -jar rhapi.jar
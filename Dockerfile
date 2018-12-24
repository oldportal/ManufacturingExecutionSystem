FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ENV _JAVA_OPTIONS "-Xms256m -Xmx512m"
COPY ${JAR_FILE} /opt/manufacturing-execution-system.jar
WORKDIR /opt
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/manufacturing-execution-system.jar"]
EXPOSE 8080/tcp

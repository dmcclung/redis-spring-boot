FROM adoptopenjdk/openjdk11
ARG JAR_FILE=target/*.jar

EXPOSE 8080
RUN addgroup spring && adduser spring --ingroup spring

USER spring:spring

COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar"]

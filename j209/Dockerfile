FROM openjdk:11

EXPOSE ${SPRINGBOOT_PORT}

ADD ./build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

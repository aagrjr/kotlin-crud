FROM openjdk:22-slim-bullseye
EXPOSE 8080

COPY /build/libs/kotlin-crud-*.jar forum.jar

ENTRYPOINT ["java","-jar","forum.jar"]

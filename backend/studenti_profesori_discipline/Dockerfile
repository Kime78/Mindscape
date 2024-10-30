FROM openjdk:17
WORKDIR /studenti_profesori_discipline
CMD ["./gradlew", "clean", "bootJar"]
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
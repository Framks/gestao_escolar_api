
FROM gradle:8.4-jdk21 AS builder
WORKDIR /home/gradle/project

COPY --chown=gradle:gradle . .
RUN ./gradlew bootJar --no-daemon

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar

EXPOSE 8080

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE:-prod} -jar /app/app.jar"]
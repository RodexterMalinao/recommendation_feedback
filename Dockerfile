FROM openjdk:8

COPY target/recommendation_feedback-0.0.1-SNAPSHOT.jar /usr/local/bin
WORKDIR /usr/local/bin

CMD ["java", "-jar", "recommendation_feedback-0.0.1-SNAPSHOT.jar"]

EXPOSE 8081
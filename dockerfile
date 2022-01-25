FROM adoptopenjdk/openjdk11:jre-11.0.13_8-alpine

EXPOSE 8081

ADD target/JCLO_homework1_1_1-0.0.1-SNAPSHOT.jar app_prod.jar

CMD ["java", "-jar", "/app_prod.jar"]
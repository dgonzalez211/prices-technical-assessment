FROM amazoncorretto:17-alpine3.15
MAINTAINER dgonzalez211
COPY target/prices-technical-assessment-0.0.1-SNAPSHOT.jar prices-technical-assessment-0.0.1.jar
ENTRYPOINT ["java","-jar","/prices-technical-assessment-0.0.1.jar"]
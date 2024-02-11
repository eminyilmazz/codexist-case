FROM openjdk:17-jdk-alpine

WORKDIR /app

MAINTAINER Emin Yilmaz <eminyilmzz@gmail.com>
EXPOSE 8070
COPY target/case-be-0.0.1.jar /app/case-be.jar

ENTRYPOINT ["java","-jar","case-be.jar"]
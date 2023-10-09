FROM openjdk:17
COPY target//spring-boot-web-basic-rest-api/target/spring-boot-web-basic-rest-api-0.0.1-SNAPSHOT.jar /user/app
WORKDIR /user/app
ENTRYPOINT [ "java","-jar","spring-boot-web-basic-rest-api/target/spring-boot-web-basic-rest-api-0.0.1-SNAPSHOT.jar" ]
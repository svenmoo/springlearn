FROM java:8
VOLUME /tmp
ADD target/eurake-server7001-0.0.1-SNAPSHOT.jar app.jar

#配置环境参数
ENV SPRING_PROFILES_ACTIVE docker

ENV BSY_SERVER_PORT 7005
ENV BSY_APPLICATION_NAME eureka01-app

ENV BSY_EUREKA_NAME eureka1
ENV BSY_EUREKA_ZONE http://eureka2:7006/eureka/

EXPOSE ${BSY_SERVER_PORT}
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]
FROM java:8
VOLUME /tmp
ADD target/eureka-provider8020-0.0.1-SNAPSHOT.jar app.jar

#配置环境参数
ENV SPRING_PROFILES_ACTIVE docker
ENV BSY_SERVER_PORT 8025

ENV BSY_INSTANTCE_ID eureka-provider1

#消费者本地debug使用localhost, docker内使用container name
ENV BSY_HOST_NAME localhost


#需要根据run时link参数修改
ENV BSY_MYSQL_HOST mysql

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]
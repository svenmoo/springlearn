FROM java:8
VOLUME /tmp
ADD target/dbapi-0.0.1-SNAPSHOT.jar app.jar

#配置环境参数
ENV SPRING_PROFILES_ACTIVE docker
ENV BSY_SERVER_PORT 8017
ENV BSY_APPLICATION_NAME dbapi-docker

#需要根据run时link参数修改
ENV BSY_MYSQL_HOST mysql

EXPOSE ${BSY_SERVER_PORT}
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]
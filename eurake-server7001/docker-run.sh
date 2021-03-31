docker run -d \
--restart=always \
-e SPRING_PROFILES_ACTIVE=docker \
-e BSY_SERVER_PORT=7001 \
-e BSY_SERVER_IP=192.168.1.188 \
-e BSY_APPLICATION_NAME=eureka1-app \
-e BSY_EUREKA_NAME=eureka1 \
-e BSY_EUREKA_ZONE=http://192.168.1.188:7002/eureka/ \
-v /root/springboot/eureka1:/app \
-p 7001:7001 \
--name eureka1 \
java:8 /usr/bin/java -jar \
-Duser.timezone=GMT+08 \
/app/eureka.jar


docker run -d \
--restart=always \
-e SPRING_PROFILES_ACTIVE=docker \
-e BSY_SERVER_PORT=7002 \
-e BSY_SERVER_IP=192.168.1.188 \
-e BSY_APPLICATION_NAME=eureka2-app \
-e BSY_EUREKA_NAME=eureka2 \
-e BSY_EUREKA_ZONE=http://192.168.1.188:7001/eureka/ \
-v /root/springboot/eureka2:/app \
-p 7002:7002 \
--name eureka2 \
java:8 /usr/bin/java -jar \
-Duser.timezone=GMT+08 \
/app/eureka.jar
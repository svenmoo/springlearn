docker run -d \
--restart=always \
-e SPRING_PROFILES_ACTIVE=docker \
-e BSY_SERVER_PORT=9001 \
-e BSY_SERVER_IP=192.168.1.188 \
-e BSY_EUREKA_ZONE=http://192.168.1.188:7001/eureka,http://192.168.1.188:7002/eureka \
-v /root/springboot/apiservice1:/app \
-p 9001:9001 \
--name apiservice1 \
java:8 /usr/bin/java -jar \
-Duser.timezone=GMT+08 \
/app/apiservice.jar

docker run -d \
--restart=always \
-e SPRING_PROFILES_ACTIVE=docker \
-e BSY_SERVER_PORT=9002 \
-e BSY_SERVER_IP=192.168.1.188 \
-e BSY_EUREKA_ZONE=http://192.168.1.188:7001/eureka,http://192.168.1.188:7002/eureka \
-v /root/springboot/apiservice2:/app \
-p 9002:9002 \
--name apiservice2 \
java:8 /usr/bin/java -jar \
-Duser.timezone=GMT+08 \
/app/apiservice.jar
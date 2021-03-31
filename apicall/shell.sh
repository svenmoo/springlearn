docker run -v /root/springboot/apicall:/app -p 12345:12345 --name apicall --entrypoint "java -jar /app/app.jar" java:8

docker run -d -v /root/springboot/apicall:/app --name apicalljar

docker run -d \
--restart=always \
-v /root/springboot/apicall:/app \
-p 12345:12345 \
--name apicall \
java:8 /usr/bin/java -jar \
-Duser.timezone=GMT+08 \
/app/apicall.jar

#hystrix.threadpool.threads.active.current.count



docker run -d \
--restart=always \
-e SPRING_PROFILES_ACTIVE=docker \
-e BSY_SERVER_PORT=8001 \
-e BSY_SERVER_IP=192.168.1.188 \
-e BSY_EUREKA_ZONE=http://192.168.1.188:7001/eureka,http://192.168.1.188:7002/eureka \
-v /root/springboot/apicall1:/app \
-p 8001:8001 \
--name apicall1 \
java:8 /usr/bin/java -jar \
-Duser.timezone=GMT+08 \
/app/apicall.jar

docker run -d \
--restart=always \
-e SPRING_PROFILES_ACTIVE=docker \
-e BSY_SERVER_PORT=8002 \
-e BSY_SERVER_IP=192.168.1.188 \
-e BSY_EUREKA_ZONE=http://192.168.1.188:7001/eureka,http://192.168.1.188:7002/eureka \
-v /root/springboot/apicall2:/app \
-p 8002:8002 \
--name apicall2 \
java:8 /usr/bin/java -jar \
-Duser.timezone=GMT+08 \
/app/apicall.jar
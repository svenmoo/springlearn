docker run -d \
--restart=always \
-v /root/springboot/apicall:/app \
-p 12345:12345 \
--name apicall \
java:8 /usr/bin/java -jar \
-Duser.timezone=GMT+08 \
/app/app.jar
#!/bin/bash

#http://192.168.1.188:9001/actuator/metrics/hystrix.threadpool.threads.active.current.count

container_name=apiservice1
ip_port=192.168.1.188:9001
wait_time=90  #服务同步eureka时间，ribbon缓存时间

#1.停止应用的服务注册
curl -s -w %{http_code} -X "POST" "http://192.168.1.188:9001/actuator/service-registry?status=DOWN" -H "Content-Type: application/vnd.spring-boot.actuator.v2+json;charset=UTF-8"

#2.等待服务更新时间刷新时间，保证其他服务已更新最新服务列表
sleep 35

#3.再等几秒，判断没有运行的请求
activeNum=$(curl -s http://192.168.1.188:9001/actuator/metrics/hystrix.threadpool.threads.active.current.count | jq ".measurements[0].value")

while [ "$activeNum" != "" ]  && [ "$activeNum" != "0" ]
do
        echo 'waiting active threads...'
        sleep 1
        activeNum=$(curl -s http://192.168.1.188:9001/actuator/metrics/hystrix.threadpool.threads.active.current.count | jq ".measurements[0].value")
done
#4.更新docker自动重启配置，关闭自动重启
docker update --restart=no apiservice1
#5.调用shutdown停止服务
curl -s -X POST http://192.168.1.188:9001/actuator/shutdown
wait
#6.再等几秒检查docker服务状态,判断是否已停止
container_state=$(docker ps -a --filter "name=apiservice1" --format "{{.Status}}")
#7.更新jar包
cp /root/springboot/apiservice-new.jar /root/springboot/apiservice1/apiservice.jar
#8.更新docker自动重启
docker update --restart=always apiservice1
#9.启动服务
docker restart apiservice1
wait
#10.检测应用服务状态
curl -s http://192.168.1.188:9001/actuator/health | jq ".status"
wait
#11.检测Eureka上服务状态
#12.处理下一个

#使用vi 更新windows换行符
#:set ff=unix
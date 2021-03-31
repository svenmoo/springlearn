docker update --restart=no apicall1 & curl -X POST http://192.168.1.188:8001/actuator/shutdown

docker update --restart=always & docker start apicall1
package com.bsy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

//    @PostConstruct
//    void start(){
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC+8"));
//    }

    public static void main(String args[]){
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}

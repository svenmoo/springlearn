package com.bsy.slueth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class ConsumerController {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/main/callhello")
    public String callHello(){
        RestTemplate rt = getRestTemplate();
        String result = rt.getForObject("http://SLEUTH-PROVIDER/main/hello", String.class);
        return "server: " + applicationName + ":" + serverPort + "called /main/hello---" + result;
    }
}

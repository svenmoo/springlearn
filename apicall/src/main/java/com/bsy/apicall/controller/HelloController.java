package com.bsy.apicall.controller;

import com.bsy.apicall.service.RemoteService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@DefaultProperties(defaultFallback = "hystrixGet")
public class HelloController {

    @Resource
    private RemoteService remoteService;

    @GetMapping("/hello/direct")
    @HystrixCommand
    public String direct(Optional<String> user){
        return "welcome " + user.orElse("guest") + "!";
    }

    @GetMapping("/hello/lazy")
    @HystrixCommand
    public String lazy(Optional<String> user, Optional<Long> lazyMilliseconds)
            throws InterruptedException {
        Thread.sleep(lazyMilliseconds.orElse(300l));
        return "welcome " + user.orElse("guest") + "!";
    }

    @GetMapping("/hello/remote")
    @HystrixCommand
    public String RemoteLazy(int times){
        String result = remoteService.lazyHello(times);

        return result;
    }


    public String hystrixGet() {
        return "error";
    }

}

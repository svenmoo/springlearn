package com.bsy.apicall.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name = "apiservice")
public interface RemoteService {

    @GetMapping("/remote/lazy")
    String lazyHello(@RequestParam("times")int times);
}

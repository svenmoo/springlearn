package com.bsy.provider.eureka.contolller;


import com.bsy.provider.eureka.service.UserService;
import com.bsy.provider.eureka.entity.BaseResult;
import com.bsy.provider.eureka.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/user/add")
    public BaseResult AddUserByName(String username){
        int result = userService.AddUser(username);
        return BaseResult.Success(result);
    }

    @GetMapping("/user/last")
    public BaseResult GetLastUsers(){
        List<Userinfo> users = userService.GetLastUsers();

        return BaseResult.Success(users);
    }

    @GetMapping("/user/hello")
    public ResponseEntity Hello(){
        BaseResult result = BaseResult.Success("hello [port is " + serverPort + ", app name is " + applicationName + "]");
        HttpHeaders headers = new HttpHeaders();
        headers.add("port", serverPort);
        return new ResponseEntity(result, headers, HttpStatus.OK);
    }
}
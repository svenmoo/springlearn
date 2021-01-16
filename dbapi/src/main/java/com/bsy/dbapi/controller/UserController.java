package com.bsy.dbapi.controller;

import com.bsy.dbapi.entity.BaseResult;
import com.bsy.dbapi.entity.Userinfo;
import com.bsy.dbapi.service.UserService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public BaseResult Hello(){
        return BaseResult.Success("hello [port is " + serverPort + ", app name is " + applicationName + "]");
    }
}

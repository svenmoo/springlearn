package com.bsy.spring.api.controllers;

import com.bsy.spring.api.entities.BaseResult;
import com.bsy.spring.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/hello")
    public BaseResult Hello(){
        return BaseResult.Success();
    }

    @GetMapping(path = "/add")
    public BaseResult AddUser(@RequestParam String username){
        userService.AddUser(username);
        return BaseResult.Success();
    }
}

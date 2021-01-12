package com.bsy.spring.api.controllers;

import com.bsy.spring.api.entities.BaseResult;
import com.bsy.spring.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/add")
    public BaseResult AddUser(String username){
        int result = userService.AddUser(username);
        return BaseResult.Success(result);
    }
}

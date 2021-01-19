package com.bsy.sonsumer.controller;

import com.bsy.common.entity.BaseResult;
import com.bsy.sonsumer.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("user/last")
    public BaseResult GetLastUsers(){
        return userService.getLastUsersResult();
    }
}

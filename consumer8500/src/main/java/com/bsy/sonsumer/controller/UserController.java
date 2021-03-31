package com.bsy.sonsumer.controller;

import com.bsy.common.entity.BaseResult;
import com.bsy.sonsumer.service.FeignUserService;
import com.bsy.sonsumer.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private FeignUserService feignUserService;

    @GetMapping("user/last")
    public BaseResult GetLastUsers(){
        return feignUserService.getLastUsers();
//        return userService.getLastUsersResult();
    }

    @GetMapping("user/last2")
    public BaseResult GetLastUsers2(){
        return feignUserService.getLastUsers();
    }
}

package com.bsy.spring.api.controllers;

import com.bsy.spring.api.entities.BaseResult;
import com.bsy.spring.api.entities.Userinfo;
import com.bsy.spring.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public BaseResult Hello(){
        return BaseResult.Success();
    }

    @PostMapping("/add")
    public BaseResult AddUser(String username, Date createtime){
        int result = userService.AddUser(username, createtime);
        return BaseResult.Success(result);
    }

    @PostMapping(value = "/abuser")
    public BaseResult AddUserEntity(@RequestBody Userinfo info) {
        int result = userService.AddUser(info);
        return BaseResult.Success(result);
    }

    @GetMapping(value = "/id/{userId}")
    public BaseResult<Userinfo> getUserById(@PathVariable("userId") Integer userId) {
        return BaseResult.Success(userService.getUserById(userId));
    }

    @GetMapping(value = "/top")
    public BaseResult<List<Userinfo>> getTopUsers(){
        List<Userinfo> topUsers = userService.getTopUsers();
        List<Userinfo> collect = topUsers.stream().filter(u -> u.getUserid() % 2 == 0).collect(Collectors.toList());
        log.info("获取偶数对象");
        return BaseResult.Success(collect);
    }
}

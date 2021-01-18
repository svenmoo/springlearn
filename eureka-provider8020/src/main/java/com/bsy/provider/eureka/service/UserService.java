package com.bsy.provider.eureka.service;

import com.bsy.provider.eureka.entity.Userinfo;

import java.util.List;

public interface UserService {

    int AddUser(String username);
    Userinfo GetUserById(Integer userId);
    List<Userinfo> GetLastUsers();

}

package com.bsy.dbapi.service;

import com.bsy.dbapi.entity.Userinfo;

import java.util.List;

public interface UserService {

    int AddUser(String username);
    Userinfo GetUserById(Integer userId);
    List<Userinfo> GetLastUsers();

}

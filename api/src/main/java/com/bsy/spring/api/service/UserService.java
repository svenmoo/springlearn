package com.bsy.spring.api.service;

import com.bsy.spring.api.dao.UserDao;
import com.bsy.spring.api.entities.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void AddUser(String username){
        Userinfo userinfo = new Userinfo(0, username, new Date());
        userDao.insert(userinfo);
    }
}

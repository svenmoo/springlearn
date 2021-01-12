package com.bsy.spring.api.service;

import com.bsy.spring.api.dao.UserDao;
import com.bsy.spring.api.entities.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int AddUser(String username){
        Userinfo userinfo = new Userinfo(0, username, new Date());
        userDao.insert(userinfo);
        return userinfo.getUserid();
    }

    public int AddUser(String username, Date createtime){
        Userinfo userinfo = new Userinfo(0, username, createtime);
        int insert = userDao.insert(userinfo);
        return userinfo.getUserid();
    }

    public int AddUser(Userinfo userinfo){
        userDao.insert(userinfo);
        return userinfo.getUserid();
    }

    public List<Userinfo> getTopUsers() {
        return userDao.getTopUsers();

    }

    public Userinfo getUserById(int userId) {
        return userDao.getUserById(userId);
    }
}

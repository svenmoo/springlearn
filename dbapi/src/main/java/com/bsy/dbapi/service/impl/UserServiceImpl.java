package com.bsy.dbapi.service.impl;

import com.bsy.dbapi.dao.UserDao;
import com.bsy.dbapi.entity.Userinfo;
import com.bsy.dbapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int AddUser(String username) {
        Userinfo user = new Userinfo(0, username, new Date());
        return userDao.insert(user);
    }

    @Override
    public Userinfo GetUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public List<Userinfo> GetLastUsers() {
        return userDao.getLastUsers();
    }
}

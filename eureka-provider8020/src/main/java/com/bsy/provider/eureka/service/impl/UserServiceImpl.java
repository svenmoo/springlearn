package com.bsy.provider.eureka.service.impl;

import com.bsy.provider.eureka.dao.UserDao;
import com.bsy.provider.eureka.service.UserService;
import com.bsy.provider.eureka.entity.Userinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
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

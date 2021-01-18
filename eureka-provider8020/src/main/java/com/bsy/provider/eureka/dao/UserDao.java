package com.bsy.provider.eureka.dao;

import com.bsy.provider.eureka.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    int insert(Userinfo record);
    Userinfo getUserById(int userId);
    List<Userinfo> getLastUsers();
}

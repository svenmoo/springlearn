package com.bsy.spring.api.dao;

import com.bsy.spring.api.entities.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    int insert(Userinfo record);
    Userinfo getUserById(int userId);
    List<Userinfo> getTopUsers();
}

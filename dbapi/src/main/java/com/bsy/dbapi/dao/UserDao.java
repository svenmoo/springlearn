package com.bsy.dbapi.dao;

import com.bsy.dbapi.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    int insert(Userinfo record);
    Userinfo getUserById(int userId);
    List<Userinfo> getLastUsers();
}

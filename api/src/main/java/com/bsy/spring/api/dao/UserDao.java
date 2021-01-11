package com.bsy.spring.api.dao;

import com.bsy.spring.api.entities.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    int insert(Userinfo record);
}

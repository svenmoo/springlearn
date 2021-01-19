package com.bsy.sonsumer.service;


import com.bsy.common.entity.BaseResult;
import com.bsy.common.entity.Userinfo;

import java.util.List;

public interface UserService {
    List<Userinfo> getLastUsers();
    String hello();
    BaseResult<List<Userinfo>> getLastUsersResult();
    BaseResult<String> helloResult();
}

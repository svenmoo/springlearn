package com.bsy.sonsumer.service.impl;

import com.bsy.common.entity.Userinfo;
import com.bsy.sonsumer.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import com.bsy.common.api.UserApi;
import com.bsy.common.entity.BaseResult;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public List<Userinfo> getLastUsers() {

        BaseResult<List<Userinfo>> entity = restTemplate.getForObject(UserApi.LIST_TOP_USERS, BaseResult.class);

        return entity.getData();
    }

    @Override
    public String hello() {
        ResponseEntity<BaseResult> entity = restTemplate.getForEntity(UserApi.Hello_USER, BaseResult.class);

        return (String) entity.getBody().getData();
    }

    @Override
    public BaseResult<List<Userinfo>> getLastUsersResult() {
        return restTemplate.getForObject(UserApi.LIST_TOP_USERS, BaseResult.class);
    }

    @Override
    public BaseResult<String> helloResult() {
        return restTemplate.getForObject(UserApi.Hello_USER, BaseResult.class);
    }
}

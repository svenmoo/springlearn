package com.bsy.sonsumer.service;

import com.bsy.common.api.UserApi;
import com.bsy.common.entity.BaseResult;
import com.bsy.common.entity.Userinfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@FeignClient(value = UserApi.USER_SERVICE)
public interface FeignUserService {

    @Bean
    @GetMapping("user/last")
    BaseResult getLastUsers();
}


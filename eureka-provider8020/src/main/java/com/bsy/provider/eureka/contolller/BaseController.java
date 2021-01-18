package com.bsy.provider.eureka.contolller;

import com.bsy.provider.eureka.entity.BaseResult;

public abstract class BaseController {
    protected BaseResult success(){
        return BaseResult.Success();
    }
}

package com.bsy.provider.eureka.contolller;

import com.bsy.common.entity.BaseResult;

public abstract class BaseController {
    protected BaseResult success(){
        return BaseResult.Success();
    }
}

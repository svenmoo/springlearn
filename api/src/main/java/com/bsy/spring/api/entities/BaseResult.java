package com.bsy.spring.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResult<T> {
    public int code;
    public String msg;
    public T data;

    public static BaseResult Success(){
        return new BaseResult(200, "success", null);
    }
}

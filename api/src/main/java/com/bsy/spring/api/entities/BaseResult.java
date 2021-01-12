package com.bsy.spring.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult<T> {
    public int code;
    public String msg;
    public T data;

    public static BaseResult Success(){
        return new BaseResult(200, "success", null);
    }

    public static <T> BaseResult<T> Success(T data){
        return new BaseResult(200, "success", data);
    }
}

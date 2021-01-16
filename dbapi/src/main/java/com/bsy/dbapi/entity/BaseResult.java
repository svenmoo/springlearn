package com.bsy.dbapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult<T> implements Serializable {
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

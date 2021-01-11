package com.bsy.spring.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Userinfo {
    private int userid;
    private String username;
    private Date createtime;
}

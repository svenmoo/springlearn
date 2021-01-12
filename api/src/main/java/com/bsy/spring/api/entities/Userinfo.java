package com.bsy.spring.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Userinfo {
    private Integer userid;
    private String username;
    private Date createtime;
}

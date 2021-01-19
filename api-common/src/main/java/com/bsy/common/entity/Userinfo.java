package com.bsy.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Userinfo {
    private Integer userid;
    private String username;
    private Date createtime;
}

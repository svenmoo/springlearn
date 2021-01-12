package com.bsy.spring.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Userinfo {
    private Integer userid;
    private String username;
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss", timezone="GMT+8")
    private Date createtime;
}

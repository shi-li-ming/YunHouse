package com.whpu.pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class Users {
    private Integer uid;
    private String name;
    private String pwd;
    private String sex;
    private Date birth;
    private String head_img;
    private String role;
}

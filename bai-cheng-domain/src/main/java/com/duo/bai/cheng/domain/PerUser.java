package com.duo.bai.cheng.domain;

import lombok.Data;

import java.util.Date;

@Data
public class PerUser {
    /*
    id         bigint(20) NOT NULL
    pname      varchar(50) NOT NULL用户名
    password   varchar(32) NOT NULL密码，加密传输
    phone      varchar(20) NULL个人注册手机号
    email      varchar(50) NULL个人注册邮箱
    created    datetime NOT NULL账号创建时间
    icard      varchar(50) NULL个人身份证
    address    varchar(80) NULL家庭住址
    nickname   varchar(50) NULL昵称
    pid        int(1) NOT NULL个人编号
    mainname   varchar(255) NULL紧急联系人
    mainphone  int(20) NULL紧急联系方式
    relation   varchar(20) NULL紧急联系人关系

    */

     private long id;
     private String pname;
     private String password;
     private String phone;
     private String email;
     private Date created;
     private String icard;
     private String address;
     private String nickname;
     private int pid;
     private String mainname;
     private int mainphone;
     private String relation;

     
}

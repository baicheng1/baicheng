package com.duo.bai.cheng.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ComUser {

   /*
    id        bigint(20) NOT NULL
    cname     varchar(50) NOT NULL企业名
    password  varchar(32) NOT NULL密码，加密传输
    phone     varchar(20) NULL法人注册手机号
    email     varchar(50) NULL注册邮箱
    bcode     varchar(50) NULL企业工商代码
    icard     varchar(50) NULL法人身份证号
    created   datetime NOT NULL账号创建时间
    address   varchar(80) NULL公司地址
    nickname  varchar(50) NULL昵称
    pid       int(1) NOT NULL企业编号
    mainname  varchar(255) NULL紧急联系人
    mainphone  int(20) NULL紧急联系方式
    relation   varchar(20) NULL紧急联系人关系




*/

   private long id;
   private String cname;
   private String password;
   private String phone;
   private String email;
   private String bcode;
   private String icard;
   private Date created;
   private String address;
   private String nickname;
   private int pid;
   private String mainname;
   private int mainphone;
   private String relation;



}

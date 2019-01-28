package com.duo.bai.cheng.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

@Data
public class Tb_User implements Serializable {
    /*    CREATE TABLE `per_user` (
            `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) NOT NULL COMMENT '用户名',
            `password` varchar(32) NOT NULL COMMENT '密码，加密传输',
            `phone` varchar(20) DEFAULT NULL COMMENT '个人注册手机号',
            `email` varchar(50) DEFAULT NULL COMMENT '个人注册邮箱',
            `created` datetime NOT NULL COMMENT '账号创建时间',
            `icard` varchar(50) DEFAULT NULL COMMENT '个人身份证',
            `address` varchar(80) DEFAULT NULL COMMENT '家庭住址',
            nickname varchar(50) NOT NULL COMMENT '用户的昵称'，
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8*/
    private Long id;
    @Length(min = 1,message = "用户名不能为空")
    private String pname;
    //这个注解的作用是，Javabean返回前端过程中，被springmvc自带的jackson转化成json字符串时忽略这个属性。对序列化也有影响.
    @Length(min = 1,message = "密码不能为空")
    @JsonIgnore
    private String password;
    private String phone;
    private String email;
    private Date created;
    private String icard;
    private String address;
    private String nickname;
    private int pid;
}

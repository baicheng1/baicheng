package com.duo.bai.cheng.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbPerUser implements Serializable {
/*   `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cname` varchar(50) NOT NULL COMMENT '企业名',
            `password` varchar(32) NOT NULL COMMENT '密码，加密传输',
            `phone` varchar(20) DEFAULT NULL COMMENT '法人注册手机号',
            `email` varchar(50) DEFAULT NULL COMMENT '注册邮箱',
            `bcode` varchar(50) DEFAULT NULL COMMENT '企业工商代码',
            `icard` varchar(50) DEFAULT NULL COMMENT '法人身份证号',
            `created` datetime NOT NULL COMMENT '账号创建时间',
            `address` varchar(80) DEFAULT NULL COMMENT '公司地址',
            nickname varchar(50) NOT NULL COMMENT '用户的昵称'，
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8*/
    private Long id;
    @Length(min = 1,message = "用户名不能为空")
    private String cname;
    //这个注解的作用是，Javabean返回前端过程中，被springmvc自带的jackson转化成json字符串时忽略这个属性。对序列化也有影响.
    @Length(min = 1,message = "密码不能为空")
    @JsonIgnore
    private String password;
    private String phone;
    private String email;
    private String bcode;
    private String icard;
    private Date created;
    private String address;
    private String nickname;
    private int pid;
}

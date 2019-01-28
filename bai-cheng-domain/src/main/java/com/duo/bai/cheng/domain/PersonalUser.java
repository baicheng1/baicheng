package com.duo.bai.cheng.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;


import java.io.Serializable;
import java.util.Date;

@Data
public class PersonalUser implements Serializable {

    private Long id;
    @Length(min=1,message = "用户名不为空")
    private String pname;
    @Length(min=1,message = "密码不为空")
    private String password;
    @Length(min = 11, max = 11, message = "电话号码长度必须为11位！")
    private String phone;
    @Email(message = "电子邮箱地址不合法！")
    private String email;
    private String icard;//个人用户身份证号
    private String address;//个人用户住址
    private Date created;
    private String nickname;
    private int pid;

}

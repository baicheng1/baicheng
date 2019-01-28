package com.duo.bai.cheng.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

@Data
public class EnterpriseUser implements Serializable {

    private Long id;
    @Length(min=1,message = "用户名不为空")
    private String cname;
    @Length(min=1,message = "密码不为空")
    private String password;
    @Length(min = 11, max = 11, message = "联系电话长度必须为11位！")
    private String phone;
    @Email(message = "电子邮箱地址不合法！")
    private String email;
    private String bcode;//企业工商代码
    private String icard;//企业用户法人身份证号
    private String address;//企业用户公司地址
    private Date created;//账户创建日期
    private String nickname;//昵称
    private String pid;

}

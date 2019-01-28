package com.duo.bai.cheng.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Tbhotai implements Serializable {
    private Long id;
    private String username;
    //这个注解的作用是，Javabean返回前端过程中，被springmvc自带的jackson转化成json字符串时忽略这个属性。对序列化也有影响.
    @JsonIgnore
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date update;
}

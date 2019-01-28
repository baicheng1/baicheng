package com.duo.bai.cheng.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
public class TbModify implements Serializable {
    private Long id;
    @Length(min = 1,message = "密码不能为空")
    @JsonIgnore
    private String password;
    @Length(min = 1,message = "确认密码不能为空")
    @JsonIgnore
    private String passwords;
    private String nickname;
    private String email;
    private String phone;
    private String icard;
    private String pic;
    private int pid;
}

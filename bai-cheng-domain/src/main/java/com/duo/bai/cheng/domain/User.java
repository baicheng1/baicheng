package com.duo.bai.cheng.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String uid;
    private String username;
    private String password;
    private int type;
    private String email;
    private String phone;
}

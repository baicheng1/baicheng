package com.duo.bai.cheng.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Credit implements Serializable {

    private Long creditId;
    private String name;
    private String goodsName;
    private Long jieMoney;
    private int month;
    private Date repaytime;
    private Date createtime;

    private double huanMoney;
    private double totalInterest;
    private double perMoney;
    private double perInterest;
    private double dayInterest;
    private Long uid;
}

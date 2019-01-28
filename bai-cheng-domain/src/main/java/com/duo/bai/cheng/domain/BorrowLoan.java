package com.duo.bai.cheng.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BorrowLoan {


   /*
    credit_id         bigint(20)     NOT NULL贷款商品id
    name              varbinary(255) NULL用户名
    pid               int(2)   NULL  0:个人贷款 1:企业贷款
    jie_money         bigint(20)     NULL用户要借的钱
    month             int(20)        NULL借款期限
    repaytime         date           Null还款时间
    createtime        date           NULL借款时间
    huan_money        double         NULL总共要还的钱
    total_interest    double         NULL总利息
    per_money         double         NULL每期要还的钱
    per_interest      double         NULL每期的利息
    day_interest      double         NULL日利率
   */


    private long creditId;
    private String name;
    private int pid;
    private long jieMoney;
    private int  month;
    private Date repaytime;
    private Date createtime;
    private double huanMoney;
    private double totalInterest;
    private double perMoney;
    private double perInterest;
    private double dayInterest;
    private Long uid;




}

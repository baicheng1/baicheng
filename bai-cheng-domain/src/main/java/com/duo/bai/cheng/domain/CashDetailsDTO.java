package com.duo.bai.cheng.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CashDetailsDTO implements Serializable {

    private Date createtime;
    private Date repaytime;
    private Long jieMoney;
    private String goodsName;
    private Long uid;

}

package com.duo.bai.cheng.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product {
    private int pid;
    private String pname;
    private int ptype;
    private BigDecimal startprice;
    private int time;
    private BigDecimal returnrate;
    private Date created;
}

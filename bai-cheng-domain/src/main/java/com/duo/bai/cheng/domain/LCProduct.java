package com.duo.bai.cheng.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class LCProduct implements Serializable {
    private int pid;
    private String pname;
    private int ptype;
    private BigDecimal startprice;
    private int time;
    private BigDecimal returnrate;
    private Date created;
}

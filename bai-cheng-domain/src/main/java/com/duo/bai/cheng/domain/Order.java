package com.duo.bai.cheng.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order implements Serializable {

    private Integer id;
    private Integer time;
    private Date created;
    private BigDecimal rate;
    private String name;
    private Integer money;
    private BigDecimal interest;
    private String uname;
    private Long uid;
}

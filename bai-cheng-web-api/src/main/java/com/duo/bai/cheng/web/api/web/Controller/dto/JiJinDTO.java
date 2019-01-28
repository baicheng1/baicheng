package com.duo.bai.cheng.web.api.web.Controller.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class JiJinDTO {
    private int id;
    private String name;
    private int apply;
    private BigDecimal buyBack;
    private BigDecimal serviceCharge;
    private BigDecimal unitNetvalue;
    private BigDecimal cumulativeNetvalue;
    private BigDecimal week;
    private BigDecimal onemonth;
    private BigDecimal threemonths;
    private BigDecimal sixmonths;
    private BigDecimal year;
    private BigDecimal threeyear;


}

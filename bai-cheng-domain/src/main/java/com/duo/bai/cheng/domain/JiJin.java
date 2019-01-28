package com.duo.bai.cheng.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class JiJin implements Serializable {
    private int id;//基金代码
    private int order;//推优顺序
    private String type;//类型
    private String name;//名称
    private Boolean apply;//申购状态
    private Boolean buyBack;//回购状态
    private BigDecimal serviceCharge;//手续费
    private String url;
    private BigDecimal unitNetvalue;//单位净值
    private BigDecimal cumulativeNetvalue;//累计净值
    private BigDecimal week;//一周涨幅
    private BigDecimal onemonth;//一周涨幅
    private BigDecimal threemonths;//一月涨幅
    private BigDecimal sixmonths;//一月涨幅
    private BigDecimal year;//一年涨幅
    private BigDecimal threeyear;//一年涨幅
}

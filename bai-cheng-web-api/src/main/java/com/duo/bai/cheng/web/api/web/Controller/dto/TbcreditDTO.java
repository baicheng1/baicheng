package com.duo.bai.cheng.web.api.web.Controller.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbcreditDTO implements Serializable {
/*    CREATE TABLE `Tbcredit` (
            `credit_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '贷款商品id',
            `name` varbinary(255) DEFAULT NULL COMMENT '用户名',
            `pid` int(11) DEFAULT NULL COMMENT '贷款商品，0是个人，1是企业',
            `jie_money` bigint(20) DEFAULT NULL COMMENT '用户要借的钱',
            `month` int(20) DEFAULT NULL COMMENT '借款期限',
            `repaytime` date DEFAULT NULL COMMENT '还款时间',
            `createtime` date DEFAULT NULL COMMENT '借款时间',
            `huan_money` decimal(9,3) DEFAULT NULL COMMENT '总共要还的钱',
            `total_interest` double DEFAULT NULL COMMENT '总利息',
            `per_money` decimal(9,3) DEFAULT NULL COMMENT '每期要还的钱',
            `per_interest` double DEFAULT NULL COMMENT '每期的利息',
            `day_interest` double DEFAULT NULL COMMENT '日利率',
    PRIMARY KEY (`credit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4*/
    private Long creditId;
    private String name;
    private int pid;
    private int month;
    private Date repaytime;
    private double huanMoney;
    private double totalInterest;
}

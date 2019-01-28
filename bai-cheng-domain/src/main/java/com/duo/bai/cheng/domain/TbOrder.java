package com.duo.bai.cheng.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TbOrder implements Serializable {

/*    CREATE TABLE `order` (
            `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` int(11) DEFAULT NULL COMMENT '时间',
            `created` date DEFAULT NULL COMMENT '购买时间',
            `rate` decimal(65,4) DEFAULT NULL COMMENT '月利率',
            `name` varchar(255) DEFAULT NULL COMMENT '理财产品名称',
            `money` int(255) DEFAULT NULL COMMENT '起头金额',
            `interest` decimal(65,4) DEFAULT NULL COMMENT '利息',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8*/
    private int id;
    private int time;
    private Date created;
    private double rate;
    private String name;
    private int money;
    private double interest;
    private String uname;
}

package com.duo.bai.cheng.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LiCaiDTO implements Serializable {

   private Date created;//购买时间
   private int money;//金额
   private double interest;
   private Long uid;



}

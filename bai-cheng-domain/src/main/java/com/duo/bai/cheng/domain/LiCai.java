package com.duo.bai.cheng.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LiCai implements Serializable {

   private int id;
   private int time;
   private Date created;
   private double rate;
   private String name;
   private int money;
   private double interest;
   private String uname;
   private Long uid;



}

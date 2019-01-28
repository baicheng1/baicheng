package com.duo.bai.cheng.web.api.web.Controller.dto;

import lombok.Data;

@Data
public class BorrowLoanDTO {

    private long jieMoney;
    private int  month;
    private double huanMoney;
    private double totalInterest;
    private double perMoney;
    private double perInterest;
    private double dayInterest;


}

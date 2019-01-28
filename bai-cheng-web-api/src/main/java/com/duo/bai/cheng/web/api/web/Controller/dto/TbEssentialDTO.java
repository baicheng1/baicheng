package com.duo.bai.cheng.web.api.web.Controller.dto;

import lombok.Data;

@Data
public class TbEssentialDTO {
/*    day_interest double 昨天借贷回报
    borrowLoanDTO.setPerInterest(borrowLoanDTO.getJieMoney() * 30 * borrowLoanDTO.getDayInterest());累计借贷回报
    borrowLoanDTO.setTotalInterest(borrowLoanDTO.getPerInterest() * borrowLoanDTO.getMonth()); 和上面的相加=账户余额*/
/*huan_moneydecimal(9,3) 要还款*/
/*jie_moneybigint(20) NULL用户要借的钱
    减去
    per_moneydecimal(9,3) NULL每期要还的钱*/
    private double dayInterest;//昨天借贷回报
    private double perInterest;//累计借贷回报
    private int money;//账户余额
    private double huanMoney;//要还款
    private double repayment;//已经还款
    private double interest;//余利宝
}

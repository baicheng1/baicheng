package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.TbOrder;
import com.duo.bai.cheng.domain.Tbcredit;
import com.duo.bai.cheng.web.api.dao.CreditDao;
import com.duo.bai.cheng.web.api.service.EssentialService;
import com.duo.bai.cheng.web.api.web.Controller.dto.TbEssentialDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EssentialServiceImpl implements EssentialService {
    @Autowired
    CreditDao creditDao;
/*    private double dayInterest;//昨天借贷回报
    private double perInterest;//累计借贷回报
    private int money;//账户余额
    private double huanMoney;//要还款
    private double repayment;//已经还款
    private double interest;//余利宝*/
    @Override
    public BaseResult select(String name) {
        Long JieMoney = Long.valueOf(0);//用户要借的钱
        double DayInterest = 0.0;//日利率
        double PerMoney= 0.0;//每期要还的钱
        double huanMoney=0.0;
        int money=0;
        double interest = 0.0;
        TbEssentialDTO tbEssentialDTO = new TbEssentialDTO();
        List<TbOrder> tbOrders = creditDao.selects(name);
        BaseResult baseResult = null;
        if (tbOrders.size()!=0){
            for (TbOrder tbOrder : tbOrders) {
                money+=tbOrder.getMoney();
                interest+=tbOrder.getInterest();
            }
            tbEssentialDTO.setMoney(money);
            tbEssentialDTO.setInterest(interest);
        }else {
            baseResult = BaseResult.fail("没有理财和基金");
        }
        List<Tbcredit> select = creditDao.select(name);
        if (select.size()!=0){
            for (Tbcredit tbcredit : select) {
                JieMoney+=tbcredit.getJieMoney();
                DayInterest+=tbcredit.getDayInterest();
                PerMoney+=tbcredit.getPerMoney();
                huanMoney+=tbcredit.getHuanMoney();
            }
            tbEssentialDTO.setDayInterest(DayInterest);
            tbEssentialDTO.setPerInterest(JieMoney*30* DayInterest);
            tbEssentialDTO.setHuanMoney(huanMoney);
            tbEssentialDTO.setRepayment(JieMoney-PerMoney);
            baseResult = BaseResult.success("成功",tbEssentialDTO);
        }else {
            baseResult = BaseResult.fail("没有贷款");
        }


        return baseResult;
    }
}

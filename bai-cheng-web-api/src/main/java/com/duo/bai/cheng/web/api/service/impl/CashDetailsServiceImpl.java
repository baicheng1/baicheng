package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.CashDetailsDTO;
import com.duo.bai.cheng.domain.Credit;
import com.duo.bai.cheng.web.api.dao.CashDetailsDao;
import com.duo.bai.cheng.web.api.service.CashDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CashDetailsServiceImpl implements CashDetailsService {

    @Autowired
    private CashDetailsDao cashDetailsDao;


    @Override
    public BaseResult select1(Long uid) {
        BaseResult baseResult = null;
        List<CashDetailsDTO> cashDetailsDTOS1 = new ArrayList<>();
        List<Credit> credits = cashDetailsDao.select1(uid);
        for (Credit credit : credits) {
            CashDetailsDTO cashDetailsDTO = new CashDetailsDTO();
            BeanUtils.copyProperties(credit,cashDetailsDTO);
            cashDetailsDTOS1.add(cashDetailsDTO);
        }
        baseResult = BaseResult.success("成功",cashDetailsDTOS1);
        return baseResult;
    }

    @Override
    public BaseResult select3(Long uid) {
        BaseResult baseResult = null;
        List<CashDetailsDTO> cashDetailsDTOS3 = new ArrayList<>();
        List<Credit> credits = cashDetailsDao.select3(uid);
        for (Credit credit : credits) {
            CashDetailsDTO cashDetailsDTO = new CashDetailsDTO();
            BeanUtils.copyProperties(credit,cashDetailsDTO);
            cashDetailsDTOS3.add(cashDetailsDTO);
        }
        baseResult = BaseResult.success("成功",cashDetailsDTOS3);
        return baseResult;
    }

    @Override
    public BaseResult select6(Long uid) {
        BaseResult baseResult = null;
        List<CashDetailsDTO> cashDetailsDTOS6 = new ArrayList<>();
        List<Credit> credits = cashDetailsDao.select6(uid);
        for (Credit credit : credits) {
            CashDetailsDTO cashDetailsDTO = new CashDetailsDTO();
            BeanUtils.copyProperties(credit,cashDetailsDTO);
            cashDetailsDTOS6.add(cashDetailsDTO);
        }
        baseResult = BaseResult.success("成功",cashDetailsDTOS6);
        return baseResult;
    }

    @Override
    public BaseResult selectByTime(Date startTime1, Date endTime1,Long uid) {


        BaseResult baseResult = null;
        List<CashDetailsDTO> cashDetailsDTOS = new ArrayList<>();
        List<Credit> credits = cashDetailsDao.selectByTime(startTime1,endTime1,uid);
        for (Credit credit : credits) {
            CashDetailsDTO cashDetailsDTO = new CashDetailsDTO();
            BeanUtils.copyProperties(credit,cashDetailsDTO);
            cashDetailsDTOS.add(cashDetailsDTO);
        }
        baseResult = BaseResult.success("成功",cashDetailsDTOS);
        return baseResult;
    }
}

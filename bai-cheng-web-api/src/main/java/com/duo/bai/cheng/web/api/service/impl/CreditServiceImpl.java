package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Tbcredit;
import com.duo.bai.cheng.web.api.dao.CreditDao;
import com.duo.bai.cheng.web.api.service.CreditService;
import com.duo.bai.cheng.web.api.web.Controller.dto.TbcreditDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {
    @Autowired
    CreditDao creditDao;
    @Override
    public BaseResult select(String name) {
        List<Tbcredit> tbcredits = creditDao.select(name);
        BaseResult baseResult = null;
        if (tbcredits.size()!=0){
            List<TbcreditDTO> tbcreditDTO = new ArrayList<>();
            for (Tbcredit tbcredit : tbcredits) {
                TbcreditDTO tbcreditDTO1 = new TbcreditDTO();
                BeanUtils.copyProperties(tbcredit,tbcreditDTO1);
                tbcreditDTO.add(tbcreditDTO1);
            }
            baseResult = BaseResult.success("成功",tbcreditDTO);
        }else {
            baseResult = BaseResult.fail("你还未借贷");
        }
        return baseResult;
    }
}

package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.domain.LCProduct;
import com.duo.bai.cheng.web.api.dao.LiCaiDao;
import com.duo.bai.cheng.web.api.service.LiCaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiCaiServiceImpl implements LiCaiService {
    @Autowired
    LiCaiDao liCaiDao;
    @Override
    public LCProduct selectById(int pid) {
        LCProduct lcProduct=liCaiDao.selectById(pid);
        return lcProduct;
    }
}

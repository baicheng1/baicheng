package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.domain.Information;
import com.duo.bai.cheng.web.api.dao.InformationDao1;
import com.duo.bai.cheng.web.api.service.InformationService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class InformationServiceImpl1 implements InformationService1 {
        @Autowired
        InformationDao1 informationDao1;
        @Override
        public List<Information> selectAllInfo() {
            List<Information> informationList=informationDao1.selectAllInfo();
            return informationList;
        }

        @Override
        public Information selectById(int id) {
            Information information=informationDao1.selectById(id);
            return information;
        }
    }

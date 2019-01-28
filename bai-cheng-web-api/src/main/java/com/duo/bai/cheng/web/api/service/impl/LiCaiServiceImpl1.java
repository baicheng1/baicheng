package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.LiCai;
import com.duo.bai.cheng.domain.LiCaiDTO;

import com.duo.bai.cheng.web.api.dao.LiCaiDao1;
import com.duo.bai.cheng.web.api.service.LiCaiService1;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class LiCaiServiceImpl1 implements LiCaiService1 {
    @Autowired
    private LiCaiDao1 liCaiDao1;


    @Override
    public BaseResult selectBy1(Long uid) {
        BaseResult baseResult = null;
        List<LiCaiDTO> liCaiDTOS1 = new ArrayList<>();
        List<LiCai> liCais = liCaiDao1.selectBy1(uid);
        for (LiCai liCai : liCais) {
            LiCaiDTO liCaiDTO = new LiCaiDTO();
            BeanUtils.copyProperties(liCai,liCaiDTO);
            liCaiDTOS1.add(liCaiDTO);
        }
        baseResult = BaseResult.success("成功",liCaiDTOS1);
        return baseResult;
    }

    @Override
    public BaseResult selectBy3(Long uid) {
        BaseResult baseResult = null;
        List<LiCaiDTO> liCaiDTOS3 = new ArrayList<>();
        List<LiCai> liCais = liCaiDao1.selectBy3(uid);
        for (LiCai liCai : liCais) {
            LiCaiDTO liCaiDTO = new LiCaiDTO();
            BeanUtils.copyProperties(liCai,liCaiDTO);
            liCaiDTOS3.add(liCaiDTO);
        }
        baseResult = BaseResult.success("成功",liCaiDTOS3);
        return baseResult;
    }

    @Override
    public BaseResult selectBy6(Long uid) {
        BaseResult baseResult = null;
        List<LiCaiDTO> liCaiDTOS6 = new ArrayList<>();
        List<LiCai> liCais = liCaiDao1.selectBy6(uid);
        for (LiCai liCai : liCais) {
            LiCaiDTO liCaiDTO = new LiCaiDTO();
            BeanUtils.copyProperties(liCai,liCaiDTO);
            liCaiDTOS6.add(liCaiDTO);
        }
        baseResult = BaseResult.success("成功",liCaiDTOS6);
        return baseResult;
    }

    @Override
    public BaseResult selectByDate(Date startTime, Date endTime,Long uid) {

        BaseResult baseResult = null;
        List<LiCaiDTO> liCaiDTOS = new ArrayList<>();
        List<LiCai> liCais = liCaiDao1.selectByDate(startTime,endTime,uid);
        for (LiCai liCai : liCais) {
            LiCaiDTO liCaiDTO = new LiCaiDTO();
            BeanUtils.copyProperties(liCai,liCaiDTO);
            liCaiDTOS.add(liCaiDTO);
        }
        baseResult = BaseResult.success("成功",liCaiDTOS);
        return baseResult;
    }
}

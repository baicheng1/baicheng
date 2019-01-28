package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.JiJin;
import com.duo.bai.cheng.web.api.dao.JiJinDao1;
import com.duo.bai.cheng.web.api.service.JiJinService1;
import com.duo.bai.cheng.web.api.web.Controller.dto.JiJinDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JiJinServiceImpl1 implements JiJinService1 {
    @Autowired
    JiJinDao1 jiJinDao1;

    @Override
    public List<JiJinDTO> findAll() {
        List<JiJinDTO> jiJinDTOS= new ArrayList<JiJinDTO>();
        List<JiJin> jiJins= jiJinDao1.findAll();
        System.out.println("==="+jiJins.toString());
        for (JiJin jiJin : jiJins){
            JiJinDTO jiJinDTO=new JiJinDTO();
            BeanUtils.copyProperties(jiJin,jiJinDTO);
            jiJinDTOS.add(jiJinDTO);
        }

        return jiJinDTOS;
    }
    @Override
    public JiJinDTO findOne(int id){

        JiJin jiJin=jiJinDao1.findOne(id);
        JiJinDTO jiJinDTO =new JiJinDTO();
        BeanUtils.copyProperties(jiJin,jiJinDTO);
        return  jiJinDTO;
    }

    @Override
    public BaseResult add(JiJin jiJin) {
        BaseResult baseResult = null;
        if (jiJin!=null){
            jiJinDao1.insertJiJin(jiJin);
            return baseResult.success("添加成功");
        }
        return baseResult.fail("添加失败");
    }

    @Override
    public BaseResult delete(int id){
        BaseResult baseResult = null;
        if(id>0){
            jiJinDao1.deleteById(id);
            return baseResult.success("删除成功");
        }
        return baseResult.fail("删除失败");
    }

}

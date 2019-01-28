package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Information;
import com.duo.bai.cheng.domain.TbPerUser;
import com.duo.bai.cheng.domain.Tb_User;
import com.duo.bai.cheng.web.api.dao.InformationDao;
import com.duo.bai.cheng.web.api.service.InformationService;
import com.duo.bai.cheng.web.api.web.Controller.dto.TbPerUserDTO;
import com.duo.bai.cheng.web.api.web.Controller.dto.TbUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    InformationDao informationDao;
    @Override
    public BaseResult select(Long id, int pid) {
        BaseResult baseResult = null;
        if (pid==1){
            TbPerUser tbPerUser = informationDao.selectAllS(id);
            if (tbPerUser!=null){
                TbPerUserDTO tbPerUserDTO = new TbPerUserDTO();
                BeanUtils.copyProperties(tbPerUser,tbPerUserDTO);
                baseResult = BaseResult.success("企业",tbPerUserDTO);
            }else {
                baseResult = BaseResult.fail("企业的id不存在");
            }
        }else {
            Tb_User tb_user = informationDao.selectAll(id);
            if (tb_user!=null){
                TbUserDTO tbUserDTO = new TbUserDTO();
                BeanUtils.copyProperties(tb_user,tbUserDTO);
                baseResult = BaseResult.success("个人",tbUserDTO);
            }else {
                baseResult = BaseResult.fail("个人的id不存在");
            }
        }
        return baseResult;
    }


}

package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.TbModify;
import com.duo.bai.cheng.domain.TbPerUser;
import com.duo.bai.cheng.domain.Tb_User;
import com.duo.bai.cheng.web.api.dao.InformationDao;
import com.duo.bai.cheng.web.api.dao.ModifyDao;
import com.duo.bai.cheng.web.api.service.IcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IcardServiceImpl implements IcardService {
    @Autowired
    ModifyDao modifyDao;
    @Autowired
    InformationDao informationDao;
    @Override
    public BaseResult upicard(TbModify tbModify) {
        BaseResult baseResult = null;
        if (tbModify.getPid()==1){
            modifyDao.upicard(tbModify);
            TbPerUser tbPerUser = informationDao.selectAllS(tbModify.getId());
            baseResult = BaseResult.success("修改成功",tbPerUser);
        }else {
            modifyDao.upicards(tbModify);
            Tb_User tb_user = informationDao.selectAll(tbModify.getId());
            baseResult = BaseResult.success("修改成功",tb_user);
        }
        return baseResult;
    }
}

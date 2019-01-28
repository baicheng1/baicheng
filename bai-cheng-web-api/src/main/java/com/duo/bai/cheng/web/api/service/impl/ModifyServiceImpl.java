package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.TbModify;
import com.duo.bai.cheng.domain.TbPerUser;
import com.duo.bai.cheng.domain.Tb_User;
import com.duo.bai.cheng.web.api.dao.InformationDao;
import com.duo.bai.cheng.web.api.dao.ModifyDao;
import com.duo.bai.cheng.web.api.dao.TbPerUserDao;
import com.duo.bai.cheng.web.api.dao.TbUserDao;
import com.duo.bai.cheng.web.api.service.ModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyServiceImpl implements ModifyService {
    @Autowired
    InformationDao informationDao;
    @Autowired
    ModifyDao modifyDao;
    @Override
    public BaseResult update(TbModify tbModify) {
        BaseResult baseResult = null;
        if (tbModify.getPid()==1){
            TbPerUser tbPerUser = informationDao.selectAllS(tbModify.getId());
            if (tbPerUser!=null){
                if (tbPerUser.getPassword().equals(tbModify.getPassword())){
                    modifyDao.update(tbModify);
                    TbPerUser str  = informationDao.selectAllS(tbModify.getId());
                    baseResult = BaseResult.success("修改成功",str);
                }else {
                    baseResult = BaseResult.fail("密码错误");
                }
            }else {
                baseResult = BaseResult.fail("企业id不存在");
            }
        }else {
            Tb_User tb_user = informationDao.selectAll(tbModify.getId());
            if (tb_user!=null){
                if (tb_user.getPassword().equals(tbModify.getPassword())){
                    modifyDao.updates(tbModify);
                    Tb_User tb_users = informationDao.selectAll(tbModify.getId());
                    baseResult = BaseResult.success("修改成功",tb_users);
                }else {
                    baseResult = BaseResult.fail("密码错误");
                }
            }else {
                baseResult = BaseResult.fail("个人id不存在");
            }
        }

        return baseResult;
    }
}

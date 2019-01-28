package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.commons.validator.BeanValidator;
import com.duo.bai.cheng.domain.TbPerUser;
import com.duo.bai.cheng.web.api.dao.TbPerUserDao;
import com.duo.bai.cheng.web.api.service.PerUserService;
import com.duo.bai.cheng.web.api.web.Controller.dto.TbPerUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerUserServiceImpl implements PerUserService {
    @Autowired
    TbPerUserDao tbPerUserDao;
    @Override
    public BaseResult login(TbPerUser tbPerUser) {
        String validator = BeanValidator.validator(tbPerUser);
        BaseResult baseResult = null;
        int str = 0;
        List<TbPerUser> tbPerUsers = tbPerUserDao.selectAll();
        for (TbPerUser perUser : tbPerUsers) {
            if (tbPerUser.getCname().equals(perUser.getCname())){
                str = 0;
                break;
            }else {
                baseResult = BaseResult.fail("用户名不存在");
                str = 1;
            }
            if (tbPerUser.getCname().equals(perUser.getEmail())){
                str = 0;
                break;
            }else {
                baseResult = BaseResult.fail("用户名不存在");
                str = 1;
            }
            if (tbPerUser.getCname().equals(perUser.getPhone())){
                str = 0;
                break;
            }else {
                baseResult = BaseResult.fail("用户名不存在");
                str = 1;
            }
        }
        if (tbPerUsers.size()!=0){
            if (str==0){
                TbPerUser user = tbPerUserDao.login(tbPerUser);
                if (validator==null){
                    if (tbPerUser.getPassword().equals(user.getPassword())){
                        //登录成功
                        TbPerUserDTO tbUserDTO = new TbPerUserDTO();
                        BeanUtils.copyProperties(user,tbUserDTO);
                        baseResult = BaseResult.success("登录成功",tbUserDTO);
                    }else {
                        //登录失败
                        baseResult = BaseResult.fail("用户名或者密码错误");
                    }
                }else {
                    baseResult = BaseResult.fail(validator);
                }
            }
        }else {
            baseResult = BaseResult.fail("用户名或者密码错误");
        }

        return baseResult;
    }
}

package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.commons.validator.BeanValidator;
import com.duo.bai.cheng.domain.Tb_User;
import com.duo.bai.cheng.web.api.dao.TbUserDao;
import com.duo.bai.cheng.web.api.service.TbUserService;
import com.duo.bai.cheng.web.api.web.Controller.dto.TbUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    TbUserDao tbUserDao;
    @Override
    public BaseResult login(Tb_User tb_user) {
        String validator = BeanValidator.validator(tb_user);
        BaseResult baseResult = null;
        int str = 0;
        List<Tb_User> tb_users = tbUserDao.selectAll();
        for (Tb_User tbUser : tb_users) {
            if (tb_user.getPname().equals(tbUser.getPname())){
                str = 0;
                break;
            }else {
                baseResult = BaseResult.fail("用户名不存在");
                str = 1;
            }
            if (tb_user.getPname().equals(tbUser.getEmail())){
                str = 0;
                break;
            }else {
                baseResult = BaseResult.fail("用户名不存在");
                str = 1;
            }
            if (tb_user.getPname().equals(tbUser.getPhone())){
                str = 0;
                break;
            }else {
                baseResult = BaseResult.fail("用户名不存在");
                str = 1;
            }
        }
        if (tb_users.size()!=0){
            if (str==0){
                Tb_User user = tbUserDao.login(tb_user);
                if (validator==null){
                    if (tb_user.getPassword().equals(user.getPassword())){
                        //登录成功
                        TbUserDTO tbUserDTO = new TbUserDTO();
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

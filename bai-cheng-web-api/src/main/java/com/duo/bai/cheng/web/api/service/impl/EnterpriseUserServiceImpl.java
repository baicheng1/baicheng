package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.EnterpriseUser;
import com.duo.bai.cheng.web.api.dao.EnterpriseUserDao;
import com.duo.bai.cheng.web.api.service.EnterpriseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class EnterpriseUserServiceImpl implements EnterpriseUserService {
    @Autowired
   private EnterpriseUserDao enterpriseUserDao;

    @Override
    public BaseResult register(EnterpriseUser enterpriseUser) {
        BaseResult baseResult = null;
        String validator = null;
       // String validator = BeanValidator.validator(enterpriseUser);
        EnterpriseUser result = enterpriseUserDao.select(enterpriseUser);

        if(result==null){
            if(validator==null){
                //将数据插入数据库
                String password = DigestUtils.md5DigestAsHex(enterpriseUser.getPassword().getBytes());
                enterpriseUser.setCreated(new Date());
                enterpriseUser.setPassword(password);
                enterpriseUserDao.register(enterpriseUser);

                //登录成功，将数据封装到TbUserDTO
                baseResult = BaseResult.success("用户注册成功");
            }else{
                //格式验证失败，返回错误信息
                baseResult = BaseResult.fail(validator);
            }
        }else{
            baseResult = BaseResult.fail("用户名/手机号/邮箱已被注册");
        }


        return baseResult;
    }

}

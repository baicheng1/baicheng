package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.PersonalUser;
import com.duo.bai.cheng.web.api.dao.PersonalUserDao;
import com.duo.bai.cheng.web.api.service.PersonalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class PersonalUserServiceImpl implements PersonalUserService {
    @Autowired
   private PersonalUserDao tbUserDao;

    @Override
    public BaseResult register(PersonalUser personalUser) {
        BaseResult baseResult = null;
       String validator = null;
       // String validator = BeanValidator.validator(personalUser);
        PersonalUser result = tbUserDao.select(personalUser);

        if(result==null){
            if(validator==null){
                //将数据插入数据库
                String password = DigestUtils.md5DigestAsHex(personalUser.getPassword().getBytes());
                personalUser.setCreated(new Date());
                personalUser.setPassword(password);
                tbUserDao.register(personalUser);

                //登录成功，将数据封装到TbUserDTO
                baseResult = BaseResult.success("个人用户注册成功");
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

package com.duo.bai.cheng.web.api.web.Controller.v1;


import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.commons.util.CookieUtils;
import com.duo.bai.cheng.domain.TbPerUser;
import com.duo.bai.cheng.web.api.service.PerUserService;
import com.duo.bai.cheng.web.api.web.Controller.dto.TbPerUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class PerUserController {
    @Autowired
    PerUserService perUserService;
    @RequestMapping(value = "logins",method = RequestMethod.POST)
    public BaseResult login(TbPerUser tbPerUser, HttpServletRequest request, HttpServletResponse response, String isRemember) {
        //登录
        BaseResult baseResult = perUserService.login(tbPerUser);
        TbPerUserDTO data = (TbPerUserDTO) baseResult.getData();
        if (data!=null){
            request.getSession().setAttribute("id",data.getId());
            request.getSession().setAttribute("pid",data.getPid());
            request.getSession().setAttribute("name",data.getCname());
            if("on".equals(isRemember)){
                if (tbPerUser.getCname()!=null){
                    CookieUtils.setCookie(request,response,"tbuser",
                            tbPerUser.getCname()+":"+tbPerUser.getPassword()+":"+data.getId()+":"+data.getPid()+":"+data.getCname(),60*60*24*7);
                }
                if (tbPerUser.getPhone()!=null){
                    CookieUtils.setCookie(request,response,"tbuser",
                            tbPerUser.getPhone()+":"+tbPerUser.getPassword()+":"+data.getId()+":"+data.getPid()+":"+data.getCname(),60*60*24*7);
                }
                if (tbPerUser.getEmail()!=null){
                    CookieUtils.setCookie(request,response,"tbuser",
                            tbPerUser.getEmail()+":"+tbPerUser.getPassword()+":"+data.getId()+":"+data.getPid()+":"+data.getCname(),60*60*24*7);
                }
            }else{
                //如果没有勾选记住我，就删除之前的Cookie
                CookieUtils.deleteCookie(request,response,"tbuser");
            }
        }
        return baseResult;
    }
}

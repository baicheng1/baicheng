package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.commons.util.CookieUtils;
import com.duo.bai.cheng.domain.Tb_User;
import com.duo.bai.cheng.web.api.service.TbUserService;
import com.duo.bai.cheng.web.api.web.Controller.dto.TbUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class UserController {
    @Autowired
    TbUserService tbUserService;
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login(Tb_User tb_user, HttpServletRequest request, HttpServletResponse response,String isRemember){
        //登录
        BaseResult baseResult = tbUserService.login(tb_user);
        TbUserDTO data = (TbUserDTO) baseResult.getData();
        if (data!=null){
            request.getSession().setAttribute("id",data.getId());
            request.getSession().setAttribute("pid",data.getPid());
            request.getSession().setAttribute("name",data.getPname());
            if("on".equals(isRemember)){
                if (tb_user.getPname()!=null){
                    CookieUtils.setCookie(request,response,"tbuser",
                            tb_user.getPname()+":"+tb_user.getPassword()+":"+data.getId()+":"+data.getPid()+":"+data.getPname(),60*60*24*7);
                }
                if (tb_user.getPhone()!=null){
                    CookieUtils.setCookie(request,response,"tbuser",
                            tb_user.getPhone()+":"+tb_user.getPassword()+":"+data.getId()+":"+data.getPid()+":"+data.getPname(),60*60*24*7);
                }
                if (tb_user.getEmail()!=null){
                    CookieUtils.setCookie(request,response,"tbuser",
                            tb_user.getEmail()+":"+tb_user.getPassword()+":"+data.getId()+":"+data.getPid()+":"+data.getPname(),60*60*24*7);
                }
            }else{
                //如果没有勾选记住我，就删除之前的Cookie
                CookieUtils.deleteCookie(request,response,"tbuser");
            }
        }
        return baseResult;
    }
    @RequestMapping(value="logout",method = RequestMethod.GET)
    public BaseResult logout(HttpServletRequest request){
        request.getSession().invalidate();
        BaseResult baseResult = BaseResult.success("成功");
        return baseResult;
    }
}

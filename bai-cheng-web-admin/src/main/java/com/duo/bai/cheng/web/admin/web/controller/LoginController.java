package com.duo.bai.cheng.web.admin.web.controller;

import com.duo.bai.cheng.domain.Tbhotai;
import com.duo.bai.cheng.web.admin.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    LoginDao loginDao;
    @RequestMapping(value={"","login"},method= RequestMethod.GET)
    public String login(){
        return "login";//   /WEB-INF/views/login.jsp
    }

    @RequestMapping(value = "logins",method = RequestMethod.POST)
    public String logins(String username, String password, HttpServletRequest request, Model model){
        Tbhotai tbhotai = loginDao.login(username);
        if (tbhotai!=null){
            if (tbhotai.getPassword().equals(password)){
                //登录成功
                request.getSession().setAttribute("user",tbhotai);
                return "index";
            }else {
                model.addAttribute("msg","用户名或密码错误");
                return login();
            }
        }else {
            model.addAttribute("msg","用户名或密码错误");
            return login();
        }
    }
}

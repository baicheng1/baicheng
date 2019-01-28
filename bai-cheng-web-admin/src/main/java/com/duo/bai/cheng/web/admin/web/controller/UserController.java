package com.duo.bai.cheng.web.admin.web.controller;

import com.duo.bai.cheng.commons.dto.PageInfo;
import com.duo.bai.cheng.domain.TbPerUser;
import com.duo.bai.cheng.domain.Tb_User;
import com.duo.bai.cheng.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    TbUserService tbUserService;
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        /*List<Tb_User> tb_users = tbUserService.selectAll();
        model.addAttribute("tb_users",tb_users);*/
        Tb_User tb_user = new Tb_User();
        model.addAttribute("tb_user",tb_user);
        return "com_user";
    }

    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<Tb_User> page(HttpServletRequest request, Tb_User tb_user){
        String draws = request.getParameter("draw");
        String starts = request.getParameter("start");
        String lengths = request.getParameter("length");
        int draw = draws == null?1:Integer.parseInt(draws);
        int start = starts == null?0:Integer.parseInt(starts);
        int length = lengths == null?10:Integer.parseInt(lengths);
        PageInfo<Tb_User> page = tbUserService.page(draw, start, length,tb_user);
        return page;
    }
}

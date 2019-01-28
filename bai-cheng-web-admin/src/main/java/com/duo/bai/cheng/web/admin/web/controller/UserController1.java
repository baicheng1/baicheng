package com.duo.bai.cheng.web.admin.web.controller;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.User;
import com.duo.bai.cheng.web.admin.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController1 {
    @Autowired
    UserService userService;

    @ModelAttribute
    public User getUser(String uid) {
        User user = new User();
        if (uid != null) {
            user = userService.selectById(uid);
        }
        return user;
    }

    @RequestMapping(value ="index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    //    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<User> users = userService.selectAllUser();
        int count = userService.count();
        model.addAttribute("users", users);
        model.addAttribute("count", count);
        return "user_list";
    }
    /**
     * 查看用户详情
     *
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail() {
        return "user_detail";
    }

    @ResponseBody
    @RequestMapping(value = "type", method = RequestMethod.GET)
    public List<User> type(Model model, String id) {
        User user = userService.selectById(id);
        if (user.getType() == 1) {
            user.setType(0);
        } else {
            user.setType(1);
        }
        userService.changeType(user);
        List<User> users = userService.selectAllUser();
        model.addAttribute("users", users);
        return users;
    }

    @RequestMapping(value = "save", method = RequestMethod.GET)
    public String save(Model model,String uid, String username, String password, int type,String email,String phone) {
        User user = new User();
        if(!StringUtils.isBlank(uid)){
            user.setUid(uid);
        }
        user.setUsername(username);
        user.setPassword(password);
        user.setType(type);
        user.setEmail(email);
        user.setPhone(phone);
        if (user != null) {
            BaseResult baseResult = userService.save(user);
            model.addAttribute("baseResult", baseResult);
            System.out.println(baseResult.getMessage());
        }

        return "redirect:/user/list";
    }

    //    @ResponseBody
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "user_form";
    }

    @ResponseBody
    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    public BaseResult deleteById(String id) {
        BaseResult baseResult = userService.deleteById(id);
        return baseResult;
    }

    //    @ResponseBody
    @RequestMapping(value = "selectBySearch", method = RequestMethod.POST)
//    public List<User> selectBySearch(String keyword,Model model){
    public String selectBySearch(String keyword, Model model) {
        List<User> users;
        if (StringUtils.isBlank(keyword)) {
            users = userService.selectAllUser();
        } else {
            users = userService.selectBySearch(keyword);
        }
        int count = userService.countBySearch(keyword);
        model.addAttribute("users", users);
        model.addAttribute("count", count);
        return "user_list";
    }

    @ResponseBody
    @RequestMapping(value = "deletemulti", method = RequestMethod.POST)
    public BaseResult deletemulti(String ids,Model model) {
        BaseResult baseResult = userService.deleteUsers(ids);
        model.addAttribute("baseResult",baseResult);
        return baseResult;
    }
}

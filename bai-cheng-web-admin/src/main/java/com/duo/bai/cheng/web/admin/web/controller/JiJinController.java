package com.duo.bai.cheng.web.admin.web.controller;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.JiJin;
import com.duo.bai.cheng.web.admin.service.JiJinService;
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
@RequestMapping("jijin")
public class JiJinController {
    @Autowired
    JiJinService jiJinService;

    @ModelAttribute
    public JiJin getJiJin(String id) {
        JiJin jiJin=new JiJin();
        if (id != null&& id!="") {
            jiJin = jiJinService.selectById(id);
            if (jiJin!=null){
                System.out.println(jiJin.toString());
            }

        }
        return jiJin;
    }

    // @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<JiJin> JiJins = jiJinService.selectAllJiJin();
        int count = jiJinService.count();
        model.addAttribute("JiJins", JiJins);
        model.addAttribute("count", count);
        return "jijin_list";
    }
    /**
     * 查看用户详情
     *
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail() {
        return "jijin_detail";
    }


    @RequestMapping(value = "save", method = RequestMethod.GET)
    public String save(Model model, JiJin jiJin) {
        System.out.println(jiJin.getId());
        jiJinService.save(jiJin);
        return "redirect:/jijin/list";
    }

    // @ResponseBody
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "jijin_form";
    }

    @ResponseBody
    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    public BaseResult deleteById(String id) {
        BaseResult baseResult = jiJinService.deleteById(id);
        return baseResult;
    }

    //  @ResponseBody
    @RequestMapping(value = "selectBySearch", method = RequestMethod.POST)
    public String selectBySearch(String keyword, Model model) {
        List<JiJin> JiJins;
        if (StringUtils.isBlank(keyword)) {
            JiJins = jiJinService.selectAllJiJin();
        } else {
            JiJins = jiJinService.selectBySearch(keyword);
        }
        int count = jiJinService.countBySearch(keyword);
        model.addAttribute("JiJins", JiJins);
        model.addAttribute("count", count);
        return "jijin_list";
    }

    @ResponseBody
    @RequestMapping(value = "deletemulti", method = RequestMethod.POST)
    public BaseResult deletemulti(String ids, Model model) {
        BaseResult baseResult = jiJinService.deleteJiJins(ids);
        model.addAttribute("baseResult",baseResult);
        return baseResult;
    }
}

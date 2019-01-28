package com.duo.bai.cheng.web.admin.web.controller;


import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Information;
import com.duo.bai.cheng.web.admin.service.InformationService;
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
@RequestMapping("info")
public class  InformationController {
    @Autowired
    InformationService informationService;

    @ModelAttribute
    public Information getInformation(String id) {
        Information information = new Information();
        if (id != null) {
            information = informationService.selectById(id);
        }
        return information;
    }


    //    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Information> informationList = informationService.selectAllInformation();
        int count = informationService.count();
        model.addAttribute("informationList", informationList);
        model.addAttribute("count", count);
        return "info_list";
    }

    /**
     * 查看用户详情
     *
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail() {
        return "info_detail";
    }


    @RequestMapping(value = "save", method = RequestMethod.GET)
    public String save(Model model,String id,String infoName,String infoUrl,String infoType,String infoContent ) {
        Information information=new Information();
        if (id!=null&&id!=""){
            information.setId(Integer.parseInt(id));
        }
        information.setInfoName(infoName);
        information.setInfoUrl(infoUrl);
        if(infoType.equals(1)){
            information.setInfoType("期货");
        }
        if(infoType.equals(2)){
            information.setInfoType("股票");
        }
        if(infoType.equals(3)){
            information.setInfoType("财经");
        }


        information.setInfoContent(infoContent);
        System.out.println(information);
        if (information != null) {
            BaseResult baseResult = informationService.save(information);
            model.addAttribute("baseResult", baseResult);
            System.out.println(baseResult.getMessage());
        }
        return "redirect:/info/list";
    }

    //    @ResponseBody
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model) {
//        List<Object> infoTypes = informationService.selectAllInfoType();
//        model.addAttribute("infoTypes", infoTypes);
//        System.out.println("=============================" + infoTypes);
        return "info_form";
    }

    @ResponseBody
    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    public BaseResult deleteById(String id) {
        System.out.println("id================"+id);
        BaseResult baseResult = informationService.deleteById(id);
        return baseResult;
    }

    //    @ResponseBody
    @RequestMapping(value = "selectBySearch", method = RequestMethod.POST)
    public String selectBySearch(String keyword, Model model) {
        System.out.println("搜索关键字==============================" + keyword);
        List<Information> informationList;
        if (StringUtils.isBlank(keyword)) {
            informationList = informationService.selectAllInformation();
        } else {
            informationList = informationService.selectBySearch(keyword);
        }
        int count = informationService.countBySearch(keyword);
        model.addAttribute("informationList", informationList);
        model.addAttribute("count", count);
        return "info_list";
    }

    @ResponseBody
    @RequestMapping(value = "deletemulti", method = RequestMethod.POST)
    public BaseResult deletemulti(String ids, Model model) {
        BaseResult baseResult = informationService.deleteInfos(ids);
        model.addAttribute("baseResult", baseResult);
        return baseResult;
    }
}




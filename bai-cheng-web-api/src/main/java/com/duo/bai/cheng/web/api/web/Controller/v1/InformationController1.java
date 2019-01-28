package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.domain.Information;
import com.duo.bai.cheng.web.api.service.InformationService;
import com.duo.bai.cheng.web.api.service.InformationService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("info")
public class InformationController1 {
    @Autowired
    InformationService1 informationService1;

    /**
     * 搜索所有的团队
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "showInfo",method = RequestMethod.GET)
    public List<Information> showInfo(Model model){
        List<Information> informationList=informationService1.selectAllInfo();
        model.addAttribute("informationList",informationList);
        return informationList;
    }
    @ResponseBody
    @RequestMapping(value = "showInfoById",method = RequestMethod.GET)
    public Information showInfoById(int id){
        Information information=informationService1.selectById(id);
        return information;
    }
}

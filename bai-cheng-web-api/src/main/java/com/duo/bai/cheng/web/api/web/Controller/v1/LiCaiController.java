package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.domain.LCProduct;
import com.duo.bai.cheng.web.api.service.LiCaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("licai")
public class LiCaiController {
    @Autowired
    LiCaiService liCaiService;
    @ModelAttribute
    public LCProduct getLIProduct(int pid, Model model){
        LCProduct lcProduct=new LCProduct();
        if(pid!=0) {
            lcProduct=liCaiService.selectById(pid);
        }
        model.addAttribute("lcProduct",lcProduct);
        return lcProduct;
    }
    @RequestMapping(value = "showCat",method = RequestMethod.GET)
    public String showCat(){
        return "show_cat";
    }
}

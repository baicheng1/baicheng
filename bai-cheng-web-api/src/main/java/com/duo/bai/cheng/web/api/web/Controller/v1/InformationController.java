package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.web.api.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class InformationController {
    @Autowired
    InformationService informationService;
    @RequestMapping(value = "information",method = RequestMethod.GET)
    public BaseResult information(HttpServletRequest request){
        //判断是个人还是企业去个人中心
        Long id = (Long) request.getSession().getAttribute("id");
        int pid = (int) request.getSession().getAttribute("pid");
        BaseResult baseResult = null;
        if (id!=null){
            baseResult =  informationService.select(id,pid);
        }else {
            baseResult = BaseResult.fail("请登录");
        }
        return baseResult;
    }

}

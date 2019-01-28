package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.commons.util.CookieUtils;
import com.duo.bai.cheng.web.api.service.CreditService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class CreditController {
    @Autowired
    CreditService creditService;
    @RequestMapping(value = "credit",method = RequestMethod.GET)
    public BaseResult credit(HttpServletRequest request, HttpServletResponse response) {
        //出借记录
       /*String name = (String) request.getSession().getAttribute("name");*/
        String name = null;
        String tbuser = CookieUtils.getCookieValue(request, response, "tbuser");
        if (!StringUtils.isBlank(tbuser)){
            String[] split = tbuser.split(":");
            name = split[4];
        }else {
             name = (String) request.getSession().getAttribute("name");
        }
        BaseResult baseResult = null;
        if (name!=null){
            baseResult = creditService.select(name);
        }else {
            baseResult = BaseResult.fail("请登录");
        }
        return baseResult;
    }
}

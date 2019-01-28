package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.commons.util.CookieUtils;
import com.duo.bai.cheng.web.api.service.EssentialService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class EssentialController {
    @Autowired
    EssentialService essentialService;
    @RequestMapping(value = "essential",method = RequestMethod.GET)
    public BaseResult essential(HttpServletRequest request, HttpServletResponse response){
        //账号总资金
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
            baseResult = essentialService.select(name);
        }else {
            baseResult = BaseResult.fail("没有贷款");
        }
        return baseResult;
    }
}

package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.TbModify;
import com.duo.bai.cheng.web.api.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class EmailController {
    @Autowired
    EmailService emailService;
    @RequestMapping(value = "email",method = RequestMethod.GET)
    public BaseResult email(TbModify tbModify, HttpServletRequest request){
        Long id = (Long) request.getSession().getAttribute("id");
        int pid = (int) request.getSession().getAttribute("pid");
        tbModify.setId(id);
        tbModify.setPid(pid);
        //邮箱修改
        BaseResult baseResult = null;
        if (tbModify.getId()!=null){
            baseResult =  emailService.upemail(tbModify);
        }else {
            baseResult = BaseResult.fail("请登录");
        }

        return baseResult;
    }
}

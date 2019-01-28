package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.TbModify;
import com.duo.bai.cheng.web.api.service.IcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class IcardController {
    @Autowired
    IcardService icardService;
    @RequestMapping(value = "icard",method = RequestMethod.GET)
    public BaseResult icard(TbModify tbModify, HttpServletRequest request){
        Long id = (Long) request.getSession().getAttribute("id");
        int pid = (int) request.getSession().getAttribute("pid");
        tbModify.setId(id);
        tbModify.setPid(pid);
        //地址修改
        BaseResult baseResult = null;
        if (tbModify.getId()!=null){
            baseResult = icardService.upicard(tbModify);
        }else {
            baseResult = BaseResult.fail("请登录");
        }
        return baseResult;
    }
}

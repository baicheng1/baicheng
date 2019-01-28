package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.TbModify;
import com.duo.bai.cheng.web.api.service.NicknameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class NicknameController {
    @Autowired
    NicknameService nicknameService;
    @RequestMapping(value = "nick",method = RequestMethod.GET)
    public BaseResult nick(TbModify tbModify, HttpServletRequest request){
        Long id = (Long) request.getSession().getAttribute("id");
        int pid = (int) request.getSession().getAttribute("pid");
        tbModify.setId(id);
        tbModify.setPid(pid);
        //昵称修改
        BaseResult baseResult = null;
        if (tbModify.getId()!=null){
            baseResult = nicknameService.upnick(tbModify);
        }else {
            baseResult = BaseResult.fail("请登录");
        }

        return baseResult;
    }
}

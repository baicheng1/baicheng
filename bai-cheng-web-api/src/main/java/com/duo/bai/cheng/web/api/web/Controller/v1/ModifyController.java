package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.TbModify;
import com.duo.bai.cheng.web.api.service.ModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class ModifyController {
    @Autowired
    ModifyService modifyService;
    @RequestMapping(value = "modify",method = RequestMethod.POST)
    public BaseResult modify(TbModify tbModify, HttpServletRequest request){
        Long id = (Long) request.getSession().getAttribute("id");
        int pid = (int) request.getSession().getAttribute("pid");
        tbModify.setId(id);
        tbModify.setPid(pid);
        //修改密码
        BaseResult baseResult = null;
        if (tbModify.getId()!=null){
            baseResult = modifyService.update(tbModify);
        }else {
            baseResult = BaseResult.fail("请登录");
        }

        return baseResult;
    }
}

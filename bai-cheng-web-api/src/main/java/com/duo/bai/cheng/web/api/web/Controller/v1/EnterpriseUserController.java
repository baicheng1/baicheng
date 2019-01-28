package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.EnterpriseUser;
import com.duo.bai.cheng.web.api.service.EnterpriseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="${api.path.v1}/users")
public class EnterpriseUserController {

    @Autowired
    private EnterpriseUserService enterpriseUserService;

    @ResponseBody
    @RequestMapping(value = "cregister", method = RequestMethod.POST)
    public BaseResult register(EnterpriseUser enterpriseUser) {

        BaseResult baseResult = enterpriseUserService.register(enterpriseUser);

        return baseResult;


    }
}

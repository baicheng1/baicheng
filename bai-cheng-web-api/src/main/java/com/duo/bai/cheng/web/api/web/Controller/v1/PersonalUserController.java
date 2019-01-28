package com.duo.bai.cheng.web.api.web.Controller.v1;


import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.PersonalUser;
import com.duo.bai.cheng.web.api.service.PersonalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="${api.path.v1}/users")
public class PersonalUserController {

    @Autowired
    private PersonalUserService tbUserService;

   @ResponseBody
    @RequestMapping(value = "pregister",method= RequestMethod.POST)
    public BaseResult register(PersonalUser personalUser){

        BaseResult baseResult = tbUserService.register(personalUser);

        return baseResult;
    }
}

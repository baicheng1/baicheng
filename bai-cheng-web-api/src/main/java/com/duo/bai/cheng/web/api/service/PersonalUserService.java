package com.duo.bai.cheng.web.api.service;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.PersonalUser;

public interface PersonalUserService {
    /**
     * 注册
     * @param personalUser
     * @return
     */
    BaseResult register(PersonalUser personalUser);
}


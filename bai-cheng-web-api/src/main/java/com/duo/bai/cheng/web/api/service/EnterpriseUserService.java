package com.duo.bai.cheng.web.api.service;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.EnterpriseUser;

public interface EnterpriseUserService {
    /**
     * 注册
     * @param enterpriseUser
     * @return
     */
    BaseResult register(EnterpriseUser enterpriseUser);
}


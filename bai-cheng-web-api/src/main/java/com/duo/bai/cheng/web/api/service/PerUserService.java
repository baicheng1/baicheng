package com.duo.bai.cheng.web.api.service;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.TbPerUser;

public interface PerUserService {
    BaseResult login(TbPerUser tbPerUser);
}

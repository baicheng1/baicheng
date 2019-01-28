package com.duo.bai.cheng.web.api.service;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Tb_User;

public interface TbUserService {
    BaseResult login(Tb_User tb_user);
}

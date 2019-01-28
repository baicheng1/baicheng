package com.duo.bai.cheng.web.admin.service;

import com.duo.bai.cheng.commons.dto.PageInfo;
import com.duo.bai.cheng.domain.TbPerUser;
import com.duo.bai.cheng.domain.Tb_User;

public interface TbUserService {
    PageInfo<Tb_User> page(int draw, int start, int length, Tb_User tb_user);

    PageInfo<TbPerUser> pages(int draw, int start, int length, TbPerUser tbPerUser);
}

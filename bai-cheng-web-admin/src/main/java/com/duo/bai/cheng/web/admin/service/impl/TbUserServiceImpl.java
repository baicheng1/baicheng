package com.duo.bai.cheng.web.admin.service.impl;

import com.duo.bai.cheng.commons.dto.PageInfo;
import com.duo.bai.cheng.domain.TbPerUser;
import com.duo.bai.cheng.domain.Tb_User;
import com.duo.bai.cheng.web.admin.service.TbUserService;
import org.springframework.stereotype.Service;

@Service
public class TbUserServiceImpl implements TbUserService {
    @Override
    public PageInfo<Tb_User> page(int draw, int start, int length, Tb_User tb_user) {
        return null;
    }

    @Override
    public PageInfo<TbPerUser> pages(int draw, int start, int length, TbPerUser tbPerUser) {
        return null;
    }
}

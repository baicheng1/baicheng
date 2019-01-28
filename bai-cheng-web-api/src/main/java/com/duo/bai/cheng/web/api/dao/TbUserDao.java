package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.domain.Tb_User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserDao {
    Tb_User login(Tb_User tb_user);
    List<Tb_User> selectAll();
}

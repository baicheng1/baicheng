package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.domain.TbPerUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbPerUserDao {
    TbPerUser login(TbPerUser tbPerUser);
    List<TbPerUser> selectAll();
}

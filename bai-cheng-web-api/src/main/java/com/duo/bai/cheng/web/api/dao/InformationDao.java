package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.domain.Information;
import com.duo.bai.cheng.domain.TbPerUser;
import com.duo.bai.cheng.domain.Tb_User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationDao {
    Tb_User selectAll(Long id);
    TbPerUser selectAllS(Long id);

}

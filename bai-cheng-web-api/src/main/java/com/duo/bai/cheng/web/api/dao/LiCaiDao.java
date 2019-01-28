package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.domain.LCProduct;
import org.springframework.stereotype.Repository;

@Repository
public interface LiCaiDao {
    LCProduct selectById(int pid);
}

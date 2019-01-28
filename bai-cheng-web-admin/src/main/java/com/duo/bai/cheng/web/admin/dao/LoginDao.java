package com.duo.bai.cheng.web.admin.dao;

import com.duo.bai.cheng.domain.Tbhotai;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
    Tbhotai login(String username);
}

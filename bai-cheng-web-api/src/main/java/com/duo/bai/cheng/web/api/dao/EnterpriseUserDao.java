package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.domain.EnterpriseUser;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseUserDao {

    /**
     * 注册
     * @param enterpriseUser
     * @return
     */
   void register(EnterpriseUser enterpriseUser);


    /**
     * 查询字段是否重复
     * @param enterpriseUser
     * @return
     */
    EnterpriseUser select(EnterpriseUser enterpriseUser);
}

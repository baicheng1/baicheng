package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.domain.PersonalUser;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalUserDao {

    /**
     * 注册
     * @param personalUser
     * @return
     */
   void register(PersonalUser personalUser);


    /**
     * 查询字段是否重复
     * @param personalUser
     * @return
     */
    PersonalUser select(PersonalUser personalUser);
}

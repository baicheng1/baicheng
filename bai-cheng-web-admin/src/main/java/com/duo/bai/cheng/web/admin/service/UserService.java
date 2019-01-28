package com.duo.bai.cheng.web.admin.service;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.User;

import java.util.List;

public interface UserService {
    User selectById(String id);

    List<User> selectAllUser();

    void changeType(User user);

    BaseResult save(User user);

    BaseResult deleteById(String id);

    List<User> selectBySearch(String keyword);

    int count();

    BaseResult deleteUsers(String ids);

//    PageInfo<User> selectByPage(int draw, int start, int length, User user);

    int countBySearch(String keyword);
}

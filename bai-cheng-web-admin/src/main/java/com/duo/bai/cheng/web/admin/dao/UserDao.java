package com.duo.bai.cheng.web.admin.dao;

import com.duo.bai.cheng.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {
    User selectById(String id);

    List<User> selectAllUser();

    void changeType(User user);

    void insert(User user);

    void deleteById(String id);

    List<User> selectBySearch(String keyword);

    int count(User user);
//    int count();

    void deleteUsers(String[] id_arr);

    List<User> selectByPage(Map<String, Object> map);

    void updateUser(User user);

    int countBySearch(String keyword);
}

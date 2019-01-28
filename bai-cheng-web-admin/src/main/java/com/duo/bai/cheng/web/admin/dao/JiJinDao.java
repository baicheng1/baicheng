package com.duo.bai.cheng.web.admin.dao;

import com.duo.bai.cheng.domain.JiJin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JiJinDao {
    List<JiJin> findAll();

    JiJin findOne(int id);

    void insertJiJin(JiJin jiJin);

    void deleteById(int id);

    void updateJiJin(JiJin jiJin);

    void deleteJiJins(String[] ids);

    int count();
}

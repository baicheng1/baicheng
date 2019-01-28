package com.duo.bai.cheng.web.admin.dao;

import com.duo.bai.cheng.domain.Information;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InformationDao {
    Information selectById(String id);

    List<Information> selectAllInformation();

    void insert(Information information);

    void deleteById(String id);

    List<Information> selectBySearch(String keyword);

//    int count(Information information);
    int count();

    void deleteInfos(String[] id_arr);

    List<Information> selectByPage(Map<String, Object> map);

    void updateInformation(Information information);

    int countBySearch(String keyword);

//    List<Object> selectAllInfoType();
}

package com.duo.bai.cheng.web.admin.dao;

import com.duo.bai.cheng.domain.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NoticeDao {
    Notice selectById(Integer id);

    List<Notice> selectAllNotice();

    void insert(Notice notice);

    void deleteById(String id);

    List<Notice> selectBySearch(String keyword);

    int count(Notice notice);
//    int count();

    void deleteNotices(String[] id_arr);

    List<Notice> selectByPage(Map<String, Object> map);

    void updateNotice(Notice notice);

    int countBySearch(String keyword);

    List<Object> selectAllJiJinId();
}

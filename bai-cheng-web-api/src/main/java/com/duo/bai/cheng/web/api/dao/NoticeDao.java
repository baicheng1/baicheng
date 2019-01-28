package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.domain.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeDao {
    public List<Notice> selectAllNotice();

    Notice selectById(int id);
}

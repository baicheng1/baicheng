package com.duo.bai.cheng.web.admin.service;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Notice;

import java.util.List;

public interface NoticeService {
    Notice selectById(Integer id);

    List<Notice> selectAllNotice();

    BaseResult save(Notice notice);

    BaseResult deleteById(String id);

    List<Notice> selectBySearch(String keyword);

    int count();

    BaseResult deleteNotices(String ids);

//    PageInfo<User> selectByPage(int draw, int start, int length, User user);

    int countBySearch(String keyword);

    List<Object> selectAllJiJinId();
}

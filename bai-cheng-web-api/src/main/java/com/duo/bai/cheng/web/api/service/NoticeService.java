package com.duo.bai.cheng.web.api.service;

import com.duo.bai.cheng.domain.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> selectAllNotice();

    Notice selectById(int id);
}

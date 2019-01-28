package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.domain.Notice;
import com.duo.bai.cheng.web.api.dao.NoticeDao;
import com.duo.bai.cheng.web.api.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeDao noticeDao;
    @Override
    public List<Notice> selectAllNotice() {
        List<Notice> notices=noticeDao.selectAllNotice();
        return notices;
    }

    @Override
    public Notice selectById(int id) {
        Notice notice=noticeDao.selectById(id);
        return notice;
    }
}

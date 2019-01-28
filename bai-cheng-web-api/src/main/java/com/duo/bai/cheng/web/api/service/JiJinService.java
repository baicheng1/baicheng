package com.duo.bai.cheng.web.api.service;

import com.duo.bai.cheng.commons.dto.SearchInfo;
import com.duo.bai.cheng.domain.JiJin;

import java.util.List;

public interface JiJinService {

    JiJin getJiJinById(Integer id);

    List<JiJin> screen();


    List<JiJin> search(SearchInfo searchInfo);

    List<JiJin> selectHot();
}

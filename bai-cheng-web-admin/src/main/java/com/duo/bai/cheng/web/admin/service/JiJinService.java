package com.duo.bai.cheng.web.admin.service;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.JiJin;

import java.util.List;

public interface JiJinService {


    JiJin selectById(String id);

    List<JiJin> selectAllJiJin();

    int count();

    BaseResult deleteById(String id);

    List<JiJin> selectBySearch(String keyword);

    int countBySearch(String keyword);

    BaseResult deleteJiJins(String ids);

    void save(JiJin jiJin);
}

package com.duo.bai.cheng.web.api.service;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.JiJin;
import com.duo.bai.cheng.web.api.web.Controller.dto.JiJinDTO;

import java.util.List;

public interface JiJinService1 {
    BaseResult add(JiJin jiJin);

    BaseResult delete(int id);

    List<JiJinDTO> findAll();

    JiJinDTO findOne(int id);
}

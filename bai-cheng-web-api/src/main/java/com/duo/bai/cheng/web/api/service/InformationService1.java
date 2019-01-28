package com.duo.bai.cheng.web.api.service;

import com.duo.bai.cheng.domain.Information;

import java.util.List;

public interface InformationService1 {
    List<Information> selectAllInfo();

    Information selectById(int id);
}

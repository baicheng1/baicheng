package com.duo.bai.cheng.web.admin.service;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Information;

import java.util.List;

public interface InformationService {
    Information selectById(String id);

    List<Information> selectAllInformation();

    BaseResult save(Information information);

    BaseResult deleteById(String id);

    List<Information> selectBySearch(String keyword);

    int count();

    BaseResult deleteInfos(String ids);

    int countBySearch(String keyword);

//    List<Object> selectAllInfoType();
}

package com.duo.bai.cheng.web.api.service;

import com.duo.bai.cheng.commons.dto.BaseResult;


public interface InformationService {

    BaseResult select(Long id, int pid);

}

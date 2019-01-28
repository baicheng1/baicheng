package com.duo.bai.cheng.web.api.service;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.TbModify;

public interface EmailService {
    BaseResult upemail(TbModify tbModify);
}

package com.duo.bai.cheng.web.api.service;

import com.duo.bai.cheng.commons.dto.BaseResult;

import java.util.Date;

public interface CashDetailsService {
    /**
     * 搜索1个月
     * @return
     */
    BaseResult select1(Long uid);

    /**
     * 搜索3个月
     * @return
     */
    BaseResult select3(Long uid);

    /**
     * 搜索6个月
     * @return
     */
    BaseResult select6(Long uid);

    /**
     * 通过开始时间和结束时间查询订单
     * @param startTime1
     * @param endTime1
     * @param uid
     * @return
     */
    BaseResult selectByTime(Date startTime1, Date endTime1, Long uid);
}

package com.duo.bai.cheng.web.api.service;

import com.duo.bai.cheng.commons.dto.BaseResult;

import java.util.Date;

public interface LiCaiService1 {
    /**
     * 搜索1个月
     * @return
     */
    BaseResult selectBy1(Long uid);

    /**
     * 搜索3个月
     * @return
     */
    BaseResult selectBy3(Long uid);

    /**
     * 搜索6个月
     * @return
     */
    BaseResult selectBy6(Long uid);

    /**
     * 通过开始时间和结束时间查询订单
     * @param startTime
     * @param endTime
     * @return
     */
    BaseResult selectByDate(Date startTime, Date endTime, Long uid);
}

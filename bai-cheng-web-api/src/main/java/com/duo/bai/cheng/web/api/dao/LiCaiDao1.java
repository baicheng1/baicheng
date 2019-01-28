package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.domain.LiCai;

import java.util.Date;
import java.util.List;

public interface LiCaiDao1 {
    /**
     * 查询1个月借贷订单
     * @return
     */
    List<LiCai> selectBy1(Long uid);

    /**
     * 查询3个月借贷订单
     * @return
     */
    List<LiCai> selectBy3(Long uid);

    /**
     * 查询6个月借贷订单
     * @return
     */
    List<LiCai> selectBy6(Long uid);

    /**
     * 查询一定时间段内的订单
     * @param startTime
     * @param endTime
     * @return
     */
    List<LiCai> selectByDate(Date startTime, Date endTime, Long uid);
}

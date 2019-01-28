package com.duo.bai.cheng.web.api.dao;


import com.duo.bai.cheng.domain.Credit;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CashDetailsDao {
    /**
     * 查询1个月借贷订单
     * @return
     */
    List<Credit> select1(Long uid);

    /**
     * 查询3个月借贷订单
     * @return
     */
    List<Credit> select3(Long uid);

    /**
     * 查询6个月借贷订单
     * @return
     */
    List<Credit> select6(Long uid);

    /**
     * 查询一定时间段内的订单
     * @param startTime1
     * @param endTime1
     * @param uid
     * @return
     */
    List<Credit> selectByTime(Date startTime1, Date endTime1, Long uid);
}

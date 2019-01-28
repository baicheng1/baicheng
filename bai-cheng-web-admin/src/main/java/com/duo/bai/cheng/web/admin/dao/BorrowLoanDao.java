package com.duo.bai.cheng.web.admin.dao;

import com.duo.bai.cheng.domain.BorrowLoan;

import java.util.List;
import java.util.Map;

public interface BorrowLoanDao {

    /**
     * 根据pid查找借款信息
     * @param pid
     * @return
     */
    List<BorrowLoan> selectAllByPid(int pid);

    /**
     * 记录数据总数
     *
     */
    int count(BorrowLoan borrowLoan);

    /**
     * 分页
     * @param map
     * @return
     */
    List<BorrowLoan> selectByPage(Map<String, Object> map);









}

package com.duo.bai.cheng.web.admin.service;

import com.duo.bai.cheng.commons.dto.PageInfo;
import com.duo.bai.cheng.domain.BorrowLoan;

import java.util.List;

public interface BorrowLoanService {

    /**
     * 根据pid查找借款信息
     * @param pid
     * @return
     */
    List<BorrowLoan> selectAllByPid(int pid);


    /**
     * 带着搜索条件的分页
     * @param draw
     * @param start
     * @param length
     * @param * @return
     */
    PageInfo<BorrowLoan> page(int draw, int start, int length, BorrowLoan borrowLoan);

}

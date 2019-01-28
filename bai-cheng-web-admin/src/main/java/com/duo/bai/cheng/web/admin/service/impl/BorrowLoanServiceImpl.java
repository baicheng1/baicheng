package com.duo.bai.cheng.web.admin.service.impl;

import com.duo.bai.cheng.commons.dto.PageInfo;
import com.duo.bai.cheng.domain.BorrowLoan;
import com.duo.bai.cheng.web.admin.dao.BorrowLoanDao;
import com.duo.bai.cheng.web.admin.service.BorrowLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BorrowLoanServiceImpl implements BorrowLoanService {

    @Autowired
    BorrowLoanDao borrowsLoanDao;

    /**
     * 根据pid查找借款信息
     * @param pid
     * @return
     */
    public  List<BorrowLoan> selectAllByPid(int pid){
        List<BorrowLoan> borrowLoans = borrowsLoanDao.selectAllByPid(pid);
        return borrowLoans;

    }


    /**
     * 分页
     * @param draw
     * @param start
     * @param length
     * @param
     * @return
     */
    @Override
    public PageInfo<BorrowLoan> page(int draw, int start, int length, BorrowLoan borrowLoan) {
        PageInfo<BorrowLoan> pageInfo = new PageInfo<>();
        int count = borrowsLoanDao.count(borrowLoan);
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        Map<String,Object> map = new HashMap<>();
        map.put("start",start);
        map.put("length",length);
        //搜索条件是在tbUser内，把tbUser封装在map中
        map.put("borrowLoan",borrowLoan);
        pageInfo.setData(borrowsLoanDao.selectByPage(map));
        return pageInfo;
    }



}

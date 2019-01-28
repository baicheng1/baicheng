package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.domain.BorrowLoan;
import com.duo.bai.cheng.domain.ComUser;
import com.duo.bai.cheng.domain.PerUser;
import com.duo.bai.cheng.web.api.dao.TbBorrowDao;
import com.duo.bai.cheng.web.api.service.TbBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbBorrowServiceImpl implements TbBorrowService {

    @Autowired
    TbBorrowDao tbBorrowDao;

    /**
     * 根据id查找用户信息
     * @param id
     * @return
     */
    @Override
    public ComUser selectComUserById(Long id) {
        ComUser comUser = tbBorrowDao.selectComUserById(id);
        return comUser;
    }

    @Override
    public PerUser selectPerUserById(Long id) {
        PerUser perUser = tbBorrowDao.selectPerUserById(id);
        return perUser;
    }

    /**
     * 根据用户名查找借贷记录
     * @param
     * @return
     */
    @Override
    public List<BorrowLoan> selectAll(BorrowLoan borrowLoan) {

        List<BorrowLoan> borrowLoans = tbBorrowDao.selectAll(borrowLoan);
        return borrowLoans;
    }

    /**
     * 添加借款信息
     * @param borrowLoan
     */
    @Override
    public void insert(BorrowLoan borrowLoan) {

        tbBorrowDao.insert(borrowLoan);
    }

    /**
     * 根据借款单号查找借款信息
     * @param creditId
     * @return
     */
    @Override
    public BorrowLoan selectByCreditId(Long creditId) {
        BorrowLoan borrowLoan = tbBorrowDao.selectByCreditId(creditId);
        return borrowLoan;
    }

    /**
     * 根据借款单号删除借款信息
     * @param
     */
    @Override
    public void delete(Long creditId) {
        tbBorrowDao.delete(creditId);
    }

    /**
     * 根据借款单号更新借款信息
     * @param borrowLoan
     */
    @Override
    public void update(BorrowLoan borrowLoan) {
       tbBorrowDao.update(borrowLoan);
    }

    /**
     * 根据用户id完善个人信息
     * @param perUser
     */
    @Override
    public void updatePer(PerUser perUser) {
        tbBorrowDao.updatePer(perUser);
    }


    /**
     * 根据用户id完善企业信息
     * @param comUser
     */
    @Override
    public void updateCom(ComUser comUser) {
        tbBorrowDao.updateCom(comUser);
    }


}

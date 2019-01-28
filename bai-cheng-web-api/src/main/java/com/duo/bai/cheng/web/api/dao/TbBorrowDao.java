package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.domain.BorrowLoan;
import com.duo.bai.cheng.domain.ComUser;
import com.duo.bai.cheng.domain.PerUser;

import java.util.List;

public interface TbBorrowDao {

    /**
     * 根据id查找用户信息
     * @param id
     * @return
     */
    ComUser selectComUserById(Long id);
    PerUser selectPerUserById(Long id);

    /**
     * 根据用户名查找用户借贷记录
     * @param
     * @return
     */
    List<BorrowLoan> selectAll(BorrowLoan borrowLoan);


    /**
     * 添加借款信息
     * @param borrowLoan
     */
    void insert(BorrowLoan borrowLoan);

    /**
     * 根据借款单号查找借款信息
     * @param creditId
     * @return
     */
    BorrowLoan selectByCreditId(Long creditId);

    /**
     * 根据借款单号删除借款信息
     * @param creditId
     */
   void delete(Long creditId);

    /**
     * 根据借款单号更新借款信息
     * @param borrowLoan
     */
   void update(BorrowLoan borrowLoan);


    /**
     * 根据用户id完善个人信息
     * @param perUser
     */
    void updatePer(PerUser perUser);


    /**
     * 根据用户id完善企业信息
     * @param comUser
     */
    void updateCom(ComUser comUser);


}

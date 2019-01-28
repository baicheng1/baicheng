package com.duo.bai.cheng.web.api.web.Controller.v1;



import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.commons.util.EmailUtils;
import com.duo.bai.cheng.domain.BorrowLoan;
import com.duo.bai.cheng.domain.ComUser;
import com.duo.bai.cheng.domain.PerUser;
import com.duo.bai.cheng.web.api.service.TbBorrowService;
import com.duo.bai.cheng.web.api.web.Controller.dto.BorrowLoanDTO;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("${api.path.v1}/borrows")
public class BorrowController {


    @Autowired
    TbBorrowService tbBorrowService;

    @Autowired
    private EmailUtils emailUtils;

    BaseResult baseResult = null;
    /**
     * 借款
     * 根据用户输入的金额和期限,自动计算出信息
     *
     * @param borrowLoanDTO
     * @return
     */
    @RequestMapping(value = "loan", method = RequestMethod.GET)
    public BaseResult borrow(BorrowLoanDTO borrowLoanDTO, HttpServletRequest request) {

        if (borrowLoanDTO.getJieMoney() > 0) {
            if (borrowLoanDTO.getMonth() < 6) {
                borrowLoanDTO.setDayInterest(0.0003);
            } else if (borrowLoanDTO.getMonth() >= 6 && borrowLoanDTO.getMonth() < 12) {
                borrowLoanDTO.setDayInterest(0.00035);
            } else if (borrowLoanDTO.getMonth() >= 12 && borrowLoanDTO.getMonth() < 18) {
                borrowLoanDTO.setDayInterest(0.0004);
            } else {
                borrowLoanDTO.setDayInterest(0.0005);
            }

            borrowLoanDTO.setPerInterest(borrowLoanDTO.getJieMoney() * 30 * borrowLoanDTO.getDayInterest());
            borrowLoanDTO.setTotalInterest(borrowLoanDTO.getPerInterest() * borrowLoanDTO.getMonth());
            borrowLoanDTO.setHuanMoney(borrowLoanDTO.getJieMoney() + borrowLoanDTO.getTotalInterest());
            borrowLoanDTO.setPerMoney(borrowLoanDTO.getHuanMoney() / borrowLoanDTO.getMonth());
            //将生成的借贷信息存入域中
            //model.addAttribute("borrowLoanDTO",borrowLoanDTO);

            request.getSession().setAttribute("borrowLoanDTO",borrowLoanDTO);
            baseResult = BaseResult.success(borrowLoanDTO);
        } else {
            baseResult = BaseResult.fail("输入金额不能小于0");
        }

       return baseResult;
    }


    /**
     * 验证借款人信息是否完整
     *
     * @return
     */
    @RequestMapping(value = "check", method = RequestMethod.GET)
    public BaseResult check(Long id, int pid, HttpServletRequest request) {

        if (pid == 0) {
            //个人借款
            PerUser perUser = tbBorrowService.selectPerUserById(id);
            //判断信息是否完整
            if (perUser.getIcard() != null && perUser.getAddress() != null && perUser.getPhone() != null) {
                //个人信息完整
                baseResult = BaseResult.success( "个人信息完整", perUser);
            } else {
                //个人信息不完整
               baseResult =  BaseResult.fail( "个人信息不完整", perUser);
            }
            request.getSession().setAttribute("perUser",perUser);

        } else {
            //企业借款
            ComUser comUser = tbBorrowService.selectComUserById(id);
            if (comUser.getAddress() != null && comUser.getBcode() != null && comUser.getIcard() != null && comUser.getPhone() != null) {
                //企业信息不完整
                baseResult = BaseResult.success( "企业信息完整", comUser);
            } else {
                //企业信息完整
                baseResult = BaseResult.fail( "企业信息不完整", comUser);
            }
            request.getSession().setAttribute("comUser",comUser);
        }
        return baseResult;
    }


    /**
     * 完善个人信息
     * @param perUser
     * @return
     */
     @RequestMapping(value = "perImprove",method = RequestMethod.POST)
     public BaseResult improve(PerUser perUser){
         tbBorrowService.updatePer(perUser);
         baseResult = BaseResult.success("个人信息已完善");
         return baseResult;
     }


    /**
     * 完善企业信息
     * @param
     * @return
     */
    @RequestMapping(value = "comImprove",method = RequestMethod.POST)
    public BaseResult improve(ComUser comUser){
        System.out.println(comUser);
        tbBorrowService.updateCom(comUser);
        baseResult = BaseResult.success("企业信息已完善");
        return baseResult;
    }









    /**
     * 还款
     * @param creditId  借款单号
     * @param count   还款月数
     * @return
     */
    @RequestMapping(value = "back",method = RequestMethod.POST)
    public BaseResult back(Long creditId, int count){

        //根据借贷单号查找借贷信息
        BorrowLoan borrowLoan = tbBorrowService.selectByCreditId(creditId);
        //还剩还款的月份与已还款的月份之差
        int sum = borrowLoan.getMonth()-count;

        if(sum<=0){
            //借款已还清,删除借款信息
            tbBorrowService.delete(creditId);
            baseResult = BaseResult.success("借款已还清");
        }else{

            //借款未还清,还需还款信息
            borrowLoan.setMonth(sum);
            borrowLoan.setTotalInterest(borrowLoan.getPerInterest() * sum);
            borrowLoan.setHuanMoney(borrowLoan.getPerMoney()*sum);
            tbBorrowService.update(borrowLoan);
            baseResult = BaseResult.success("还款成功",borrowLoan);
        }

        return baseResult;
    }

    /**
     * 借款成功,保存借款信息
     * @param name
     * @param pid
     * @param
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public BaseResult save(String name, int pid, String email, HttpServletRequest request, Object o) throws EmailException {
        //从域中取出borrowDTO
        BorrowLoanDTO borrowLoanDTO =  (BorrowLoanDTO) request.getSession().getAttribute("borrowLoanDTO");
        Date date=new Date();
        BorrowLoan borrowLoan = new BorrowLoan();
        BeanUtils.copyProperties(borrowLoanDTO,borrowLoan);
        borrowLoan.setCreatetime(new Date());
        borrowLoan.setName(name);
        borrowLoan.setPid(pid);
        borrowLoan.setRepaytime(new Date(date.getTime()+(long)30 * 24 * 60 * 60 * 1000*borrowLoan.getMonth()));

        //借款成功,发送邮件到用户邮箱
        System.out.println("==="+borrowLoan.getJieMoney());
       emailUtils.send("借款信息",String.format("您的借款已到账,金额为:【%s】,请注意查收!",borrowLoan.getJieMoney()),
                email);

        tbBorrowService.insert(borrowLoan);
        baseResult = BaseResult.success("添加信息成功",borrowLoan);
        return baseResult;
    }




    /**
     * 借款记录
     * @param
     * @return
     */
    @RequestMapping(value = "record",method = RequestMethod.GET)
    public BaseResult record(BorrowLoan borrowLoan){
        List<BorrowLoan> borrowLoans = tbBorrowService.selectAll(borrowLoan);
        baseResult = BaseResult.success("查询成功", borrowLoans);
        return baseResult;
    }




}

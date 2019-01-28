package com.duo.bai.cheng.web.admin.web.controller;

import com.duo.bai.cheng.commons.dto.PageInfo;
import com.duo.bai.cheng.domain.BorrowLoan;
import com.duo.bai.cheng.web.admin.service.BorrowLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("borrows")
public class BorrowController {

    @Autowired
    BorrowLoanService borrowLoanService;


    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "loanInfo",method = RequestMethod.GET)
    public String loan(){
      //  List<BorrowLoan> borrowLoans = borrowLoanService.selectAllByPid(pid);
      //  model.addAttribute("borrowsLoan",borrowLoans);
        return "loanInfo";
    }


    @ResponseBody
    @RequestMapping(value="page",method= RequestMethod.GET)
    public PageInfo<BorrowLoan> page(HttpServletRequest request, BorrowLoan borrowLoan){

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        int draw = strDraw == null ? 1 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);
        PageInfo<BorrowLoan> pageInfo =  borrowLoanService.page(draw,start,length,borrowLoan);
        return pageInfo;
    }



}

package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.web.api.service.CashDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value="${api.path.v1}/goods")
public class CashDetailsController {

    @Autowired
    private CashDetailsService cashDetailsService;

    @RequestMapping(value ="month1", method = RequestMethod.POST)
    public BaseResult search1(Long uid) {
        BaseResult baseResult = null;
    if(uid!=null){
        baseResult = cashDetailsService.select1(uid);

        return baseResult;

    }else{
        baseResult = BaseResult.success("用户未登录，请先登录");
        return baseResult;
    }


    }
    @RequestMapping(value ="month3", method = RequestMethod.POST)
    public BaseResult search3(Long uid) {
        BaseResult baseResult = null;
        if(uid!=null){
            baseResult = cashDetailsService.select3(uid);

            return baseResult;
        }else{
            baseResult = BaseResult.success("用户未登录，请先登录");
            return baseResult;
        }

    }

    @RequestMapping(value ="month6", method = RequestMethod.POST)
    public BaseResult search6(Long uid) {
        BaseResult baseResult = null;
        if(uid!=null){
           baseResult = cashDetailsService.select6(uid);

            return baseResult;
        }else{
            baseResult = BaseResult.success("用户未登录，请先登录");
            return baseResult;
        }
    }

    @RequestMapping(value ="date", method = RequestMethod.POST)
    public BaseResult search(String startTime, String endTime, Long uid) {
        BaseResult baseResult = null;
        if(uid!=null){
            // String string = "2016-10-24 21:59:06";
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Date startTime1 = format.parse(startTime);
                Date endTime1 = format.parse(endTime);

                baseResult = cashDetailsService.selectByTime(startTime1,endTime1,uid);

                return baseResult;

            } catch (ParseException e) {
                e.printStackTrace();
            }
            return baseResult;
        }else{
            baseResult = BaseResult.success("用户未登录，请先登录");
            return baseResult;
        }
    }
}

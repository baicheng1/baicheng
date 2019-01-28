package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.web.api.service.LiCaiService;
import com.duo.bai.cheng.web.api.service.LiCaiService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value="${api.path.v1}/orders")
public class LiCaiController1 {
    @Autowired
    private LiCaiService1 liCaiService1;


    @RequestMapping(value ="month1", method = RequestMethod.POST)
    public BaseResult search1(Long uid) {
        BaseResult baseResult = null;
        if(uid!=null){
            baseResult = liCaiService1.selectBy1(uid);

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
            baseResult = liCaiService1.selectBy3(uid);
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
            baseResult = liCaiService1.selectBy6(uid);

            return baseResult;
        }else{
            baseResult = BaseResult.success("用户未登录，请先登录");
            return baseResult;
        }
    }

    @RequestMapping(value ="date", method = RequestMethod.POST)
    public BaseResult search(String startTime,String endTime,Long uid) {
        BaseResult baseResult = null;
        if(uid!=null){
            // String string = "2016-10-24";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startTime1 = sdf.parse(startTime);
                Date endTime1 = sdf.parse(endTime);

                baseResult = liCaiService1.selectByDate(startTime1,endTime1,uid);

                return baseResult;

            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }else{
            baseResult = BaseResult.success("用户未登录，请先登录");
            return baseResult;
        }
    }
}

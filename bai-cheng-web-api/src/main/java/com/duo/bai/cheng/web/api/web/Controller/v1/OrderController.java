package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Order;
import com.duo.bai.cheng.web.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public BaseResult add(String uname, String name, int time, String rate, String money,Long uid){
        Order order=new Order();
        order.setName(name);
        order.setTime(time);
        order.setRate(new BigDecimal(rate));
        order.setMoney(Integer.parseInt(money));
        order.setCreated(new Date());
        BigDecimal interest=order.getRate().multiply(new BigDecimal(time).multiply(new BigDecimal(money)));
        order.setInterest(interest);
        order.setUname(uname);
        order.setUid(uid);
        System.out.println(order.toString());
        BaseResult baseResult = orderService.addOrder(order);
        return baseResult;
    }
}

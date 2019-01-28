package com.duo.bai.cheng.web.api.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Order;
import com.duo.bai.cheng.web.api.dao.OrderDao;
import com.duo.bai.cheng.web.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Override
    public BaseResult addOrder(Order order) {
        orderDao.addOrder(order);
        BaseResult baseResult= BaseResult.success("购买成功");
        return baseResult;
    }
}

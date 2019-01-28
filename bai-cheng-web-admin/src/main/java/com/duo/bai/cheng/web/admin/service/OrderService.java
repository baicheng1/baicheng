package com.duo.bai.cheng.web.admin.service;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Order;

import java.util.List;

public interface OrderService {
    Order selectById(Integer id);

    List<Order> selectAllOrder();

    BaseResult save(Order order);

    BaseResult deleteById(String id);

    List<Order> selectBySearch(String keyword);

    int count();

    BaseResult deleteOrders(String ids);

//    PageInfo<User> selectByPage(int draw, int start, int length, User user);

    int countBySearch(String keyword);

//    List<Object> selectAllJiJinId();
}

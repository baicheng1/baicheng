package com.duo.bai.cheng.web.admin.dao;

import com.duo.bai.cheng.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDao {
    Order selectById(Integer id);

    List<Order> selectAllOrder();

    void insert(Order order);

    void deleteById(String id);

    List<Order> selectBySearch(String keyword);

    int count(Order order);
//    int count();

    void deleteOrders(String[] id_arr);

    List<Order> selectByPage(Map<String, Object> map);

    void updateOrder(Order order);

    int countBySearch(String keyword);

//    List<Object> selectAllJiJinId();
}

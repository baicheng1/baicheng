package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    void addOrder(Order order);
}

package com.duo.bai.cheng.web.api.dao;

import com.duo.bai.cheng.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductDao {
    List<Product> findAllByType(int type);

    List<Product> findAllByCreated();

    List<Product> findAllByReturnrate();

    Product findAllByTypeAndId(Map<String, Object> map);
}

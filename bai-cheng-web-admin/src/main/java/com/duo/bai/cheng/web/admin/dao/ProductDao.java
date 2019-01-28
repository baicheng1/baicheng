package com.duo.bai.cheng.web.admin.dao;

import com.duo.bai.cheng.domain.Product;

import java.util.List;


public interface ProductDao {
    List<Product> findAll();

    int count();

    void insert(Product product);

    void update(Product product);

    Product selectById(String pid);

   void deleteById(String pid);

    void deleteNotices(String[] id_arr);
}

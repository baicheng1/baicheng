package com.duo.bai.cheng.web.api.service;

import com.duo.bai.cheng.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllByType(int ptype);

    List<Product> findAllByCreated();

    List<Product> findAllByReturnrate();

    Product findAllByTypeAndId(int ptype, int pid);
}

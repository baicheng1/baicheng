package com.duo.bai.cheng.web.admin.service;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> selectAllProduct();


    int count() ;

    BaseResult deleteById(String id) ;

    List<Product> selectBySearch(String keyword) ;

    int countBySearch(String keyword) ;

    BaseResult deleteProducts(String ids) ;

    Product selectById(String pid);

    BaseResult save(Product product);
}

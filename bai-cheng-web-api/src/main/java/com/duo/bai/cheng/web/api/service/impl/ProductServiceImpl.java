package com.duo.bai.cheng.web.api.service.impl;


import com.duo.bai.cheng.domain.Product;
import com.duo.bai.cheng.web.api.dao.ProductDao;
import com.duo.bai.cheng.web.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
    @Override
    public List<Product> findAllByType(int ptype) {
        return productDao.findAllByType(ptype);
    }

    @Override
    public List<Product> findAllByCreated() {
        return productDao.findAllByCreated();
    }

    @Override
    public List<Product> findAllByReturnrate() {
        return productDao.findAllByReturnrate();
    }

    @Override
    public Product findAllByTypeAndId(int ptype, int pid) {
        Map<String,Object> map = new HashMap<>();
        map.put("ptype",ptype);
        map.put("pid",pid);
        return productDao.findAllByTypeAndId(map);
    }
}

package com.duo.bai.cheng.web.admin.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Product;
import com.duo.bai.cheng.web.admin.dao.ProductDao;
import com.duo.bai.cheng.web.admin.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
    @Override
    public List<Product> selectAllProduct() {
        return productDao.findAll();
    }

    @Override
    public int count() {
        return productDao.count();
    }

    @Override
    public BaseResult deleteById(String pid) {
        BaseResult baseResult;
        //判断ids是否为空
        if (!StringUtils.isBlank(pid)) {
            System.out.println("要删除的id：" + pid);
            productDao.deleteById(pid);
            baseResult = BaseResult.success("删除成功");
        } else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }

    @Override
    public List<Product> selectBySearch(String keyword) {
        return null;
    }

    @Override
    public int countBySearch(String keyword) {
        return 0;
    }

    @Override
    public BaseResult deleteProducts(String ids) {
        BaseResult baseResult;
        //判空
        if(!StringUtils.isBlank(ids)){
            String[] id_arr = ids.split(",");
            productDao.deleteNotices(id_arr);
            baseResult= BaseResult.success("删除成功");

        }else {
            baseResult= BaseResult.fail("删除失败");
        }
        return baseResult;
    }

    @Override
    public Product selectById(String pid) {
        return productDao.selectById(pid);
    }

    @Override

        public BaseResult save(Product product) {
            //验证表单是否通过
            BaseResult baseResult = checkNotice(product);
            if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
                //表单验证通过
                System.out.println("======"+product.getPid());
                if (product.getPid()==0) {
                    //新增用户
                    productDao.insert(product);
                } else {
                    //编辑用户
                    productDao.update(product);
                }
                baseResult.setMessage("产品保存成功");
            }
            //不通过 直接返回
            return baseResult;
        }
    public BaseResult checkNotice(Product product) {
        BaseResult baseResult = BaseResult.success();
        if (StringUtils.isBlank(product.getPname())) {
            baseResult = BaseResult.fail("产品名称不能为空，请重新填写");
            return baseResult;
        }

        return baseResult;
    }
}

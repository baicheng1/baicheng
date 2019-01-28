package com.duo.bai.cheng.web.api.web.Controller.v1;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Product;
import com.duo.bai.cheng.web.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.path.v1}/licaiProduct")
public class ProductController {
    @Autowired
    ProductService productService;
    //查询活期或定期
    @RequestMapping(value="{ptype}",method = RequestMethod.GET)
    public BaseResult findAllByType(@PathVariable("ptype") int type){
        List<Product> products=productService.findAllByType(type);
        BaseResult baseResult = BaseResult.success(200,"成功",products);
        return baseResult;
    }
    //查询单个活期或定期
    @RequestMapping(value="showone",method = RequestMethod.GET)
    public BaseResult findAllByTypeAndId(String ptype, String pid){
        System.out.println(ptype+"" +
                "========================="+pid);
        Product product=productService.findAllByTypeAndId(Integer.parseInt(ptype),Integer.parseInt(pid));
        BaseResult baseResult = BaseResult.success(200,"成功",product);
        return baseResult;
    }
    //查询活期最新上架
    @RequestMapping(value="created",method = RequestMethod.GET)
    public BaseResult findAllByCreated(){
        List<Product> products=productService.findAllByCreated();
        BaseResult baseResult = BaseResult.success(200,"成功",products);
        return baseResult;
    }
    //查询活期本月最佳
    @RequestMapping(value="returnrate",method = RequestMethod.GET)
    public BaseResult findAllByReturnrate(){
        List<Product> products=productService.findAllByReturnrate();
        BaseResult baseResult = BaseResult.success(200,"成功",products);
        return baseResult;
    }

}

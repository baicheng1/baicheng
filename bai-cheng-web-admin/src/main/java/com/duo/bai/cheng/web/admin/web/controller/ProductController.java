package com.duo.bai.cheng.web.admin.web.controller;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Product;
import com.duo.bai.cheng.web.admin.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("licai")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute
    public Product getProduct(String pid) {
        Product product = new Product();
        if (pid != null) {
            product = productService.selectById(pid);
            if (product!=null){
                System.out.println(product.toString());
            }

        }
        return product;
    }

      // @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Product> products = productService.selectAllProduct();
        int count = productService.count();
        model.addAttribute("products", products);
        model.addAttribute("count", count);
        return "licai_list";
    }
    /**
     * 查看用户详情
     *
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail() {
        return "product_detail";
    }


    @RequestMapping(value = "save", method = RequestMethod.GET)
    public String save(Model model, String pid, String pname, String ptype, String startprice, String time, String returnrate) {
        Product product=new Product();
        if (pid!=null&&pid!=""){
            product.setPid(Integer.parseInt(pid));
        }
        product.setPname(pname);
        product.setPtype(Integer.parseInt(ptype));
        product.setStartprice(new BigDecimal(startprice));
        product.setTime(Integer.parseInt(time));
        product.setReturnrate(new BigDecimal(returnrate));
        product.setCreated(new Date());
        productService.save(product);
        return "redirect:/licai/list";
    }

      // @ResponseBody
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "licai_form";
    }

    @ResponseBody
    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    public BaseResult deleteById(String id) {
        BaseResult baseResult = productService.deleteById(id);
        return baseResult;
    }

     //  @ResponseBody
    @RequestMapping(value = "selectBySearch", method = RequestMethod.POST)
    public String selectBySearch(String keyword, Model model) {
        List<Product> products;
        if (StringUtils.isBlank(keyword)) {
            products = productService.selectAllProduct();
        } else {
            products = productService.selectBySearch(keyword);
        }
        int count = productService.countBySearch(keyword);
        model.addAttribute("Products", products);
        model.addAttribute("count", count);
        return "licai_list";
    }

    @ResponseBody
    @RequestMapping(value = "deletemulti", method = RequestMethod.POST)
    public BaseResult deletemulti(String ids, Model model) {
        BaseResult baseResult = productService.deleteProducts(ids);
        model.addAttribute("baseResult",baseResult);
        return baseResult;
    }
}

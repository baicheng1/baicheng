package com.duo.bai.cheng.web.admin.web.controller;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Order;
import com.duo.bai.cheng.web.admin.service.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @ModelAttribute
    public Order getOrder(Integer id) {
        Order order = new Order();
        if (id != null) {
            order = orderService.selectById(id);
        }
        return order;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    //    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Order> orders = orderService.selectAllOrder();
        int count = orderService.count();
        model.addAttribute("orders", orders);
        model.addAttribute("count", count);
        return "order_list";
    }
    /**
     * 查看用户详情
     *
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail() {
        return "order_detail";
    }


    @RequestMapping(value = "save", method = RequestMethod.GET)
    public String save(Model model, Order order) {
//        if (id!=null&&id!=""){
//            order.setId(Integer.parseInt(id));
//        }
//        if (order != null) {
            BaseResult baseResult = orderService.save(order);
            model.addAttribute("baseResult", baseResult);
            System.out.println(baseResult.getMessage());
//        }

        return "redirect:/order/list";
    }

    //    @ResponseBody
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model) {
//        List<Object> jiJinId_ids=orderService.selectAllJiJinId();
//        model.addAttribute("jiJinId_ids",jiJinId_ids);
//        System.out.println("============================="+jiJinId_ids);
        return "order_form";
    }

    @ResponseBody
    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    public BaseResult deleteById(String id) {
        BaseResult baseResult = orderService.deleteById(id);
        return baseResult;
    }

    //    @ResponseBody
    @RequestMapping(value = "selectBySearch", method = RequestMethod.POST)
    public String selectBySearch(String keyword, Model model) {
        System.out.println("搜索关键字=============================="+keyword);
        List<Order> orders;
        if (StringUtils.isBlank(keyword)) {
            orders = orderService.selectAllOrder();
        } else {
            orders = orderService.selectBySearch(keyword);
        }
        int count = orderService.countBySearch(keyword);
        model.addAttribute("orders", orders);
        model.addAttribute("count", count);
        return "order_list";
    }

    @ResponseBody
    @RequestMapping(value = "deletemulti", method = RequestMethod.POST)
    public BaseResult deletemulti(String ids, Model model) {
        BaseResult baseResult = orderService.deleteOrders(ids);
        model.addAttribute("baseResult",baseResult);
        return baseResult;
    }




    /**
     * 分页（搜索后）
     *
     * @param request
     * @param user
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value = "page", method = RequestMethod.GET)
//    public PageInfo<User> page(HttpServletRequest request, User user) {
//        String strDraw = request.getParameter("draw");
//        String strStart = request.getParameter("start");
//        String strLength = request.getParameter("Length");
//        int draw = strDraw == null ? 1 : Integer.parseInt(strDraw);
//        int start = strStart == null ? 0 : Integer.parseInt(strStart);
//        int length = strLength == null ? 10 : Integer.parseInt(strLength);
//        PageInfo<User> pageInfo = userService.selectByPage(draw, start, length, user);
//        return pageInfo;
//    }
}

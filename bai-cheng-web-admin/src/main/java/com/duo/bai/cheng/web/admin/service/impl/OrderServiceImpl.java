package com.duo.bai.cheng.web.admin.service.impl;

import com.duo.bai.cheng.commons.dto.BaseResult;
import com.duo.bai.cheng.domain.Order;
import com.duo.bai.cheng.web.admin.dao.OrderDao;
import com.duo.bai.cheng.web.admin.service.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public Order selectById(Integer id) {
        Order order = orderDao.selectById(id);
        return order;
    }

    @Override
    public List<Order> selectAllOrder() {
        List<Order> orders = orderDao.selectAllOrder();
        return orders;
    }

    @Override
    public BaseResult save(Order order) {
        //验证表单是否通过
        BaseResult baseResult = checkOrder(order);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            //表单验证通过
            if (order.getId()==null) {
                //新增用户
//                order.setOrderCreated(new Date());
                orderDao.insert(order);
            } else {
                //编辑用户
                orderDao.updateOrder(order);
            }
            baseResult.setMessage("用户保存成功");
        }
        //不通过 直接返回
        return baseResult;
    }

    @Override
    public BaseResult deleteById(String id) {
        BaseResult baseResult;
        //判断ids是否为空
        if (!StringUtils.isBlank(id)) {
            System.out.println("要删除的id：" + id);
            orderDao.deleteById(id);
            baseResult = BaseResult.success("删除成功");
        } else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }

    @Override
    public List<Order> selectBySearch(String keyword) {
        List<Order> orders=orderDao.selectBySearch(keyword);
        return orders;
    }

    @Override
    public int count() {
        Order order=new Order();
        return orderDao.count(order);
    }

    @Override
    public BaseResult deleteOrders(String ids) {
        BaseResult baseResult;
        //判空
        if(!StringUtils.isBlank(ids)){
            String[] id_arr = ids.split(",");
            orderDao.deleteOrders(id_arr);
            baseResult= BaseResult.success("删除成功");

        }else {
            baseResult= BaseResult.fail("删除失败");
        }
        return baseResult;
    }

//    @Override
//    public PageInfo<User> selectByPage(int draw, int start, int length, User user) {
//        PageInfo<User> pageInfo = new PageInfo<>();
//        pageInfo.setDraw(draw);
//        Map<String, Object> map = new HashMap<>();
//        pageInfo.setRecordsTotal(userDao.count(user));
//        pageInfo.setRecordsFiltered(userDao.count(user));
//        //将分页条件封装到map里面
//        map.put("start", start);
//        map.put("length", length);
//        map.put("user", user);
//        pageInfo.setData(userDao.selectByPage(map));
//        return pageInfo;
//    }

    @Override
    public int countBySearch(String keyword) {
        int count=orderDao.countBySearch(keyword);
        return count;
    }
//
//    @Override
//    public  List<Object> selectAllJiJinId() {
//        List<Object> jiJinId_ids=orderDao.selectAllJiJinId();
//        return jiJinId_ids;
//    }

    public BaseResult checkOrder(Order order) {
        BaseResult baseResult = BaseResult.success();
        if (StringUtils.isBlank(order.getName())) {
                baseResult = BaseResult.fail("理财产品不能为空，请重新填写");
                return baseResult;
        }
        if (StringUtils.isBlank(order.getTime().toString())) {
            baseResult = BaseResult.fail("周期不能为空，请重新填写");
            return baseResult;
        }
        if (StringUtils.isBlank(order.getMoney().toString())) {
            baseResult = BaseResult.fail("投资金额不能为空，请重新填写");
            return baseResult;
        }
        if (StringUtils.isBlank(order.getRate().toString())) {
            baseResult = BaseResult.fail("月利率不能为空，请重新填写");
            return baseResult;
        }
        return baseResult;
    }


}

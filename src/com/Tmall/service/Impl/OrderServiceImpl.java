package com.Tmall.service.Impl;

import com.Tmall.bean.Order;
import com.Tmall.mapper.OrderMapper;
import com.Tmall.service.OrderService;
import com.Tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jingyi
 * @Classname OrderServiceImpl
 * @description TODO
 * @date 2021/8/3 15:42
 */
@Service
public class OrderServiceImpl  implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> list(Page page) {
        return orderMapper.list(page);
    }

    @Override
    public int total() {
        return orderMapper.total();
    }

    @Override
    public void updateOrderStatus(Order o) {
        orderMapper.updateOrderStatus(o);
    }

    @Override
    public Order addOrder(Order order) {
        orderMapper.addOrder(order);
        return order;
    }

    @Override
    public Order getOrder(Integer oid) {
        return orderMapper.getOrder(oid);
    }

    @Override
    public void updateOrderStatusAndpayDate(Order order) {
        orderMapper.updateOrderStatusAndpayDate(order);
    }

    @Override
    public List<Order> getAbleOrders(Integer uid) {
        return orderMapper.getAbleOrders(uid);
    }

    @Override
    public void updateOrderStatusAndConfirmDate(Order order) {
        orderMapper.updateOrderStatusAndConfirmDate(order);
    }

    @Override
    public boolean updatestatusdel(Order order) {
        int i = orderMapper.updatestatusdel(order);
        if (i>0){
            return true;
        }else{
            return false;
        }
    }
}

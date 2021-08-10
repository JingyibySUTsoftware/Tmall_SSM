package com.Tmall.service;

import com.Tmall.bean.Order;
import com.Tmall.util.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface OrderService {
    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";
    /**
     * @description 获取订单表的信息
     * @param page
     * @author jingyi
     * @date 2021/8/3 15:41
     * @return java.util.List<com.Tmall.bean.Order>
     */
    public List<Order> list(Page page);
    /**
     * @description 获取订单的总数
     * @param
     * @author jingyi
     * @date 2021/8/3 15:59
     * @return int
     */
    public int total();
    /**
     * @description 发货
     * @param o
     * @author jingyi
     * @date 2021/8/4 14:40
     * @return void
     */
    void updateOrderStatus(Order o);
}

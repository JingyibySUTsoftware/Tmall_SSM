package com.Tmall.service;

import com.Tmall.bean.Order;
import com.Tmall.util.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface OrderService {
    //订单状态码
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
    /**
     * @description 创建订单
     * @param
     * @param order
     * @author jingyi
     * @date 2021/8/31 11:49
     * @return void
     */
    Order addOrder(Order order);
    /**
     * @description 根据订单号获取订单信息
     * @param
     * @param oid
     * @author jingyi
     * @date 2021/8/31 15:26
     * @return com.Tmall.bean.Order
     */
    Order getOrder(Integer oid);
    /**
     * @description 修改订单支付时间和状态
     * @param
     * @param order
     * @author jingyi
     * @date 2021/8/31 15:33
     * @return void
     */
    void updateOrderStatusAndpayDate(Order order);
    /**
     * @description 查看用户所有未被删除的所有的订单
     * @param
     * @param uid
     * @author jingyi
     * @date 2021/8/31 17:05
     * @return java.util.List<com.Tmall.bean.Order>
     */
    List<Order> getAbleOrders(Integer uid);
    /**
     * @description 修改订单状态和订单确认收获日期
     * @param
     * @param order
     * @author jingyi
     * @date 2021/8/31 19:43
     * @return void
     */
    void updateOrderStatusAndConfirmDate(Order order);
    /**
     * @description 将订单状态隐藏
     * @param
     * @param order
     * @author jingyi
     * @date 2021/8/31 19:51
     * @return void
     */
    boolean updatestatusdel(Order order);
}

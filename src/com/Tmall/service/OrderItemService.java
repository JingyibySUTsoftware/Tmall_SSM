package com.Tmall.service;

import com.Tmall.bean.Order;
import com.Tmall.bean.OrderItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface OrderItemService {
    /**
     * @description 通过订单id获取详细订单
     * @param oid
     * @author jingyi
     * @date 2021/8/3 21:13
     * @return java.util.List<com.Tmall.bean.OrderItem>
     */
    List<OrderItem> getByoid(Integer oid);
    /**
     * @description 循环遍历给每个订单赋总价格和商品数量
     * @param or
     * @author jingyi
     * @date 2021/8/3 21:15
     * @return void
     */
     void fill(List<Order> or);
     /**
      * @description 循环遍历
      * @param o
      * @author jingyi
      * @date 2021/8/3 21:16
      * @return void
      */
     void fill(Order o);
    /**
     * @description 获取商品的销量
     * @param
     * @param pid
     * @author jingyi
     * @date 2021/8/15 17:08
     * @return int
     */
    int getSaleCount(Integer pid);
}

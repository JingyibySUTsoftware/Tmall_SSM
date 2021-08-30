package com.Tmall.mapper;

import com.Tmall.bean.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemMapper {
     List<OrderItem>  getByoid(Integer oid);

     int getSaleCount(Integer pid);

     List<OrderItem> getOderItemsByuid(Integer uid);

     void addOrderItem(OrderItem orderItem);

     void updateOrderItem(OrderItem orderItem);

     OrderItem getOrderItem(Integer id);

     void deleteOrderItem(Integer id);
}

package com.Tmall.mapper;

import com.Tmall.bean.Order;
import com.Tmall.util.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    List<Order> list(Page page);

    int total();

    void updateOrderStatus(Order o);

	void  addOrder(Order order);

	Order getOrder(Integer oid);

	void updateOrderStatusAndpayDate(Order order);

	List<Order> getAbleOrders(Integer uid);

	void updateOrderStatusAndConfirmDate(Order order);

	int updatestatusdel(Order order);
}

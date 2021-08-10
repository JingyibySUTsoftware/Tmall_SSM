package com.Tmall.mapper;

import com.Tmall.bean.Order;
import com.Tmall.util.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
	public List<Order> list(Page page);

	public int total();

	public void updateOrderStatus(Order o);
}

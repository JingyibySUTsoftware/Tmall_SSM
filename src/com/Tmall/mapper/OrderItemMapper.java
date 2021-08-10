package com.Tmall.mapper;

import com.Tmall.bean.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemMapper {
    public List<OrderItem>  getByoid(Integer oid);
}

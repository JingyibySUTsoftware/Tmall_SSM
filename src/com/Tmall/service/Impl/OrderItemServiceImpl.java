package com.Tmall.service.Impl;

import com.Tmall.bean.Order;
import com.Tmall.bean.OrderItem;
import com.Tmall.bean.Product;
import com.Tmall.bean.ProductImage;
import com.Tmall.mapper.OrderItemMapper;
import com.Tmall.service.OrderItemService;
import com.Tmall.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jingyi
 * @Classname OrderItemServiceImpl
 * @description TODO
 * @date 2021/8/3 20:38
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private ProductImageService productImageService;

    @Override
    public List<OrderItem> getByoid(Integer oid) {
        return orderItemMapper.getByoid(oid);
    }

    @Override
    public void fill(List<Order> or) {
        for (Order order : or) {
            fill(order);
        }
    }
    public ProductImage setFirstProductImage(Product product) {
        ProductImage productImage = null;
        List<ProductImage> list = productImageService.list(product.getId(), ProductImageService.TYPE_SINGLE);
        if (!list.isEmpty()){
         productImage = list.get(0);
        }
        return  productImage;
    }

    @Override
    public void fill(Order o) {
        List<OrderItem> byoid = orderItemMapper.getByoid(o.getId());
        double total=0;
        int totalnumber=0;
        for (OrderItem orderItem : byoid) {
            total+=orderItem.getNumber()*orderItem.getProduct().getPromotePrice();
            totalnumber+=orderItem.getNumber();
            orderItem.getProduct().setProductImage(setFirstProductImage(orderItem.getProduct()));
        }
        o.setTotal(total);
        o.setTotalNumber(totalnumber);
        o.setOrderItem(byoid);
    }

}

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
    //遍历每一条订单
    @Override
    public void fill(List<Order> or) {
        for (Order order : or) {
            fill(order);
        }
    }
    //只查询每个产品的封面图片，只要一张
    public ProductImage setFirstProductImage(Product product) {
        ProductImage productImage = null;
        List<ProductImage> list = productImageService.list(product.getId(), ProductImageService.TYPE_SINGLE);
        if (!list.isEmpty()){
         productImage = list.get(0);
        }
        return  productImage;
    }
    //为每个订单添加具体的购买明细(查找该订单下的所有产品信息，每个产品添加封面图片id，方便前台调用显示)
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

    @Override
    public Integer getSaleCount(Integer pid) {
        Integer saleCount = orderItemMapper.getSaleCount(pid);
        if(saleCount==null){
            return 0;
        }else {
            return  saleCount;
        }
        //return orderItemMapper.getSaleCount(pid);
    }

    @Override
    public List<OrderItem> getOderItemsByuid(Integer uid) {
        return orderItemMapper.getOderItemsByuid(uid);
    }

    @Override
    public OrderItem addOrderItem(OrderItem orderItem) {
       orderItemMapper.addOrderItem(orderItem);
       return orderItem;
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        orderItemMapper.updateOrderItem(orderItem);
    }

    @Override
    public OrderItem getOrderItem(Integer id) {
        return orderItemMapper.getOrderItem(id);
    }

    @Override
    public void deleteOrderItem(Integer id) {
        orderItemMapper.deleteOrderItem(id);
    }

    @Override
    public void updateOrderItemoid(Integer oid, Integer id) {
        orderItemMapper.updateOrderItemoid(oid, id);
    }

}

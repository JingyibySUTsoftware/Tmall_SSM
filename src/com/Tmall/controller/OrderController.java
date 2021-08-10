package com.Tmall.controller;

import com.Tmall.bean.Order;
import com.Tmall.service.OrderItemService;
import com.Tmall.service.OrderService;
import com.Tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * @author jingyi
 * @Classname OrderController
 * @description TODO
 * @date 2021/8/3 15:45
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
    @RequestMapping("admin_order_list")
    public String getlist(Model model, Page page){
        int total = orderService.total();
        page.setTotal(total);
        List<Order> orderlist = orderService.list(page);
        orderItemService.fill(orderlist);
        model.addAttribute("orderList",orderlist);
        model.addAttribute("Page",page);
        return "admin/listOrder";
    }
    @RequestMapping("admin_order_delivery")
    public String updateStatus(Order o){
        o.setDeliveryDate(new Date());
        o.setStatus(OrderService.waitConfirm);
        orderService.updateOrderStatus(o);
        return "redirect:admin_order_list";
    }
}

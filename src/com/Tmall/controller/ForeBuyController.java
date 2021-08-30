package com.Tmall.controller;

import com.Tmall.bean.OrderItem;
import com.Tmall.bean.Product;
import com.Tmall.bean.ProductImage;
import com.Tmall.bean.User;
import com.Tmall.service.OrderItemService;
import com.Tmall.service.ProductImageService;
import com.Tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jingyi
 * @Classname ForeBuyController
 * @description TODO
 * @date 2021/8/29 21:08
 */
@Controller
public class ForeBuyController {
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductImageService productImageService;
    @RequestMapping("forebuyone")
    public  String buyone(Integer pid, Integer num, HttpServletRequest request){
        User nameAndID = (User) request.getSession().getAttribute("nameAndID");
        List<OrderItem> orderItemList = orderItemService.getOderItemsByuid(nameAndID.getId());
        Product product = productService.get(pid);
        boolean flag=false;
        Integer oiid=0;
        //若数据库中有该商品的订单项信息，则数量在原有上增加
        for (OrderItem orderItem : orderItemList) {
            if(orderItem.getPid().intValue()==product.getId().intValue()){
                orderItem.setNumber(orderItem.getNumber()+num);
                orderItem.setPid(pid);
                orderItem.setUid(nameAndID.getId());
                orderItemService.updateOrderItem(orderItem);
                System.out.println(oiid);
                oiid=orderItem.getId();
                flag=true;
                break;
            }
        }
        //若没有，则新建一个新的订单项
        if(!flag){
            OrderItem orderItem = new OrderItem();
            orderItem.setNumber(num);
            orderItem.setUid(nameAndID.getId());
            orderItem.setPid(pid);
            OrderItem orderItem1 = orderItemService.addOrderItem(orderItem);
            oiid=orderItem1.getId();
        }
        return "redirect:forebuy?oiid="+oiid;
    }
    @RequestMapping("forebuy")
    public  String buy(Model model, String [] oiid, HttpSession session){
        float total=0;
        List<OrderItem> itemList = new ArrayList<>();
        for (String s : oiid) {
            int id = Integer.parseInt(s);
            OrderItem orderItem = orderItemService.getOrderItem(id);
            total+=orderItem.getNumber()*orderItem.getProduct().getPromotePrice();
            Product product = orderItem.getProduct();
            setFirstProductImage(product);
            orderItem.setProduct(product);
            itemList.add(orderItem);
        }
        session.setAttribute("orderItems",itemList);
        model.addAttribute("total",total);
        return "fore/buy";
    }
    //购物车页面功能
    //增加商品到购物车
    @RequestMapping("foreaddCart")
    @ResponseBody
    public String addCart(Integer pid,Integer num,HttpServletRequest request){
        try{
            User nameAndID = (User) request.getSession().getAttribute("nameAndID");
            List<OrderItem> orderItemList = orderItemService.getOderItemsByuid(nameAndID.getId());
            Product product = productService.get(pid);
            boolean flag=false;
            //若数据库中有该商品的订单项信息，则数量在原有上增加
            for (OrderItem orderItem : orderItemList) {
                if(orderItem.getPid().intValue()==product.getId().intValue()){
                    orderItem.setNumber(orderItem.getNumber()+num);
                    orderItem.setPid(pid);
                    orderItem.setUid(nameAndID.getId());
                    orderItemService.updateOrderItem(orderItem);
                    flag=true;
                    break;
                }
            }
            //若没有，则新建一个新的订单项
            if(!flag){
                OrderItem orderItem = new OrderItem();
                orderItem.setNumber(num);
                orderItem.setUid(nameAndID.getId());
                orderItem.setPid(pid);
                orderItemService.addOrderItem(orderItem);
            }
            return  "success";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "fail";
    }

    //查看购物车页面
    @RequestMapping("forecart")
    public String cart(Model model,HttpServletRequest request){
        User nameAndID = (User) request.getSession().getAttribute("nameAndID");
        List<OrderItem> orderItemList = orderItemService.getOderItemsByuid(nameAndID.getId());
        for (OrderItem orderItem : orderItemList) {
            Product product = orderItem.getProduct();
            setFirstProductImage(product);
            orderItem.setProduct(product);
        }
        model.addAttribute("orderItems",orderItemList);
        return "fore/cart";
    }
    //更改购物车中某个商品的数量
    @RequestMapping("forechangeOrderItem")
    @ResponseBody
    public String changeorderItemNum(Integer pid,Integer num,HttpSession session){
        User nameAndID = (User)session.getAttribute("nameAndID");
        if (nameAndID==null){
            return "fail";
        }else {
            List<OrderItem> oderItems = orderItemService.getOderItemsByuid(nameAndID.getId());
            for (OrderItem oderItem : oderItems) {
                if(oderItem.getPid().intValue()==pid){
                    oderItem.setNumber(num);
                    oderItem.setPid(pid);
                    oderItem.setUid(nameAndID.getId());
                    orderItemService.updateOrderItem(oderItem);
                    break;
                }
            }
            return "success";
        }
    }
    //删除购物车某个商品订单
    @RequestMapping("foredeleteOrderItem")
    @ResponseBody
    public String deleteOrderItem(Integer oiid,HttpSession session){
        User nameAndID = (User)session.getAttribute("nameAndID");
        if (nameAndID==null){
            return "fail";
        }else {
            orderItemService.deleteOrderItem(oiid);
            return "success";
        }
    }
    public void setFirstProductImage(Product product) {
        List<ProductImage> list = productImageService.list(product.getId(), ProductImageService.TYPE_SINGLE);
        if (!list.isEmpty()){
            ProductImage productImage = list.get(0);
            product.setProductImage(productImage);
        }
    }
}

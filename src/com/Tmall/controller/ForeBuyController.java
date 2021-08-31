package com.Tmall.controller;

import com.Tmall.bean.*;
import com.Tmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private OrderService orderService;
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
            orderItem.setId(id);
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
    //生成订单
    @RequestMapping("forecreateOrder")
    public String createOrder(Order order,Model model,HttpSession session){
        User nameAndID = (User)session.getAttribute("nameAndID");
        String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + (int)(Math.random()*8999+1000);
        order.setOrderCode(orderCode);
        order.setCreateDate(new Date());
        order.setUid(nameAndID.getId());
        order.setStatus(orderService.waitPay);
        Order order1 = orderService.addOrder(order);
        List<OrderItem> orderItems = (List<OrderItem>) session.getAttribute("orderItems");
        float total=0;
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem.getId());
            orderItemService.updateOrderItemoid(order1.getId(),orderItem.getId());
            total+=orderItem.getProduct().getPromotePrice()*orderItem.getNumber();
        }
        return "redirect:forealipay?oid="+order1.getId()+"&total="+total;

    }

    //跳转到支付页
    @RequestMapping("forealipay")
    public String toAlipay(Integer oid, Float total, Model model){
        model.addAttribute("oid",oid);
        model.addAttribute("total",total);
        return "fore/alipay";
    }

    //完成支付之后
    @RequestMapping("forepayed")
    public String payed(Integer oid,Float total,Model model){
        Order order = orderService.getOrder(oid);
        order.setStatus(orderService.waitDelivery);
        order.setPayDate(new Date());
        orderService.updateOrderStatusAndpayDate(order);
        model.addAttribute("order",order);
        return "fore/payed";
    }
    //查看用户的订单信息
    @RequestMapping("forebought")
    public String tobought(HttpSession session,Model model){
        User nameAndID = (User)session.getAttribute("nameAndID");
        List<Order> ableOrders = orderService.getAbleOrders(nameAndID.getId());
        orderItemService.fill(ableOrders);
        model.addAttribute("orders",ableOrders);
        return  "fore/bought";
    }
    //确认收货
    @RequestMapping("foreconfirmPay")
    public String toConfirmPay(Integer oid,Model model){
        Order order = orderService.getOrder(oid);
        orderItemService.fill(order);
        model.addAttribute("order",order);
        return "fore/confirmPay";
    }
    //订单最终确认支付
    @RequestMapping("foreorderConfirmed")
    public  String toOrderConfirm(Integer oid){
        Order order = orderService.getOrder(oid);
        order.setStatus(orderService.waitReview);
        order.setConfirmDate(new Date());
        orderService.updateOrderStatusAndConfirmDate(order);
        return "fore/orderConfirmed";
    }
    @RequestMapping("foredeleteOrder")
    @ResponseBody
    public String deleteOrder(Integer oid){
        Order order = orderService.getOrder(oid);
        order.setStatus(orderService.delete);
        boolean flag = orderService.updatestatusdel(order);
        if (flag){
            return "success";
        }else {
            return "fail";
        }

    }
    @Autowired
    private ReviewService reviewService;
    //订单评价
    //查看产品所有的评价信息
    @RequestMapping("forereview")
    public String review(Integer oid,Model model){
        Order order = orderService.getOrder(oid);
        orderItemService.fill(order);
        Product product = order.getOrderItem().get(0).getProduct();
        List<Review> reviews = reviewService.getReviews(product.getId());
        productService.setSaleAndReviewNumber(product);
        model.addAttribute("product",product);
        model.addAttribute("reviews",reviews);
        model.addAttribute("order",order);
        return "fore/review";
    }
    //对产品进行评价
    @RequestMapping("foredoreview")
    public String doreview(Integer oid,Integer pid,String content,HttpSession session){
        Order order = orderService.getOrder(oid);
        order.setStatus(orderService.finish);
        orderService.updatestatusdel(order);


        String Content = HtmlUtils.htmlEscape(content);
        User nameAndID = (User)session.getAttribute("nameAndID");
        Review review = new Review();
        review.setContent(Content);
        review.setUid(nameAndID.getId());
        review.setPid(pid);
        review.setCreatedate(new Date());
        reviewService.addReview(review);
        return "redirect:forereview?oid="+oid+"&showonly=true";
    }
    //设置产品封面缩略图
    public void setFirstProductImage(Product product) {
        List<ProductImage> list = productImageService.list(product.getId(), ProductImageService.TYPE_SINGLE);
        if (!list.isEmpty()){
            ProductImage productImage = list.get(0);
            product.setProductImage(productImage);
        }
    }
}

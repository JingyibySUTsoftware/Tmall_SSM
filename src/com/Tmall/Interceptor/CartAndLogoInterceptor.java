package com.Tmall.Interceptor;

import com.Tmall.bean.OrderItem;
import com.Tmall.bean.User;
import com.Tmall.service.OrderItemService;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author jingyi
 * @Classname CartAndLogoInterceptor
 * @description TODO
 * @date 2021/8/30 17:40
 */
@Component
public class CartAndLogoInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private OrderItemService orderItemService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
        /**
         * 获取当前的contextPath:Tmall_SSM,用与放在左上角那个变形金刚，点击之后才能够跳转到首页，否则点击之后也仅仅停留在当前页面
         */
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        session.setAttribute("contextPath",contextPath);

        /**
         * 获取购物车中一共有多少数量
         */
        @NotNull
        User nameAndID = (User) session.getAttribute("nameAndID");
        if(nameAndID!=null){
            List<OrderItem> orderItems = orderItemService.getOderItemsByuid(nameAndID.getId());
            int  cartTotalItemNumber = 0;
            for (OrderItem orderItem : orderItems){
                cartTotalItemNumber+=orderItem.getNumber();
            }
            session.setAttribute("cartTotalItemNumber",cartTotalItemNumber);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}

package com.Tmall.Interceptor;

import com.Tmall.bean.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author jingyi
 * @Classname LoginInterceptor
 * @description 登录拦截器
 * @date 2021/8/30 16:54
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String contextPath=request.getServletContext().getContextPath();
        String[] notNeedAuthPage = new String[]{
                "home",
                "checkLogin",
                "register",
                "loginAjax",
                "login",
                "product",
                "category",
                "search"
        };
        String uri = request.getRequestURI();
        System.out.println(uri);
        uri = StringUtils.remove(uri,contextPath);
        if (uri.startsWith("/fore")){
            String method = StringUtils.substringAfterLast(uri,"/fore");
            if (!Arrays.asList(notNeedAuthPage).contains(method)){
                User user = (User) session.getAttribute("nameAndID");
                if (user == null){
                    response.sendRedirect("tologin");
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}

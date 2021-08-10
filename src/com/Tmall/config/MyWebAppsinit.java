package com.Tmall.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

/**
 * @author jingyi
 * @Classname web.xml对应的配置类
 * @description TODO
 * @date 2021/8/3 9:43
 */
public class MyWebAppsinit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //Spring的配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    //SpringMVC的配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringMVCConfig.class};
    }
    //分发servlet
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    //中文过滤器
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //触发父类的onStartup
        super.onStartup(servletContext);
        //1.创建字符集过滤器对象
        CharacterEncodingFilter cef = new CharacterEncodingFilter();
        //2.设置使用的字符集
        cef.setEncoding("UTF-8");
        //3.添加到容器（它不是ioc容器，而是ServletContainer）
        FilterRegistration.Dynamic registration = servletContext.addFilter("characterEncodingFilter", cef);
        //4.添加映射
        registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/*");
    }

}

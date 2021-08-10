package com.Tmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author jingyi
 * @Classname SpringMVC配置类
 * @description TODO
 * @date 2021/8/3 9:45
 */
@ComponentScan(value="com.Tmall",
        includeFilters=@ComponentScan.Filter(type= FilterType.ANNOTATION,classes= Controller.class))//只扫描Controll注解
@EnableWebMvc//SpringMVC配置注解
public class SpringMVCConfig implements WebMvcConfigurer {
    //视图定位
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
    //开启默认资源加载
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    //开启上传文件解析
    @Bean(name="multipartResolver")
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        //resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setResolveLazily(true);
        resolver.setMaxInMemorySize(40960);
        //上传文件大小 50M 50*1024*1024
        resolver.setMaxUploadSize(50*1024*1024);
        return resolver;
    }

    //设置StringHttpMessageConverter 使ajax回传的数据不乱码
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter shm = new StringHttpMessageConverter(Charset.forName("utf-8"));
        converters.add(shm);
    }

}

package com.Tmall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author jingyi
 * @Classname SpringConfig
 * @description Spring配置类
 * @date 2021/8/3 9:44
 */
@ComponentScan(value="com.Tmall",
        excludeFilters=@ComponentScan.Filter(type= FilterType.ANNOTATION,classes= Controller.class))//扫描所有除Controller以外所有配置注解
@MapperScan(value="com.Tmall.mapper")//扫描所有mapper
@PropertySource(value="classpath:jdbc.properties")//加载数据库配置文件
@Import({JDBCConfig.class,MybatisConfig.class})//引入另外两个配置类
@EnableAspectJAutoProxy//开启AOP
@EnableTransactionManagement//开启自动事务管理
public class SpringConfig {

}

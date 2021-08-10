package com.Tmall.config;


import com.Tmall.util.Page;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author jingyi
 * @Classname MybatisConfig
 * @description  Mybatis配置类
 * @date 2021/8/3 9:35
 */
public class MybatisConfig {
    // Spring整合Mybatis后，Spring控制链接对象
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(@Autowired DataSource datasource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(datasource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.Tmall.bean");
        return sqlSessionFactoryBean;
    }
    //分页插件
    @Bean
    public Page getPageInterceptor() {
        Page page = new Page();
        return page;

    }
}

package com.Tmall.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author jingyi
 * @Classname JDBCConfig
 * @description 数据库连接配置类
 * @date 2021/8/3 9:34
 */
public class JDBCConfig {
    //数据库连接基本属性值
    @Value("${driverClassName}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${uname}")
    private String username;
    @Value("${password}")
    private String password;

    //配置druid数据源
    @Bean
    public DruidDataSource getDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        //配置初始化大小、最小、最大
        dataSource.setInitialSize(1);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(20);
        //配置获取连接等待超时的时间
        dataSource.setMaxWait(60000);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        //配置一个连接在池中最小生存的时间
        dataSource.setMinEvictableIdleTimeMillis(30000);
        //打开PSCache，并且指定每个连接上PSCache的大小
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        return dataSource;
    }
}

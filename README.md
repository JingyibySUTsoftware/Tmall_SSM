# Tmall_SSM
基于【SSM】的模仿天猫的【简易版天猫】网站，已完成天猫的基本功能，有前台和后台管理，可用于个人学习

## 模仿天猫整站Tmall_SSM实践项目
### 技术栈
>
>Java: Java SE基础
前端： HTML,CSS, JavaScript, JQuery,AJAX, Bootstrap
J2EE：Tomcat, Servlet, JSP, Filter
框架：Spring，Spring MVC，Mybatis，SSM整合
数据库：MySQL
开发工具: IDEA,Git

### 表结构
表名     | 中文含义 |介绍
-------- | -----| -----
Category  | 分类表|存放分类信息，如女装，平板电视，沙发等
Property  |属性表|存放属性信息，如颜色，重量，品牌，厂商，型号等
Product |产品表|存放产品信息，如LED40EC平板电视机，海尔EC6005热水器
PropertyValue|属性值表|存放属性值信息，如重量是900g,颜色是粉红色
ProductImage|产品图片表|存放产品图片信息，如产品页显示的5个图片
Review|评论表|存放评论信息，如买回来的蜡烛很好用
User|用户表	|存放用户信息，如西门吹雪
Order|订单表|存放订单信息，包括邮寄地址，电话号码等信息
OrderItem|订单项表|存放订单项信息，包括购买产品种类，数量等

### 表关系
![在这里插入图片描述](https://img-blog.csdnimg.cn/129d19d20d114dd5959cf8fee95b8b5f.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5Yid57qn54K85Li55biIWWlreS0tMTIyOQ==,size_20,color_FFFFFF,t_70,g_se,x_16)
### 功能概览
![在这里插入图片描述](https://img-blog.csdnimg.cn/57e9f2841e3648d9aa18779b3255ad7a.jpg?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5Yid57qn54K85Li55biIWWlreS0tMTIyOQ==,size_17,color_FFFFFF,t_70,g_se,x_16)

### 项目页面结构预览
![在这里插入图片描述](https://img-blog.csdnimg.cn/2bc4cd5517a24aa3b1a42dcb33916ec8.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5Yid57qn54K85Li55biIWWlreS0tMTIyOQ==,size_6,color_FFFFFF,t_70,g_se,x_16)
+ include 存放页面的公共部分
+ fore      存放前台页面
+ admin  存放后台页面

### 项目代码结构预览
![在这里插入图片描述](https://img-blog.csdnimg.cn/8ed6ec5b698743e99959d44e54e0809f.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5Yid57qn54K85Li55biIWWlreS0tMTIyOQ==,size_6,color_FFFFFF,t_70,g_se,x_16)
+ bean 实体类
+ comparator 比较器（用于搜索后对结果筛选）
+ config 这个 项目没有采用SSM的xml配置，而是采用类似于springboot的配置类，这里就是各种的配置类
+ controller 控制层，负责对前台的请求，进行路径配置，跳转到相应的页面
+ Interceptor 拦截器，项目中有的业务需要登录才能使用，因此需要拦截器对请求进行拦截，如果没登录，就让他去登陆
+ mapper 数据库映射层，数据库表与实体类之间的映射
+ service 业务接口层，业务所有的接口与实现
+ util 工具类，分页工具类（这个也可以使用pageHelper插件），图片上传工具类


### 效果图（篇幅有限，仅展示部分）
首页
![在这里插入图片描述](https://img-blog.csdnimg.cn/d3655887c1c24d5da2c8d3a5c2d57d61.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5Yid57qn54K85Li55biIWWlreS0tMTIyOQ==,size_20,color_FFFFFF,t_70,g_se,x_16)
后台
![在这里插入图片描述](https://img-blog.csdnimg.cn/9496c2721fdb447a856a408afce9d498.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5Yid57qn54K85Li55biIWWlreS0tMTIyOQ==,size_20,color_FFFFFF,t_70,g_se,x_16)
### 总结
通过这个项目让我系统地感受到框架开发的便捷，同时也让我所学的知识点可以融会贯通，同时也发现了我很多的不足之处，同样地，这个项目也有很多可以值得改进的地方，比如可以使用mybatis进行逆向工程生成mapper映射，可以对接真实的支付宝接口等。

### 致谢
>参考了项目[tmallSSM](https://github.com/czwbig/Tmall_SSM)
>感谢[how2j.cn/tmall](https://how2j.cn/tmall/)


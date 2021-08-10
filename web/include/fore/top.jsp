<%--
  Created by IntelliJ IDEA.
  User: czwbig
  Date: 2018/11/5
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<nav class="top">
    <div style="max-width:1024px;margin:0px auto;">
        <a href="forehome">
            <span style="color: #C40000;margin: 0px;" class="glyphicon glyphicon-home redColor"></span>
            天猫首页
        </a>

        <span>喵，欢迎来到天猫</span>
        <c:if test="${!empty user}">
            <a href="${pageContext.request.contextPath}/login.jsp">${user.name}</a>
            <a href="forelogout">退出</a>
        </c:if>
        <c:if test="${empty user}">
            <a href="${pageContext.request.contextPath}/login.jsp">请登录</a>
            <a href="${pageContext.request.contextPath}/register.jsp">免费注册</a>
        </c:if>



        <span class="pull-right">
            <a href="forebought">我的订单</a>
            <a href="forecart">
                <span style="color: #c40000;margin: 0px;" class="glyphicon glyphicon-shopping-cart redColor"></span>
                购物车<strong>${cartTotalItemNumber}</strong> 件
            </a>
        </span>
    </div>
</nav>
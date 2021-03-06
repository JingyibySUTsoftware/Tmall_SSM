<%--
  Created by IntelliJ IDEA.
  User: czwbig
  Date: 2018/11/6
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>


<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--如果没有限定测试参数，则默认显示100条--%>
<c:if test="${empty param.categorycount}">
    <c:set var="categorycount" scope="page" value="100"/>
</c:if>

<c:if test="${!empty param.categorycount}">
    <c:set var="categorycount" scope="page" value="${param.categorycount}"/>
</c:if>

<div class="categoryProducts">
    <c:forEach items="${category.products}" var="p" varStatus="stc">
        <c:if test="${stc.count<=categorycount}">
            <div class="productUnit" price="${p.promotePrice}">
                <div class="productUnitFrame">
                    <a href="foreproduct?id=${p.id}">
                        <img class="productImage" src="${pageContext.request.contextPath}/img/productSingle/middle/${p.productImage.id}.jpg">
                    </a>
                    <span class="productPrice">¥<fmt:formatNumber type="number" value="${p.promotePrice}"
                                                                  minFractionDigits="2"/></span>
                    <a class="productLink" href="foreproduct?id=${p.id}">
                            ${fn:substring(p.name, 0, 50)}
                    </a>

                    <a class="tmallLink" href="foreproduct?id=${p.id}">天猫专卖</a>

                    <div class="show1 productInfo">
                        <span class="monthDeal ">月成交 <span class="productDealNumber">${p.saleCount}笔</span></span>
                        <span class="productReview">评价<span class="productReviewNumber">${p.reviewCount}</span></span>
                        <span class="wangwang">
                    <a class="wangwanglink" href="#nowhere">
                        <img src="${pageContext.request.contextPath}/img/site/wangwang.png">
                    </a>

                    </span>
                    </div>
                </div>
            </div>
        </c:if>
    </c:forEach>
    <div style="clear:both"></div>
</div>
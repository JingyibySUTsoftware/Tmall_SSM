<%--
  Created by IntelliJ IDEA.
  User: czwbig
  Date: 2018/11/6
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>

<div class="productReviewDiv">
    <div class="productReviewTopPart">
        <a href="#nowhere" class="productReviewTopPartSelectedLink">商品详情</a>
        <a href="#nowhere" class="selected">累计评价 <span class="productReviewTopReviewLinkNumber">${ReviewCount}</span>
        </a>
    </div>

    <div class="productReviewContentPart">
        <c:forEach items="${reviews}" var="r">
            <div class="productReviewItem">

                <div class="productReviewItemDesc">
                    <div class="productReviewItemContent">
                            ${r.content }
                    </div>
                    <div class="productReviewItemDate"><fmt:formatDate value="${r.createdate}"
                                                                       pattern="yyyy-MM-dd"/></div>
                </div>
                <div class="productReviewItemUserInfo">

                        ${r.user.name}<span class="userInfoGrayPart">（匿名）</span>
                </div>

                <div style="clear:both"></div>

            </div>
        </c:forEach>
    </div>

</div>
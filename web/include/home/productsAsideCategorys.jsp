<%--
  Created by IntelliJ IDEA.
  User: czwbig
  Date: 2018/11/5
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<head>
    <style type="text/css">
        div.productsAsideCategorys div.row {
            margin: 20px 80px 0px 80px;
        }

        div.productsAsideCategorys div.row div.seperator {
            margin-top: 20px;
            border-bottom-style: dashed;
            border-bottom-width: 1px;
            border-bottom-color: #e7e7e7;
        }
    </style>
</head>

<script>
    $(function () {
        $("div.productsAsideCategorys div.row a").each(function () {
            var v = Math.round(Math.random() * 6);
            if (v == 1){
                $(this).css("color", "#87CEFA");
            }
        });
    });
</script>
<c:forEach items="${categories}" var="c" varStatus="st">
    <div cid="${c.id}" class="productsAsideCategorys">
        <c:forEach items="${c.productsRow}" var="ps">
            <div class="row show1">
                <c:forEach items="${ps}" var="p">
                    <c:if test="${!empty p.subTitle}">
                        <a href="foreproduct?product.id=${p.id}">
                            <c:forEach items="${fn:split(p.subTitle, '')}" var="title" varStatus="st">
                                <c:if test="${st.index == 0}">
                                    ${title}
                                </c:if>
                            </c:forEach>
                        </a>
                    </c:if>
                </c:forEach>
                <div class="seperator"></div>
            </div>
        </c:forEach>
    </div>
</c:forEach>
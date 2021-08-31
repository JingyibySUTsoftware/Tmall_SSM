<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<div class="aliPayPageDiv">
    <div class="aliPayPageLogo">
        <img class="pull-left" src="${pageContext.request.contextPath}/img/site/simpleLogo.png">
        <div style="clear:both"></div>
    </div>

    <div>
        <span class="confirmMoneyText">扫一扫付款（元）</span>
        <span class="confirmMoney">
        ￥<fmt:formatNumber type="number" value="${total}" minFractionDigits="2"/></span>

    </div>
    <div>
        <img class="aliPayImg" src="${pageContext.request.contextPath}/img/site/alipay2wei.png" style="max-width: 20%;">
    </div>
    <div class="text-primary">仅作为演示,请不要扫描，点击下方 确认支付 即可付款成功</div>
    <div>
        <a href="forepayed?oid=${oid}&total=${total}"><button class="confirmPay">确认支付</button></a>
    </div>

</div>
<%@ page contentType="text/html; charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../../include/admin/adminHeader.jsp" %>
<%@include file="../../../include/admin/adminNavigator.jsp" %>

<title>编辑用户</title>

<script>
    $(function () {

        $("#editForm").submit(function () {
            if (!checkEmpty("name", "用户名"))
                return false;

            return true;
        });
    });

</script>

<div class="workingArea">

    <ol class="breadcrumb">
        <li><a href="admin_category_list">用户管理</a></li>
        <li class="active">修改密码</li>
    </ol>

    <div class="panel panel-warning editDiv">
        <div class="panel-heading">修改密码</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="admin_user_update">
                <table class="editTable">
                    <tr>
                        <td>用户名</td>
                        <td><input id="name" name="name" value="${u.name}" type="text" class="form-control" readonly="true"></td>
                    </tr>
                    <tr>
                        <td>新密码</td>
                        <td>
                            <input id="password" name="password" type="text" class="form-control"></td>
                        </td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="id" value="${u.id}">
                            <button type="submit" class="btn btn-success">确认修改</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
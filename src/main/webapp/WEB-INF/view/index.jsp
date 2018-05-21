<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

    <meta charset="utf-8">

    <link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SLXY 房产管理 HOME</title>
</head>
<body>
<div id="wrapper">
    <!--引入公共页面-->
    <!--引入公共页面-->
    <c:if test="${sessionScope.admins.type eq '教师'}">
        <%@include file="teacherCommon.jsp"%>
    </c:if>
    <c:if test="${sessionScope.admins.type eq '系统管理员'}">
        <%@include file="common.jsp"%>
    </c:if>
    <c:if test="${sessionScope.admins.type eq '普通管理员'}">
        <%@include file="common.jsp"%>
    </c:if>
    <%----%>
    <%--<jsp:include page="common.jsp"/>--%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">主页 <label style="float: right">欢迎您${sessionScope.admins.user}</label></h2>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <img src="/resources/img/03-6-a18.jpg" style="height: 100%;width: 100%">
        </div>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
</body>
</html>

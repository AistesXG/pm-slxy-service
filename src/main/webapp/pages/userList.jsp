<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
</head>
<body>
<jsp:include page="common.jsp"/>
<section id="container" class="">
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header"><i class="icon_document_alt"></i>用户管理</h3>
                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="/pages/index.jsp">系统首页</a></li>
                        <li><i class="icon_document_alt"></i>用户管理</li>
                        <li><i class="icon_document_alt"></i>用户列表</li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12 col-md-12 ">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2><i class="fa fa-flag-o red"></i><strong>Registered Users</strong></h2>
                        </div>
                        <div class="panel-body">
                            <table class="table bootstrap-datatable countries">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>用户名</th>
                                    <th>性别</th>
                                    <th>电话号码</th>
                                    <th>家庭住址</th>
                                    <th>身份证号</th>
                                    <th>备注</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${userList}" var="user" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td>${user.userName}</td>
                                        <td>${user.userSex}</td>
                                        <td>${user.userTelphone}</td>
                                        <td>${user.userAddress}</td>
                                        <td>${user.userIdcard}</td>
                                        <td>${user.userRemarks}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </div>

                </div>
            </div>
        </section>
    </section>
</section>
</body>
</html>
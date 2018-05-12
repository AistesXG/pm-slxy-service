<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>房屋价格信息</title>
</head>
<!-- DataTables CSS -->
<link href="/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">


<style>
    table {
        text-align: center;
    }

    table thead th {
        text-align: center;
    }

</style>
<body>
<div id="wrapper">
    <!--引入公共页面-->
    <jsp:include page="../common.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">房屋价格信息</h2>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        房屋的价格
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover"
                               id="dataTables-example">
                            <thead>
                            <tr>
                                </th>
                                <th>保障期单间每平方米价格</th>
                                <th>保障期单元房每平方米价格</th>
                                <th>延长期单间每平方米价格</th>
                                <th>延长期单元房每平方米价格</th>
                                <th>超限期单间每平方米价格</th>
                                <th>超限期单元房每平方米价格</th>
                                <c:if test="${sessionScope.admins.type eq '系统管理员'}">
                                    <th>操作</th>
                                </c:if>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${list}" var="price" varStatus="status">
                                <tr class="gradeU">
                                    <td>${price.bzqdj}</td>
                                    <td>${price.bzqdyf}</td>
                                    <td>${price.ycqdj}</td>
                                    <td>${price.ycqdyf}</td>
                                    <td>${price.cxqdj}</td>
                                    <td>${price.cxqdyf}</td>
                                    <c:if test="${sessionScope.admins.type eq '系统管理员'}">
                                        <td class="center">
                                            <button onclick="window.location.href = '/zjhsbz/selectPriceById?id=' + '${price.id}'"
                                                    class="btn btn-sm">编辑
                                            </button>
                                        </td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /#page-wrapper -->
            </div>
        </div>
    </div>
</div>
</body>
<!-- DataTables JavaScript -->
<script src="/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>
<script src="/resources/js/ajaxfileupload.js"></script>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户信息</title>
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

    #deleteBtn {
        float: right;
        margin-top: -5px;
        margin-left: 5px;
    }

    #addAdminBtn {
        float: right;
        margin-top: -5px;
        margin-left: 5px;
    }


</style>
<body>
<div id="wrapper">
    <!--引入公共页面-->
    <jsp:include page="../common.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">用户信息</h2>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        已注册的用户
                        <c:if test="${sessionScope.admins.type eq '系统管理员'}">
                            <button type="button" id="deleteBtn" onclick="delAll()"
                                    class="btn btn-primary">批量删除
                            </button>
                            <button type="button" id="addAdminBtn" onclick="window.location.href = '/jump/jumpAddAdmin'"
                                    class="btn btn-primary">添加用户
                            </button>
                        </c:if>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover"
                               id="dataTables-example">
                            <thead>
                            <tr>
                                <c:if test="${sessionScope.admins.type eq '系统管理员'}">
                                    <th><input type="checkbox" name="checkAll" id="checkAll" value="1"
                                               onclick="checkt()"/>
                                    </th>
                                </c:if>
                                <th>序号</th>
                                <th>用户名</th>
                                <th>邮箱</th>
                                <th>电话号码</th>
                                <th>角色</th>
                                <c:if test="${sessionScope.admins.type eq '系统管理员'}">
                                    <th>操作</th>
                                </c:if>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${adminList}" var="admin" varStatus="status">
                                <tr class="gradeU">
                                    <c:if test="${sessionScope.admins.type eq '系统管理员'}">
                                        <td><input type="checkbox" name="uid" id="uid" value="${admin.id}"
                                                   style="margin-right: 8px;"></td>
                                    </c:if>
                                    <td>${status.count}</td>
                                    <td>${admin.user}</td>
                                    <td>${admin.email}</td>
                                    <td class="center">${admin.phone}</td>
                                    <td class="center">${admin.type}</td>
                                    <c:if test="${sessionScope.admins.type eq '系统管理员'}">
                                        <td class="center">
                                            <button type="button" id="updateAdminBtn"
                                                    onclick="window.location.href='/admin/selectAdmin?id='+${admin.id}"
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
<script>
    $(document).ready(function () {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });

    <!--全选和全不选-->
    function checkt() {
        var checkAll = document.getElementById("checkAll");
        checkAll.value == 1 ? checkAll.value = 2 : checkAll.value = 1;
        var uid = document.getElementsByName("uid");

        for (var i = 0; i < uid.length; i++) {
            if (checkAll.value == 1) {
                uid[i].checked = false;//全不选
            } else {
                uid[i].checked = true;//全选
            }
        }
    }

    function selectId() {
        var ids = "";
        $("input[name='uid']:checkbox:checked").each(function () {
            if (ids.length == 0) {
                ids = $(this).val();
            } else {
                ids += "," + $(this).val();
            }
        });
        return ids;

    }

    <!--删除-->
    function delAll() {
        var ids = selectId();
        if (ids.length == 0) {
            alert("请选择一条数据，才能进行删除！");
            return "";
        }
        var ids = selectId()
        if (confirm("确定要删除所选的数据")) {
            $.ajax({
                type: "get",
                url: '/admin/deleteAdminByIds',
                data: {ids: ids},
                contentType: 'application/json',
                dataType: "json",
                success: function (data) {
                    if (data == "ok") {
                        window.location.href = "/admin/adminList";
                    } else {
                        alert(data);
                    }
                }
            })
        }
    }

</script>
</html>
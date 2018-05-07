<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>教师租房房屋详情</title>
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

        #addHouseBtn {
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
                <h2 class="page-header">教师租房房屋详情</h2>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        已拥有的教师租房房屋 <button type="button" id="deleteBtn" onclick="delAll()"
                                      class="btn btn-primary">批量删除</button>
                        <button type="button"  id="addHouseBtn" onclick=" window.location.href = '/jump/jumpAddHouse'"
                                class="btn btn-primary">添加房屋</button>

                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover"
                               id="dataTables-example">
                            <thead>
                            <tr>
                                <th><input type="checkbox" name="checkAll" id="checkAll" value="1" onclick="checkt()"/>
                                </th>
                                <th>序号</th>
                                <th>租住者姓名</th>
                                <th>租住者所在部门</th>
                                <th>房间楼号</th>
                                <th>房间编号</th>
                                <th>房间面积</th>
                                <th>租住状态</th>
                                <th>房间备注</th>
                                <th>操作</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${houseList}" var="house" varStatus="status">
                                <tr class="gradeU">
                                    <td><input type="checkbox" name="hid" id="hid" value="${house.id}"
                                               style="margin-right: 8px; "></td>
                                    <td>${status.count}</td>
                                    <td>${house.zzzxm}</td>
                                    <td>${house.zzzszbm}</td>
                                    <td>${house.fjbh}</td>
                                    <td class="center" >${house.fjlh}</td>
                                    <td class="center">${house.fjmj}</td>
                                    <td class="center" style="color: red; font-weight: bolder">${house.zzzt}</td>
                                    <td class="center">${house.fjbz}</td>
                                    <td align="right">
                                        <c:if test="${house.zzzt == '未租'}">
                                            <button type="button" class="btn btn-sm" onclick="window.location.href='/houseCzqk/selectHouseToCzqkById?id=' + '${house.id}'">申请</button>
                                        </c:if>
                                        <c:if test="${house.zzzt == '已租'}">
                                            <button type="button" class="btn btn-sm">续租</button>
                                            <button type="button" class="btn btn-sm">退房</button>
                                        </c:if>
                                        <button type="button"  onclick="window.location.href = '/house/selectHouseById?id=' + ${house.id}"
                                                class="btn btn-sm">编辑</button>
                                    </td>
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
        var hid = document.getElementsByName("hid");

        for (var i = 0; i < hid.length; i++) {
            if (checkAll.value == 1) {
                hid[i].checked = false;//全不选
            } else {
                hid[i].checked = true;//全选
            }
        }
    }

    <!--跳转到addHouseView页面-->
    function addHouseView() {
       ;
    }

    function selectId() {
        var ids = "";
        $("input[name='hid']:checkbox:checked").each(function () {
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
                url: '/house/deleteHouse',
                data: {ids: ids},
                contentType: 'application/json',
                dataType: "json",
                success: function (data) {
                    if (data == "ok") {
                        window.location.href = "/house/houseList";
                    } else {
                        alert(data);
                    }
                }
            })
        }
    }
</script>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>房屋详情</title>
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

        #addHousePubBtn {
            float: right;
            margin-top: -5px;
            margin-left: 5px;
        }

        #updateHousePubBth {
            float: right;
            margin-top: -5px;

        }

    </style>
<body>
<div id="wrapper">
    <!--引入公共页面-->
    <jsp:include page="../common.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">房屋信息</h2>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        已拥有的房屋 <input type="button" value="删除" id="deleteBtn" onclick="delAll()"
                                      class="btn btn-primary"/>
                        <input type="button" value="添加" id="addHousePubBtn" onclick="addHousePubView()"
                               class="btn btn-primary">
                        <input type="button" value="修改" id="updateHousePubBth" onclick="updateHousePubView()"
                               class="btn btn-primary"/>
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
                                <th>楼号</th>
                                <th>编号</th>
                                <th>面积</th>
                                <th>使用状态</th>
                                <th>使用类型</th>
                                <th>使用部门</th>
                                <th>备注</th>
                                <th>操作</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${housePubList}" var="house" varStatus="status">
                                <tr class="gradeU">
                                    <td><input type="checkbox" name="hid" id="hid" value="${house.id}"
                                               style="margin-right: 8px; "></td>
                                    <td>${status.count}</td>
                                    <td>${house.housefloornumber}</td>
                                    <td>${house.housenumber}</td>
                                    <td>${house.housearea}</td>
                                    <td class="center">${house.housestatus}</td>
                                    <td class="center">${house.housetype}</td>
                                    <td class="center">${house.housedepartment}</td>
                                    <td class="center">${house.houseremarks}</td>
                                    <td colspan="2">
                                        <c:if test="${house.housestatus eq '未租出'}">
                                            <button onclick="rentalHouse(${house.id})" class="btn btn-sm">租房</button>
                                        </c:if>
                                        <c:if test="${house.housestatus eq '已租出'}">
                                            <button onclick="checkOut()" class="btn btn-sm">退房</button>
                                        </c:if>

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

    <!--跳转到addAdmin页面-->
    function addHousePubView() {
        window.location.href = "/jump/jumpAddHousePub";
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
                url: '/housePub/deleteHousePub',
                data: {ids: ids},
                contentType: 'application/json',
                dataType: "json",
                success: function (data) {
                    if (data == "ok") {
                        window.location.href = "/housePub/housePubList";
                    } else {
                        alert(data);
                    }
                }
            })
        }
    }


    <!--跳转到updateAdmin页面-->
    function updateHousePubView() {
        var id = selectId();
        if (id.length == 0) {
            alert("请选择一条数据,才能修改！");
            return "";
        }
        window.location.href = "/housePub/selectHousePubById?id=" + id;
    }


    <!--租房-->
    function rentalHouse(id) {
        window.location.href = "/jump/jumpRentalHouse?id=" + id;
    }

    <!--退房-->
    function checkOut() {
        var id =  selectId();
        if (id.length == 0) {
            alert("请选择一条数据，才能进行退房！");
            return "";
        }
        console.log(id)
        if (confirm("确定要退房吗？")) {
            $.ajax({
                type: "post",
                url: '/houseRentingSituation/retreatHouse',
                data: {id: id},
                dataType: "json",
                success: function (data) {
                    if (data == "ok") {
                        window.location.href = "/housePub/housePubList";
                    } else {
                        alert(data);
                    }
                }
            })
        }
    }
</script>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>公用房屋详情</title>
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


    </style>
<body>
<div id="wrapper">
    <!--引入公共页面-->
    <jsp:include page="../common.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">公用房屋信息</h2>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        已拥有的公用房屋
                        <select name="fjsyzt" class="form-control-static" id="fjsyzt">
                            <option value="0"></option>
                            <option value="空闲">空闲</option>
                            <option value="在用">在用</option>
                        </select>
                        <button type="button" id="selectHousePubByStatus" onclick="selectHousePubByStatus()"
                                class="btn btn-primary">按租住状态搜索
                        </button>
                        <button type="button" id="deleteBtn" onclick="delAll()"
                                class="btn btn-primary">批量删除
                        </button>
                        <button type="button" id="addHousePubBtn"
                                onclick="window.location.href = '/jump/jumpAddHousePub'"
                                class="btn btn-primary">添加房屋
                        </button>

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
                            <c:forEach items="${housePubList}" var="housePub" varStatus="status">
                                <tr class="gradeU">
                                    <td><input type="checkbox" name="hid" id="hid" value="${housePub.id}"
                                               style="margin-right: 8px"></td>
                                    <td>${status.count}</td>
                                    <td>${housePub.fjlh}</td>
                                    <td>${housePub.fjbh}</td>
                                    <td>${housePub.fjmj}</td>
                                    <td class="center" style="color: red; font-weight: bolder">${housePub.fjsyzt}</td>
                                    <td class="center">${housePub.fjsylx}</td>
                                    <td class="center">${housePub.fjsybm}</td>
                                    <td class="center">${housePub.fjbz}</td>
                                    <td align="center">
                                        <button type="button"
                                                onclick=" window.location.href = '/housePub/selectHousePubById?id=' + '${housePub.id}'"
                                                class="btn btn-sm">编辑
                                        </button>
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

    <!--按照租房状态来查找教师租房的房屋信息-->
    function selectHousePubByStatus() {
        var fjsyzt = $('#fjsyzt').val();
        if (fjsyzt == "0") {
            window.location.href = "/housePub/housePubList";
        } else {
            window.location.href = "/housePub/selectHousePubByStatus?fjsyzt=" + fjsyzt;
        }
    }
</script>
</html>
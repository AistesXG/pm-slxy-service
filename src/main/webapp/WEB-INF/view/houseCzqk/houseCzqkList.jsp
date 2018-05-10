<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>住房情况详情</title>
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
                <h2 class="page-header">住房情况详情</h2>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        已租住的信息
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover"
                               id="dataTables-example">
                            <thead>
                            <tr>

                                <th>序号</th>
                                <th>房间楼号</th>
                                <th>房间编号</th>
                                <th>申请租住日期</th>
                                <th>租住到期日期</th>
                                <th>房间租住类型</th>
                                <th>房间面积</th>
                                <th>租住教师姓名</th>
                                <th>审批状态</th>
                                <th>教师参加工作时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${houseCzqkList}" var="houseCzqk" varStatus="status">
                                <tr class="gradeU">
                                    <td>${status.count}</td>
                                    <td>${houseCzqk.fjlh}</td>
                                    <td>${houseCzqk.fjbh}</td>
                                    <td>${houseCzqk.sqzzrq}</td>
                                    <td>${houseCzqk.zzdqrq}</td>
                                    <td>${houseCzqk.fjzzlx}</td>
                                    <td>${houseCzqk.fjmj}</td>
                                    <td>${houseCzqk.zzjsxm}</td>
                                    <td style="color: red;font-weight: bolder">${houseCzqk.spzt}</td>
                                    <td>${houseCzqk.jscjgzrq}</td>
                                    <td>
                                        <button type="button" id="displayHouseCzqk" class="btn btn-sm"
                                                onclick="window.location.href = '/houseCzqk/selectHouseCzqkById?id=' + '${houseCzqk.id}'">
                                            查看
                                        </button>
                                        <c:if test="${houseCzqk.spzt == '审核未通过'}">
                                        <button type="button"  id="applyPass"
                                                class="btn btn-sm" onclick="applyThrough(${houseCzqk.id})">审批
                                        </button>
                                        <button type="button" onclick="" id="applyNotPass"
                                                class="btn btn-sm" onclick="notApplyThrough()">不审批
                                        </button>
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

    <!--审批通过-->
    function applyThrough(houseCzqkId) {
        $.ajax({
            url: '/houseCzqk/applyThrough',
            data: {id: houseCzqkId},
            dataType: 'json',
            type: 'post',
            success: function (data) {
                if (data == "ok") {
                    window.location.href = "/houseCzqk/HouseCzqkList";
                } else {
                    alert(data);
                }
            }
        })
    }
</script>
</html>
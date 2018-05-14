<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>计算费用</title>

    <link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>费用详情</title>
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
</head>
<body>
<div id="wrapper">
    <!--引入公共页面-->
    <jsp:include page="../common.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">计算费用</h2>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        费用详细信息
                        <input type="text" name="startTime" class=" form-control-static laydate-icon" value="" size="10"
                               id="startTime" readonly>
                        <input type="text" name="endTime" class=" form-control-static laydate-icon" value="" size="10"
                               id="endTime" readonly>
                        <button type="button" class="btn btn-primary" onclick="Calculation()">计算费用</button>
                        <button type="button" id="exportPrice"
                                onclick="exportPirceToExcel()"
                                class="btn btn-primary">导出
                        </button>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover"
                               id="dataTables-example">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>楼号</th>
                                <th>编号</th>
                                <th>申请日期</th>
                                <th>到期日期</th>
                                <th>租住类型</th>
                                <th>面积</th>
                                <th>原始租金标准</th>
                                <th>双职工</th>
                                <th>计算系数</th>
                                <th>所在部门</th>
                                <th>教师姓名</th>
                                <th>月租费</th>
                                <th>月数</th>
                                <th>季度租金</th>
                                <th>工作日期</th>
                                <th>带小孩</th>
                                <th>特殊系数</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${calculations}" var="calculation" varStatus="status">
                                <tr class="gradeU">
                                    <td>${status.count}</td>
                                    <td>${calculation.fjlh}</td>
                                    <td>${calculation.fjbh}</td>
                                    <td>${calculation.sfqr}</td>
                                    <td>${calculation.dqrq}</td>
                                    <td>${calculation.zzlx}</td>
                                    <td>${calculation.fjmj}</td>
                                    <td>${calculation.zjbz}</td>
                                    <td>${calculation.sfszg}</td>
                                    <td>${calculation.jsxs}</td>
                                    <td>${calculation.szbm}</td>
                                    <td>${calculation.jsxm}</td>
                                    <td>${calculation.yzf}</td>
                                    <td>${calculation.month}</td>
                                    <td>${calculation.jdzj}</td>
                                    <td>${calculation.gzrq}</td>
                                    <td>${calculation.sfcxqdxh}</td>
                                    <td>${calculation.tszs}</td>
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

    !function () {
        laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
        laydate({elem: '#startTime'});//绑定开始时间
        laydate({elem: '#endTime'});//绑定结束时间
    }();

    function Calculation() {
        var startTime = $('#startTime').val();
        var endTime = $('#endTime').val();
        if (startTime == "" || endTime == "") {
            window.location.href = "/jump/jump404";
        } else {
            window.location.href = "/house/calculation?startTime=" + startTime + "&endTime=" + endTime;
        }
    }

    function exportPirceToExcel() {
        var startTime = $('#startTime').val();
        var endTime = $('#endTime').val();
        if (startTime == "" || endTime == "") {
            window.location.href = "/jump/jump404";
        } else {
            window.location.href = "/house/exportCalculationPriceToExcel?startTime=" + startTime + "&endTime=" + endTime;
        }
    }

</script>
</html>
</body>
</html>

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
                            <c:forEach items="${caculations}" var="caculation" varStatus="status">
                                <tr class="gradeU">
                                    <td>${status.count}</td>
                                    <td>${caculation.fjlh}</td>
                                    <td>${caculation.fjbh}</td>
                                    <td>${caculation.sfqr}</td>
                                    <td>${caculation.dqrq}</td>
                                    <td>${caculation.zzlx}</td>
                                    <td>${caculation.fjmj}</td>
                                    <td>${caculation.zjbz}</td>
                                    <td>${caculation.sfszg}</td>
                                    <td>${caculation.jsxs}</td>
                                    <td>${caculation.szbm}</td>
                                    <td>${caculation.jsxm}</td>
                                    <td>${caculation.yzf}</td>
                                    <td>${caculation.month}</td>
                                    <td>${caculation.jdzj}</td>
                                    <td>${caculation.gzrq}</td>
                                    <td>${caculation.sfcxqdxh}</td>
                                    <td>${caculation.tszs}</td>
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

</script>
</html>
</body>
</html>

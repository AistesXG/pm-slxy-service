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

        #updateRentingHouseBtn {
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
                <h2 class="page-header">租房信息</h2>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        已租房屋的信息
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
                                <th>租住年限</th>
                                <th>租住到期日期</th>
                                <th>房间租住类型</th>
                                <th>房间面积</th>
                                <th>特殊房间系数</th>
                                <th>是否双职工</th>
                                <th>是否带小孩</th>
                                <th>教师所在部门</th>
                                <th>教师编号</th>
                                <th>教师姓名</th>
                                <th>备注</th>
                                <th>操作</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${houseRentingHouseList}" var="houseRenting" varStatus="status">
                                <tr class="gradeU">
                                    <td>${status.count}</td>
                                    <td>${houseRenting.housefloornumber}</td>
                                    <td>${houseRenting.housenumber}</td>
                                    <td>${houseRenting.applycheckdate}</td>
                                    <td>${houseRenting.applytime}</td>
                                    <td>${houseRenting.applyexpiredate}</td>
                                    <td>${houseRenting.houserentaltype}</td>
                                    <td>${houseRenting.housearea}</td>
                                    <td>${houseRenting.specialrentalhouse}</td>
                                    <td>${houseRenting.whetherdoubleone}</td>
                                    <td>${houseRenting.whetherchild}</td>
                                    <td>${houseRenting.rentalteacherdepartment}</td>
                                    <td>${houseRenting.rentallteachernumber}</td>
                                    <td>${houseRenting.rentalteachername}</td>
                                    <td>${houseRenting.houseremarks}</td>
                                    <td><input type="button" value="修改" id="updateRentingHouseBtn"
                                                              onclick="updateRentingHouse()"
                                                              class="btn btn-sm"/></td>
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

    function updateRentingHouse() {

    }

</script>
</html>
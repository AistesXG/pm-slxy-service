<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>教师信息</title>
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

    #addTeacherBtn {
          float: right;
          margin-top: -5px;
          margin-left: 5px;
      }

    #updateTeacherBtn {
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
                <h2 class="page-header">教师信息</h2>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        已添加的教师 <input type="button" value="删除" id="deleteBtn" onclick="delAll()"
                                      class="btn btn-primary"/>
                        <input type="button" value="添加" id="addTeacherBtn" onclick="addTeacherView()"
                               class="btn btn-primary">
                        <input type="button" value="修改" id="updateTeacherBtn" onclick="updateTeacherView()"
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
                                <th>教师姓名</th>
                                <th>教工编号</th>
                                <th>性别</th>
                                <th>出生年月</th>
                                <th>学历</th>
                                <th>参加工作时间</th>
                                <th>所在部门</th>
                                <th>租房状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${teacherList}" var="teacher" varStatus="status">
                                <tr class="gradeU">
                                    <td><input type="checkbox" name="tid" id="tid" value="${teacher.id}" style="margin-right: 8px; "></td>
                                    <td>${status.count}</td>
                                    <td>${teacher.xm}</td>
                                    <td>${teacher.jggh}</td>
                                    <td>${teacher.xb}</td>
                                    <td>${teacher.csrq}</td>
                                    <td>${teacher.xl}</td>
                                    <td>${teacher.cjgzrq}</td>
                                    <td>${teacher.szbm}</td>
                                    <td style="color: red; font-weight: bolder">${teacher.zfzt}</td>
                                    <td class="center"><button onclick="display(${teacher.id})" class="btn btn-sm">查看</button></td>
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
        var tid = document.getElementsByName("tid");

        for (var i = 0; i < tid.length; i++) {
            if (checkAll.value == 1) {
                tid[i].checked = false;//全不选
            } else {
                tid[i].checked = true;//全选
            }
        }
    }


    function selectId() {
        var ids = "";
        $("input[name='tid']:checkbox:checked").each(function () {
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
                url: '/teacher/deleteTeacherByIds',
                data: {ids: ids},
                contentType: 'application/json',
                dataType: "json",
                success: function (data) {
                    if (data == "ok") {
                        window.location.href = "/teacher/teacherList";
                    } else {
                        alert(data);
                    }
                }
            })
        }
    }

    <!--跳转到addTeacherView页面-->
    function addTeacherView() {
        window.location.href = "/jump/jumpAddTeacher";
    }

    <!--跳转到updateAdmin页面-->
    function updateTeacherView() {
        var id = selectId();
        if(id.length == 0){
            alert("请选择一条数据,才能修改！");
            return "" ;
        }
        var str = id.split(",");
        if (str.length >1) {
            alert("一次只能选择一条数据修改!")
            return "";
        }
        window.location.href="/teacher/selectTeacher?id="+id;
    }

    <!--详情页-->
    function display(id) {
        window.location.href = "/jump/jumpOneTeacher?id="+id;
    }
</script>
</html>
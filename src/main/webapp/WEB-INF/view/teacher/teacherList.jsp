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

    #importTeacher {
        float: right;
        margin-top: -3px;
        margin-left: 5px;
    }

    #exportTeacher {
        float: right;
        margin-top: -3px;
        margin-left: 5px;
    }

    #deleteBtn {
        float: right;
        margin-top: -3px;
        margin-left: 5px;
    }

    #addTeacherBtn {
        float: right;
        margin-top: -3px;
        margin-left: 5px;
    }

    #searchTeacherByDept {
        margin-top: -3px;
    }
    #searchTeacherByStatus {
        margin-top: -3px;
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
                        已添加的教师
                        <select name="szbm" class="form-control-static " id="szbm">
                            <option value="0"></option>
                            <c:forEach items="${departments}" var="dept">
                                <option value="${dept}">${dept}</option>
                            </c:forEach>
                        </select>
                        <button type="button" id="searchTeacherByDept" onclick="selectTeacherByDept()"
                                class="btn btn-primary">按部门搜索
                        </button>
                        <select name="zfzt" class="form-control-static" id="zfzt">
                            <option value="0"></option>
                            <option value="未租">未租</option>
                            <option value="已租">已租</option>
                        </select>
                        <button type="button" id="searchTeacherByStatus" onclick="selectTeacherByStatus()"
                                class="btn btn-primary">按租住状态搜索
                        </button>
                        <c:if test="${sessionScope.admins.type eq '系统管理员'}">
                            <button type="button" id="importTeacher" onclick="displayEITeacher()"
                                    class="btn btn-primary">
                                批量导入
                            </button>
                            <button type="button" id="exportTeacher" onclick="exportTeacher()"
                                    class="btn btn-primary">批量导出
                            </button>
                            <button type="button" value="删除" id="deleteBtn" onclick="delAll()"
                                    class="btn btn-primary">批量删除
                            </button>
                            <button type="button" value="添加" id="addTeacherBtn"
                                    onclick="window.location.href = '/jump/jumpAddTeacher'"
                                    class="btn btn-primary">添加教师
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
                                    <c:if test="${sessionScope.admins.type eq '系统管理员'}">
                                        <td><input type="checkbox" name="tid" id="tid" value="${teacher.id}"
                                                   style="margin-right: 8px; "></td>
                                    </c:if>
                                    <td>${status.count}</td>
                                    <td>${teacher.xm}</td>
                                    <td>${teacher.jggh}</td>
                                    <td>${teacher.xb}</td>
                                    <td>${teacher.csrq}</td>
                                    <td>${teacher.xl}</td>
                                    <td>${teacher.cjgzrq}</td>
                                    <td>${teacher.szbm}</td>
                                    <td style="color: red; font-weight: bolder">${teacher.zfzt}</td>
                                    <td class="center" colspan="2">
                                        <button onclick="window.location.href = '/teacher/selectTeacherById?id=' + '${teacher.id}'"
                                                class="btn btn-sm">查看
                                        </button>
                                        <c:if test="${sessionScope.admins.type eq '系统管理员'}">
                                            <button onclick="window.location.href = '/teacher/selectTeacher?id=' + '${teacher.id}'"
                                                    class="btn btn-sm">编辑
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


<div class="modal" id="import" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content" style="width:auto;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    <li class="fa fa-remove"></li>
                </button>
                <h5 class="modal-title">Excel文件上传</h5>
            </div>
            <div class="modal-body">
                <form id="importFile" name="importFile" class="form-horizontal" method="post"
                      enctype="multipart/form-data" action="/teacher/importExcelTeacher">
                    <div class="box-body">
                        <div>
                            <label class="control-label">请选择要导入的Excel文件：</label>
                            <input id="excelFile" name="excelFile" class="file-loading" type="file" accept=".xls,.xlsx">
                            <input type="submit" value="提交">
                        </div>
                    </div>
                </form>
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

    function selectTeacherByDept() {
        var szbm = $('#szbm').val();
        if(szbm == "0"){
            window.location.href = "/teacher/teacherList";
        }else {
            window.location.href = "/teacher/selectTeacherByDept?szbm=" + szbm;
        }
    }
    function selectTeacherByStatus() {
        var zfzt = $('#zfzt').val();
        if(zfzt == "0"){
            window.location.href = "/teacher/teacherList";
        }else {
            window.location.href = "/teacher/selectTeacherByStatus?zfzt=" + zfzt;
        }
    }

    <!--显示导入弹窗-->
    function displayEITeacher() {
        var $import = $('#import');
        $import.modal({backdrop: 'static'});
    }

    <!--导出教师信息-->
    function exportTeacher() {
        var ids = selectId();
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/teacher/exportTeacherToExcel",
            data: {ids: ids},
            success: function (data) {
                console.log(data)
                alert("导出成功!")
            },
            error: function () {
                alert("导出失败!");
            }
        })
    }

</script>
</html>
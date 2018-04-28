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
        margin-top: -5px;
        margin-left: 5px;
    }

    #exportTeacher {
        float: right;
        margin-top: -5px;
        margin-left: 5px;
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
                                    <td><input type="checkbox" name="tid" id="tid" value="${teacher.id}"
                                               style="margin-right: 8px; "></td>
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
                                        <button onclick="display(${teacher.id})" class="btn btn-sm">查看</button>
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

<div class="modal" id="content" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                    <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title">教师详情</h4>
            </div>
            <div class="modal-body">
                <form onsubmit="false" role="form" class="form-horizontal">
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">教师姓名:</label>
                        <div class="col-sm-7">
                            <input type="text" name="xm" class="form-control" id="xm"
                                   value="" size="10" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">教工编号:</label>
                        <div class="col-sm-7">
                            <input type="text" name="jggh" class="form-control"
                                   value="" size="6" readonly="readonly" id="jggh"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">性别:</label>
                        <div class="col-sm-7">
                            <input type="text" name="xb" class="form-control"
                                   value="" size="2" readonly="readonly" id="xb">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">身份证号:</label>
                        <div class="col-sm-7">
                            <input type="text" name="sfzh" class="form-control"
                                   value="" size="18" readonly="readonly" id="sfzh"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">出生年月:</label>
                        <div class="col-sm-7">
                            <input type="text" name="csrq" class="form-control"
                                   value="" size="10" readonly="readonly" id="csrq"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">学历:</label>
                        <div class="col-sm-7">
                            <input type="text" name="xl" class="form-control"
                                   value="" size="18" readonly="readonly" id="xl"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">参加工作时间:</label>
                        <div class="col-sm-7">
                            <input type="text" name="cjgzrq" class="form-control"
                                   value="" size="10" readonly="readonly" id="cjgzrq"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">申请住房日期:</label>
                        <div class="col-sm-7">
                            <input type="text" name="sqzfrq" class="form-control"
                                   value="" size="10" readonly="readonly" id="sqzfrq"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">所在部门:</label>
                        <div class="col-sm-7">

                            <input type="text" name="szbm" class="form-control"
                                   value="" size="30" readonly="readonly" id="szbm">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">籍贯:</label>
                        <div class="col-sm-7">
                            <input type="text" name="jg" class="form-control"
                                   value="" size="30" readonly="readonly" id="jg"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">租房状态:<span class="must">*</span></label>
                        <div class="col-sm-7">
                            <input type="text" name="zfzt" class="form-control"
                                   value="" size="4" readonly="readonly" id="zfzt"></div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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


    <!--显示教师信息的弹窗-->
    <!--给input赋值-->
    function display(teacherId) {
        var $content = $('#content');
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/teacher/selectTeacherById",
            data: {"id": teacherId},
            success: function (data) {
                var object = $.parseJSON(data);
                $("input[id=xm]").val(object.xm);
                $("input[id=xb]").val(object.xb);
                $("input[id=jggh]").val(object.jggh);
                $("input[id=sfzh]").val(object.sfzh);
                $("input[id=csrq]").val(object.csrq);
                $("input[id=xl]").val(object.xl);
                $("input[id=cjgzrq]").val(object.cjgzrq);
                $("input[id=sqzfrq]").val(object.sqzfrq);
                $("input[id=szbm]").val(object.szbm);
                $("input[id=jg]").val(object.jg);
                $("input[id=xl]").val(object.xl);
                $("input[id=zfzt]").val(object.zfzt);
            }
        });
        $content.modal({backdrop: 'static'});
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
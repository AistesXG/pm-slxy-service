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
                                <th>租房标志</th>
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
                                    <td style="color: red;font-weight: bolder">${houseCzqk.zfxztfzt}</td>
                                    <td style="color: red;font-weight: bolder">${houseCzqk.spzt}</td>
                                    <td>${houseCzqk.jscjgzrq}</td>
                                    <td>
                                        <button type="button" id="displayHouseCzqk" class="btn btn-sm"
                                                onclick="window.location.href = '/houseCzqk/selectHouseCzqkById?id=' + '${houseCzqk.id}'">
                                            查看
                                        </button>
                                        <c:if test="${houseCzqk.spzt == '审核不通过'}">
                                            <c:if test="${houseCzqk.zfxztfzt == '退房'}">
                                                <button type="button"
                                                        class="btn btn-sm"
                                                        onclick="applyCheckOutHouse(${houseCzqk.id})">审批退房
                                                </button>
                                                <button type="button"
                                                        class="btn btn-sm" onclick="notApply(${houseCzqk.id})">不审批
                                                </button>
                                            </c:if>
                                            <c:if test="${houseCzqk.zfxztfzt == '租房' || houseCzqk.zfxztfzt == '续租'}">
                                                <button type="button"
                                                        class="btn btn-sm" onclick="applyThrough(${houseCzqk.id})">审批
                                                </button>
                                                <button type="button"
                                                        class="btn btn-sm" onclick="notApply(${houseCzqk.id})">不审批
                                                </button>
                                            </c:if>
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

<!-- 弹出窗内容 -->
<div class="modal" id="content" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                    <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title">房屋详情</h4>
            </div>
            <div class="modal-body">
                <form onsubmit="false" role="form" class="form-horizontal" id="addForm" action="/notApply/addNotApply">
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">申请类型:</label>
                        <div class="col-sm-7">
                            <input type="text" name="status" class="form-control" id="status" value="" size="10"
                                   readonly>
                            <span id="msg"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">不审批原因:</label>
                        <div class="col-sm-7">
                            <textarea cols="5" rows="5" name="reason" class="form-control" id="reason"></textarea>
                        </div>
                    </div>
                </form>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" onclick="addNotApply()">提交</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
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

    <!--租房和续租审批通过-->
    function applyThrough(houseCzqkId) {
        $.ajax({
            url: '/houseCzqk/applyThrough',
            data: {id: houseCzqkId},
            dataType: 'json',
            type: 'post',
            success: function (data) {
                if (data == "ok") {
                    window.location.href = "/houseCzqk/houseCzqkList";
                } else {
                    alert(data);
                }
            }
        })
    }

    <!--退房审批通过-->
    function applyCheckOutHouse(houseCzqkId) {
        $.ajax({
            url: '/houseCzqk/selectStatusById',
            data: {id: houseCzqkId},
            dataType: 'json',
            type: 'post',
            success: function (data) {
                if (data == "ok") {
                    window.location.href = "/houseCzqk/houseCzqkList";
                } else {
                    alert(data);
                }
            }
        })
    }

    <!--给input赋值-->
    function notApply(houseCzqkId) {
        var $content = $('#content');
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/notApply/selectStatusById",
            data: {"id": houseCzqkId},
            success: function (data) {
                var object = $.parseJSON(data);
                $("input[id=status]").val(object.zfxztfzt);
            }
        });
        $content.modal({backdrop: 'static'});
    }

    function addNotApply() {
        $.ajax({
            type: "post",
            dataType: "json",
            url: $('#addForm').attr('action'),
            data: $('#addForm').serialize(),
            success: function (data) {
                if (data == "ok") {
                    window.location.href = "/houseCzqk/houseCzqkList";
                } else {
                    alert("error");
                }
            }
        });
    }
</script>
</html>
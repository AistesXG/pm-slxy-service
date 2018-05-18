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
                        已拥有的公用房屋 <span style="color: red;">红色的表示在用的 灰色的表示空闲的 </span>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped  table-hover"
                               id="dataTables-example">
                            <tbody>
                            <c:forEach items="${housePubList}" var="housePub" varStatus="status">
                                <c:if test="${(status.index + 1) % 9 == 1}">
                                    <tr class="gradeU">
                                </c:if>
                                <input type="hidden" name="id" id="houseId" value="${housePub.id}">
                                <td>
                                    <c:choose>
                                        <c:when test="${housePub.fjsyzt == '空闲'}">
                                            <button class="btn btn-info housePubDetail"
                                                    onclick="housePubDetail(${housePub.id})"><img
                                                    src="/resources/img/fwhb.jpg"></button>
                                            <br>
                                            ${housePub.fjbh}
                                        </c:when>
                                        <c:otherwise>
                                            <button class="btn btn-info housePubDetail"
                                                    onclick="housePubDetail(${housePub.id})"><img
                                                    src="/resources/img/fw.jpg"></button>
                                            <br>
                                            ${housePub.fjbh}
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <c:if test="${(status.index + 1) % 9 == 0}">
                                    </tr>
                                </c:if>
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
                <form onsubmit="false" role="form" class="form-horizontal">
                    <br>
                    <div class="form-group">
                        <input type="hidden" id="housePubId" name="id">
                        <label class="col-sm-3 control-label">楼号:</label>
                        <div class="col-sm-7">
                            <input type="text" name="fjlh" class="form-control" id="fjlh" value=""
                                   size="10" readonly>
                            <span id="msg"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">编号:</label>
                        <div class="col-sm-7">
                            <input type="text" name="fjbh" id="fjbh" class="form-control" value=""
                                   size="20" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">面积:</label>
                        <div class="col-sm-7">
                            <input type="text" id="fjmj" name="fjmj" class="form-control" value=""
                                   size="8" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">使用状态:</label>
                        <div class="col-sm-7">
                            <input type="text" name="fjsyzt" class="form-control" value=""
                                   size="4" id="fjsyzt" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">使用类型:</label>
                        <div class="col-sm-7">
                            <input type="text" name="fjsylx" class="form-control" value=""
                                   size="20" id="fjsylx" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">使用部门:</label>
                        <div class="col-sm-7">
                            <input type="text" name="fjsybm" class="form-control" value=""
                                   size="30" id="fjsybm" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">备注:</label>
                        <div class="col-sm-7">
                    <textarea cols="5" rows="5" name="fjbz" class="form-control"
                              id="fjbz" readonly></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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
    <!--给input赋值-->
    function housePubDetail(houseId) {
        var $content = $('#content');
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/housePub/selectHousePubDetailById",
            data: {"id": houseId},
            success: function (data) {
                var object = $.parseJSON(data);
                $("input[id=housePubId]").val(object.id);
                $("input[id=fjlh]").val(object.fjlh);
                $("input[id=fjbh]").val(object.fjbh);
                $("textarea[id=fjbz]").val(object.fjbz);
                $("input[id=fjmj]").val(object.fjmj);
                $("input[id=fjsybm]").val(object.fjsybm);
                $("input[id=fjsylx]").val(object.fjsylx);
                $("input[id=fjsyzt]").val(object.fjsyzt);
            }
        });
        $content.modal({backdrop: 'static'});
    }

</script>
</html>
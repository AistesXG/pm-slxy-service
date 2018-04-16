<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>添加用户</title>
</head>
<style type="text/css">
    .must {
        color: red;
        font-size: 30px;
        position: absolute;
        top: 2px;
    }
</style>
<body>
<div id="wrapper">
    <!--引入公共页面-->
    <jsp:include page="../common.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">修改用户</h1>
            </div>
            <!-- /.col-lg-12 -->
            <div class="row">
                <div class="col-lg-4 ">
                    <form onsubmit="false" role="form" id="updateForm" class="form-horizontal">
                        <br>
                        <input type="hidden" value="${teacher.id}" name="id">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">教师姓名:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="xm" class="form-control" id="xm"
                                       value="${teacher.xm}" size="10">
                                <span id="msg"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">教工编号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="jggh" class="form-control"
                                       value="${teacher.jggh}" size="6" id="jggh">
                                <span id="numberMsg"></span></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="radio" name="xb" value="男"
                                       <c:if test="${teacher.xb eq '男'}">checked</c:if>/>男 &nbsp;
                                <input type="radio" name="xb" value="女"
                                       <c:if test="${teacher.xb eq '女'}">checked</c:if>>女
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">身份证号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="sfzh" class="form-control"
                                       value="${teacher.sfzh}" size="18" id="sfzh">
                                <span id="idCardMsg"></span></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">出生年月:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="csrq" class="form-control"
                                       value="${teacher.csrq}" size="10"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学历:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="xl" class="form-control"
                                       value="${teacher.xl}" size="18"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">参加工作时间:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="cjgzrq" class="form-control"
                                       value="${teacher.cjgzrq}" size="10"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">所在部门:<span class="must">*</span></label>
                            <div class="col-sm-9">

                                <select name="szbm" class="form-control">
                                    <option value="${teacher.szbm}">${teacher.szbm}</option>
                                    <%--<c:forEach items="${deptList}" var="dept">--%>
                                        <%--<option value="${dept.departmentName}">${dept.departmentName}</option>--%>
                                    <%--</c:forEach>--%>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">籍贯:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="jg" class="form-control"
                                       value="${teacher.jg}" size="30"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">租房状态:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="zfzt" class="form-control"
                                       value="${teacher.zfzt}" size="4" readonly="readonly"></div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <input type="button" value="提交" class="btn btn-primary" onclick="updateTeacher()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
                                type="reset" value="重置" class="btn btn-primary">
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function updateTeacher() {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/teacher/updateTeacher",
            data: $('#updateForm').serialize(),
            success: function (data) {
                if (data == "ok") {
                    window.location.href = "/teacher/teacherList";
                } else {
                    alert(data);
                }
            }
        })
    }

    <!--检测教师编号是否可用是否可以使用-->
    $(function () {
        $('#jggh').blur(function () {
            var jggh = $('#jggh').val();
            var msgObj = $('#numberMsg');
            if (jggh == "") {
                msgObj.css("color", "red").html("教工编号不能为空")
            } else {
                $.ajax({
                    type: "post",
                    dataType: "json",
                    url: "/checkTeacherNum",
                    data: {jggh: jggh},
                    success: function (data) {
                        if (data == "ok") {
                            msgObj.css("color", "red").html("该编号可以使用");
                        } else {
                            msgObj.css("color", "red").html("该编号已经存在");
                        }
                    }
                })
            }
        })

        $('#sfzh').blur(function () {
            var sfzh = $('#sfzh').val();
            var msgObj = $('#idCardMsg');
            if (sfzh == "") {
                msgObj.css("color", "red").html("身份证号不能为空")
            } else {
                $.ajax({
                    type: "post",
                    dataType: "json",
                    url: "/checkTeacherIdCard",
                    data: {sfzh: sfzh},
                    success: function (data) {
                        if (data == "ok") {
                            msgObj.css("color", "red").html("该身份证号可以使用");
                        } else {
                            msgObj.css("color", "red").html("该身份证号已经存在");
                        }
                    }
                })
            }
        })
    })


</script>
</html>
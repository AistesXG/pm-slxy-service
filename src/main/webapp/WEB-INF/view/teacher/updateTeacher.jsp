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
                                <input type="text" name="teachername" class="form-control" id="teachername"
                                       value="${teacher.teachername}" size="10">
                                <span id="msg"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">教工编号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teachernumber" class="form-control"
                                       value="${teacher.teachernumber}" size="6"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="radio" name="teachersex" value="男"
                                       <c:if test="${teacher.teachersex eq '男'}">checked</c:if>/>男 &nbsp;
                                <input type="radio" name="teachersex" value="女"
                                       <c:if test="${teacher.teachersex eq '女'}">checked</c:if>>女
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">身份证号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teacheridcard" class="form-control"
                                       value="${teacher.teacheridcard}" size="18"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">出生年月:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teacherbirthdate" class="form-control"
                                       value="${teacher.teacherbirthdate}" size="10"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学历:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teachereducation" class="form-control"
                                       value="${teacher.teachereducation}" size="18"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">参加工作时间:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teacherstartwork" class="form-control"
                                       value="${teacher.teacherstartwork}" size="10"></div>
                        </div>
                        <%--<div class="form-group">--%>
                            <%--<label class="col-sm-3 control-label">申请住房日期:</label>--%>
                            <%--<div class="col-sm-9">--%>
                                <%--<input type="text" name="teacherhousingdate" class="form-control"--%>
                                       <%--value="${teacher.teacherhousingdate}" size="10"></div>--%>
                        <%--</div>--%>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">所在部门:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teacherdepartment" class="form-control"
                                       value="${teacher.teacherdepartment}" size="30"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">籍贯:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teacherplaceorigin" class="form-control"
                                       value="${teacher.teacherplaceorigin}" size="30"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">租房状态:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teacherrentalstatus" class="form-control"
                                       value="${teacher.teacherrentalstatus}" size="4" readonly="readonly"></div>
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

</script>
</html>
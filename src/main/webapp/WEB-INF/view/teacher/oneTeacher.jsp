<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>教师详情</title>
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
                <h1 class="page-header">教师详情</h1>
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
                                       value="${teacher.teachername}" size="10" readonly="readonly">
                                <span id="msg"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">教工编号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teachernumber" class="form-control"
                                       value="${teacher.teachernumber}" size="6" readonly="readonly"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teachersex" class="form-control"
                                value="${teacher.teachersex}" size="2" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">身份证号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teacheridcard" class="form-control"
                                       value="${teacher.teacheridcard}" size="18" readonly="readonly"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">出生年月:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teacherbirthdate" class="form-control"
                                       value="${teacher.teacherbirthdate}" size="10" readonly="readonly"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学历:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teachereducation" class="form-control"
                                       value="${teacher.teachereducation}" size="18" readonly="readonly"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">参加工作时间:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teacherstartwork" class="form-control"
                                       value="${teacher.teacherstartwork}" size="10" readonly="readonly"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">申请住房日期:</label>
                            <div class="col-sm-9">
                                <input type="text" name="teacherhousingdate" class="form-control"
                                       value="${teacher.teacherhousingdate}" size="10" readonly="readonly"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">所在部门:<span class="must">*</span></label>
                            <div class="col-sm-9">

                                <%--<select name="teacherdepartment"  class="form-control">--%>
                                <%--<option value="${teacher.teacherdepartment}" readonly="readonly">${teacher.teacherdepartment}</option>--%>
                                <%--</select>--%>
                                <input type="text" name="teacherdepartment" class="form-control"
                                       value="${teacher.teacherdepartment}" size="30" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">籍贯:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teacherplaceorigin" class="form-control"
                                       value="${teacher.teacherplaceorigin}" size="30" readonly="readonly"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">租房状态:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="teacherrentalstatus" class="form-control"
                                       value="${teacher.teacherrentalstatus}" size="4" readonly="readonly"></div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
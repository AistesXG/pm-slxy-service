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
                <h1 class="page-header">添加用户</h1>
            </div>
            <!-- /.col-lg-12 -->
            <div class="row">
                <div class="col-lg-4 ">
                    <form onsubmit="false" role="form" id="addForm" class="form-horizontal">
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">教师姓名:<span class="must">*</span></label>
                            <div class="col-sm-9">
                            <input type="text" name="teachername" class="form-control" id="teachername" value="" size="10">
                            <span id="msg"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">教工编号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                            <input type="text" name="teachernumber" class="form-control" value="" size="6">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别:<span class="must">*</span></label><div class="col-sm-9">
                            <input type="radio" name="teachersex" checked="checked" value="男"/>男 &nbsp;
                            <input type="radio" name="teachersex" value="女">女</div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">身份证号:<span class="must">*</span></label><div class="col-sm-9">
                            <input type="text" name="teacheridcard" class="form-control" value="" size="18"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">出生年月:<span class="must">*</span></label><div class="col-sm-9">
                            <input type="text" name="teacherbirthdate" class="form-control" value="" size="10"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学历:<span class="must">*</span></label><div class="col-sm-9">
                            <input type="text" name="teachereducation" class="form-control" value="" size="18"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">参加工作时间:<span class="must">*</span></label><div class="col-sm-9">
                            <input type="text" name="teacherstartwork" class="form-control" value="" size="10"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">申请住房日期:<span class="must">*</span></label><div class="col-sm-9">
                            <input type="text" name="teacherhousingdate" class="form-control" value="" size="10"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">所在部门:<span class="must">*</span></label><div class="col-sm-9">
                            <input type="text" name="teacherdepartment" class="form-control" value="" size="30"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">籍贯:<span class="must">*</span></label>
                            <div class="col-sm-9">
                            <input type="text" name="teacherplaceorigin" class="form-control" value="" size="30"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">租房状态:<span class="must">*</span></label><div class="col-sm-9">
                            <input type="text" name="teacherrentalstatus" class="form-control" value="" size="4"></div>
                        </div>

                        <div class="form-group" style="text-align: center">
                            <input type="button" value="提交" class="btn btn-primary" onclick="addTeacher()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
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
    <!--添加用户-->
    function addTeacher() {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/teacher/addTeacher",
            data: $('#addForm').serialize(),
            success: function (data) {
                if (data == "ok") {
                    window.location.href = "/teacher/teacherList";
                } else {
                    alert(data);
                }
            }

        })
    }

/*    <!--检测用户名是否可以使用-->
    $(function () {
        $('#user').blur(function () {
            var cuser = $('#user').val();
            var msgObj = $('#msg');
            if(cuser ==""){
                msgObj.css("color","red").html("用户名不能为空")
            }else{
                $.ajax({
                    type: "post",
                    dataType: "json",
                    url: "/checkUser",
                    data: {user: cuser},
                    success: function (data) {
                        if (data == "ok") {
                            msgObj.css("color","red").html("用户名可以使用");
                        }else{
                            msgObj.css("color","red").html("用户名已经被注册");
                        }
                    }
                })}
        })
    })*/
</script>
</html>
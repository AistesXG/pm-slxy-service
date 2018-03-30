<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
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
                            <label class="col-sm-3 control-label">用户名:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="user" class="form-control" id="user" value="" size="20">
                                <span id="msg"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">密码:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="password" name="pass" class="form-control" value="" size="20">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">email:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" id="email" name="email" class="form-control" value="" size="50">
                                <span id="msgEmail"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">电话号码:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="phone" class="form-control" value="" size="11" id="phone">
                                <span id="msgPhone"></span>
                            </div>
                        </div>
                        <%-- <div class="form-group">
                             <label>角色:</label>
                             <select class="form-control" name="type">
                                 <option value="普通管理员">普通管理员</option>
                                 <option value="系统管理员">系统管理员</option>
                             </select>
                         </div>--%>
                        <div class="form-group" style="text-align: center">
                            <input type="button" value="提交" class="btn btn-primary" onclick="addAdmin()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
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
    function addAdmin() {
        var regEmail = new RegExp("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
        var testEmail = regEmail.test($('#email').val());
        var regPhone = new RegExp("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$")
        var testPhone = regPhone.test($('#phone').val());
        if(!testEmail){
            var msgEmail = $('#msgEmail');
            msgEmail.css("color", "red").html("邮箱格式错误！")
        }
        if(!testPhone){
            var msgPhone = $('#msgPhone');
            msgPhone.css("color", "red").html("电话号码格式错误！")
        }
        if(testEmail && testPhone){
            $.ajax({
                type: "post",
                dataType: "json",
                url: "/admin/addAdmin",
                data: $('#addForm').serialize(),
                success: function (data) {
                    if (data == "ok") {
                        window.location.href = "/admin/adminList";
                    } else {
                        alert(data);
                    }
                }
            })
        }
    }

    <!--检测用户名是否可以使用-->
    $(function () {
        $('#user').blur(function () {
            var cuser = $('#user').val();
            var msgObj = $('#msg');
            if (cuser == "") {
                msgObj.css("color", "red").html("用户名不能为空")
            } else {
                $.ajax({
                    type: "post",
                    dataType: "json",
                    url: "/checkUser",
                    data: {user: cuser},
                    success: function (data) {
                        if (data == "ok") {
                            msgObj.css("color", "red").html("用户名可以使用");
                        } else {
                            msgObj.css("color", "red").html("用户名已经被注册");
                        }
                    }
                })
            }
        })
    })
</script>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>添加用户</title>
</head>
<body>
<div id="wrapper">
    <!--引入公共页面-->
    <jsp:include page="common.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">修改</h2>
            </div>
            <!-- /.col-lg-12 -->
            <div class="row">
                <div class="col-lg-4 ">
                    <form onsubmit="false" role="form" id="addForm">
                        <br>
                        <input type="hidden" name="id" value="${admin.id}">
                        <div class="form-group">
                            <label>用户名:</label>
                            <input type="text" name="user" class="form-control" id="user" value="${admin.user}" size="20">
                            <span id="msg"></span>
                        </div>
                        <div class="form-group">
                            <label>email:</label>
                            <input type="text" name="email" class="form-control" value="${admin.email}" size="50">
                        </div>
                        <div class="form-group">
                            <label>电话号码:</label>
                            <input type="text" name="phone" class="form-control" value="${admin.phone}" size="11">
                        </div>
                         <div class="form-group">
                             <label>角色:</label>
                             <select class="form-control" name="type">
                                 <c:choose>
                                     <c:when test="${admin.type == '普通管理员'}">
                                         <option value="普通管理员" selected>普通管理员</option>
                                         <option value="系统管理员">系统管理员</option>
                                     </c:when>
                                     <c:otherwise>
                                         <option value="普通管理员">普通管理员</option>
                                         <option value="系统管理员" selected>系统管理员</option>
                                     </c:otherwise>
                                 </c:choose>
                             </select>
                         </div>
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
    <!--修改用户-->
    function addAdmin() {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/admin/updateAdmin",
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


</script>
</html>

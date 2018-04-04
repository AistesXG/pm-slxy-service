<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
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
                <h1 class="page-header">添加房屋信息</h1>
            </div>
            <!-- /.col-lg-12 -->
            <div class="row">
                <div class="col-lg-4 ">
                    <form onsubmit="false" role="form" id="addForm" class="form-horizontal">
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">楼号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="housefloornumber" class="form-control" id="housefloornumber" value="" size="10">
                                <span id="msg"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">编号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="housenumber" class="form-control" value="" size="20">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">面积:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" id="housearea" name="housearea" class="form-control" value="" size="8">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">使用状态:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="housestatus" class="form-control" value="" size="4" id="housestatus">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">使用类型:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="housetype" class="form-control" value="" size="20" id="housetype">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">使用部门:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="housedepartment" class="form-control" value="" size="30" id="housedepartment">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">备注:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <textarea cols="5" rows="5" name="houseremarks" class="form-control"  id="houseremarks"></textarea>
                            </div>
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
</html>
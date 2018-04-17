<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>添加房屋信息</title>
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
                                <input type="text" name="fjlh" class="form-control" id="fjlh" value="" size="10">
                                <span id="msg"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">编号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="fjbh" class="form-control" value="" size="20">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">面积:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" id="fjmj" name="fjmj" class="form-control" value="" size="8">
                            </div>
                        </div>
                        <div class="form-group">
                        <label class="col-sm-3 control-label">使用类型:</label>
                        <div class="col-sm-9">
                            <select name="fjsylx" class="form-control">
                                <option value="">---请选择房间类型---</option>
                                <option value="保障期单间">保障期单间</option>
                                <option value="保障期单元房">保障期单元房</option>
                                <option value="延长期单间">延长期单间</option>
                                <option value="延长期单元房">延长期单元房</option>
                                <option value="超限期单间">超限期单间</option>
                                <option value="超限期单元房">超限期单元房</option>
                                <option value="特殊房间">特殊房间</option>
                            </select>
                            <%--<input type="text" name="fjsylx" class="form-control" value="" size="20" id="fjsylx">--%>
                        </div>
                    </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">使用部门:</label>
                            <div class="col-sm-9">
                                <input type="text" name="fjsybm" class="form-control" value="" size="30" id="fjsybm">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">备注:</label>
                            <div class="col-sm-9">
                                <textarea cols="5" rows="5" name="fjbz" class="form-control"  id="fjbz"></textarea>
                            </div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <input type="button" value="提交" class="btn btn-primary" onclick="addHousePub()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
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
    function addHousePub() {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/housePub/addHousePub",
            data: $('#addForm').serialize(),
            success: function (data) {
                if (data == "ok") {
                    console.log(data)
                    window.location.href = "/housePub/housePubList";
                } else {
                    alert(data);
                }
            }
        })
    }
</script>
</html>
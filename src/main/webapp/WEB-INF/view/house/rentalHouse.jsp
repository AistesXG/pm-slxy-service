<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>租房</title>
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
                <h1 class="page-header">租房</h1>
            </div>
            <!-- /.col-lg-12 -->
            <div class="row">
                <div class="col-lg-4 ">
                    <form onsubmit="false" role="form" id="addForm" class="form-horizontal">
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">楼号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="housefloornumber" class="form-control"
                                       value="${housePub.housefloornumber}" size="20" readonly="readonly">
                                <span id="msg"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">编号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="housenumber" class="form-control"
                                       value="${housePub.housenumber}" size="20" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">申请租住日期:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="applycheckdate" class="form-control" value="" size="20">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">租住年限:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="applytime" class="form-control" value="" size="10">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">租住到期日期:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="applyexpiredate" class="form-control" value="" size="20">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">房间租住类型:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="houserentaltype" class="form-control" value="" size="20">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">面积:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" id="housearea" name="housearea" class="form-control"
                                       value="${housePub.housearea}" readonly="readonly" size="10">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">特殊房间系数:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="specialrentalhouse" class="form-control" value="" size="10">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">双职工租住一间:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="radio" name="whetherdoubleone" checked="checked" value="是">是
                                <input type="radio" name="whetherdoubleone" value="否">否
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">是否带小孩:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="radio" name="whetherchild" checked="checked" value="是">是
                                <input type="radio" name="whetherchild" value="否">否
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">租住教师所在部门:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="rentalteacherdepartment" class="form-control" value=""
                                       size="30">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">租住教师编号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="rentallteachernumber" class="form-control" value="" size="6">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">租住教师姓名:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="rentalteachername" class="form-control" value="" size="10">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">备注:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <textarea cols="5" rows="5" name="houseremarks" class="form-control"></textarea>
                            </div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <input type="button" value="提交" onclick="rental()" id="rental" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
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
    function rental() {
        $.ajax({
            async: false,
            type: "post",
            dataType: "json",
            url: "/houseRentingSituation/rentalHouse",
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

</script>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="/resources/js/laydate.js"></script>
    <title>申请租房</title>
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
                <h1 class="page-header">申请租房</h1>
            </div>
            <!-- /.col-lg-12 -->
            <div class="row">
                <div class="col-lg-4 ">
                    <form onsubmit="false" role="form" id="addForm" class="form-horizontal"
                          action="/houseCzqk/addHouseCzqk">
                        <br>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">房间楼号:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" name="fjlh" class="form-control" id="fjlh" value="${house.fjlh}" size="20">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">房间编号:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" name="fjbh" class="form-control" value="${house.fjbh}" size="20">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">申请租住日期:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" id="sqzzrq" name="sqzzrq" class="form-control laydate-icon" value=""
                                       size="10" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租住年限:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <select name="zznx" id="zznx" class="form-control">
                                    <option value="">---请选择租住年限---</option>
                                    <option value="1">1年</option>
                                    <option value="2">2年</option>
                                    <option value="3">3年</option>
                                    <option value="4">4年</option>
                                    <option value="5">5年</option>
                                    <option value="6">6年</option>
                                    <option value="7">7年</option>
                                    <option value="8">8年</option>
                                    <option value="9">9年</option>
                                    <option value="10">10年</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租住到期日期:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" id="zzdqrq" name="zzdqrq" class="form-control laydate-icon" value="" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">房间租住类型:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <select name="fjzzlx" id="fjzzlx" class="form-control">
                                    <option value="">---请选择房间类型---</option>
                                    <option value="保障期单间">保障期单间</option>
                                    <option value="保障期单元房">保障期单元房</option>
                                    <option value="延长期单间">延长期单间</option>
                                    <option value="延长期单元房">延长期单元房</option>
                                    <option value="超限期单间">超限期单间</option>
                                    <option value="超限期单元房">超限期单元房</option>
                                    <option value="特殊房间">特殊房间</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">房间面积:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" id="fjmj" name="fjmj" class="form-control" value="${house.fjmj}" size="20">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">特殊房间系数:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" id="tszzxs" name="tszzxs" class="form-control" value="" size="8">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">是否属于双职工租住一个房子:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="radio" name="sfszg" checked="checked" value="是"/>是 &nbsp;
                                <input type="radio" name="sfszg" value="否">否
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">是否带小孩:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="radio" name="sfcxqdxh" checked="checked" value="是"/>是 &nbsp;
                                <input type="radio" name="sfcxqdxh" value="否">否
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租住教师所在部门:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <select name="zzjsszbm" id="zzjsszbm" class="form-control" onchange="selectTeacherXmByDept()">
                                    <option value="">---请选择部门---</option>
                                    <c:forEach items="${departments}" var="dept">
                                        <option value="${dept}">${dept}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租住教师姓名:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <select name="zzjsxm" id="zzjsxm" class="form-control"></select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">备注:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <textarea cols="5" rows="5" name="bzsm" class="form-control" id="bzsm"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">教师警告日期:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" id="jscjgzrq" name="jscjgzrq" class="form-control  laydate-icon"
                                       value="" size="8" readonly>
                            </div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <input type="submit" value="提交" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
                                type="reset" value="重置" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button
                                type="button" class="btn btn-primary" onclick="window.history.go(-1)">返回
                        </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
    $(document).ready(function () {
        $('#addForm')
            .bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    fjsylx: {
                        validators: {
                            notEmpty: {
                                message: '房间使用类型不能为空'
                            }
                        }
                    }

                }
            }).on('success.form.bv', function (e) {
            e.preventDefault();
            var $form = $(e.target);
            var bv = $form.data('bootstrapValidator');
            $.ajax({
                type: 'post',
                dataType: 'json',
                url: $form.attr('action'),
                data: $form.serialize(),
                success: function (data) {
                    if (data == "ok") {
                        window.location.href = "/houseCzqk/HouseCzqkList";
                    } else {
                        alert(data);
                    }
                }
            })
        })
    })

    !function () {
        laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
        laydate({elem: '#sqzzrq'});//绑定出生年月元素
        laydate({elem: '#zzdqrq'});//绑定参加工作时间
        laydate({elem: '#jscjgzrq'})//绑定警报日期
    }();

    <!--给jsxm赋值-->
    function selectTeacherXmByDept() {
        var szbm = $('#zzjsszbm').val();
        $.ajax({
            url: "/teacher/selectTeacherXmByDept",
            type: "post",
            data: {"szbm": szbm},
            dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            success: function (data) {
                var object = $.parseJSON(data)
                $('#zzjsxm').html("");
                var option = "";
                for (var i = 0; i < object.length; i++) {
                    option += "<option value='" + object[i] + "'>" + object[i] + "</option>"
                }
                $('#zzjsxm').html(option);
            }
        })
    }
</script>
</html>
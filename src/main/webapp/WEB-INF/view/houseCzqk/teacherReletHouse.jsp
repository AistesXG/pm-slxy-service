<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon"/>
    <title>续租房屋</title>
    <style type="text/css">
        .must {
            color: red;
            font-size: 30px;
            position: absolute;
            top: 2px;
        }

        .red {
            color: red;
        }
    </style>
</head>
<body>
<div id="wrapper">
    <!--引入公共页面-->
    <%@include file="../teacherCommon.jsp"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">续租房屋<label
                        style="font-size:20px;color: red;">下拉列表中红色的表示未选择的，黑色的表示数据库中的数据</label></h1>
            </div>
            <!-- /.col-lg-12 -->
            <div class="row">
                <div class="col-lg-4 ">
                    <form onsubmit="false" role="form" id="addForm" class="form-horizontal"
                          action="/houseCzqk/teacherReletHouse">
                        <br>
                        <input type="hidden" name="id" value="${houseCzqk.id}">
                        <div class="form-group">
                            <label class="col-sm-6 control-label">房间楼号:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" name="fjlh" class="form-control" id="fjlh" value="${houseCzqk.fjlh}"
                                       size="20" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">房间编号:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" name="fjbh" class="form-control" value="${houseCzqk.fjbh}" size="20"
                                       readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">申请租住日期:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" id="sqzzrq" name="sqzzrq" class="form-control laydate-icon"
                                       value="${houseCzqk.sqzzrq}"
                                       size="10" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租住年限:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <select name="zznx" id="zznx" class="form-control">
                                    <option value="${houseCzqk.zznx}">${houseCzqk.zznx}年</option>
                                    <option value="1" class="red">1年</option>
                                    <option value="2" class="red">2年</option>
                                    <option value="3" class="red">3年</option>
                                    <option value="4" class="red">4年</option>
                                    <option value="5" class="red">5年</option>
                                    <option value="6" class="red">6年</option>
                                    <option value="7" class="red">7年</option>
                                    <option value="8" class="red">8年</option>
                                    <option value="9" class="red">9年</option>
                                    <option value="10" class="red">10年</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租住到期日期:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" id="zzdqrq" name="zzdqrq" class="form-control laydate-icon"
                                       value="${houseCzqk.zzdqrq}"
                                       readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">房间租住类型:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <select name="fjzzlx" id="fjzzlx" class="form-control">
                                    <option value="${houseCzqk.fjzzlx}">${houseCzqk.fjzzlx}</option>
                                    <option value="保障期单间" class="red">保障期单间</option>
                                    <option value="保障期单元房" class="red">保障期单元房</option>
                                    <option value="延长期单间" class="red">延长期单间</option>
                                    <option value="延长期单元房" class="red">延长期单元房</option>
                                    <option value="超限期单间" class="red">超限期单间</option>
                                    <option value="超限期单元房" class="red">超限期单元房</option>
                                    <option value="特殊房间" class="red">特殊房间</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">房间面积:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" id="fjmj" name="fjmj" class="form-control" value="${houseCzqk.fjmj}"
                                       size="20" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">特殊房间系数:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" id="tszzxs" name="tszzxs" class="form-control"
                                       value="${houseCzqk.tszzxs}" size="8">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">是否属于双职工租住一个房子:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="radio" name="sfszg" value="是"
                                       <c:if test="${houseCzqk.sfszg eq '是'}">checked</c:if>/>是 &nbsp;
                                <input type="radio" name="sfszg" value="否"
                                       <c:if test="${houseCzqk.sfszg eq '否'}">checked</c:if>/>否 &nbsp;
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">是否带小孩:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="radio" name="sfcxqdxh" value="是"
                                       <c:if test="${houseCzqk.sfcxqdxh eq '是'}">checked</c:if>/>是 &nbsp;
                                <input type="radio" name="sfcxqdxh" value="否"
                                       <c:if test="${houseCzqk.sfcxqdxh eq '否'}">checked</c:if>/>否 &nbsp;
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租住教师所在部门:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" id="zzjsszbm" name="zzjsszbm" class="form-control"
                                       value="${houseCzqk.zzjsszbm}" size="30" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租住教师编号:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" id="zzjsbh" name="zzjsbh" class="form-control"
                                       value="${houseCzqk.zzjsbh}" size="6" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租住教师姓名:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" id="zzjsxm" name="zzjsxm" class="form-control"
                                       value="${houseCzqk.zzjsxm}" size="10" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">备注:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <textarea cols="5" rows="5" name="bzsm" class="form-control"
                                          id="bzsm">${houseCzqk.bzsm}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">教师参加工作时间:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" id="jscjgzrq" name="jscjgzrq" class="form-control  laydate-icon"
                                       value="${houseCzqk.jscjgzrq}" size="10" readonly>
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
            }).on('success.form.bv', function (e) {
            e.preventDefault();
            var $form = $(e.target);
            var bv = $form.data('bootstrapValidator');
            var data = $form.serialize();
            $.ajax({
                type: 'post',
                dataType: 'json',
                url: $form.attr('action'),
                data: data,
                success: function (data) {
                    if (data == "ok") {
                        alert("续租成功!")
                        window.location.href = "/house/houseList";
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
</script>
</html>

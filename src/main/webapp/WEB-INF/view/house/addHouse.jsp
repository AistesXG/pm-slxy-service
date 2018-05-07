<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>添加教师房屋信息</title>
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
                <h1 class="page-header">添加教师房屋信息</h1>
            </div>
            <!-- /.col-lg-12 -->
            <div class="row">
                <div class="col-lg-4 ">
                    <form onsubmit="false" role="form" id="addForm" class="form-horizontal"
                          action="/house/addHouse">
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">租住者姓名:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="zzzxm" class="form-control" id="zzzxm" value="" size="10">
                                <span id="msg"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">房间编号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" id="fjbh" name="fjbh" class="form-control" value="" size="20">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">房间楼号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" id="fjlh" name="fjlh" class="form-control" value="" size="20">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">房间面积:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" id="fjmj" name="fjmj" class="form-control" value="">
                            </div>
                        </div>
                        <%--<div class="form-group">--%>
                            <%--<label class="col-sm-3 control-label">房间备注:<span class="must">*</span></label>--%>
                            <%--<div class="col-sm-9">--%>
                                <%--<textarea cols="5" rows="5" name="fjbz" class="form-control" id="fjbz"></textarea>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="form-group" style="text-align: center">
                            <input type="submit" value="提交" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
                                type="reset" value="重置" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-primary" onclick="window.history.go(-1)">返回</button>
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
                    zzzxm: {
                        message: 'This user is not valid',
                        validators: {
                            notEmpty: {
                                message: '租住者姓名不能为空'
                            },
                            stringLength: {
                                max: 10,
                                message: '最长为10个字符'
                            }
                        }
                    },
                    fjbh: {
                        validators: {
                            notEmpty: {
                                message: '房间编号不能为空'
                            },
                            stringLength: {
                                max: 20,
                                message: '最大为20个字符'
                            },
                            remote: {
                                type: 'POST',
                                url: '/checkHouseBh',
                                message: '房间编号重复',
                                delay: 1000
                            }
                        }
                    },
                    fjlh: {
                        validators: {
                            notEmpty: {
                                message: '房间楼号不能为空'
                            },
                            stringLength: {
                                max: 20,
                                message: '最大为20个字符'
                            }
                        }
                    },
                    fjmj: {
                        validators: {
                            notEmpty: {
                                message: '房间面积不能为空',
                            },
                            stringLength: {
                                max: 8,
                                message: '最大为8个字符'
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
                        window.location.href = "/house/houseList";
                    } else {
                        alert(data);
                    }
                }
            })
        })
    })

</script>
</html>
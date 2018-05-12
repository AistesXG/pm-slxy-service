<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <script src="/resources/js/laydate.js"></script>
    <title>添加教师</title>
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
                    <form onsubmit="false" role="form" id="addForm" class="form-horizontal"
                          action="/teacher/addTeacher">
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">教师姓名:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="xm" class="form-control" id="xm" value=""
                                       size="10">

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">教工编号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="jggh" class="form-control" value="" size="6"
                                       id="jggh">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="radio" name="xb" checked="checked" value="男"/>男 &nbsp;
                                <input type="radio" name="xb" value="女">女
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">身份证号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="sfzh" class="form-control" value="" size="18"
                                       id="sfzh">

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">出生年月:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="csrq" class="form-control laydate-icon" value="" size="10"
                                       id="csrq" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学历:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <select name="xl" class="form-control">
                                    <option value="">---请选择学历---</option>
                                    <option value="本科">本科</option>
                                    <option value="硕士">硕士</option>
                                    <option value="博士">博士</option>
                                </select>
                                <%--<input type="text" name="xl" class="form-control" value="" size="18">--%>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">参加工作时间:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="cjgzrq" class="form-control laydate-icon" value="" size="10"
                                       id="cjgzrq" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">所在部门:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <select name="szbm" class="form-control" id="szbm">
                                    <option value="">---请选择部门---</option>
                                    <c:forEach items="${departments}" var="dept">
                                        <option value="${dept}">${dept}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">籍贯:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="jg" class="form-control" value="" size="30">
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
                    xm: {
                        message: 'This user is not valid',
                        validators: {
                            notEmpty: {
                                message: '教师姓名不能为空'
                            },
                            stringLength: {
                                max: 10,
                                message: '行名不能超过10个字符'
                            },
                            regexp: {
                                regexp: /^[\u4E00-\u9FA5A-Za-z]+$/,
                                message: '姓名只能是英文和中文'
                            }
                        }
                    },
                    jggh: {
                        validators: {
                            notEmpty: {
                                message: '教工编号不能为空'
                            },
                            stringLength: {
                                max: 6,
                                message: '教工编号最大为6位'
                            },
                            remote: {
                                type: 'POST',
                                url: '/checkTeacherNum',
                                message: '教师编号已经存在',
                                delay: 1000
                            }
                        }
                    },
                    sfzh: {
                        validators: {
                            notEmpty: {
                                message: '身份证号不能为空'
                            },
                            stringLength: {
                                max: 18,
                                message: '身份证号最大18位'
                            },
                            remote: {
                                type: 'POST',
                                url: '/checkTeacherIdCard',
                                message: '身份证号已经存在',
                                delay: 1000
                            },
                            regexp: {
                                regexp: /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/,
                                message: '身份证号码格式不正确'
                            }
                        }
                    },
                    xl: {
                        validators: {
                            notEmpty: {
                                message: '学历不能为空'
                            },
                        }
                    },
                    szbm: {
                        validators: {
                            notEmpty: {
                                message: '所在部门不能为空'
                            }
                        }
                    },
                    jg: {
                        validators: {
                            notEmpty: {
                                message: '籍贯不能为空'
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
                        window.location.href = "/teacher/teacherList";
                    } else {
                        alert(data);
                    }
                }
            })
        })
    })

    !function () {
        laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
        laydate({elem: '#csrq'});//绑定出生年月元素
        laydate({elem: '#cjgzrq'});//绑定参加工作时间
    }();
</script>
</html>
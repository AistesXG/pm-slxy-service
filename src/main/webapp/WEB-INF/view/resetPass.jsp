<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改密码页</title>
    <link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon"/>
    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--引入日历插件js-->
    <script type="text/javascript" src="/resources/js/laydate.js"></script>
    <!-- Bootstrap validator  CSS -->
    <link href="/resources/css/bootstrapValidator.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!--Bootstrap validator JavaScript-->
    <script src="/resources/js/bootstrapValidator.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="/resources/vendor/raphael/raphael.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/js/sb-admin-2.js"></script>
</head>
<body background="/resources/img/03-6-a18.jpg" style="overflow: hidden">

<form onsubmit="false" role="form" id="updatePassForm" class="form-horizontal"
      action="/admin/updatePass" style="margin-left: 300px;margin-top: 200px">
    <br>
    <div class="form-group">
        <label class="col-sm-3 control-label">用户名:<span class="must">*</span></label>
        <div class="col-sm-4">
            <input type="text" name="user" class="form-control" id="user" value="" size="20">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label">新密码:<span class="must">*</span></label>
        <div class="col-sm-4">
            <input type="password" id="pass" name="pass" class="form-control" value="" size="22">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label">确认密码:<span class="must">*</span></label>
        <div class="col-sm-4">
            <input type="password" id="repass" name="repass" class="form-control" value="" size="22">
        </div>
    </div>
    <div class="form-group" style="margin-left: 480px">
        <input type="submit" value="提交" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
            type="reset" value="重置" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button
            type="button" class="btn btn-primary" onclick="window.history.go(-1)">返回
    </button>
    </div>
</form>
<script type="text/javascript">
    $(document).ready(function () {
        $('#updatePassForm')
            .bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    user: {
                        threshold: 4,
                        message: 'This user is not valid',
                        validators: {
                            notEmpty: {
                                message: '用户名不能为空'
                            },
                            stringLength: {
                                min: 4,
                                max: 10,
                                message: '用户名必须在4到10个字符之间'
                            },
                            remote: {
                                type: 'POST',
                                url: '/checkUserSFCZ',
                                message: '该用户名不存在',
                                delay: 1000
                            },
                            regexp: {
                                regexp: /^[a-zA-Z0-9_]+$/,
                                message: '用户名只能包含大写、小写、数字和下划线'
                            }
                        }
                    },
                    pass: {

                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            },
                            stringLength: {
                                min: 6,
                                max: 21,
                                message: '密码必须在6到21个字符之间'
                            },
                            different: {//不能和用户名相同
                                field: 'user',//需要进行比较的input name值
                                message: '不能和用户名相同'
                            },
                            regexp: {
                                regexp: '^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$',
                                message: '密码必须要包含数字和大小写字母'
                            }
                        }
                    },
                    repass: {
                        message: '密码无效',
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            },
                            stringLength: {
                                min: 6,
                                max: 21,
                                message: '密码必须在6到21个字符之间'
                            },
                            identical: {//相同
                                field: 'pass',
                                message: '两次密码不一致'
                            },
                            different: {//不能和用户名相同
                                field: 'user',
                                message: '不能和用户名相同'
                            },
                            regexp: {//匹配规则
                                regexp: '^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$',
                                message: '密码必须要包含数字和大小写字母'
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
                        window.location.href = "jump/jumpLogin";
                    } else {
                        alert(data);
                    }
                }
            })
        })
    })


</script>

</body>
</html>

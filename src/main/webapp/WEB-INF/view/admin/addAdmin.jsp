<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon"/>
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
                    <form onsubmit="false" role="form" id="addForm" class="form-horizontal" action="/admin/addAdmin">
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
                                <input type="password" name="pass" class="form-control" value="" size="22">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">确认密码:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="password" name="repass" class="form-control" value="" size="22">
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
                                url: '/checkUser',
                                message: '用户已存在',
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
                    },
                    email: {
                        validators: {
                            notEmpty: {
                                message: '邮箱不能为空'
                            },
                            emailAddress: {
                                message: '邮箱格式有误'
                            }
                        }
                    },
                    phone: {
                        validators: {
                            notEmpty: {
                                message: '电话号码不能为空'
                            },
                            regexp: {
                                regexp: '^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$',
                                message: '必须是13 14 15 18 开头的11位数字'
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
                        window.location.href = "/admin/adminList";
                    } else {
                        alert(data);
                    }
                }
            })
        })
    })


</script>
</html>
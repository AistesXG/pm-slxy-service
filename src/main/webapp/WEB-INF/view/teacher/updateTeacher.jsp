<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="/resources/laydate/laydate.js"></script>
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
                <h1 class="page-header">修改用户</h1>
            </div>
            <!-- /.col-lg-12 -->
            <div class="row">
                <div class="col-lg-4 ">
                    <form onsubmit="false" role="form" id="updateForm" class="form-horizontal"
                          action="/teacher/updateTeacher">
                        <br>
                        <input type="hidden" value="${teacher.id}" name="id">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">教师姓名:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="xm" class="form-control" id="xm"
                                       value="${teacher.xm}" size="10">
                                <span id="msg"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">教工编号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="jggh" class="form-control"
                                       value="${teacher.jggh}" size="6" id="jggh">
                                <span id="numberMsg"></span></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="radio" name="xb" value="男"
                                       <c:if test="${teacher.xb eq '男'}">checked</c:if>/>男 &nbsp;
                                <input type="radio" name="xb" value="女"
                                       <c:if test="${teacher.xb eq '女'}">checked</c:if>>女
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">身份证号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="sfzh" class="form-control"
                                       value="${teacher.sfzh}" size="18" id="sfzh">
                                <span id="idCardMsg"></span></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">出生年月:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="csrq" class="form-control laydate-icon"
                                       value="${teacher.csrq}" size="10" id="csrq" readonly></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学历:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <select name="xl" class="form-control">
                                    <c:choose>
                                        <c:when test="${teacher.xl == '本科'}">
                                            <option value="本科" selected>本科</option>
                                            <option value="硕士">硕士</option>
                                            <option value="博士">博士</option>
                                        </c:when>
                                        <c:when test="${teacher.xl == '硕士'}">
                                            <option value="本科">本科</option>
                                            <option value="硕士" selected>硕士</option>
                                            <option value="博士">博士</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="本科">本科</option>
                                            <option value="硕士">硕士</option>
                                            <option value="博士" selected>博士</option>
                                        </c:otherwise>
                                    </c:choose>
                                </select>
                                <%--<input type="text" name="xl" class="form-control"--%>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">参加工作时间:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="cjgzrq" class="form-control laydate-icon"
                                       value="${teacher.cjgzrq}" size="10" id="cjgzrq" readonly></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">所在部门:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <select name="szbm" class="form-control">
                                    <option value="${teacher.szbm}">${teacher.szbm}</option>
                                    <%--<c:forEach items="${deptList}" var="dept">--%>
                                    <%--<option value="${dept.departmentName}">${dept.departmentName}</option>--%>
                                    <%--</c:forEach>--%>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">籍贯:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="jg" class="form-control"
                                       value="${teacher.jg}" size="30"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">租房状态:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="zfzt" class="form-control"
                                       value="${teacher.zfzt}" size="4" readonly="readonly"></div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <input type="submit" value="提交" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
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

    $(document).ready(function () {
        $('#updateForm')
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
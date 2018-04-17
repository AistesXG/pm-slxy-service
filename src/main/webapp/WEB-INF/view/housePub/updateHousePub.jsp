<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>修改房屋信息</title>
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
                <h1 class="page-header">修改房屋信息</h1>
            </div>
            <!-- /.col-lg-12 -->
            <div class="row">
                <div class="col-lg-4 ">
                    <form onsubmit="false" role="form" id="updateForm" class="form-horizontal" action="/housePub/updateHousePub">
                        <br>

                        <input type="hidden" value="${housePub.id}" name="id">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">楼号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="fjlh" class="form-control" id="fjlh" value="${housePub.fjlh}" size="10">
                                <span id="msg"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">编号:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="fjbh" class="form-control" value="${housePub.fjbh}" size="20">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">面积:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" id="fjmj" name="fjmj" class="form-control" value="${housePub.fjmj}" size="8">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">使用状态:<span class="must">*</span></label>
                            <div class="col-sm-9">
                                <input type="text" name="fjsyzt" class="form-control" value="${housePub.fjsyzt}" size="4" id="fjsyzt" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">使用类型:</label>
                            <div class="col-sm-9">
                                <select name="fjsylx" class="form-control">
                                    <option value="${housePub.fjsylx}">${housePub.fjsylx}</option>
                                    <option value="保障期单间">保障期单间</option>
                                    <option value="保障期单元房">保障期单元房</option>
                                    <option value="延长期单间">延长期单间</option>
                                    <option value="延长期单元房">延长期单元房</option>
                                    <option value="超限期单间">超限期单间</option>
                                    <option value="超限期单元房">超限期单元房</option>
                                    <option value="特殊房间">特殊房间</option>
                                </select>
                                <%--<input type="text" name="fjsylx" class="form-control" value="${housePub.fjsylx}" size="20" id="fjsylx">--%>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">使用部门:</label>
                            <div class="col-sm-9">
                                <select name="fjsybm" class="form-control" id="fjsybm">
                                    <c:set value="${housePub.fjsybm}" var='deptName'/>
                                    <c:forEach items="${departments}" var="dept">
                                        <c:if test="${dept eq deptName}">
                                            <option value="${dept}" selected>${dept}</option>
                                        </c:if>
                                        <c:if test="${dept != depeName}">
                                            <option value="${dept}">${dept}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                                <%--<input type="text" name="fjsybm" class="form-control" value="${housePub.fjsybm}" size="30" id="fjsybm">--%>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">备注:</label>
                            <div class="col-sm-9">
                                <textarea cols="5" rows="5" name="fjbz" class="form-control"  id="fjbz">${housePub.fjbz}</textarea>
                            </div>
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
                    fjlh: {
                        threshold: 4,
                        message: 'This user is not valid',
                        validators: {
                            notEmpty: {
                                message: '房间楼号不能为空'
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
                        window.location.href = "/housePub/housePubList";
                    } else {
                        alert(data);
                    }
                }
            })
        })
    })
</script>
</html>
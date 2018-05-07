<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>更新房屋价格</title>
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
                <h2 class="page-header">修改</h2>
            </div>
            <!-- /.col-lg-12 -->
            <div class="row">
                <div class="col-lg-4 ">
                    <form onsubmit="false" role="form" id="updateForm" class=form-horizontal
                          action="/zjhsbz/updatePrice">
                        <br>
                        <input type="hidden" name="id" value="${housePrice.id}">
                        <div class="form-group">
                            <label class="col-sm-8 control-label">保障期单间每平方米价格:<span class="must">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" name="bzqdj" class="form-control" id="bzqdj"
                                       value="${housePrice.bzqdj}"
                                >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-8 control-label">保障期单元房每平方米价格:<span class="must">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" name="bzqdyf" class="form-control" value="${housePrice.bzqdyf}"
                                       id="bzqdyf">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-8 control-label">延长期单间每平方米价格:<span class="must">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" name="ycqdj" class="form-control" value="${housePrice.ycqdj}"
                                       id="ycqdj">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-8 control-label">延长期单元房每平方米价格:<span class="must">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" name="ycqdyf" class="form-control" value="${housePrice.ycqdyf}"
                                       id="ycqdyf">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-8 control-label">超限期单间每平方米价格:<span class="must">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" name="cxqdj" class="form-control" value="${housePrice.cxqdj}"
                                       id="cxqdj">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-8 control-label">超限期单元房每平方米价格:<span class="must">*</span></label>
                            <div class="col-sm-4">
                                <input type="text" name="cxqdyf" class="form-control" value="${housePrice.cxqdyf}"
                                       id="cxqdyf">
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
        $('#updateForm')
            .bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    bzqdj: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            },
                        }
                    },
                    bzqdyf: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            },
                        }
                    },
                    ycqdj: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            },
                        }
                    },
                    ycqdyf: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            },
                        }
                    },
                    cxqdj: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            },
                        }
                    },
                    cxqdyf: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            },
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
                        window.location.href = "/zjhsbz/housePriceList";
                    } else {
                        alert(data);
                    }
                }
            })
        })
    })
</script>
</html>

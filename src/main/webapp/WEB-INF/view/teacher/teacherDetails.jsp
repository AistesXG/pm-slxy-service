<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon" />
    <title>教师详情</title>
</head>
<body>
<div id="wrapper">
    <!--引入公共页面-->
    <jsp:include page="../common.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">教师详情</h1>
            </div>
            <!-- /.col-lg-12 -->
            <div class="row">
                <div class="col-lg-4 ">
                    <form onsubmit="false" role="form" id="updateForm" class="form-horizontal"
                          action="/teacher/updateTeacher">
                        <br>
                        <input type="hidden" value="${teacher.id}" name="id">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">教师姓名:</label>
                            <div class="col-sm-9">
                                <input type="text" name="xm" class="form-control" id="xm"
                                       value="${teacher.xm}" size="10" readonly="readonly">
                                <span id="msg"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">教工编号:</label>
                            <div class="col-sm-9">
                                <input type="text" name="jggh" class="form-control"
                                       value="${teacher.jggh}" size="6" id="jggh" readonly="readonly">
                                <span id="numberMsg"></span></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别:</label>
                            <div class="col-sm-9">
                                <input type="text" name="xb" id="xb" readonly="readonly" value="${teacher.xb}"
                                       class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">身份证号:</label>
                            <div class="col-sm-9">
                                <input type="text" name="sfzh" class="form-control"
                                       value="${teacher.sfzh}" size="18" id="sfzh" readonly="readonly">
                                <span id="idCardMsg"></span></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">出生年月:</label>
                            <div class="col-sm-9">
                                <input type="text" name="csrq" class="form-control"
                                       value="${teacher.csrq}" size="10" id="csrq" readonly="readonly"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学历:</label>
                            <div class="col-sm-9">
                                <input type="text" name="xl" class="form-control" value="${teacher.xl}"
                                       readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">参加工作时间:</label>
                            <div class="col-sm-9">
                                <input type="text" name="cjgzrq" class="form-control"
                                       value="${teacher.cjgzrq}" size="10" id="cjgzrq" readonly="readonly"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">申请住房日期:</label>
                            <div class="col-sm-9">
                                <input type="text" name="cjgzrq" class="form-control"
                                       value="${teacher.sqzfrq}" size="10" id="sqzfrq" readonly="readonly"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">所在部门:</label>
                            <div class="col-sm-9">
                                <input type="text" name="szbm" class="form-control"
                                       value="${teacher.szbm}" size="10" id="szbm" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">籍贯:</label>
                            <div class="col-sm-9">
                                <input type="text" name="jg" class="form-control"
                                       value="${teacher.jg}" size="30" readonly="readonly"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">租房状态:</label>
                            <div class="col-sm-9">
                                <input type="text" name="zfzt" class="form-control"
                                       value="${teacher.zfzt}" size="4" readonly="readonly"></div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <button type="button" class="btn btn-primary" onclick="window.history.go(-1)">返回</button>
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

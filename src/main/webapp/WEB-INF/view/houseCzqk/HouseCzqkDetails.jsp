<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="shortcut icon" href="/resources/slxy.ico" type="image/x-icon"/>
<head>
    <title>租住情况详情</title>
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
                    <form onsubmit="false" role="form" id="addForm" class="form-horizontal">
                        <br>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">房间楼号:</label>
                            <div class="col-sm-6">
                                <input type="text" name="fjlh" class="form-control" id="fjlh" value="${houseCzqk.fjlh}"
                                       size="20" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">房间编号:</label>
                            <div class="col-sm-6">
                                <input type="text" name="fjbh" class="form-control" value="${houseCzqk.fjbh}" size="20"  readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">申请租住日期:</label>
                            <div class="col-sm-6">
                                <input type="text" id="sqzzrq" name="sqzzrq" class="form-control" value="${houseCzqk.sqzzrq}""
                                       size="10" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租住年限:</label>
                            <div class="col-sm-6">
                                <input type="text" name="zznx" id="zznx" class="form-control" value="${houseCzqk.zznx}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租住到期日期:</label>
                            <div class="col-sm-6">
                                <input type="text" id="zzdqrq" name="zzdqrq" class="form-control" value="${houseCzqk.zzdqrq}"
                                       readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">房间租住类型:</label>
                            <div class="col-sm-6">
                                <input type="text" name="fjzzlx" id="fjzzlx" class="form-control" value="${houseCzqk.fjzzlx}" readonly>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">房间面积:</label>
                            <div class="col-sm-6">
                                <input type="text" id="fjmj" name="fjmj" class="form-control" value="${houseCzqk.fjmj}"
                                       size="20" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">特殊房间系数:</label>
                            <div class="col-sm-6">
                                <input type="text" id="tszzxs" name="tszzxs" class="form-control" value="${houseCzqk.tszzxs}" size="8" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">是否属于双职工租住一个房子:<span class="must">*</span></label>
                            <div class="col-sm-6">
                                <input type="text" name="sfszg" id="sfszg" value="${houseCzqk.sfszg}" class="form-control" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">是否带小孩:</label>
                            <div class="col-sm-6">
                                <input type="text" name="sfcxqdxh"  id="sfcxqdxh" value="${houseCzqk.sfcxqdxh}" class="form-control" readonly/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租住教师所在部门:</label>
                            <div class="col-sm-6">
                                <input type="text" name="zzjsszbm" id="zzjsszbm" class="form-control" value="${houseCzqk.zzjsszbm}" readonly>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租住教师编号:</label>
                            <div class="col-sm-6">
                                <input type="text" name="zzjsbh" id="zzjsbh" class="form-control" value="${houseCzqk.zzjsbh}" readonly>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租住教师姓名:</label>
                            <div class="col-sm-6">
                                <input type="text" name="zzjsxm" id="zzjsxm" class="form-control" value="${houseCzqk.zzjsxm}" readonly>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">备注:</label>
                            <div class="col-sm-6">
                                <textarea  rows="2" name="bzsm" class="form-control" id="bzsm" readonly>${houseCzqk.bzsm}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">教师参加工作时间:</label>
                            <div class="col-sm-6">
                                <input type="text" id="jscjgzrq" name="jscjgzrq" class="form-control"
                                       value="${houseCzqk.jscjgzrq}" size="8" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">审批状态:</label>
                            <div class="col-sm-6">
                                <input type="text" id="spzt" name="spzt" class="form-control"
                                       value="${houseCzqk.spzt}" size="8" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">租房续租退房状态:</label>
                            <div class="col-sm-6">
                                <input type="text" id="zfxztfzt" name="zfxztfzt" class="form-control"
                                       value="${houseCzqk.zfxztfzt}" size="10" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-6 control-label">是否续租:</label>
                            <div class="col-sm-6">
                                <input type="text" id="sfxz" name="sfxz" class="form-control"
                                       value="${houseCzqk.sfxz}" size="10" readonly>
                            </div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <button
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
</html>

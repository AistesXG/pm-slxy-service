<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>费用详情页</title>
</head>
<body>
<div id="wrapper">
    <!--引入公共页面-->
    <jsp:include page="../common.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">计算费用</h2>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        费用详细信息
                        <input type="text" name="startTime" class="laydate-icon" value="" size="10"
                               id="startTime" readonly>
                        <input type="text" name="endTime" class="laydate-icon" value="" size="10"
                               id="endTime" readonly>
                        <button type="button" class="btn btn-primary" onclick="Caculation()">计算费用</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script>
!function () {
laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
laydate({elem: '#startTime'});//绑定开始时间
laydate({elem: '#endTime'});//绑定结束时间
}();

function Caculation() {
    var startTime = $('#startTime').val();
    var endTime  = $('#endTime').val();
    if(startTime == "" || endTime == "") {
        window.location.href = "/jump/jump404";
    }else {
        window.location.href = "/house/caculation?startTime=" + startTime + "&endTime=" + endTime;
    }
}


</script>
</html>

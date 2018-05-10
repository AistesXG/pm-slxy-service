<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
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
</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/jump/jumpHome">SLXY 房产管理 V1.0.0</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                </li>
                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                </li>
                <li class="divider"></li>
                <li><a href="/jump/jumpLogin"><i class="fa fa-sign-out fa-fw"></i>Logout</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li class="sidebar-search">
                    <div class="input-group custom-search-form">


                    </div>
                    <!-- /input-group -->
                </li>
                <li>
                    <a href="/jump/jumpHome"><i class="fa fa-dashboard fa-fw"></i>主页</a>
                </li>
                <li>
                    <a href="/admin/adminList"><i class="fa fa-wrench fa-fw"></i>用户管理</a>
                </li>
                <li>
                    <a href="/teacher/teacherList"><i class="fa fa-wrench fa-fw"></i>教师管理</a>
                </li>
                <li>
                    <a href="/zjhsbz/housePriceList"><i class="fa fa-wrench fa-fw"></i>房屋价格管理</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-edit fa-fw"></i>公用房管理</a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/housePub/housePubList">公用房信息管理</a>
                        </li>
                        <li>
                            <a href="/jump/jumpHousePubDetailOperate    ">公用房屋的图片样式详情</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-edit fa-fw"></i>教师用房管理</a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/house/houseList">教师用房信息管理</a>
                        </li>
                        <li>
                            <a href="/jump/jumpHouseDetailOperate">教师房屋的图片样式详情</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="/houseCzqk/HouseCzqkList"><i class="fa fa-wrench fa-fw"></i>住房情况管理</a>
                </li>
                <li>
                    <a href="#"><i class=" fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="#">Second Level Item</a>
                        </li>
                        <li>
                            <a href="#">Second Level Item</a>
                        </li>
                        <li>
                            <a href="#">Third Level <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>
                            </ul>
                            <!-- /.nav-third-level -->
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="blank.html">Blank Page</a>
                        </li>
                        <li>
                            <a href="login.html">Login Page</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>
</body>

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

</html>
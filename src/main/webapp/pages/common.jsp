<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>

    <!-- Bootstrap CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="/resources/css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="/resources/css/elegant-icons-style.css" rel="stylesheet"/>
    <link href="/resources/css/font-awesome.min.css" rel="stylesheet"/>
    <!-- full calendar css-->
    <link href="/resources/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet"/>
    <link href="/resources/assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet"/>
    <!-- easy pie chart-->
    <link href="/resources/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css"
          media="screen"/>
    <!-- owl carousel -->
    <link rel="stylesheet" href="/resources/css/owl.carousel.css" type="text/css">
    <link href="/resources/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
    <!-- Custom styles -->
    <link rel="stylesheet" href="/resources/css/fullcalendar.css">
    <link href="/resources/css/widgets.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
    <link href="/resources/css/style-responsive.css" rel="stylesheet"/>
    <link href="/resources/css/xcharts.min.css" rel=" stylesheet">
    <link href="/resources/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
</head>
<body>
<header class="header dark-bg">
    <div class="toggle-nav">
        <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"></div>
    </div>

    <!--logo start-->
    <a href="/pages/index.jsp" class="logo">SLXY <span class="lite">房产管理系统</span></a>
    <!--logo end-->

    <div class="nav search-row" id="top_menu">
        <!--  search form start -->
        <ul class="nav top-menu">
            <li>
                <form class="navbar-form">
                    <input class="form-control" placeholder="Search" type="text">
                </form>
            </li>
        </ul>
        <!--  search form end -->
    </div>

    <div class="top-nav notification-row">
        <!-- notificatoin dropdown start-->
        <ul class="nav pull-right top-menu">
            <!-- user login dropdown start-->
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                                <img alt="" src="../resources/img/avatar1_small.jpg">
                            </span>
                    <span class="username">Jenifer Smith</span>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu extended logout">
                    <div class="log-arrow-up"></div>
                    <li class="eborder-top">
                        <a href="#"><i class="icon_profile"></i> My Profile</a>
                    </li>
                    <li>
                        <a href="#"><i class="icon_mail_alt"></i> My Inbox</a>
                    </li>
                    <li>
                        <a href="#"><i class="icon_clock_alt"></i> Timeline</a>
                    </li>
                    <li>
                        <a href="#"><i class="icon_chat_alt"></i> Chats</a>
                    </li>
                    <li>
                        <a href="/login.jsp"><i class="icon_key_alt"></i> Log Out</a>
                    </li>
                    <li>
                        <a href="documentation.html"><i class="icon_key_alt"></i> Documentation</a>
                    </li>
                    <li>
                        <a href="documentation.html"><i class="icon_key_alt"></i> Documentation</a>
                    </li>
                </ul>
            </li>
            <!-- user login dropdown end -->
        </ul>
        <!-- notificatoin dropdown end-->
    </div>
</header>
<!--header end-->

<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
            <li class="active">
                <a class="" href="/pages/index.jsp">
                    <i class="icon_house_alt"></i>
                    <span>首页</span>
                </a>
            </li>
            <li class="sub-menu">
                <a href="javascript:;" class="">
                    <i class="icon_document_alt"></i>
                    <span>Forms</span>
                    <span class="menu-arrow arrow_carrot-right"></span>
                </a>
                <ul class="sub">
                    <li><a class="" href="form_component.html">Form Elements</a></li>
                    <li><a class="" href="form_validation.html">Form Validation</a></li>
                </ul>
            </li>
            <li class="sub-menu">
                <a href="javascript:;" class="">
                    <i class="icon_desktop"></i>
                    <span>UI Fitures</span>
                    <span class="menu-arrow arrow_carrot-right"></span>
                </a>
                <ul class="sub">
                    <li><a class="" href="general.html">Elements</a></li>
                    <li><a class="" href="buttons.html">Buttons</a></li>
                    <li><a class="" href="grids.html">Grids</a></li>
                </ul>
            </li>
            <li>
                <a class="" href="widgets.html">
                    <i class="icon_genius"></i>
                    <span>Widgets</span>
                </a>
            </li>
            <li>
                <a class="" href="chart-chartjs.html">
                    <i class="icon_piechart"></i>
                    <span>Charts</span>

                </a>

            </li>

            <li class="sub-menu">
                <a href="javascript:;" class="">
                    <i class="icon_table"></i>
                    <span>Tables</span>
                    <span class="menu-arrow arrow_carrot-right"></span>
                </a>
                <ul class="sub">
                    <li><a class="" href="basic_table.html">Basic Table</a></li>
                </ul>
            </li>

            <li class="sub-menu">
                <a href="javascript:;" class="">
                    <i class="icon_documents_alt"></i>
                    <span>Pages</span>
                    <span class="menu-arrow arrow_carrot-right"></span>
                </a>
                <ul class="sub">
                    <li><a class="" href="profile.html">Profile</a></li>
                    <li><a class="" href="login.html"><span>Login Page</span></a></li>
                    <li><a class="" href="blank.html">Blank Page</a></li>
                    <li><a class="" href="404.html">404 Error</a></li>
                </ul>
            </li>

        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->

<!-- javascripts -->
<script src="/resources/js/jquery.js"></script>
<script src="/resources/js/jquery-ui-1.10.4.min.js"></script>
<script src="/resources/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-ui-1.9.2.custom.min.js"></script>
<!-- bootstrap -->
<script src="/resources/js/bootstrap.min.js"></script>
<!-- nice scroll -->
<script src="/resources/js/jquery.scrollTo.min.js"></script>
<script src="/resources/js/jquery.nicescroll.js" type="text/javascript"></script>
<!-- charts scripts -->
<script src="/resources/assets/jquery-knob/js/jquery.knob.js"></script>
<script src="/resources/js/jquery.sparkline.js" type="text/javascript"></script>
<script src="/resources/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
<script src="/resources/js/owl.carousel.js"></script>
<!-- jQuery full calendar -->
<script src="/resources/js/fullcalendar.min.js"></script> <!-- Full Google Calendar - Calendar -->
<script src="/resources/assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
<!--script for this page only-->
<script src="/resources/js/calendar-custom.js"></script>
<script src="/resources/js/jquery.rateit.min.js"></script>
<!-- custom select -->
<script src="/resources/js/jquery.customSelect.min.js"></script>
<script src="/resources/assets/chart-master/Chart.js"></script>

<!--custome script for all page-->
<script src="/resources/js/scripts.js"></script>
<!-- custom script for this page-->
<script src="/resources/js/sparkline-chart.js"></script>
<script src="/resources/js/easy-pie-chart.js"></script>
<script src="/resources/js/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/resources/js/jquery-jvectormap-world-mill-en.js"></script>
<script src="/resources/js/xcharts.min.js"></script>
<script src="/resources/js/jquery.autosize.min.js"></script>
<script src="/resources/js/jquery.placeholder.min.js"></script>
<script src="/resources/js/gdp-data.js"></script>
<script src="/resources/js/morris.min.js"></script>
<script src="/resources/js/sparklines.js"></script>
<script src="/resources/js/charts.js"></script>
<script src="/resources/js/jquery.slimscroll.min.js"></script>
</body>
</html>
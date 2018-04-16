<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title>SLXY HOUSE MANAGER SYSTEM LOGIN VIEW</title>
	<link rel="stylesheet" href="${ctx}/resources/css/style.css">

		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Lambent Login Form Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
	<h1>商洛学院房产管理系统</h1>
	<div class="main-agileinfo">
		<h2>现在登录</h2>
		<form action="/login" method="post">
			<input type="text" name="user" class="name" placeholder="Username" required="">
			<input type="password" name="pass" class="password" placeholder="Password" required="">
			<ul>
				<li>
					<input type="checkbox" id="brand1" value="">
					<label for="brand1"><span></span>记得我</label>
				</li>
			</ul>
            <a href="#">忘记密码?
</a><br>
			<div class="clear"></div>
			<input type="submit" value="Login">
		</form>
	</div>
	<div class="footer-w3l">
		<p class="agile"> &copy; 2017 FRG 1003581879@qq.com</p>
	</div>
</body>
</html>
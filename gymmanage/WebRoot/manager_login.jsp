<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'manager_login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">


<!--- CSS --->
<link rel="stylesheet" href="./css/style.css" type="text/css" />


<!--- Javascript libraries (jQuery and Selectivizr) used for the custom checkbox --->

<!--[if (gte IE 6)&(lte IE 8)]>
		<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="selectivizr.js"></script>
		<noscript><link rel="stylesheet" href="fallback.css" /></noscript>
	<![endif]-->

</head>

<body>
	<div id="container">
		<form action="welcome.html">
			<div class="login">登录</div>
			<div class="username-text">用户名:</div>
			<div class="password-text">密码:</div>
			<div class="username-field">
				<input type="text" name="username"  placeholder="请输入用户名" />
			</div>
			<div class="password-field">
				<input type="password" name="password" placeholder="请输入密码" />
			</div>
			<input type="checkbox" name="remember-me" id="remember-me" /><label
				for="remember-me">记住我</label>
			<div class="forgot-usr-pwd">
				  <a href="#">忘记密码</a>?
			</div>
			<input type="submit" name="submit" value="GO" />
		</form>
	</div>
</body>
</html>
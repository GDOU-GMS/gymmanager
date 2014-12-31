<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'manager_login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">


<!--- CSS --->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" type="text/css" />


<!--- Javascript libraries (jQuery and Selectivizr) used for the custom checkbox --->

<!--[if (gte IE 6)&(lte IE 8)]>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/selectivizr.js"></script>
		<noscript><link rel="stylesheet" href="${pageContext.request.contextPath }/css/fallback.css" /></noscript>
	<![endif]-->

</head>

<body>
	<c:if test="${!empty message}">
		<script type="text/javascript">
			alert("${message}");
		</script>
	</c:if>
	<div class="top">
	   <img alt="" src="${pageContext.request.contextPath }/images/toplogo3.png"> 
	</div>
	<div id="container">
	<div class="login">登录</div>
		<form action="${pageContext.request.contextPath }/managerAction/loginCheck.action" method="post">
			<div class="username-text">用户名:</div>
			<div class="password-text">密码:</div>
			<div class="username-field">
				<input type="text" name="manager.account" value="1" placeholder="请输入用户名" />
			</div> 
			<div class="password-field">
				<input type="password" name="manager.password" value="1" placeholder="请输入密码" />
			</div>
			<div class="permission" >
				<input class="superAdmin" type="radio" name="manager.permission" value="superAdmin" ><span>超级管理员</span>
				<input class="manager" type="radio" name="manager.permission" value="manager" checked="checked" ><span>管理员</span>
			</div>
			<!-- <input type="checkbox" name="remember-me" id="remember-me" /><label
				for="remember-me">记住我</label> -->
			<div class="forgot-usr-pwd">
				  <a href="#">忘记密码</a>
			</div>
			<input type="submit" name="submit" value="GO" />
		</form>
	</div>
</body>
</html>

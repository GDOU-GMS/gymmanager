<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selfInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
  	<div class="pageContent">
  		<div class="pageFormContent" layoutH="56">
  			 <dl class="nowrap">
				<dt></dt>
				<dd>
				<a class="buttonActive" href="${pageContext.request.contextPath}/manager/updateSelfInfo.jsp"
				 target="dialog" width="750" height="500">
				<span>编辑个人信息</span></a>
			 </dd>
			</dl>
  			<p>
				<label>用户名：</label>
				<span>${manager.account}</span>
			</p>
			<p>
				<label>姓名：</label>
				<span>${manager.name}</span>
			</p>
			<p>
				<label>联系方式：</label>
				<span>${manager.telephone}</span>
			</p>
			<p>
				<label>生日：</label>
				<span>${manager.birthday}</span>
			</p>
			<p>
				<label>E-mail：</label>
				<span>${manager.email}</span>
			</p>
			<p>
				<label>家庭地址：</label>
				<span>${manager.address}</span>
			</p>
  		</div>
  	</div>
  </body>
</html>

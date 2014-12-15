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
  			<p>
				<label>用户名：</label>
				<input name="sn" type="text" size="30" value="100001" readonly="readonly"/>
			</p>
			<p>
				<label>姓名：</label>
				<input name="sn" type="text" size="30" value="100001" readonly="readonly"/>
			</p>
			<p>
				<label>联系方式：</label>
				<input name="sn" type="text" size="30" value="100001" readonly="readonly"/>
			</p>
			<p>
				<label>生日：</label>
				<input name="sn" type="text" size="30" value="100001" readonly="readonly"/>
			</p>
			<p>
				<label>E-mail：</label>
				<input name="sn" type="text" size="30" value="100001" readonly="readonly"/>
			</p>
			<p>
				<label>家庭地址：</label>
				<input name="sn" type="text" size="30" value="100001" readonly="readonly"/>
			</p>
  		</div>
  	</div>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatePassword.jsp' starting page</title>
    
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
		<form action="${pageContext.request.contextPath}/managerAction/updatePassword.action" 
		method="post" onsubmit="return validateCallback(this,navTabAjaxDone);">
	  		<div class="pageFormContent nowrap" layoutH="56">
	  			<dl>
					<dt>旧密码：</dt>
					<dd>
						<!--  <input name="oPassword" type="password" value="" size="30" />-->
						<input name="oPassword" type="password" value="" size="30" />
					</dd>
				</dl>
				<dl>
					<dt>新密码：</dt>
					<dd>
						<input name="nPassword" type="password" value="" size="30" />
					</dd>
					
				</dl>
				<dl>
					<dt>确定新密码：</dt>
					<dd>
						<input name="rnPassword" type="password" value=""size="30" />
					</dd>
				</dl>
				
	  		</div>
	  		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	  	</form>
  	</div>
    
  </body>
</html>

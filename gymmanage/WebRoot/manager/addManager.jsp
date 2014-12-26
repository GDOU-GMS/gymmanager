<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addManager.jsp' starting page</title>
    
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
		<form action="${pageContext.request.contextPath}/managerAction/addManager.action" 
		method="post" onsubmit="return validateCallback(this,dialogAjaxDone);">
	  		<div class="pageFormContent nowrap" layoutH="56">
	  			<dl>
					<dt>用户名：</dt>
					<dd>
						<input name="manager.account"  class="required"type="text" size="30" />
					</dd>
				</dl>
				<dl>
					<dt>姓名：</dt>
					<dd>
						<input name="manager.name" class="required" type="text" size="30" />
					</dd>
					
				</dl>
				<dl>
					<dt>联系方式：</dt>
					<dd>
						<input name="manager.telephone"class="phone textInput" type="text" size="30" />
					</dd>
				</dl>
				<dl>
					<!--  <dt>生日：</dt>
					<dd>
						<input name="manager.birthday" type="text" size="30" />
					</dd>-->
					<dt>生日：</dt>
					<dd>
						<input type="text" name="manager.birthday" class="date" readonly="true"/>
						<a class="inputDateButton" href="javascript:;">选择</a>
						<span class="info">日期格式为yyyy-MM-dd</span>
					</dd>
				
				</dl>
				<dl>
					<dt>E-mail：</dt>
					<dd>
						<input name="manager.email" class="email textInput" type="text" size="30" />
					</dd>
				</dl>
				<dl>
					<dt>家庭住址：</dt>
					<dd>
						<input name="manager.address" type="text" size="30" />
					</dd>
				</dl>
				
	  		</div>
	  		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	  	</form>
  	</div>
    
    
    
  </body>
</html>

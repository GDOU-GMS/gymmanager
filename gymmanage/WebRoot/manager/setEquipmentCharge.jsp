<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addEquipment.jsp' starting page</title>
    
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
<div class="page">
	<div class="pageContent">
		<form method="post" action="${pageContext.request.contextPath }/equipmentaction/setEquipmentCharge.action" 
		  class="pageForm required-validate" 
		   onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent nowrap" layoutH="80">
					<dl>
					<dt>器材收费标准号：</dt>
					<dd>
						<input type="text" name="equipmentCharge.id" class="required">
					</dd>
					
				<dl>
					<dt>器材收费标准：</dt>
					<dd>
						<input type="text" name="equipmentCharge.feescale" class="required">
					</dd>
					
				</dl>
					<dl>
					<dt>器材类型：</dt>
					<dd>
						<input type="text" name="equipmentCharge.type" class="required">
					</dd>
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>
  </body>
</html>

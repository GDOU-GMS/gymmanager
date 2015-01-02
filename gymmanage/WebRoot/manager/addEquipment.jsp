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
		<form method="post" action="${pageContext.request.contextPath }/equipmentaction/addEquipment.action" 
		  class="pageForm required-validate" 
		   onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent nowrap" layoutH="80">
					<dl>
					<dt>器材名称：</dt>
					<dd>
						<input type="text" name="equipment.name" class="required">
					</dd>
					
				</dl>	
				<dl>
					<dt>器材数量：</dt>
					<dd>
						<input type="text" name="equipment.totalNum" class="required">
					</dd>
					
				</dl>
					<dl>
					<dt>器材类型：</dt>
					<dd>
						<input type="text" name="equipment.type" class="required">
					</dd>
				</dl>
					<dl>
					<dt>器材类型号：</dt>
					<dd>
						<input type="text" name="equipment.typeId" class="required">
					</dd>
				</dl>
					<dl>
					<dt>是否维修：</dt>
					<dd>
						<input type="text" name="equipment.underRepair" class="required">
					</dd>
				</dl>
					<dl>
					<dt>是否可借：</dt>
					<dd>
						<input type="text" name="equipment.loanable" class="required">
					</dd>
				</dl>
					<p>
					<label>器材作用：</label>
					<textarea name="equipment.description" rows="10" cols="18" >
					</textarea>
				</p>
				
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

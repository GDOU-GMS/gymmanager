<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addEquipRent.jsp' starting page</title>
    
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
		<form method="post" action="${pageContext.request.contextPath }/equipmentaction/addEquipRentInfo.action" 
		  class="pageForm required-validate" 
		   onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent nowrap" layoutH="80">
					<dl>
					<dt>器材号：</dt>
					<dd>
						<input type="text" name="equipmentRents.id" class="required">
					</dd>
					
				</dl>
					<dl>
					<dt>租借号：</dt>
					<dd>
						<input type="text" name="equipmentRents.equipmentId" class="required">
					</dd>
					
				</dl>
					<dl>
					<dt>学号：</dt>
					<dd>
						<input type="text" name="equipmentRents.userId" class="required">
					</dd>
					
				</dl>	
				<dl>
					<dt>租借日期：</dt>
					<dd>
                        <input type="text" name="equipmentRents.startDate" class="date" readonly="true"/>
						<a class="inputDateButton" href="javascript:;">选择</a>
						<span class="info">日期格式为yyyy-MM-dd</span>					</dd>
					
				</dl>
					<dl>
					<dt>到期日期：</dt>
					<dd>
                        <input type="text" name="equipmentRents.endDate" class="date" readonly="true"/>
						<a class="inputDateButton" href="javascript:;">选择</a>
						<span class="info">日期格式为yyyy-MM-dd</span>					</dd>
				</dl>
				<dl>
					<dt>应付费用：</dt>
						<input type="text" name="equipmentRents.price" class="required">
				</dl>
				<dl>
				    <dt>状态</dt>
				    <dd>
				    <select name="equipmentRents.statue">
							<option value="undeleted" >未删除</option>
						</select>
				    </dd>
				</dl>
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

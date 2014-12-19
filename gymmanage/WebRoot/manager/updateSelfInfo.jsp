<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateSelfInfo.jsp' starting page</title>
    
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
		<form action="${pageContext.request.contextPath}/managerAction/updateManager.action?manager.id=${manager.id} " 
		method="post"onsubmit="return validateCallback(this, dialogAjaxDone);" >
	  		<div class="pageFormContent nowrap" layoutH="79">
	  			 <dl>
					<dt>用户名：</dt>
					<dd>
						<input name="manager.account" value="${manager.account }"type="text" size="30" />
					</dd>
				</dl> 
				<dl>
					<dt>姓名：</dt>
					<dd>
						<input name="manager.name" value="${manager.name}"type="text" size="30" />
					</dd>
					
				</dl>
				<dl>
					<dt>联系方式：</dt>
					<dd>
						<input name="manager.telephone"value="${manager.telephone}" type="text" size="30" />
					</dd>
				</dl>
				<dl>
					<dt>生日：</dt>
					<dd>
						<input name="manager.birthday" value="${manager.birthday}" type="text" size="30"/>
						<span class="info">生日日期的格式为2014/01/01</span>
					    
					
					</dd>
				</dl>
				<dl>
					<dt>E-mail：</dt>
					<dd>
						<input name="manager.email" value="${manager.email}" type="text" size="30" />
					</dd>
				</dl>
				<dl>
					<dt>家庭地址：</dt>
					<dd>
						<input name="manager.address" value="${manager.address}" type="text" size="30" />
					</dd>
				</dl>
				
			
		  			<!--  <p>
						<label>用户名：</label>
						<input name="manager.account" type="text" size="30" />
					</p>
					
					<p>
						<label>姓名：</label>
						<input name="manager.name" type="text" size="30" />
						
					</p>
					
					<p>
						<label>联系方式：</label>
						<input name="manager.telephone" type="text" size="30" />
					
					</p>
					<p>
						<label>生日：</label>
						<input name="manager.birthday" type="text" size="30"/>
						<span class="info">生日日期的格式为2014/01/01</span>
						
					</p>
					<p>
						<label>E-mail：</label>
						<input name="manager.email" type="text" size="30" />
						
					</p>
					<p>
						<label>家庭地址：</label>
						<input name="manager.address" type="text" size="30" />
						
					</p>-->
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

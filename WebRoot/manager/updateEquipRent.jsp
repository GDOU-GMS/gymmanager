<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<form method="post" action="${pageContext.request.contextPath }/equipmentaction/updateEquipRent.action" 
		  class="pageForm required-validate" 
		   onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent nowrap" layoutH="80">
			
				<input type="text" name="equipmentRents.id" value="${equipmentRents.id }" style="display:none;">
				<dl>
					<dt>学号：</dt>
					<dd>
						<input type="text" name="equipmentRents.studentNo" class="required  " minlength="12" maxlength="12" value="${equipmentRents.studentNo }">
					</dd>
					
				</dl>	
				<dl>
					<dt>选择器材</dt>
					<dd>
						<select name="equipmentRents.equipmentId">
							<c:forEach items="${EquipmentTypes }" var="equipmentType">
								<optgroup label="${equipmentType.type }">
									<c:forEach items="${equipments }" var="equipment">
										<c:if test="${equipmentType.id==equipment.typeId }">
											<option value="${equipment.id }" <c:if test="${equipmentRents.equipmentId eq equipment.id }">selected="selected"</c:if>  >${equipment.name }</option>
										</c:if>
									</c:forEach>
								</optgroup>
							</c:forEach>
						</select>
					</dd>
				</dl>
				
				<dl>
					<dt>数量：</dt>
					<dd>
						<input type="text" name="oldNum" class="required" value="${equipmentRents.num }" style="display: none;">
						<input type="text" name="equipmentRents.num" class="required" value="${equipmentRents.num }">
					</dd>
					
				</dl>	
				<dl>
					<dt>租借日期：</dt>
					<dd>
                        <input type="text" name="equipmentRents.startDate" class="date" readonly="true" value="${equipmentRents.startDate }"/>
						<a class="inputDateButton" href="javascript:;">选择</a>
						<span class="info">日期格式为yyyy-MM-dd</span>					</dd>
					
				</dl>
					<dl>
					<dt>到期日期：</dt>
					<dd>
                        <input type="text" name="equipmentRents.endDate" class="date" readonly="true" value="${equipmentRents.endDate }"/>
						<a class="inputDateButton" href="javascript:;">选择</a>
						<span class="info">日期格式为yyyy-MM-dd</span>					</dd>
				</dl>
				<!-- <dl>
					<dt>应付费用：</dt>
						<input type="text" name="equipmentRents.price" class="required">
				</dl> -->
				<dl>
				    <dt>状态</dt>
				    <dd>
				    <select name="equipmentRents.statue">
							<option value="unpassed" >未过期</option>
							<!-- <c:if test="${equipmentRents.statue eq 'unpassed' }">
								<option value="${equipmentRents.statue }">未过期</option>
							</c:if>
							<c:if test="${equipmentRents.statue eq 'passed' }">
								<option value="${equipmentRents.statue }">已过期</option>
							</c:if> -->
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

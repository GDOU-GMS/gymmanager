<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'EquipmentRentQuery.jsp' starting page</title>
    
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
      <form id="pagerForm" method="post"
		action="${pageContext.request.contextPath }/equipmentaction/getAllEquipmentRent.action">
		<input type="hidden" name="pageNum" value="1" />
		<!--【必须】value=1可以写死-->
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<!--【可选】每页显示多少条-->
		<%-- <input type="hidden" name="status" value="${param.status}"> 
		<input type="hidden" name="keywords" value="${param.keywords}" /> 
		<input type="hidden" name="orderField" value="${param.orderField}" /><!--【可选】查询排序--> --%>
	</form>
  
  
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" 
		    action="${pageContext.request.contextPath }/equipmentaction/queryEquipmentRent.action"
		     method="post">
		<input type="hidden" id="selectedId_demo"/>
		<div class="searchBar">
			<table class="searchContent">
					<tr>
						<td>学号：<input type="text" name="equipmentRents.studentNo" />
						</td>
						<td>状态:</td>
						<td><select  name="equipmentRents.statue">
								<option value="none">--请选择--</option>
								<option value="unpassed">未过期</option>
								<option value="passed">已过期</option>
						</select></td>
					</tr>
				</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				</ul>
			</div>
		</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${pageContext.request.contextPath }/equipmentaction/getDataForaddequipRentQuery.action" 
				target="navTab"><span>添加</span></a></li>
				<li><a class="add" href="${pageContext.request.contextPath }/equipmentaction/recoverEquipRent.action?id={equipmentRent}"
				 target="ajaxTodo"><span>归还</span></a></li>
				<li><a class="edit" href="${pageContext.request.contextPath }/equipmentaction/getDateForupdateEquipRent.action?id={equipmentRent}"
				 target="navTab"><span>修改</span></a></li>
				<%-- <li><a class="delete" href="${pageContext.request.contextPath }/equipmentaction/deleteEquipmentInfo.action?id={equipmentRent}" 
				target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li> --%>
				<li><a class="delete" href="${pageContext.request.contextPath }/equipmentaction/dealpassedEquipRent.action"
				 target="ajaxTodo"><span>一件处理到期</span></a></li>
				
				<li class="line">line</li>
			</ul>
		</div>
		<table class="table" layouth="142">
			<thead>
				<tr>
					<th style="width:120px;">租借号</th>
					<th style="width:100px;">学号</th>
					<th style="width:100px;">用户名</th>
					<th style="width:140px;">器材名称</th>
					<th style="width:140px;">数量</th>
					<th style="width:120px;">应付款</th>
					<th style="width:150px;">租借日期</th>
					<th style="width:150px;">到期日期</th>
					<th style="width:150px;">器材状态</th>
				</tr>
			</thead>
			<tbody>
			   <c:forEach items="${page.list }"  var="equipmentRent">
				<tr target="equipmentRent" rel="${equipmentRent.id}">
					<td>${equipmentRent.id}</td>
					<td>${equipmentRent.studentNo}</td>
					<td>${equipmentRent.username}</td>
					<td>${equipmentRent.equipmentname}</td>
					<td>${equipmentRent.num}</td>
					<td>${equipmentRent.price}</td>
					<td>${equipmentRent.startDate}</td>
					<td>${equipmentRent.endDate}</td>
					<td>
					<c:if test="${equipmentRent.statue eq 'unpassed' }"><span>未到期</span></c:if>
					<c:if test="${equipmentRent.statue eq 'passed' }"><span style="color: red;">已到期</span></c:if>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="panelBar">
			<div class="pages">
				<span>显示</span> <select class="combox" name="numPerPage"
					onchange="navTabPageBreak({numPerPage:this.value})">
					<option value="20">20</option>
					<option value="10">10</option>
					<option value="50">50</option>
					<option value="100">100</option>
					<option value="200">200</option>
				</select> <span>条，共${page.totalRecord}条</span>
			</div>

			<div class="pagination" targetType="navTab"
				totalCount="${page.totalRecord}" numPerPage="${page.pageSize }"
				pageNumShown="10" currentPage="${page.pageNum }"></div>

		</div>
	</div>

  </body>
</html>

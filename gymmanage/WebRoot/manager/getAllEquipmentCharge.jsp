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
    
    <title>My JSP 'getAllEquipment.jsp' starting page</title>
    
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
		action="${pageContext.request.contextPath }/equipmentaction/getAllEquipmentCharge.action">
		<input type="hidden" name="pageNum" value="1" />
		<!--【必须】value=1可以写死-->
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<!--【可选】每页显示多少条-->
		<%-- <input type="hidden" name="status" value="${param.status}"> 
		<input type="hidden" name="keywords" value="${param.keywords}" /> 
		<input type="hidden" name="orderField" value="${param.orderField}" /><!--【可选】查询排序--> --%>
	</form>
  
   	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${pageContext.request.contextPath }/equipmentaction/queryEquipmentCharge.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>器材类型：<input type="text" name="equipmentCharge.type" />
						</td>
					</tr>
				</table>
				<div class="subBar">
					<ul>
						<li><div class="buttonActive">
								<div class="buttonContent">
									<button type="submit">检索</button>
								</div>
							</div></li>
					</ul>
				</div>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add"
					href="${pageContext.request.contextPath }/equipmentaction/getDataForsetEquipmentCharge.action?id={equipmentCharges}"
					target="navTab"><span>设置器材收费标准</span></a></li>
				<li><a class="delete"
					href="${pageContext.request.contextPath }/equipmentaction/deleteEquipmentCharge.action?id={equipmentCharges}"
					target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<%-- <li><a class="edit"
					href="${pageContext.request.contextPath}/equipmentaction/updateEquipmentCharge.action?id={equipmentCharges}"
					target="navTab"><span>修改</span></a></li> --%>
			</ul>
		</div>
		<table class="table" width="100%" layoutH="138">
			<thead>
				<tr>
					<th width="80">器材收费标准号</th>
					<th width="150">器材收费标准</th>
					<th width="150">器材类型</th>
				</tr>
			</thead>
			<tbody>
			 	<c:forEach items="${page.list}" var="equipmentCharges">
					<tr target="equipmentCharges" rel="${equipmentCharges.id}">
						<td>${equipmentCharges.id}</td>
						<td>${equipmentCharges.feescale}</td>
						<td>${equipmentCharges.type}</td>
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

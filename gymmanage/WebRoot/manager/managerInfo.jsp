<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'managerInfo.jsp' starting page</title>
    
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
    <div class="pageHeader">
	<form id="pagerForm" action="${pageContext.request.contextPath}/managerAction/getManagers.action"
	 method="post"onsubmit="return navTabSearch(this);" >
	   <input type="hidden" name="pageNum" value="1" />
		<!--【必须】value=1可以写死-->
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<!--【可选】每页显示多少条-->
		<%-- <input type="hidden" name="status" value="${param.status}"> 
		<input type="hidden" name="keywords" value="${param.keywords}" /> 
		<input type="hidden" name="orderField" value="${param.orderField}" /><!--【可选】查询排序--> --%>
    </from>
	<div class="searchBar">
	<form rel="pagerForm" action="${pageContext.request.contextPath}/managerAction/getManagers.action" method="post" 
	   onsubmit="return navTabSearch(this);">
		<table class="searchContent">
			<tr>
				<td>
					用户名：<input type="text" id="account" name="account">
				</td>
				<td>
					姓名：<input type="text" id="name" name="name">
				</td>
				
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
			 </ul>
		</div>
	</div>
	</form>
</div>
  <div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="delete"
				href="${pageContext.request.contextPath}/manager/addManager.jsp" target="dialog"width="750" height="400"
				 ><span>添加</span></a></li>
			</span></a></li>
			<li><a class="delete"
				href="${pageContext.request.contextPath}/managerAction/deleteManager.action?id={managerId}" target="ajaxTodo"
				title="确定要删除吗?" ><span>删除</span></a></li>
			</span></a></li>
			
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80"align="center">序号</th>
				<th width="120"align="center">用户名</th>
				<th  width="120"align="center">姓名</th>
				<th width="100"align="center">联系方式</th>
				<th width="100"align="center">生日</th>
				<th width="150"align="center">E_mail</th>
				<th width="80" align="center">家庭地址</th>
			</tr>
		</thead>
		<tbody>
			<!--<c:forEach var="manager" items="${listManager}">
				<tr target="managerId" rel="${manager.id}">
					<td>${manager.id}</td>
					<td>${manager.account}</td>
					<td>${manager.name}</td>
					<td>${manager.telephone}</td>
					<td>${manager.birthday}</td>
					<td>${manager.email}</td>
					<td>${manager.address}</td>
				</tr>
			</c:forEach>-->
			<c:forEach var="manager" items="${page.list}">
				<tr target="managerId" rel="${manager.id}">
					<td>${manager.id}</td>
					<td>${manager.account}</td>
					<td>${manager.name}</td>
					<td>${manager.telephone}</td>
					<td>${manager.birthday}</td>
					<td>${manager.email}</td>
					<td>${manager.address}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共${page.totalRecord}条</span>
		</div>
		
		<div class="pagination" targetType="navTab"
				totalCount="${page.totalRecord}" numPerPage="${page.pageSize}"
				pageNumShown="10" currentPage="${page.pageNum}"></div>

	</div>
</div>
    
  </body>
</html>

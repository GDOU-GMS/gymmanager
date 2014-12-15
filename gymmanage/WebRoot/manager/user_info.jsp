<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">

  $("#studentNo").val("${studentNo}")
  $("#name").val("${name}")
  $("#academy").val("${academy}")
  


</script>

<div class="pageHeader">
	<form action="${pageContext.request.contextPath}/manager/getUsers.action" method="post" onsubmit="return navTabSearch(this);" >
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					用户名：<input type="text" id="studentNo" name="studentNo">
				</td>
				<td>
					姓名：<input type="text" id="name" name="name">
				</td>
				<td>
					学院：<input type="text" id="academy" name="academy">
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
				href="${pageContext.request.contextPath}/manager/deleteUser.action?id={userId}" target="ajaxTodo"
				title="确定要删除吗?"><span>删除</span></a></li>
			</span></a></li>
			
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80"align="center">序号</th>
				<th width="120"align="center">用户名</th>
				<th  width="120"align="center">姓名</th>
				<th width="100"align="center">学院</th>
				<th width="100"align="center">专业</th>
				<th width="150"align="center">班级</th>
				<th width="80" align="center">性别</th>
				<th width="80"align="center">联系方式</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${listUsers}">
				<tr target="userId" rel="${user.id}">
					<td>${user.id}</td>
					<td>${user.studentNo}</td>
					<td>${user.name}</td>
					<td>${user.academy}</td>
					<td>${user.major}</td>
				    <td>${user.className}</td>
				    <td>${user.gender}</td>
				    <td>${user.telephone}</td>
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
			<span>条，共${totalCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="200" numPerPage="20" pageNumShown="10" currentPage="1"></div>

	</div>
</div>
<c:remove var="qresult" scope="session" />

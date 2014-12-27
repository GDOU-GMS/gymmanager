<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'getAllSiteOrder.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

</head>

<body>
	<form id="pagerForm" method="post"
		action="${pageContext.request.contextPath }/site/getAllEvents.action">
		<input type="hidden" name="pageNum" value="1" />
		<!--【必须】value=1可以写死-->
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<!--【可选】每页显示多少条-->
		<%-- <input type="hidden" name="status" value="${param.status}"> 
		<input type="hidden" name="keywords" value="${param.keywords}" /> 
		<input type="hidden" name="orderField" value="${param.orderField}" /><!--【可选】查询排序--> --%>
	</form>

	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${pageContext.request.contextPath }/events/queryEvents.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>赛事名称：<input type="text" name="events.name" />
						</td>
						<td>场地名称：<input type="text" name="sitename" />
						</td>
						<td>状态</td>
						<td><select class="combox" name="events.statue">
								<option value="none">--请选择--</option>
								<option value="unpassed">未过期</option>
								<option value="passed">已过期</option>
						</select></td>
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
					href="${pageContext.request.contextPath }/events/getDataForAddEvents.action"
					target="navTab"><span>添加</span></a></li>
				<li><a class="edit"
					href="${pageContext.request.contextPath}/events/getDataForUpdateEvents.action?id={events}"
					target="navTab"><span>修改</span></a></li>
				<li><a class="delete"
					href="${pageContext.request.contextPath }/events/deleteEvents.action?id={events}"
					target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
					<li><a class="delete"
					href="${pageContext.request.contextPath }/events/dealPassed.action"
					target="ajaxTodo" title="确定要处理过期吗?"><span>一键处理过期</span></a></li>
			</ul>
		</div>
		<table class="table" width="100%" layoutH="138">
			<thead>
				<tr>
					<th width="60">赛事ID</th>
					<th width="60">赛事名称</th>
					<th width="120">赛事时间</th>
					<th width="80">赛事地点</th>
					<th width="200">赛事描述</th>
					<th width="60">状态</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.list }" var="events">
					<tr target="events" rel="${events.id}">
						<td>${events.id }</td>
						<td>${events.name }</td>
						<td>${events.startTime }~${events.endTime }</td>
						<td>${events.sitename }</td>
						<td>${events.description }</td>
						<td>
							<c:if test="${events.statue eq 'passed' }" ><p style="color:red;">已过期</p></c:if>
							<c:if test="${events.statue eq 'unpassed' }"><P>未过期</P></c:if>
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

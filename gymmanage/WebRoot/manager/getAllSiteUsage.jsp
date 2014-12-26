<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'getAllSiteUsage.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

</head>

<body>
	<form id="pagerForm" method="post"
		action="${pageContext.request.contextPath }/site/getAllSiteOrder.action">
		<input type="hidden" name="pageNum" value="1" />
		<!--【必须】value=1可以写死-->
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<!--【可选】每页显示多少条-->
		<%-- <input type="hidden" name="status" value="${param.status}"> 
		<input type="hidden" name="keywords" value="${param.keywords}" /> 
		<input type="hidden" name="orderField" value="${param.orderField}" /><!--【可选】查询排序--> --%>
	</form>

	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${pageContext.request.contextPath }/site/querySiteUsage.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>场地名称：<input type="text" name="site.name" />
						</td>
						<td>用户名称：<input type="text" name="username" />
						</td>
						<td>状态</td>
						<td><select class="combox" name="siteUsage.statue">
								<option value="none">--请选择--</option>
								<option value="notimeout">未超时</option>
								<option value="timeout">已超时</option>
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
					<%--  <li><a class="button" href="${pageContext.request.contextPath }/manager/advancedSearchSiteOrder.jsp" target="dialog"
							mask="true" title="查询框"><span>高级检索</span></a></li> --%>
					</ul>
				</div>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add"
					href="${pageContext.request.contextPath }/site/getDataForAddSiteUsage.action"
					target="navTab"><span>添加</span></a></li>
				<li><a class="edit"
					href="${pageContext.request.contextPath}/site/getDataForUpdateSiteUsage.action?id={siteUsage}"
					target="navTab"><span>修改</span></a></li>
				<li><a class="delete"
					href="${pageContext.request.contextPath }/site/deleteSiteUsage.action?id={siteUsage}"
					target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li><a class="delete"
					href="${pageContext.request.contextPath }/site/dealTimeOutSiteUsage.action"
					target="ajaxTodo" title="确定要处理吗?"><span>处理到时间场地</span></a></li>
				<li><a class="delete"
					href="${pageContext.request.contextPath }/site/deleteAllTimeOutSiteUsage.action"
					target="ajaxTodo" title="确定要删除吗?"><span>删除到时间的所有场地使用</span></a></li>
				<%-- <li><a class="edit"
					href="${pageContext.request.contextPath}/site/getDataForUpdateSiteOrder.action?id={siteOrder}"
					target="ajaxTodo"><span>使用</span></a></li> --%>
			</ul>
		</div>
		<table class="table" width="100%" layoutH="138">
			<thead>
				<tr>
					<th width="80">ID</th>
					<th width="80">学号</th>
					<th width="100">预约用户</th>
					<th width="120">开始时间</th>
					<th width="120">结束时间</th>
					<th width="120">使用场地</th>
					<th width="120">总价</th>
					<th width="100">状态</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.list }" var="siteUsage">
					<tr target="siteUsage" rel="${siteUsage.id}">
						<td>${siteUsage.id }</td>
						<td>${siteUsage.studentNo }</td>
						<td>${siteUsage.username }</td>
						<td>${siteUsage.stratTime }</td>
						<td>${siteUsage.endTime }</td>
						<td>${siteUsage.sitename }</td>
						<td>${siteUsage.price }</td>
						<td>
							<c:if test="${siteUsage.statue eq 'timeout' }" ><p style="color:red;">已超时</p></c:if>
							<c:if test="${siteUsage.statue eq 'notimeout' }"><p>未超时</p></c:if>
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

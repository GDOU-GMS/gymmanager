<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'getAllNotice.jsp' starting page</title>

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
		<form onsubmit="return navTabSearch(this);" action="${pageContext.request.contextPath }/notice/queryNotice.action" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>公告标题：<input type="text" name="notice.title" />
						</td>
						<td>查询时间：<input type="text" name="startTime" class="date" readonly="true"/>
						</td>
						<td>到：<input type="text" name="endTime" class="date" readonly="true"/>
						</td>
					</tr>
				</table>
				<div class="subBar">
					<ul>
						<li>
							<div class="buttonActive">
								<div class="buttonContent">
									<button type="submit">检索</button>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add"
					href="${pageContext.request.contextPath }/manager/addNotice.jsp"
					target="navTab"><span>添加</span></a></li>
				<li><a class="edit"
					href="${pageContext.request.contextPath}/notice/getDataForUpdateNotice.action?id={notice}"
					rel="updateNotice"
					target="navTab"><span>修改</span></a></li>
				<li><a class="delete"
					href="${pageContext.request.contextPath }/notice/deleteNotice.action?id={notice}"
					target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			</ul>
		</div>
		<table class="table" width="100%" layoutH="138">
			<thead>
				<tr>
					<th width="60">公告ID</th>
					<th width="60">公告标题</th>
					<th width="60">公告内容</th>
					<th width="60">公告时间</th>
					<th width="60">查看详情</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.list }" var="notice">
					<tr target="notice" rel="${notice.id}">
						<td>${notice.id }</td>
						<td>${notice.title }</td>
						<%-- <td>${notice.content }</td> --%>
						<td>请查看详情</td>
						<td>${notice.time }</td>
						<td><a href="${pageContext.request.contextPath }/notice/showNoticeDetail.action?id=${notice.id}" target="navTab" >查看详情</a></td>
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

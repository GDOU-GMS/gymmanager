<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'getAllSiteOrder.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

</head>

<body>
	<%-- <form id="pagerForm" method="post"
		action="${pageContext.request.contextPath }/site/getAllSiteOrder.action">
		<input type="hidden" name="pageNum" value="1" />
		<!--【必须】value=1可以写死-->
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<!--【可选】每页显示多少条-->
		<input type="hidden" name="status" value="${param.status}"> 
		<input type="hidden" name="keywords" value="${param.keywords}" /> 
		<input type="hidden" name="orderField" value="${param.orderField}" /><!--【可选】查询排序-->
	</form> --%>


	<div class="pageHeader">
		<!-- <form onsubmit="return navTabSearch(this);" action="#" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>场地名称：<input type="text" name="keyword" />
						</td>
						<td>用户名称：<input type="text" name="keyword" />
						</td>
						<td>预约开始时间：<input type="text" name="keyword" />
						</td>
						<td>~</td>
						<td>结束时间：<input type="text" name="keyword" />
						</td>
						<td>状态</td>
						<td><select class="combox" name="site.statue">
								<option value="noon">--请选择--</option>
								<option value="undeleted">未删除</option>
								<option value="deleted">已删除</option>
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
						<li><a class="button" href="demo_page6.html" target="dialog"
							mask="true" title="查询框"><span>高级检索</span></a></li>
					</ul>
				</div>
			</div>
		</form> -->
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				
				<li><a class="add"
					href="#"
					target="ajaxTodo"><span>投入使用</span></a></li>
				<li><a class="delete"
					href="${pageContext.request.contextPath }/site/dealBreach.action"
					target="ajaxTodo"><span>处理过期预约</span></a></li>
				<%-- <li><a class="delete"
					href="${pageContext.request.contextPath }/site/deleteSiteOrder.action?id={siteOrder}"
					target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li><a class="edit"
					href="${pageContext.request.contextPath}/site/getDataForUpdateSiteOrder.action?id={siteOrder}"
					target="navTab"><span>修改</span></a></li>
				<li><a class="edit"
					href="${pageContext.request.contextPath}/site/getDataForUpdateSiteOrder.action?id={siteOrder}"
					target="ajaxTodo"><span>使用</span></a></li> --%>
			</ul>
		</div>
		<table class="table" width="100%" layoutH="138">
			<thead>
				<tr>
					<th width="80">预约ID</th>
					<th width="80">学号</th>
					<th width="100">预约用户</th>
					<th width="120">预约开始时间</th>
					<th width="120">预约结束时间</th>
					<th width="120">预定场地</th>
					<th width="100">预约时间</th>
					<th width="100">状态</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${siteOrders }" var="siteOrder">
					<tr target="siteOrder" rel="${siteOrder.id}">
						<td>${siteOrder.id }</td>
						<td>${siteOrder.studentNo }</td>
						<td>${siteOrder.username }</td>
						<td>${siteOrder.stratTime }</td>
						<td>${siteOrder.endTime }</td>
						<td>${siteOrder.sitename }</td>
						<td>${siteOrder.orderTime }</td>
						<td>${siteOrder.statue }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%-- <div class="panelBar">
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

		</div> --%>
	</div>

</body>
</html>

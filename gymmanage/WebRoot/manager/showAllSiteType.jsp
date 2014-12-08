<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'showAllSiteType.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

	
<style type="text/css">
.container{
	margin-top: 50px;
}
table {
	border-spacing: 0;
	border-collapse: collapse;
}

.table {
	border-collapse: collapse !important;
}
tr {
	text-align: center;
}
</style>
</head>

<body>

	<div class="container">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<table class="table">
				<tr>
					<td>类型名称</td>
					<td>修改</td>
					<td>删除</td>
				</tr>
				<c:forEach items="${siteTypes }" var="siteType">
					<tr>
						<td>${siteType.type }</td>
						<td><a href="#">修改</a></td>
						<td><a href="#">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>

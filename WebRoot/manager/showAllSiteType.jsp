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
.container {
	margin-top: 50px;
}

body,table {
	font-size: 12px;
}

table {
	table-layout: fixed;
	empty-cells: show;
	border-collapse: collapse;
	margin: 0 auto;
}
tr{
text-align: center;
}

td {
	height: 30px;
}
.table {
	border: 1px solid #cad9ea;
	color: #666;
}

.table th {
	background-repeat: repeat-x;
	height: 30px;
}

.table td,.table th {
	border: 1px solid #cad9ea;
	padding: 0 1em 0;
}

.table tr.alter {
	background-color: #f5fafe;
}
}
</style>
</head>

<body>

	<div class="container">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<table class="table" width="50%">
				<tr>
					<th>类型名称</th>
					<th>修改</th>
					<th>删除</th>
				</tr>
				<c:forEach items="${siteTypes }" var="siteType">
					<tr  class="alter">
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

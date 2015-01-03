<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

</head>

<body>

	

	<div class="pageHeader">
		
	</div>
	<div class="pageContent"  >
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add"
					href="${pageContext.request.contextPath }/manager/addEquipmentType.jsp"
					target="dialog"><span>添加</span></a></li>
				<li><a class="delete"
					href="${pageContext.request.contextPath }/equipmentaction/deleteEquipmentType.action?id={equipmentType}"
					target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li><a class="edit" href="${pageContext.request.contextPath }/equipmentaction/getDataForUpdateEquipmentType.action?id={equipmentType}"
					target="dialog"><span>修改</span></a></li>
				<!-- <li class="line">line</li>
				<li><a class="icon" href="demo/common/dwz-team.xls"
					target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li> -->
			</ul>
		</div>
		<table class="table" width="100%" layoutH="138">
			<thead>
				<tr>
					<th width="80"></th>
					<th width="120">器材类型ID</th>
					<th>类型名称</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${equipmentTypes }" var="equipmentType">
					<tr target="equipmentType" rel="${equipmentType.id }">
						<td>器材类型</td>
						<td>${equipmentType.id }</td>
						<td>${equipmentType.type}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>

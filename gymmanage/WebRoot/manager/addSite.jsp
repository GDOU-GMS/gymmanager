<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>addSite</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

</head>

<body>
	<h2 class="contentTitle">添加场地类型</h2>


	<div class="pageContent">

		<form method="post"
			action="${pageContext.request.contextPath }/site/addSite.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this,navTabAjaxDone)">
			<div class="pageFormContent nowrap" layoutH="97">
				<dl>
					<dt>场地类型</dt>
					<dd>
						<select name="site.typeId">
							<c:forEach items="${siteTypes }" var="siteType">
								<option value="${siteType.id}" >${siteType.type}</option>
							</c:forEach>
						</select>
					</dd>
					
				</dl>
				<dl>
					<dt>名称</dt>
					<dd>
						<input type="text" name="site.name" class="required">
					</dd>
					
				</dl>
				<dl>
					<dt>收费标准</dt>
					<dd>
						<input type="text" name="site.feeScale" class="number required">元/小时
					</dd>
					
				</dl>
				<dl>
					<dt>状态</dt>
					<dd>
						<select name="site.statue">
							<option value="undeleted" >未删除</option>
						</select>
					</dd>
					
				</dl>
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">提交</button>
							</div>
						</div></li>
					<li><div class="button">
							<div class="buttonContent">
								<button type="button" class="close">取消</button>
							</div>
						</div></li>
				</ul>
			</div>
		</form>

	</div>
</body>
</html>

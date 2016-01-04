<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>updateSiteType</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />



</head>

<body>
	<h2 class="contentTitle">修改器材类型</h2>


	<div class="pageContent">
		<form method="post"
			action="${pageContext.request.contextPath }/equipmentaction/updateEquipmentType.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this,dialogAjaxDone)">
			<div class="pageFormContent nowrap" layoutH="97">
				<dl>
					<dt>请修改器材类型名称</dt>
					<dd>
						<input type="text" name="equipmentType.type" class="required" value="${equipmentType.type}"> 
						<input type="text" name="equipmentType.id" class="required" value="${equipmentType.id}" style="display: none;">
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

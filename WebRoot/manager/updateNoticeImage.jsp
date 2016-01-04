<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>addNotice</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

</head>

<body>
	<h2 class="contentTitle">添加公告</h2>


	<div class="pageContent">

		<form method="post"
			action="${pageContext.request.contextPath }/notice/updateNoticeImage.action"
			class="pageForm required-validate"
			enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogAjaxDone);" >
			<div class="pageFormContent nowrap" layoutH="97">
			<input type="text" name="id" value="${param.id }" style="display: none;">
				<dl>
					<dt>选择新图片：</dt>
					<dd>
						<input type="file" name="noticeImage"  />
					</dd>
					
				</dl>
			</div>
			
			<div class="formBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit" onclick="closeNavTab()">提交</button>
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

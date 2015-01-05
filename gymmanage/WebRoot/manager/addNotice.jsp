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
			action="${pageContext.request.contextPath }/notice/addNotice.action"
			class="pageForm required-validate"
			enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,navTabAjaxDone);" 
			>
			<div class="pageFormContent nowrap" layoutH="97">
				<dl>
					<dt>公告标题：</dt>
					<dd>
						<input name="notice.title" type="text" class="required" style="width: 450px;">
					</dd>
				</dl>
				<dl>
					<dt>公告内容：</dt>
					<dd>
						<textarea rows="10" cols="72" name="notice.content"  class="required"></textarea>
					</dd>
				</dl>
				<dl>
					<dt>公告图片：</dt>
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

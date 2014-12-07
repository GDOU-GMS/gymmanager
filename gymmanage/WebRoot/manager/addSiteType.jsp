<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'addSiteType.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">



</head>

<body>
	<div id="container">
		<div class="form" style="margin: 100px;">
			<form action="${pageContext.request.contextPath }/site/addSiteType.action" class="form">
				请输入场地类型名称：<input type="text" name="siteType.type"><br><br>
				 <input type="submit" name="submit" value="提交">
			</form>
		</div>
	</div>
</body>
</html>

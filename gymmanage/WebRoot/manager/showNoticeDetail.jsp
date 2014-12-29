<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showNoticeDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<style type="text/css">
	label {
		font-size: 15px;
		line-height: 22px;
	}
	.text{
		width: 600px;
	}
	</style>
  </head>
  
  <body>
    <div id="container">
    	<div class="text">
    		<label>ID:</label>
    		<label>${notice.id }</label><hr>
    		<label>标题:</label>
    		<label>${notice.title }</label><hr>
    		<label>内容:</label><br>
    		<label>${notice.content }</label><hr>
    		<label>时间:</label>
    		<label>${notice.time }</label><hr>
    		<label>图片如下：</label><br>
    	</div>
    	<div>
    		<img src="${pageContext.request.contextPath }/upload/${notice.image}">
    	</div>
    </div>
  </body>
</html>

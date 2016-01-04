<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

       <script src="${pageContext.request.contextPath }/js/dateTimePicker.js" type="text/javascript" language="javascript"></script>
  </head>
  
  <body>
    <input name="txtDate" type="text" value="2008-12-15 23:34:23" style="hpadding-left:5px;" id="txtDate" onclick="SetDate(this,'yyyy-MM-dd hh:mm:ss')" readonly="readonly" />
    <input name="txtDate1" type="text" style="padding-left:5px; width: 200px;" id="txtDate" onclick="SetDate(this,'yyyy-MM-dd hh:mm')" readonly="readonly" />
    <input name="txtDate2" type="text" style="padding-left:5px;" id="txtDate" onclick="SetDate(this)" readonly="readonly" />
    <input name="txtDate3" type="button" style="padding-left:5px;" id="txtDate" onclick="SetDate(document.all.txtDate2,'yyyy-MM-dd')" readonly="readonly" />
  </body>
</html>

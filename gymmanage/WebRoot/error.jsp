<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Bootstrap 101 Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/media/css/bootstrap.min.css" rel="stylesheet" media="screen">
  </head>
  <body>
    <div class="hero-unit">
        <h2>出错了</h2>
        <p>${message }</p>
        <p><a href="#" class="btn btn-primary btn-large">返回首页</a></p>
	</div>
    <script src="${pageContext.request.contextPath }/media/js/jquery-1.10.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/media/js/bootstrap.min.js"></script>
  </body>
</html>

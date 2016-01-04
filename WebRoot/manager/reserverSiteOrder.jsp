<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>reserverSiteOrder</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

</head>

<body>
	<h2 class="contentTitle">添加场地预约</h2>


	<div class="pageContent">

		<form method="post"
			action="${pageContext.request.contextPath }/site/reserveSiteOrder.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this,navTabAjaxDone)">
			<div class="pageFormContent nowrap" layoutH="97">
				<dl>
					<dt>选择场地</dt>
					<dd>
						<select name="siteOrder.siteId">
							<c:forEach items="${siteTypes }" var="siteType">
								<optgroup label="${siteType.type }">
									<c:forEach items="${sites }" var="site">
										<c:if test="${siteType.id==site.typeId }">
											<option value="${site.id }">${site.name }</option>
										</c:if>
									</c:forEach>
								</optgroup>
							</c:forEach>
						</select>
					</dd>
				</dl>
				<dl>
					<dt>预约开始时间：</dt>
				
					<dd>
						<input type="text" name="siteOrder.stratTime" class="date" dateFmt="yyyy-MM-dd HH:mm:ss" readonly="true"/>
						<a class="inputDateButton" href="javascript:;">选择</a>
					</dd>
					
				</dl>
				<dl>
					<dt>预约结束时间：</dt>
					<dd>
						<input type="text" name="siteOrder.endTime" class="date" dateFmt="yyyy-MM-dd HH:mm:ss" readonly="true"/>
						<a class="inputDateButton" href="javascript:;">选择</a>
					</dd>
					
				</dl>
				<dl>
					<dt>状态</dt>
					<dd>
						<select name="siteOrder.statue">
							<option value="unpassed" >未过期</option>
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

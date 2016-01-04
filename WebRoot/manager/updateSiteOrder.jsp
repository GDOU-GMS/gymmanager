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
	<h2 class="contentTitle">添加场地预约</h2>


	<div class="pageContent">

		<form method="post"
			action="${pageContext.request.contextPath }/site/updateSiteOrder.action"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this,navTabAjaxDone)">
			<div class="pageFormContent nowrap" layoutH="97">
			<input type="text" name="siteOrder.id" value="${siteOrder.id }" style="display: none">
				<dl>
					<dt>学生学号</dt>
					<dd>
						<input name="studentNo" type="text" class="number required" minlength="12" maxlength="12" value="${user.studentNo }">
					</dd>
				</dl>
				<%-- <dl>
					<dt>选择场地类型</dt>
					<dd>
						<select name="siteType">
							<c:forEach items="${siteTypes }" var="siteType">
								<option value="${siteType.id}" <c:if test="${siteType.id eq type.id }">selected="selected"</c:if> >${siteType.type}</option>
							</c:forEach>
						</select>
					</dd>
				</dl>
				<dl>
					<dt>选择场地</dt>
					<dd>
						<select name="siteOrder.siteId">
							<c:forEach items="${sites }" var="s">
								<option value="${s.id}" <c:if test="${s.id eq site.id }">selected="selected"</c:if> >${s.name}</option>
							</c:forEach>
						</select>
					</dd>
				</dl> --%>
				<dl>
					<dt>选择场地</dt>
					<dd>
						<select name="siteOrder.siteId">
							<c:forEach items="${siteTypes }" var="siteType">
								<optgroup label="${siteType.type }">
									<c:forEach items="${sites }" var="s">
										<c:if test="${siteType.id==s.typeId }">
											<option value="${s.id }" <c:if test="${site.id eq s.id }">selected="selected"</c:if>>${s.name }</option>
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
						<input type="text" name="siteOrder.stratTime" class="date" dateFmt="yyyy-MM-dd HH:mm:ss" readonly="true" value="${stratTime }"/>
						<a class="inputDateButton" href="javascript:;">选择</a>
					</dd>
					
				</dl>
				<dl>
					<dt>预约结束时间：</dt>
					<dd>
						<input type="text" name="siteOrder.endTime" class="date" dateFmt="yyyy-MM-dd HH:mm:ss" readonly="true" value="${endTime }"/>
						<a class="inputDateButton" href="javascript:;">选择</a>
					</dd>
					
				</dl>
				<dl>
					<dt>状态</dt>
					<dd>
						<select name="siteOrder.statue">
							<option value="${siteOrder.statue }" >${siteOrder.statue }</option>
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

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'advancedSearchSiteOrder.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

</head>

<body>
	<div class="pageContent">
		<form method="post" action="" class="pageForm"
			onsubmit="return navTabSearch(this);">
			<div class="pageFormContent" layoutH="58">
				<div class="unit">
					<label>请输入检索条件：</label>
				</div>
				<div class="divider">divider</div>
				<div class="unit">
					<label>场地名称：</label>
					<input type="text" name="site.name" class="required" />
				</div>
				<div class="unit">
					<label>预约开始时间：</label> 
					<input type="text" name="siteOrder.stratTime" class="date required" dateFmt="yyyy-MM-dd HH:mm:ss"  />
				</div>
				<div class="unit">
					<label>结束时间：</label> 
					<input type="text" name="siteOrder.endTime" class="date required" dateFmt="yyyy-MM-dd HH:mm:ss"  />
				</div>
				<div class="unit">
					<label>状态：</label>
					<select class="combox" name="site.statue">
						<option value="noon">--请选择--</option>
						<option value="unpassed">未过期</option>
						<option value="passed">已过期</option>
					</select>
				</div>

			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">开始检索</button>
							</div>
						</div></li>
					<li><div class="button">
							<div class="buttonContent">
								<button type="reset">清空重输</button>
							</div>
						</div></li>
				</ul>
			</div>
		</form>
	</div>
</body>
</html>

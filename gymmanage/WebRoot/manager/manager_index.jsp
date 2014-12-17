<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>广东海洋大学体育馆管理系统</title>

<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />


<link href="${pageContext.request.contextPath }/themes/default/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="${pageContext.request.contextPath }/themes/css/core.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="${pageContext.request.contextPath }/themes/css/print.css" rel="stylesheet" type="text/css"
	media="print" />
<link href="${pageContext.request.contextPath }/uploadify/css/uploadify.css" rel="stylesheet"
	type="text/css" media="screen" />
<!--[if IE]>
<link href="${pageContext.request.contextPath }/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="${pageContext.request.contextPath }/js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="${pageContext.request.contextPath }/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/jquery.validate.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/uploadify/scripts/jquery.uploadify.js"
	type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="${pageContext.request.contextPath }/text/javascript" src="chart/raphael.js"></script>
<script type="${pageContext.request.contextPath }/text/javascript" src="chart/g.raphael.js"></script>
<script type="${pageContext.request.contextPath }/text/javascript" src="chart/g.bar.js"></script>
<script type="${pageContext.request.contextPath }/text/javascript" src="chart/g.line.js"></script>
<script type="${pageContext.request.contextPath }/text/javascript" src="chart/g.pie.js"></script>
<script type="${pageContext.request.contextPath }/text/javascript" src="chart/g.dot.js"></script>

<script src="${pageContext.request.contextPath }/js/dwz.core.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.util.date.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.drag.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.tree.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.accordion.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.ui.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.theme.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.navTab.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.tab.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.resize.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.dialog.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.stable.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.ajax.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.pagination.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.database.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.effects.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.panel.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.history.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.combox.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/dwz.print.js" type="text/javascript"></script>
<!--
<script src="${pageContext.request.contextPath }/bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="${pageContext.request.contextPath }/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		DWZ.init("dwz.frag.xml", {
			loginUrl : "login_dialog.html",
			loginTitle : "登录", // 弹出登录对话框
			//		loginUrl:"login.html",	// 跳到登录页面
			statusCode : {
				ok : 200,
				error : 300,
				timeout : 301
			}, //【可选】
			pageInfo : {
				pageNum : "pageNum",
				numPerPage : "numPerPage",
				orderField : "orderField",
				orderDirection : "orderDirection"
			}, //【可选】
			debug : false, // 调试模式 【true|false】
			callback : function() {
				initEnv();
				$("#themeList").theme({
					themeBase : "themes"
				}); // themeBase 相对于index页面的主题base路径
			}
		});
	});
</script>

</head>
<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="#">标志</a>
				<ul class="nav">
					<li><a href="#">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->

		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>主菜单</h2>
					<div>收缩</div>
				</div>

				<div class="accordion" fillSpace="sidebar">
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a>人员管理</a>
								<ul>
									<li><a
										href="${pageContext.request.contextPath }/manager/getAllUsers.action"
										target="navTab">添加场地管理员</a></li>
								</ul></li>

							<li><a>场地管理</a>
								<ul>
									<li><a
										href="${pageContext.request.contextPath }/site/getAllSite.action"
										target="navTab" rel="getAllSite">场地管理</a></li>
									<li><a
										href="${pageContext.request.contextPath }/site/getAllSiteType.action"
										target="navTab" rel="getAllSiteType">类型管理</a></li>
									<li><a
										href="${pageContext.request.contextPath }/site/getAllSiteOrder.action"
										target="navTab" rel="getAllSiteOrder">预约管理</a></li>
									<li><a href="#" target="navTab">收费标准</a></li>
								</ul></li>

							<li><a>赛事管理</a>
								<ul>
									<li><a href="#" target="navTab">添加赛事</a></li>
									<li><a href="#" target="navTab">所有赛事</a></li>
								</ul></li>
							<li><a>器材管理</a>
								<ul>
									<li><a href="#" target="navTab">添加器材</a></li>
									<li><a href="#" target="navTab">所有器材</a></li>
								</ul></li>
							<li><a>个人信息管理</a>
								<ul>
									<li><a href="#" target="navTab">个人信息</a></li>
									<li><a href="#" target="navTab">修改密码</a></li>
								</ul></li>
							<li><a>其他</a>
								<ul>
									<li><a href="#" target="navTab">管内设施惩罚条例</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span
										class="home_icon">首页</span></span></a></li>
						</ul>
					</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="pageFormContent">欢迎来到广东海洋大学体育馆管理系统后台</div>
						<div class="divider"></div>
						<div>welcome</div>
					</div>

				</div>
				<div class="tabsFooter">
					<div class="tabsFooterContent"></div>
				</div>
			</div>
		</div>

	</div>

	<!-- <div id="footer">
		Copyright &copy; 2010 <a href="demo_page2.html" target="dialog">DWZ团队</a>
		京ICP备05019125号-10
	</div> -->

	<!-- 注意此处js代码用于google站点统计，非DWZ代码，请删除 -->
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-16716654-1' ]);
		_gaq.push([ '_trackPageview' ]);

		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? ' https://ssl'
					: ' http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>

</body>
</html>

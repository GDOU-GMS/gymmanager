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
				<li><a href="#">欢迎${manager.account }</a></li>
					<li><a href="${pageContext.request.contextPath }/managerAction/logout.action">退出</a></li>
				</ul>
				<!-- <ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul> -->
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
										href="${pageContext.request.contextPath }/useraction/getAllUsers.action"
										target="navTab"rel="getAllUsers">用户信息查询</a></li>
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
									<li><a
										href="${pageContext.request.contextPath }/site/getAllReserveSiteOrder.action"
										target="navTab" rel="getAllReserveSiteOrder">预留管理</a></li>
									<li><a href="${pageContext.request.contextPath }/site/getCurrentSiteOrder.action" rel="getCurrentSiteOrder" target="navTab">今日预约</a></li>
									<li><a href="${pageContext.request.contextPath }/site/getAllSiteUsage.action" target="navTab" rel="getAllSiteUsage">场地使用</a></li>
								</ul></li>

							<li><a>赛事管理</a>
								<ul>
									<li><a href="${pageContext.request.contextPath }/events/getAllEvents.action" target="navTab" rel="getAllEvents">赛事管理</a></li>
								</ul></li>
							<li><a>器材管理</a>
								<ul>
									<li><a href="${pageContext.request.contextPath }/equipmentaction/getAllEquipmentType.action"  target="navTab" rel="getAllEquipmentType">类型管理</a></li>
									<li><a href="${pageContext.request.contextPath }/equipmentaction/getAllEquipment.action"  target="navTab" rel="getAllEquipment">器材管理</a></li>
									<li><a href="${pageContext.request.contextPath }/equipmentaction/getAllEquipmentRent.action" target="navTab" rel="getAllEquipmentRent">器材租借</a></li>
									<li><a href="${pageContext.request.contextPath }/equipmentaction/getAllEquipmentCharge.action" target="navTab" rel="getAllEquipmentCharge">器材租借收费标准设置</a></li>
								</ul></li>
							<li><a>个人信息管理</a>
								<ul>
									<li><a href="${pageContext.request.contextPath }/managerAction/getManagerSelf.action" 
									target="navTab"rel="getManagerSelf">个人信息</a></li>
									<li><a href="${pageContext.request.contextPath }/manager/updatePassword.jsp" 
									target="navTab">修改密码</a></li>
								</ul></li>
							<li><a href="#">场馆公告</a>
								<ul>
									<li><a href="${pageContext.request.contextPath }/notice/getAllNotice.action" target="navTab" rel="getAllNotice">公告管理</a></li>
								</ul></li>
							<li><a href="#">其他</a>
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
						<div class="pageFormContent"><h2 style="line-height:19px">欢迎来到广东海洋大学体育馆管理系统后台</h2></div>
						<div class="divider"></div>
						<!--  <div>welcome</div>-->
						<div>
						<span style="line-height:19px;font-size:13px;"">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp广东海洋大学体育馆始建于2005年，
						于2005年5月施工到2010年10份正式竣工，于2010年11月17日正式投入使用。该馆共投入4000余万元。 主校区体育馆位于校园中心区域，依山傍海，气势恢宏，与周围错落有致
						的楼群及雕塑相映成趣，构成一幅中西风格相统一、自然与人文相协调的和谐风景。体育馆占地面积1万4平方米，建筑面积高达13500平方米，共有四层。首层作为主场馆，共设有2397个座位，主场馆内最多可以容纳5717人。
						主场馆内除了设有体育学院办公室、运动器材室、运动员休息室和会议室以外，还有一个标准篮球场，其面积等同于12个羽毛球场和两个排球场。除了日
						常可供师生进行体育锻炼外，也可举行军训动员大会、大型文艺演出等大型活动。值得注意的是，第二层除了设有台球、健身房外，还设有保龄球馆。第三、
						四层则分别设有乒乓球室和武术馆、体操馆。体育馆管理系统是广东海洋大学信息化服务平台的一部分，用它取代传统的手工做业方式，体育馆管理软件是
						一款专业的体育馆场地管理系统，球馆管理系统，它集前台收银收费管理，一卡通功能，场地自动计费管理，场地预定，会员管理等强大功能为一身，系统
						界面简洁优美，操作直观简单，无需专门培训即可操作使用，是羽毛球馆，乒乓球馆，台球厅，篮球场，健身房等体育场馆管理信息化理想的管理软件。</span>
						</div>
						<div>
						
						</div>
						
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

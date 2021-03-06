<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
  <head>
  	<base href="<%=basePath%>">
    <title>广东海洋大学体育馆</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="author" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->

	<link href="${pageContext.request.contextPath }/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath }/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath }/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath }/media/css/style-metro.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath }/media/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath }/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath }/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

	<link href="${pageContext.request.contextPath }/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES -->

	<link href="${pageContext.request.contextPath }/media/css/timeline.css" rel="stylesheet" type="text/css"/>

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="${pageContext.request.contextPath }/media/image/favicon1.ico" />

  </head>
  
 <body class="page-header-fixed">

	<!-- BEGIN HEADER -->

	<div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- BEGIN TOP NAVIGATION BAR -->

		<div class="navbar-inner">

			<div class="container-fluid">

				<!-- BEGIN LOGO -->

				<a class="brand" href="${pageContext.request.contextPath }/index.jsp">

				<img src="${pageContext.request.contextPath }/media/image/logo1.png" alt="logo"/>

				</a>

				<!-- END LOGO -->

				<!-- BEGIN RESPONSIVE MENU TOGGLER -->

				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">

				<img src="${pageContext.request.contextPath }/media/image/menu-toggler.png" alt="" />

				</a>          

				<!-- END RESPONSIVE MENU TOGGLER -->            

				<!-- BEGIN TOP NAVIGATION MENU -->              

				<ul class="nav pull-right">
					<!-- BEGIN USER LOGIN DROPDOWN -->
					
					<c:if test="${user==null }">
					
						<li><a href="${pageContext.request.contextPath }/client/login.jsp"><i class="icon-user"></i>登录</a></li>
					
					</c:if>
					
					<c:if test="${user!=null }">
					
						<li class="dropdown user">
	
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
	
							<%-- <img alt="" src="${pageContext.request.contextPath }/media/image/avatar1_small.jpg" />  --%>
	
							<i class="icon-user"></i>
							
							<span class="username">${user.name }</span>
	
							<i class="icon-angle-down"></i>
	
							</a> 
	
							<ul class="dropdown-menu">
							
								<li><a href="${pageContext.request.contextPath}/useraction/getUserSelf.action"><i class="icon-user"></i>个人信息</a></li>

								<li><a href="${pageContext.request.contextPath }/site/clientGetMySiteOrderData.action"><i class="icon-calendar"></i>我的预约</a></li>
	
								<li><a href="${pageContext.request.contextPath}/useraction/checkBeforeUpdatePassword.action"><i class="icon-edit"></i>修改密码</a></li>

								<li class="divider"></li>

								<li><a href="${pageContext.request.contextPath }/useraction/logout.action"><i class="icon-key"></i>退出</a></li>
							</ul>
						</li>
					</c:if>
					<!-- END USER LOGIN DROPDOWN -->

				</ul>

				<!-- END TOP NAVIGATION MENU --> 

			</div>

		</div>

		<!-- END TOP NAVIGATION BAR -->

	</div>

	<!-- END HEADER -->
    <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div>

	<!-- BEGIN CONTAINER -->

	<div class="page-container">

		<!-- BEGIN SIDEBAR -->

		<div class="page-sidebar nav-collapse collapse">

			<!-- BEGIN SIDEBAR MENU -->        

			<ul class="page-sidebar-menu">

				<li>

					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

					<div class="sidebar-toggler hidden-phone"></div>

					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

				</li>

				<li>

					<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->

					<form class="sidebar-search">

						<div class="input-box">

							<a href="javascript:;" class="remove"></a>

							<input type="text" placeholder="Search..." />

							<input type="button" class="submit" value=" " />

						</div>

					</form>

					<!-- END RESPONSIVE QUICK SEARCH FORM -->

				</li>

				<li class=" ">

					<a href="#">

					<i class="icon-home"></i> 

					<span class="title">首页</span>

					<span class="selected"></span>

					</a>

				</li>

				<li class="start active">

					<a href="javascript:;">

					<i class="icon-tasks"></i> 

					<span class="title">场馆概览</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li class="active">

							<a href="${pageContext.request.contextPath}/client/gymIntroduction.jsp">场馆简介</a>

						</li>

						<li >

							<a href="${pageContext.request.contextPath}/client/gymView.jsp">场馆风采</a>

						</li>
						<li >

							<a href="${pageContext.request.contextPath }/client/gymMap.jsp">场馆地图</a>

						</li>

					</ul>

				</li>

				<li class="">

					<a href="javascript:;">

					<i class="icon-cogs"></i> 

					<span class="title">场馆设施</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li >

							<a href="${pageContext.request.contextPath}/client/badmintonHall.jsp">

							羽毛球馆</a>

						</li>

						<li >

							<a href="${pageContext.request.contextPath}/client/tableTennnisHall.jsp">

							乒乓球馆</a>

						</li>

						<li >

							<a href="${pageContext.request.contextPath}/client/billiardsHall.jsp">

							台球厅</a>

						</li>

						<li >

							<a href="${pageContext.request.contextPath}/client/fitness.jsp">

							健身房</a>

						</li>

					</ul>

				</li>

				<li class="">

					<a href="javascript:;">

					<i class="icon-qrcode"></i> 

					<span class="title">场地预约</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li >

							<a href="${pageContext.request.contextPath }/site/clientGetDataForAddSiteOrder.action">

							场地预约</a>

						</li>

						<li >

							<a href="${pageContext.request.contextPath }/site/clientGetFeeScale.action">

							收费标准</a>

						</li>


					</ul>

				</li>

				<li class="">

					<a href="javascript:;">

					<i class="icon-list"></i> 

					<span class="title">场馆公告</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li >

							<a href="${pageContext.request.contextPath}/notice/getAllGymNews.action">

							<!-- <i class="icon-time"></i> -->

							最新公告</a>

						</li>


					</ul>

				</li>

				<li class="">

					<a href="javascript:;">

					<i class="icon-download"></i> 

					<span class="title">资料下载</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li >

							<a href="${pageContext.request.contextPath }/document/赛事申请表.doc">

							赛事申请表.doc</a>

						</li>


					</ul>

				</li>

				<li>

					<a class="active" href="javascript:;">

					<i class="icon-sitemap"></i> 

					<span class="title">网站导航</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li>

							<a href="javascript:;">

							校内导航

							<span class="arrow"></span>

							</a>

							<ul class="sub-menu">

								<li><a href="http://www.gdou.edu.cn/" target="_blank">广东海洋大学</a></li>
								<li><a href="http://210.38.137.116:81/scxy/" target="_blank">水产学院</a></li>
								<li><a href="http://www1.gdou.edu.cn/spkjxy/index.asp" target="_blank">食品科技学院</a></li>
								<li><a href="http://210.38.137.116:81/hyqx/" target="_blank">海洋与气象学院</a></li>
								<li><a href="http://www1.gdou.edu.cn/nxy/web/" target="_blank">农学院</a></li>
								<li><a href="http://www1.gdou.edu.cn/gcxy/" target="_blank">工程学院</a></li>
								<li><a href="http://210.38.139.34/" target="_blank">信息学院</a></li>
								<li><a href="http://www1.gdou.edu.cn/jgxy/j_default.asp" target="_blank">经济管理学院</a></li>
								<li><a href="http://www1.gdou.edu.cn/hhxy/index.asp" target="_blank">航海学院</a></li>
								<li><a href="http://210.38.137.111:81/l_index.asp" target="_blank">理学院</a></li>
								<li><a href="http://210.38.137.93:888/w_default.asp" target="_blank">外国语学院</a></li>
								<li><a href="http://www1.gdou.edu.cn/wxy/index.asp" target="_blank">文学院</a></li>
								<li><a href="http://www1.gdou.edu.cn/xzxy/" target="_blank">政治与行政学院</a></li>
								<li><a href="http://www1.gdou.edu.cn/ysxy/" target="_blank">中歌艺术院</a></li>
								<li><a href="http://210.38.137.111:84/t_default.asp" target="_blank">体育与休闲学院</a></li>

							</ul>

						</li>

						<li>

							<a href="javascript:;">

							体育网站

							<span class="arrow"></span>

							</a>

							<ul class="sub-menu">

								<li><a href="http://cctv5.cntv.cn/" target="_blank">CCTV5</a></li>

								<li><a href="http://sports.sina.com.cn/" target="_blank">新浪竞技风暴</a></li>

								<li><a href="http://sports.sohu.com/" target="_blank">搜狐体育</a></li>
								
								<li><a href="http://sports.qq.com/" target="_blank">腾讯体育</a></li>
								<li><a href="http://sports.tom.com/" target="_blank"> TOM体育 </a></li>
								<li><a href="http://nba.hupu.com/" target="_blank"> 虎扑篮球 </a></li>
								<li><a href="http://www.zhibo8.cc/" target="_blank"> 直播吧 </a></li>
								<li><a href="http://www.titan24.com/" target="_blank"> 体坛网 </a></li>
								<li><a href="http://sports.163.com/" target="_blank"> 网易体育 </a></li>

							</ul>

						</li>

						<li>

							<a href="#">

							教育网站
							<span class="arrow"></span>
							</a>
							<ul class="sub-menu">

								<li><a href="http://www.cernet.edu.cn/" target="_blank">教育科研网</a></li>
								<li><a href="http://www.jsj.edu.cn/" target="_blank">教育涉外监管信息网</a></li>
								<li><a href="http://yz.chsi.cn/ " target="_blank">中国研究生招生信息网</a></li>
								<li><a href="http://www.wei.moe.edu.cn/zh/ " target="_blank"> 世界教育信息网</a></li>
								<li><a href="http://www.csc.edu.cn/" target="_blank">国家留学网</a></li>
								<li><a href="http://www.chinaedu.edu.cn/" target="_blank">中国教育信息网</a></li>
								<li><a href="http://www.neea.edu.cn/" target="_blank">中国教育考试网</a></li>
								<li><a href=" http://www.cern.net.cn/" target="_blank">中国教育资源网</a></li>
								<li><a href="http://www.paper.edu.cn/ " target="_blank">中国科技论文在线</a></li>

							

							</ul>

						</li>

					</ul>

				</li>


				<li class="">

					<a href="javascript:;">

					<i class="icon-user"></i> 

					<span class="title">个人中心</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li >

							<a href="${pageContext.request.contextPath}/useraction/getUserSelf.action">

							个人信息</a>

						</li>
						<li >

							<a href="${pageContext.request.contextPath }/site/clientGetMySiteOrderData.action">

							我的预约</a>

						</li>

						<li >

							<a href="${pageContext.request.contextPath}/client/updatePassword.jsp">

							修改密码</a>

						</li>

					</ul>

				</li>


			</ul>
			<!-- 导航结束 -->
			<!-- END SIDEBAR MENU -->

		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->
		
		<div class="page-content">

			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<div id="portlet-config" class="modal hide">

				<div class="modal-header">

					<button data-dismiss="modal" class="close" type="button"></button>

					<h3>portlet Settings</h3>

				</div>

				<div class="modal-body">

					<p>Here will be a configuration form</p>

				</div>

			</div>

			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN STYLE CUSTOMIZER -->

						<div class="color-panel hidden-phone">

							<div class="color-mode-icons icon-color"></div>

							<div class="color-mode-icons icon-color-close"></div>

							<div class="color-mode">

								<p>THEME COLOR</p>

								<ul class="inline">

									<li class="color-black current color-default" data-style="default"></li>

									<li class="color-blue" data-style="blue"></li>

									<li class="color-brown" data-style="brown"></li>

									<li class="color-purple" data-style="purple"></li>

									<li class="color-grey" data-style="grey"></li>

									<li class="color-white color-light" data-style="light"></li>

								</ul>

								<label>

									<span>Layout</span>

									<select class="layout-option m-wrap small">

										<option value="fluid" selected>Fluid</option>

										<option value="boxed">Boxed</option>

									</select>

								</label>

								<label>

									<span>Header</span>

									<select class="header-option m-wrap small">

										<option value="fixed" selected>Fixed</option>

										<option value="default">Default</option>

									</select>

								</label>

								<label>

									<span>Sidebar</span>

									<select class="sidebar-option m-wrap small">

										<option value="fixed">Fixed</option>

										<option value="default" selected>Default</option>

									</select>

								</label>

								<label>

									<span>Footer</span>

									<select class="footer-option m-wrap small">

										<option value="fixed">Fixed</option>

										<option value="default" selected>Default</option>

									</select>

								</label>

							</div>

						</div>

						<!-- END BEGIN STYLE CUSTOMIZER --> 

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							场馆简介 <!--<small>coming soon page with date countdown</small>-->

						</h3>

						<!--  <ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#">Pages</a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#">Timeline</a></li>

						</ul>-->

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<ul class="timeline">

							<li class="timeline-yellow">

								<div class="timeline-time">

									<span class="date"></span>

									<span class="time"></span>

								</div>

								<div class="timeline-icon"><i class="icon-trophy"></i></div>

								<div class="timeline-body">

									<h2>基本介绍</h2>

									<div class="timeline-content">

										<img class="timeline-img pull-left" src="media/image/2.jpg" alt="">

										体育馆管理系统是广东海洋大学信息化服务平台的一部分，用它取代传统的手工做业方式，体育馆管理软件是一款专业的体育馆场地管理系统，球馆管理系统，它集前台收银收费管理，一卡通功能，场地自动计费管理，场地预定，会员管理等强大功能为一身，系统界面简洁优美，操作直观简单，无需专门培训即可操作使用，是羽毛球馆，乒乓球馆，台球厅，篮球场，健身房等体育场馆管理信息化理想的管理软件。

									</div>

									<!-- <div class="timeline-footer">

										<a href="#" class="nav-link pull-right">

										Read more <i class="m-icon-swapright m-icon-white"></i>                              

										</a>  

									</div>-->

								</div>

							</li>

							<li class="timeline-blue">

								<div class="timeline-time">

									<span class="date"></span>

									<span class="time"></span>

								</div>

								<div class="timeline-icon"><i class="icon-facetime-video"></i></div>

								<div class="timeline-body">

									<h2>营业时间</h2>

									<div class="timeline-content">

										<img class="timeline-img pull-right" src="media/image/1.jpg" alt="">

										周一至周五：上午：10:10-11：50 <br/>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下午：14:30-17：55<br/>
										周六周日：&nbsp;&nbsp;&nbsp;&nbsp;上午：10:10-12:00<br/>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下午：14:30-20:00<br/>
										
										

									</div>

									<!--<div class="timeline-footer">

										<a href="#" class="nav-link">

										Read more <i class="m-icon-swapright m-icon-white"></i>                              

										</a>                         

									</div>-->

								</div>

							</li>

							<li class="timeline-green">

								<div class="timeline-time">

									<span class="date"></span>

									<span class="time"></span>

								</div>

								<div class="timeline-icon"><i class="icon-comments"></i></div>

								<div class="timeline-body">

									<h2>管内设备</h2>

									<div class="timeline-content">

										<img class="timeline-img pull-left" src="media/image/3.jpg" alt="">
										广东海洋大学体育馆建设内容有：主场馆、练习馆、大众活动中心、行政楼、餐厅、中央能源中心、停车场、运动员村及附属停车场、商业设施等，它是一个以体育比赛为主，兼顾文艺表演、会议展览的多功能综合性体育建筑。主场馆入口设有约1500平方米的大圆形广场，空间宽阔，方便人流集散。主场馆总建筑面积39635平方米，纵向最大跨度160米，横向最大跨度110米，馆内的观众席共设大小（24-16平方米）包厢24个，常规座位10018个，其中贵宾席654个，固定座位5044个，活动座位约4320 个。
										
										

									</div>

									<!-- <div class="timeline-footer">

										<a href="#" class="nav-link">

										Read more <i class="m-icon-swapright m-icon-white"></i>                              

										</a>                        

									</div>-->

								</div>

							</li>

							<!--<li class="timeline-purple">

								<div class="timeline-time">

									<span class="date">4/15/13</span>

									<span class="time">13:15</span>

								</div>

								<div class="timeline-icon"><i class="icon-music"></i></div>

								<div class="timeline-body">

									<h2>Promotion Day</h2>

									<div class="timeline-content">

										<div class="scroller" data-height="175px" data-always-visible="1" data-rail-visible1="1">

											<p>

												<img class="timeline-img pull-right" src="media/image/4.jpg" alt="">

												Caulie dandelion maize lentil collard greens radish arugula sweet pepper water spinach kombu courgette lettuce. Celery coriander bitterleaf epazote radicchio shallot winter purslane collard greens spring onion squash lentil. Artichoke salad bamboo shoot black-eyed pea brussels sprout garlic kohlrabi. coriander bitterleaf epazote radicchio shallot winter purslane collard.

											</p>

											<p>

												Coriander bitterleaf epazote radicchio shallot winter purslane collard.

												Caulie dandelion maize lentil collard greens radish arugula sweet pepper water spinach kombu courgette lettuce. Celery coriander bitterleaf epazote radicchio shallot winter purslane collard greens spring onion squash lentil. Artichoke salad bamboo shoot black-eyed pea brussels sprout garlic kohlrabi.

											</p>

											<p>

												<img class="timeline-img pull-left" src="media/image/6.jpg" alt="">                                    

												Caulie dandelion maize lentil collard greens radish arugula sweet pepper water spinach kombu courgette lettuce. Celery coriander bitterleaf epazote radicchio shallot winter purslane collard greens spring onion squash lentil. Artichoke salad bamboo shoot black-eyed pea brussels sprout garlic kohlrabi radicchio shallot winter purslane collard greens spring onion squash lentil.

											</p>

											<p>

												Coriander bitterleaf epazote radicchio shallot winter purslane collard.

												Caulie dandelion maize lentil collard greens radish arugula sweet pepper water spinach kombu courgette lettuce. Celery coriander bitterleaf epazote radicchio shallot winter purslane collard greens spring onion squash lentil. Artichoke salad bamboo shoot black-eyed pea brussels sprout garlic kohlrabi.

											</p>

										</div>

									</div>

									<div class="timeline-footer">

										<a href="#" class="btn blue">

										Read more <i class="m-icon-swapright m-icon-white"></i>                              

										</a>                        

									</div>

								</div>

							</li>

							<li class="timeline-red">

								<div class="timeline-time">

									<span class="date">4/16/13</span>

									<span class="time">21:30</span>

								</div>

								<div class="timeline-icon"><i class="icon-rss"></i></div>

								<div class="timeline-body">

									<h2>Daily Feeds</h2>

									<div class="timeline-content">

										<img class="timeline-img pull-left" src="media/image/5.jpg" alt="">

										Parsley amaranth tigernut silver beet maize fennel spinach. Ricebean black-eyed pea maize scallion green bean spinach cabbage jicama bell pepper carrot onion corn plantain garbanzo. Sierra leone bologi komatsuna celery peanut swiss chard silver beet squash dandelion maize chicory burdock tatsoi dulse radish wakame beetroot.

									</div>

									<div class="timeline-footer">

										<a href="#" class="btn green pull-right">

										Read more <i class="m-icon-swapright m-icon-white"></i>                              

										</a>     

									</div>

								</div>

							</li>

							<li class="timeline-grey">

								<div class="timeline-time">

									<span class="date">4/17/13</span>

									<span class="time">12:11</span>

								</div>

								<div class="timeline-icon"><i class="icon-time"></i></div>

								<div class="timeline-body">

									<h2>Staff Meeting</h2>

									<div class="timeline-content">

										Caulie dandelion maize lentil collard greens radish arugula sweet pepper water spinach kombu courgette lettuce. Celery coriander bitterleaf epazote radicchio shallot winter purslane collard greens spring onion squash lentil. Artichoke salad bamboo shoot black-eyed pea brussels sprout garlic kohlrabi.

									</div>

									<div class="timeline-footer">

										<a href="#" class="nav-link pull-right">

										Read more <i class="m-icon-swapright m-icon-white"></i>                              

										</a>     

									</div>

								</div>

							</li>

							<li class="timeline-blue">

								<div class="timeline-time">

									<span class="date">4/18/13</span>

									<span class="time">09:56</span>

								</div>

								<div class="timeline-icon"><i class="icon-bar-chart"></i></div>

								<div class="timeline-body">

									<h2>Demo Europe 2013</h2>

									<div class="timeline-content">

										<img class="timeline-img pull-left" src="media/image/2.jpg" alt="">

										Parsnip lotus root celery yarrow seakale tomato collard greens tigernut epazote ricebean melon tomatillo soybean chicory broccoli beet greens peanut salad. Lotus root burdock bell pepper chickweed shallot groundnut pea sprouts welsh onion wattle seed pea salsify turnip scallion peanut arugula bamboo shoot onion swiss chard.

									</div>

									<div class="timeline-footer">

										<a href="#" class="nav-link">

										Read more <i class="m-icon-swapright m-icon-white"></i>                              

										</a>     

									</div>

								</div>

							</li>  -->

						</ul>

					</div>

				</div>

				<!-- END PAGE CONTENT-->

			</div>

			<!-- END PAGE CONTAINER--> 

		</div>

		<!-- END PAGE -->    

	</div>

	<!-- END CONTAINER -->

	

	<!-- BEGIN FOOTER -->

	<!-- <div class="footer">

		<div class="footer-inner">

			2013 &copy; Metronic by keenthemes.Collect from <a href="http://www.cssmoban.com/" title="网站模板" target="_blank">网站模板</a> - More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>

		</div>

		<div class="footer-tools">

			<span class="go-top">

			<i class="icon-angle-up"></i>

			</span>

		</div>

	</div>
 -->
	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<script src="${pageContext.request.contextPath }/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="${pageContext.request.contextPath }/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

	<script src="${pageContext.request.contextPath }/media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="${pageContext.request.contextPath }/media/js/excanvas.min.js"></script>

	<script src="${pageContext.request.contextPath }/media/js/respond.min.js"></script>  

	<![endif]-->   

	<script src="${pageContext.request.contextPath }/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/jquery.blockui.min.js" type="text/javascript"></script>  

	<script src="${pageContext.request.contextPath }/media/js/jquery.cookie.min.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/jquery.uniform.min.js" type="text/javascript" ></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="${pageContext.request.contextPath }/media/js/jquery.vmap.js" type="text/javascript"></script>   

	<script src="${pageContext.request.contextPath }/media/js/jquery.vmap.russia.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/jquery.vmap.world.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/jquery.vmap.europe.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/jquery.vmap.germany.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/jquery.vmap.usa.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/jquery.vmap.sampledata.js" type="text/javascript"></script>  

	<script src="${pageContext.request.contextPath }/media/js/jquery.flot.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/jquery.flot.resize.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/jquery.pulsate.min.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/date.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/daterangepicker.js" type="text/javascript"></script>     

	<script src="${pageContext.request.contextPath }/media/js/jquery.gritter.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/fullcalendar.min.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/jquery.easy-pie-chart.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/jquery.sparkline.min.js" type="text/javascript"></script>  

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${pageContext.request.contextPath }/media/js/app.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/media/js/index.js" type="text/javascript"></script>        

	<!-- END PAGE LEVEL SCRIPTS -->  

	<script>

		jQuery(document).ready(function() {    

		   App.init(); // initlayout and core plugins

		   Index.init();

		   Index.initJQVMAP(); // init index page's custom scripts

		   Index.initCalendar(); // init index page's custom scripts

		   Index.initCharts(); // init index page's custom scripts

		   Index.initChat();

		   Index.initMiniCharts();

		   Index.initDashboardDaterange();

		   Index.initIntro();

		});

	</script>

	<!-- END JAVASCRIPTS -->

</body>
</html>

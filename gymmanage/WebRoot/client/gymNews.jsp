<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>广东海洋大学体育馆管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
	
	<link href="${pageContext.request.contextPath }/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath }/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath }/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath }/media/css/style-metro.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath }/media/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath }/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath }/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

	<link href="${pageContext.request.contextPath }/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath }/media/css/jquery.fancybox.css" rel="stylesheet" />

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES -->


	<link href="${pageContext.request.contextPath }/media/css/blog.css" rel="stylesheet" type="text/css"/>

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="${pageContext.request.contextPath }/media/image/favicon.ico" />
	
	
	

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
	<!-- 头部结束 -->
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

				<li class="">

					<a href="javascript:;">

					<i class="icon-tasks"></i> 

					<span class="title">场馆概览</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li >

							<a href="${pageContext.request.contextPath}/client/gymIntroduction.jsp">场馆简介</a>

						</li>

						<li >

							<a href="${pageContext.request.contextPath}/client/gymView.jsp">场馆风采</a>

						</li>
						<li >

							<a href="#">场馆地图</a>

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

				<li class="start active">

					<a href="javascript:;">

					<i class="icon-list"></i> 

					<span class="title">场馆公告</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li class="active" >

							<a href="${pageContext.request.contextPath}/client/gymNews.jsp">

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

			<!-- END SIDEBAR MENU -->
			<!-- 导航结束 -->
		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->
		<div class="page-content">

			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<!--  <div id="portlet-config" class="modal hide">

				<div class="modal-header">

					<button data-dismiss="modal" class="close" type="button"></button>

					<h3>portlet Settings</h3>

				</div>

				<div class="modal-body">

					<p>Here will be a configuration form</p>

				</div>

			</div>-->

			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN STYLE CUSTOMIZER -->

						<!--<div class="color-panel hidden-phone">

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

						</div>-->

						<!-- END BEGIN STYLE CUSTOMIZER --> 

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

						  场馆公告<!-- <small>news view samples</small> --> 

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

							<li><a href="#">News View</a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12 news-page blog-page">

						<div class="row-fluid">

							<div class="span8 blog-tag-data">

								<!--  <h1>风采</h1>-->
								<div id="myCarousel" class="carousel slide">

									<!-- Carousel indicators

										<ol class="carousel-indicators">

										 <li data-target="#myCarousel" data-slide-to="0" class="active"></li>

										 <li data-target="#myCarousel" data-slide-to="1"></li>

										 <li data-target="#myCarousel" data-slide-to="2"></li>

										</ol>

										-->

									<!-- Carousel items -->

									<!--  <div class="carousel-inner">

										<div class="item active">

											<img src="${pageContext.request.contextPath }/media/image/badminton1.png" alt="">

											<div class="carousel-caption">

												<h4><a href="page_news_item.html">First Thumbnail label</a></h4>

												<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor.</p>

											</div>

										</div>

										<div class="item">

											<img src="${pageContext.request.contextPath }/media/image/badminton2.png" alt="">

											<div class="carousel-caption">

												<h4><a href="page_news_item.html">Second Thumbnail label</a></h4>

												<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor.</p>

											</div>

										</div>

										<div class="item">

											<img src="${pageContext.request.contextPath }/media/image/badminton3.png" alt="">

											<div class="carousel-caption">

												<h4><a href="page_news_item.html">Third Thumbnail label</a></h4>

												<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor.</p>

											</div>

										</div>

									</div>-->

									<!-- Carousel nav -->

									<!--  <a class="carousel-control left" href="#myCarousel" data-slide="prev">

									<i class="m-icon-big-swapleft m-icon-white"></i>

									</a>

									<a class="carousel-control right" href="#myCarousel" data-slide="next">

									<i class="m-icon-big-swapright m-icon-white"></i>

									</a>-->

								</div>

								<!--<img src="media/image/item_img1.jpg" alt="">-->
								

								<!-- <div class="row-fluid">

									<div class="span6">

										<ul class="unstyled inline blog-tags">

											<li>

												<i class="icon-tags"></i> 

												<a href="#">Technology</a> 

												<a href="#">Education</a>

												<a href="#">Internet</a>

											</li>

										</ul>

									</div>

									<div class="span6 blog-tag-data-inner">

										<ul class="unstyled inline">

											<li><i class="icon-calendar"></i> <a href="#">April 16, 2013</a></li>

											<li><i class="icon-comments"></i> <a href="#">38 Comments</a></li>

										</ul>

									</div>

								</div>-->

								<!--  <div class="news-item-page">

									<!--  <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culp orem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat. At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero consectetur adipiscing elit magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat. Pellentesque viverra vehicula sem ut volutpat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna. Sed et quam lacus.</p>-->
									

									<!--  <blockquote class="hero">

										<!--  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit posuere erat a ante.</p>

										 <small>Someone famous <cite title="Source Title">Source Title</cite></small>-->
										<!--  <h3>羽毛球馆简介</h3>
										 <big>羽毛球场双打球场的标准尺寸长度是13.4米，宽度是6.10米，单打宽5.18米，理想的羽毛球比赛场地是用弹性的木材拼接而成（只要不是把小木块竖着拼接即可）。目前国际比赛已采用化学合成材料作为可移动的球场。当然，在基层的各级比赛中，当达不到上述条件的要求时，也可以在水泥地或三合土的地面上进行竞赛。现在的大学，机关，医院等一般都有自己的羽毛球场地，而且都是万奥塑胶的。不论是采用木板地面还是合成材料地面，都必须保证运动员在比赛中不感到太滑或太粘，并有一定的弹性。
										 </big>

									</blockquote>

									<!--  <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique dimentum eleifend enim a feugiat. Pellentesque viverra vehicula sem ut volutpat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna. Sed et quam lacus.</p>-->

								<!--  </div>

								<hr>-->

								<div class="media">

								

									<a href="#" class="pull-left">

									<img alt="" src="media/image/9.jpg" class="media-object">

									</a>

									<div class="media-body">
									
										<c:forEach items="${notices }" var="notice">
											<div class="media" id="${notice.id }">

											<a href="#" class="pull-left">

											<img alt="" src="${pageContext.request.contextPath }/upload/${notice.image}" class="media-object" style="min-width:200px;min-height:200px;">

											</a>

											<div class="media-body">

												<h4 class="media-heading">${notice.title } <span>${notice.time }</span></h4>

												<p>${notice.content }</p>

											</div>

										</div>
										<hr>
										</c:forEach>
									</div>

								</div><!-- 留言结束 -->

								<!-- <hr>
								

								<div class="post-comment">

									<h3>发表留言</h3>

									<form>

										<label>姓名：</label>

										<input type="text" class="span7 m-wrap">

										<label>学院<span class="color-red"></span></label>

										<input type="text" class="span7 m-wrap">

										<label>留言</label>

										<textarea class="span10 m-wrap" rows="8"></textarea>

										<p><button class="btn blue" type="submit">发表</button></p>

									</form>

								</div>-->

							</div>

							<div class="span4">

								<!--  <h2>News Feeds</h2>

								<div class="top-news">

									<a href="#" class="btn green">

									<span>Top Week</span>

									<em>Posted on: April 15, 2013</em>

									<em>

									<i class="icon-tags"></i>

									Internet, Music, People

									</em>

									<i class="icon-music top-news-icon"></i>                             

									</a>

									<a href="#" class="btn yellow">

									<span>Study Abroad</span>

									<em>Posted on: April 13, 2013</em>

									<em>

									<i class="icon-tags"></i>

									Education, Students, Canada

									</em>

									<i class="icon-book top-news-icon"></i>                              

									</a>

									<a href="#" class="btn red">

									<span>Metronic News</span>

									<em>Posted on: April 16, 2013</em>

									<em>

									<i class="icon-tags"></i>

									Money, Business, Google

									</em>

									<i class="icon-briefcase top-news-icon"></i>

									</a>

									<a href="#" class="btn blue">

									<span>Gold Price Falls</span>

									<em>Posted on: April 14, 2013</em>

									<em>

									<i class="icon-tags"></i>

									USA, Business, Apple

									</em>

									<i class="icon-globe top-news-icon"></i>                             

									</a>

								</div>

								<div class="space20"></div>

								<h2>News Tags</h2>

								<ul class="unstyled inline sidebar-tags">

									<li><a href="#"><i class="icon-tags"></i> Business</a></li>

									<li><a href="#"><i class="icon-tags"></i> Music</a></li>

									<li><a href="#"><i class="icon-tags"></i> Internet</a></li>

									<li><a href="#"><i class="icon-tags"></i> Money</a></li>

									<li><a href="#"><i class="icon-tags"></i> Google</a></li>

									<li><a href="#"><i class="icon-tags"></i> TV Shows</a></li>

									<li><a href="#"><i class="icon-tags"></i> Education</a></li>

									<li><a href="#"><i class="icon-tags"></i> People</a></li>

									<li><a href="#"><i class="icon-tags"></i> People</a></li>

									<li><a href="#"><i class="icon-tags"></i> Math</a></li>

									<li><a href="#"><i class="icon-tags"></i> Photos</a></li>

									<li><a href="#"><i class="icon-tags"></i> Electronics</a></li>

									<li><a href="#"><i class="icon-tags"></i> Apple</a></li>

									<li><a href="#"><i class="icon-tags"></i> Canada</a></li>

								</ul>

								<div class="space20"></div>

								<h2>Tabs</h2>

								<div class="tabbable tabbable-custom">

									<ul class="nav nav-tabs">

										<li class="active"><a data-toggle="tab" href="#tab_1_1">Section 1</a></li>

										<li class=""><a data-toggle="tab" href="#tab_1_2">Section 2</a></li>

										<li class=""><a data-toggle="tab" href="#tab_1_3">Section 3</a></li>

									</ul>

									<div class="tab-content">

										<div id="tab_1_1" class="tab-pane active">

											<p>I'm in Section 1.</p>

											<p>

												Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat.

											</p>

										</div>

										<div id="tab_1_2" class="tab-pane">

											<p>Howdy, I'm in Section 2.</p>

											<p>

												Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat. Ut wisi enim ad minim veniam, quis nostrud exerci tation.

											</p>

										</div>

										<div id="tab_1_3" class="tab-pane">

											<p>Howdy, I'm in Section 3.</p>

											<p>

												Duis autem vel eum iriure dolor in hendrerit in vulputate.

												Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat

											</p>

										</div>

									</div>

								</div>

								<div class="space20"></div>

								<h2>Recent Twitts</h2>

								<div class="blog-twitter">

									<div class="blog-twitter-block">

										<a href="">@keenthemes</a> 

										<p>At vero eos et accusamus et iusto odio.</p>

										<a href="#"><em>http://t.co/sBav7dm</em></a> 

										<span>5 hours ago</span>

										<i class="icon-twitter blog-twiiter-icon"></i>

									</div>

									<div class="blog-twitter-block">

										<a href="">@keenthemes</a> 

										<p>At vero eos et accusamus et iusto odio.</p>

										<a href="#"><em>http://t.co/sBav7dm</em></a> 

										<span>8 hours ago</span>

										<i class="icon-twitter blog-twiiter-icon"></i>

									</div>

									<div class="blog-twitter-block">

										<a href="">@keenthemes</a> 

										<p>At vero eos et accusamus et iusto odio.</p>

										<a href="#"><em>http://t.co/sBav7dm</em></a> 

										<span>12 hours ago</span>

										<i class="icon-twitter blog-twiiter-icon"></i>

									</div>

								</div>-->

								<!--  <div class="space20"></div>

								<h2>Flickr</h2>

								<ul class="unstyled blog-images">

									<li>

										<a class="fancybox-button" data-rel="fancybox-button" title="390 x 220 - keenthemes.com" href="media/image/1.jpg">

										<img alt="" src="media/image/1.jpg">

										</a>

									</li>

									<li><a href="#"><img alt="" src="media/image/2.jpg"></a></li>

									<li><a href="#"><img alt="" src="media/image/3.jpg"></a></li>

									<li><a href="#"><img alt="" src="media/image/4.jpg"></a></li>

									<li><a href="#"><img alt="" src="media/image/5.jpg"></a></li>

									<li><a href="#"><img alt="" src="media/image/6.jpg"></a></li>

									<li><a href="#"><img alt="" src="media/image/8.jpg"></a></li>

									<li><a href="#"><img alt="" src="media/image/10.jpg"></a></li>

									<li><a href="#"><img alt="" src="media/image/11.jpg"></a></li>

									<li><a href="#"><img alt="" src="media/image/1.jpg"></a></li>

									<li><a href="#"><img alt="" src="media/image/2.jpg"></a></li>

									<li><a href="#"><img alt="" src="media/image/7.jpg"></a></li>

								</ul>-->

							</div>

						</div>

					</div>

				</div>

				<!-- END PAGE CONTENT-->

			</div>

			<!-- END PAGE CONTAINER--> <!-- 内容结束 -->

		</div>
		
			
		<!-- END PAGE -->
	</div>
				
	<!-- END CONTAINER -->
		
	</div>

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

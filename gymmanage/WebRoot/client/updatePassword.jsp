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
	<meta content="" name="description" />
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

	<link href="${pageContext.request.contextPath }/media/css/bootstrap-fileupload.css" rel="stylesheet" type="text/css" />

	<link href="${pageContext.request.contextPath }/media/css/chosen.css" rel="stylesheet" type="text/css" />

	<link href="${pageContext.request.contextPath }/media/css/profile.css" rel="stylesheet" type="text/css" />

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="${pageContext.request.contextPath }/media/image/favicon1.ico" />
	
	<script type="text/javascript">
		function validate(psw){
			with(document.all){
				var password = document.getElementById('password');
				if(oldPassword.value==""||password.value=="" ||repassword.value==""){
					alert("密码不能为空");
					return false;
				}else if(oldPassword.value!=psw){
					alert("旧密码输入不正确！");
					return false;
				}else if(password.value != repassword.value){
					alert("您输入两次密码不一致！");
					return false;
				}else {
				document.forms[0].submit();
				}
			}
		}
	</script>
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
	
							<i class="icon-user"></i>
							
							<span class="username">${user.name }</span>
	
							<i class="icon-angle-down"></i>
	
							</a>
	
							<ul class="dropdown-menu">
							
								<li><a href="${pageContext.request.contextPath}/useraction/getUserSelf.action"><i class="icon-user"></i>个人信息</a></li>

								<li><a href="#"><i class="icon-calendar"></i>我的预约</a></li>
	
								<li><a href="${pageContext.request.contextPath}/client/updatePassword.jsp"><i class="icon-edit"></i>修改密码</a></li>

								<li class="divider"></li>

								<li><a href="login.html"><i class="icon-key"></i>退出</a></li>
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

				<li class="start">

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

							<a href="#">场馆简介</a>

						</li>


						
						<li >

							<a href="#">场馆风采</a>

						</li>
						<li >

							<a href="#">场馆地图</a>

						</li>

					<!-- 	<li >

							<a href="layout_ajax.html">

							Content Loading via Ajax</a>

						</li>

						<li >

							<a href="layout_sidebar_closed.html">

							Sidebar Closed Page</a>

						</li>

						<li >

							<a href="layout_blank_page.html">

							Blank Page</a>

						</li>

						<li >

							<a href="layout_boxed_page.html">

							Boxed Page</a>

						</li>

						<li >

							<a href="layout_boxed_not_responsive.html">

							Non-Responsive Boxed Layout</a>

						</li>
 -->
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

							<a href="ui_general.html">

							羽毛球馆</a>

						</li>

						<li >

							<a href="ui_buttons.html">

							乒乓球馆</a>

						</li>

						<li >

							<a href="ui_modals.html">

							台球厅</a>

						</li>

						<li >

							<a href="ui_tabs_accordions.html">

							健身房</a>

						</li>

						<!-- <li >

							<a href="ui_jqueryui.html">

							jQuery UI Components</a>

						</li>

						<li >

							<a href="ui_sliders.html">

							Sliders</a>

						</li>

						<li >

							<a href="ui_tiles.html">

							Tiles</a>

						</li>

						<li >

							<a href="ui_typography.html">

							Typography</a>

						</li>

						<li >

							<a href="ui_tree.html">

							Tree View</a>

						</li>

						<li >

							<a href="ui_nestable.html">

							Nestable List</a>

						</li>
 -->
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

							<a href="#">

							场地预约</a>

						</li>

						<li >

							<a href="#">

							收费标准</a>

						</li>

						<!-- <li >

							<a href="form_component.html">

							Form Components</a>

						</li>

						<li >

							<a href="form_wizard.html">

							Form Wizard</a>

						</li>

						<li >

							<a href="form_validation.html">

							Form Validation</a>

						</li>

						<li >

							<a href="form_fileupload.html">

							Multiple File Upload</a>

						</li>

						<li >

							<a href="form_dropzone.html">

							Dropzone File Upload</a>

						</li> -->

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

							<a href="${pageContext.request.contextPath}/client/gymNews.jsp">

							<!-- <i class="icon-time"></i> -->

							最新公告</a>

						</li>

						<!-- <li >

							<a href="page_coming_soon.html">

							<i class="icon-cogs"></i>

							Coming Soon</a>

						</li>

						<li >

							<a href="page_blog.html">

							<i class="icon-comments"></i>

							Blog</a>

						</li>

						<li >

							<a href="page_blog_item.html">

							<i class="icon-font"></i>

							Blog Post</a>

						</li>

						<li >

							<a href="page_news.html">

							<i class="icon-coffee"></i>

							News</a>

						</li>

						<li >

							<a href="page_news_item.html">

							<i class="icon-bell"></i>

							News View</a>

						</li>

						<li >

							<a href="page_about.html">

							<i class="icon-group"></i>

							About Us</a>

						</li>

						<li >

							<a href="page_contact.html">

							<i class="icon-envelope-alt"></i>

							Contact Us</a>

						</li>

						<li >

							<a href="page_calendar.html">

							<i class="icon-calendar"></i>

							Calendar</a>

						</li> -->

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

							<a href="extra_profile.html">

							赛事申请表.doc</a>

						</li>

						<!-- <li >

							<a href="extra_lock.html">

							Lock Screen</a>

						</li>

						<li >

							<a href="extra_faq.html">

							FAQ</a>

						</li>

						<li >

							<a href="inbox.html">

							Inbox</a>

						</li>

						<li >

							<a href="extra_search.html">

							Search Results</a>

						</li>

						<li >

							<a href="extra_invoice.html">

							Invoice</a>

						</li>

						<li >

							<a href="extra_pricing_table.html">

							Pricing Tables</a>

						</li>

						<li >

							<a href="extra_image_manager.html">

							Image Manager</a>

						</li>

						<li >

							<a href="extra_404_option1.html">

							404 Page Option 1</a>

						</li>

						<li >

							<a href="extra_404_option2.html">

							404 Page Option 2</a>

						</li>

						<li >

							<a href="extra_404_option3.html">

							404 Page Option 3</a>

						</li>

						<li >

							<a href="extra_500_option1.html">

							500 Page Option 1</a>

						</li>

						<li >

							<a href="extra_500_option2.html">

							500 Page Option 2</a>

						</li> -->

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

								<li><a href="#">Sample Link 2</a></li>

								<li><a href="#">Sample Link 3</a></li>

							</ul>

						</li>

						<li>

							<a href="javascript:;">

							体育网站

							<span class="arrow"></span>

							</a>

							<ul class="sub-menu">

								<li><a href="http://cctv5.cntv.cn/" target="_blank">CCTV5</a></li>

								<li><a href="#">Sample Link 1</a></li>

								<li><a href="#">Sample Link 1</a></li>

							</ul>

						</li>

						<li>

							<a href="#">

							教育网站
							<span class="arrow"></span>
							</a>
							<ul class="sub-menu">

								<li><a href="http://www.cernet.edu.cn/" target="_blank">教育科研网</a></li>

								<li><a href="#">Sample Link 1</a></li>

								<li><a href="#">Sample Link 1</a></li>

							</ul>

						</li>

					</ul>

				</li>

				<!-- <li>

					<a href="javascript:;">

					<i class="icon-folder-open"></i> 

					<span class="title">4 Level Menu</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li>

							<a href="javascript:;">

							<i class="icon-cogs"></i> 

							Item 1

							<span class="arrow"></span>

							</a>

							<ul class="sub-menu">

								<li>

									<a href="javascript:;">

									<i class="icon-user"></i>

									Sample Link 1

									<span class="arrow"></span>

									</a>

									<ul class="sub-menu">

										<li><a href="#"><i class="icon-remove"></i> Sample Link 1</a></li>

										<li><a href="#"><i class="icon-pencil"></i> Sample Link 1</a></li>

										<li><a href="#"><i class="icon-edit"></i> Sample Link 1</a></li>

									</ul>

								</li>

								<li><a href="#"><i class="icon-user"></i>  Sample Link 1</a></li>

								<li><a href="#"><i class="icon-external-link"></i>  Sample Link 2</a></li>

								<li><a href="#"><i class="icon-bell"></i>  Sample Link 3</a></li>

							</ul>

						</li>

						<li>

							<a href="javascript:;">

							<i class="icon-globe"></i> 

							Item 2

							<span class="arrow"></span>

							</a>

							<ul class="sub-menu">

								<li><a href="#"><i class="icon-user"></i>  Sample Link 1</a></li>

								<li><a href="#"><i class="icon-external-link"></i>  Sample Link 1</a></li>

								<li><a href="#"><i class="icon-bell"></i>  Sample Link 1</a></li>

							</ul>

						</li>

						<li>

							<a href="#">

							<i class="icon-folder-open"></i>

							Item 3

							</a>

						</li>

					</ul>

				</li> -->

				<li class="start active">

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

							<a href="login.html">

							我的预约</a>

						</li>

						<li >

							<a href="${pageContext.request.contextPath}/client/updatePassword.jsp">

							修改密码</a>

						</li>

					</ul>

				</li>

				<!-- <li class="">

					<a href="javascript:;">

					<i class="icon-th"></i> 

					<span class="title">Data Tables</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li >

							<a href="table_basic.html">

							Basic Tables</a>

						</li>

						<li >

							<a href="table_responsive.html">

							Responsive Tables</a>

						</li>

						<li >

							<a href="table_managed.html">

							Managed Tables</a>

						</li>

						<li >

							<a href="table_editable.html">

							Editable Tables</a>

						</li>

						<li >

							<a href="table_advanced.html">

							Advanced Tables</a>

						</li>

					</ul>

				</li> -->

				<!-- <li class="">

					<a href="javascript:;">

					<i class="icon-file-text"></i> 

					<span class="title">Portlets</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li >

							<a href="portlet_general.html">

							General Portlets</a>

						</li>

						<li >

							<a href="portlet_draggable.html">

							Draggable Portlets</a>

						</li>

					</ul>

				</li> -->

				<!-- <li class="">

					<a href="javascript:;">

					<i class="icon-map-marker"></i> 

					<span class="title">Maps</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li >

							<a href="maps_google.html">

							Google Maps</a>

						</li>

						<li >

							<a href="maps_vector.html">

							Vector Maps</a>

						</li>

					</ul>

				</li>

				<li class="last ">

					<a href="charts.html">

					<i class="icon-bar-chart"></i> 

					<span class="title">Visual Charts</span>

					</a>

				</li> -->

			</ul>
			<!--  导航结束-->
			<!-- END SIDEBAR MENU -->

		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		

		<!-- END PAGE HEADER-->
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

							个人详细信息 <!-- <small>user profile sample</small>-->

						</h3>
     
						<!-- <ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#">Extra</a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#">User Profile</a></li>

						</ul> -->

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid profile">

					<div class="span12">

						<!--BEGIN TABS-->

						<div class="tabbable tabbable-custom tabbable-full-width">

							<ul class="nav nav-tabs">

								<!--  <li class="active"><a href="#tab_1_1" data-toggle="tab">Overview</a></li>

								<li><a href="#tab_1_2" data-toggle="tab">Profile Info</a></li>

								<li><a href="#tab_1_3" data-toggle="tab">Account</a></li>

								<li><a href="#tab_1_4" data-toggle="tab">Projects</a></li>

								<li><a href="#tab_1_6" data-toggle="tab">Help</a></li>-->
								<li class="active"><a href="#tab_1_3" data-toggle="tab">编辑个人信息</a></li>
							</ul>

							<div class="tab-content">
      
								<!--  <div class="tab-pane row-fluid active" id="tab_1_1">

									<ul class="unstyled profile-nav span3">

										<li><img src="media/image/profile-img.png" alt="" /> <a href="#" class="profile-edit">edit</a></li>

										<li><a href="#">Projects</a></li>

										<li><a href="#">Messages <span>3</span></a></li>

										<li><a href="#">Friends</a></li>

										<li><a href="#">Settings</a></li>

									</ul>

									<div class="span9">

										<div class="row-fluid">

											<div class="span8 profile-info">

												<h1>John Doe</h1>

												<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt laoreet dolore magna aliquam tincidunt erat volutpat laoreet dolore magna aliquam tincidunt erat volutpat.</p>

												<p><a href="#">www.mywebsite.com</a></p>

												<ul class="unstyled inline">

													<li><i class="icon-map-marker"></i> Spain</li>

													<li><i class="icon-calendar"></i> 18 Jan 1982</li>

													<li><i class="icon-briefcase"></i> Design</li>

													<li><i class="icon-star"></i> Top Seller</li>

													<li><i class="icon-heart"></i> BASE Jumping</li>

												</ul>

											</div>

											<!--end span8-->

											<!--  <div class="span4">

												<div class="portlet sale-summary">

													<div class="portlet-title">

														<div class="caption">Sales Summary</div>

														<div class="tools">

															<a class="reload" href="javascript:;"></a>

														</div>

													</div>

													<ul class="unstyled">

														<li>

															<span class="sale-info">TODAY SOLD <i class="icon-img-up"></i></span> 

															<span class="sale-num">23</span>

														</li>

														<li>

															<span class="sale-info">WEEKLY SALES <i class="icon-img-down"></i></span> 

															<span class="sale-num">87</span>

														</li>

														<li>

															<span class="sale-info">TOTAL SOLD</span> 

															<span class="sale-num">2377</span>

														</li>

														<li>

															<span class="sale-info">EARNS</span> 

															<span class="sale-num">$37.990</span>

														</li>

													</ul>

												</div>

											</div>

											<!--end span4-->

										<!--  </div>-->

										<!--end row-fluid-->

										<!-- <div class="tabbable tabbable-custom tabbable-custom-profile">

											<ul class="nav nav-tabs">

												<li class="active"><a href="#tab_1_11" data-toggle="tab">Latest Customers</a></li>

												<li class=""><a href="#tab_1_22" data-toggle="tab">Feeds</a></li>

											</ul>

											<div class="tab-content">

												<div class="tab-pane active" id="tab_1_11">

													<div class="portlet-body" style="display: block;">

														<table class="table table-striped table-bordered table-advance table-hover">

															<thead>

																<tr>

																	<th><i class="icon-briefcase"></i> Company</th>

																	<th class="hidden-phone"><i class="icon-question-sign"></i> Descrition</th>

																	<th><i class="icon-bookmark"></i> Amount</th>

																	<th></th>

																</tr>

															</thead>

															<tbody>

																<tr>

																	<td><a href="#">Pixel Ltd</a></td>

																	<td class="hidden-phone">Server hardware purchase</td>

																	<td>52560.10$ <span class="label label-success label-mini">Paid</span></td>

																	<td><a class="btn mini green-stripe" href="#">View</a></td>

																</tr>

																<tr>

																	<td>

																		<a href="#">

																		Smart House

																		</a>  

																	</td>

																	<td class="hidden-phone">Office furniture purchase</td>

																	<td>5760.00$ <span class="label label-warning label-mini">Pending</span></td>

																	<td><a class="btn mini blue-stripe" href="#">View</a></td>

																</tr>

																<tr>

																	<td>

																		<a href="#">

																		FoodMaster Ltd

																		</a>

																	</td>

																	<td class="hidden-phone">Company Anual Dinner Catering</td>

																	<td>12400.00$ <span class="label label-success label-mini">Paid</span></td>

																	<td><a class="btn mini blue-stripe" href="#">View</a></td>

																</tr>

																<tr>

																	<td>

																		<a href="#">

																		WaterPure Ltd

																		</a>

																	</td>

																	<td class="hidden-phone">Payment for Jan 2013</td>

																	<td>610.50$ <span class="label label-danger label-mini">Overdue</span></td>

																	<td><a class="btn mini red-stripe" href="#">View</a></td>

																</tr>

																<tr>

																	<td><a href="#">Pixel Ltd</a></td>

																	<td class="hidden-phone">Server hardware purchase</td>

																	<td>52560.10$ <span class="label label-success label-mini">Paid</span></td>

																	<td><a class="btn mini green-stripe" href="#">View</a></td>

																</tr>

																<tr>

																	<td>

																		<a href="#">

																		Smart House

																		</a>  

																	</td>

																	<td class="hidden-phone">Office furniture purchase</td>

																	<td>5760.00$ <span class="label label-warning label-mini">Pending</span></td>

																	<td><a class="btn mini blue-stripe" href="#">View</a></td>

																</tr>

																<tr>

																	<td>

																		<a href="#">

																		FoodMaster Ltd

																		</a>

																	</td>

																	<td class="hidden-phone">Company Anual Dinner Catering</td>

																	<td>12400.00$ <span class="label label-success label-mini">Paid</span></td>

																	<td><a class="btn mini blue-stripe" href="#">View</a></td>

																</tr>

															</tbody>

														</table>

													</div>

												</div>

												<!--tab-pane-->

												<!--  <div class="tab-pane" id="tab_1_22">

													<div class="tab-pane active" id="tab_1_1_1">

														<div class="scroller" data-height="290px" data-always-visible="1" data-rail-visible1="1">

															<ul class="feeds">

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label label-success">                        

																					<i class="icon-bell"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					You have 4 pending tasks.

																					<span class="label label-important label-mini">

																					Take action 

																					<i class="icon-share-alt"></i>

																					</span>

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			Just now

																		</div>

																	</div>

																</li>

																<li>

																	<a href="#">

																		<div class="col1">

																			<div class="cont">

																				<div class="cont-col1">

																					<div class="label label-success">                        

																						<i class="icon-bell"></i>

																					</div>

																				</div>

																				<div class="cont-col2">

																					<div class="desc">

																						New version v1.4 just lunched!   

																					</div>

																				</div>

																			</div>

																		</div>

																		<div class="col2">

																			<div class="date">

																				20 mins

																			</div>

																		</div>

																	</a>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label label-important">                      

																					<i class="icon-bolt"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					Database server #12 overloaded. Please fix the issue.                      

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			24 mins

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label label-info">                        

																					<i class="icon-bullhorn"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					New order received. Please take care of it.                 

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			30 mins

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label label-success">                        

																					<i class="icon-bullhorn"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					New order received. Please take care of it.                 

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			40 mins

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label label-warning">                        

																					<i class="icon-plus"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					New user registered.                

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			1.5 hours

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label label-success">                        

																					<i class="icon-bell-alt"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					Web server hardware needs to be upgraded. 

																					<span class="label label-inverse label-mini">Overdue</span>             

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			2 hours

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label">                       

																					<i class="icon-bullhorn"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					New order received. Please take care of it.                 

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			3 hours

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label label-warning">                        

																					<i class="icon-bullhorn"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					New order received. Please take care of it.                 

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			5 hours

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label label-info">                        

																					<i class="icon-bullhorn"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					New order received. Please take care of it.                 

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			18 hours

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label">                       

																					<i class="icon-bullhorn"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					New order received. Please take care of it.                 

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			21 hours

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label label-info">                        

																					<i class="icon-bullhorn"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					New order received. Please take care of it.                 

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			22 hours

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label">                       

																					<i class="icon-bullhorn"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					New order received. Please take care of it.                 

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			21 hours

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label label-info">                        

																					<i class="icon-bullhorn"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					New order received. Please take care of it.                 

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			22 hours

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label">                       

																					<i class="icon-bullhorn"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					New order received. Please take care of it.                 

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			21 hours

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label label-info">                        

																					<i class="icon-bullhorn"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					New order received. Please take care of it.                 

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			22 hours

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label">                       

																					<i class="icon-bullhorn"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					New order received. Please take care of it.                 

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			21 hours

																		</div>

																	</div>

																</li>

																<li>

																	<div class="col1">

																		<div class="cont">

																			<div class="cont-col1">

																				<div class="label label-info">                        

																					<i class="icon-bullhorn"></i>

																				</div>

																			</div>

																			<div class="cont-col2">

																				<div class="desc">

																					New order received. Please take care of it.                 

																				</div>

																			</div>

																		</div>

																	</div>

																	<div class="col2">

																		<div class="date">

																			22 hours

																		</div>

																	</div>

																</li>

															</ul>

														</div>

													</div>

												</div>

												<!--tab-pane-->

										<!--  	</div>

										</div>

									</div>

									<!--end span9-->

								<!--  </div>--><!-- 第一个结束 -->

								<!--end tab-pane-->

								<!--  <div class="tab-pane profile-classic row-fluid" id="tab_1_2">-->
								<!--  <div class="tab-pane profile-classic row-fluid active" id="tab_1_2">
									<div class="span2"><img src="media/image/profile-img.png" alt="" /> <a href="#" class="profile-edit">edit</a></div>

									<ul class="unstyled span10">

										<li><span>用户名：</span>${user.studentNo}</li>

										<li><span>姓名：</span> ${user.name }</li>

										<li><span>学院：</span> ${user.academy}</li>

										<li><span>专业：</span> ${user.major}</li>

										<li><span>班级：</span> ${user.className }</li>

										<li><span>性别：</span>${user.gender}</li>

										<li><span>联系方式：</span>${user.telephone}</a></li>

										<!-- <li><span>Interests:</span> Design, Web etc.</li>

										<li><span>Website Url:</span> <a href="#">http://www.mywebsite.com</a></li>

										<li><span>Mobile Number:</span> +1 646 580 DEMO (6284)</li>

										<li><span>About:</span> Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod.</li>
										 -->
									<!--  </ul>
									<div align="right">
									<a href="#" class="btn blue"><i class="icon-pencil"></i> 编辑个人信息</a>
									</div>

								</div>
<!-- 第二个结束 -->
								<!--tab_1_2-->

								 <!-- <div class="tab-pane row-fluid profile-account" id="tab_1_3">-->
								 <div class="tab-pane row-fluid profile-account active" id="tab_1_3">

									<div class="row-fluid">

										<div class="span12">

											<!--  <div class="span3">
												
												 <ul class="ver-inline-menu tabbable margin-bottom-10">

													<li class="active">

														<a data-toggle="tab" href="#tab_1-1">

														<i class="icon-cog"></i> 

														Personal info

														</a> 

														<span class="after"></span>                                    

													</li>

													<li class=""><a data-toggle="tab" href="#tab_2-2"><i class="icon-picture"></i> Change Avatar</a></li>

													<li class=""><a data-toggle="tab" href="#tab_3-3"><i class="icon-lock"></i> Change Password</a></li>

													<li class=""><a data-toggle="tab" href="#tab_4-4"><i class="icon-eye-open"></i> Privacity Settings</a></li>

												</ul>

											</div>-->
											<div class="span3"><img src="${pageContext.request.contextPath }/media/image/profile-img.png" alt="" /> <a href="#" class="profile-edit"></a></div>
											<div class="span9">

												<div class="tab-content">

													<div id="tab_1-1" class="tab-pane active">

														<div style="height: auto;" id="accordion1-1" class="accordion collapse">

															<form role="form" action="${pageContext.request.contextPath}/useraction/clientUpdatePassword.action" onsubmit="return validate('${user.password}')" method="post">

																<input type="text" value="${user.id }" name="user.id" style="display: none;">
																
																<label class="control-label">旧密码</label>

																<input type="password" placeholder="请输入原密码"name="oldPassword" class="m-wrap span8"/>

																<label class="control-label">新密码</label>

																<input type="password" placeholder="请输入新密码" id="password"  name="user.password"class="m-wrap span8" />

																<label class="control-label">确定新密码</label>

																<input type="password" placeholder="请确定新密码"name="repassword" class="m-wrap span8" />

																
																<div class="submit-btn">

																	<input type="submit" class="btn green" value="保存">

																	<a href="#" class="btn">取消</a>

																</div>

															</form>

														</div>

													</div>

													<div id="tab_2-2" class="tab-pane">

														<div style="height: auto;" id="accordion2-2" class="accordion collapse">

															<form action="#">

																<p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod.</p>

																<br />

																<div class="controls">

																	<div class="thumbnail" style="width: 291px; height: 170px;">

																		<img src="media/image/AAAAAA&amp;text=no+image" alt="" />

																	</div>

																</div>

																<div class="space10"></div>

																<div class="fileupload fileupload-new" data-provides="fileupload">

																	<div class="input-append">

																		<div class="uneditable-input">

																			<i class="icon-file fileupload-exists"></i> 

																			<span class="fileupload-preview"></span>

																		</div>

																		<span class="btn btn-file">

																		<span class="fileupload-new">Select file</span>

																		<span class="fileupload-exists">Change</span>

																		<input type="file" class="default" />

																		</span>

																		<a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>

																	</div>

																</div>

																<div class="clearfix"></div>

																<div class="controls">

																	<span class="label label-important">NOTE!</span>

																	<span>You can write some information here..</span>

																</div>

																<div class="space10"></div>

																<div class="submit-btn">

																	<a href="#" class="btn green">Submit</a>

																	<a href="#" class="btn">Cancel</a>

																</div>

															</form>

														</div>

													</div>

													<div id="tab_3-3" class="tab-pane">

														<div style="height: auto;" id="accordion3-3" class="accordion collapse">

															<form action="#">

																<label class="control-label">Current Password</label>

																<input type="password" class="m-wrap span8" />

																<label class="control-label">New Password</label>

																<input type="password" class="m-wrap span8" />

																<label class="control-label">Re-type New Password</label>

																<input type="password" class="m-wrap span8" />

																<div class="submit-btn">

																	<a href="#" class="btn green">Change Password</a>

																	<a href="#" class="btn">Cancel</a>

																</div>

															</form>

														</div>

													</div>

													<div id="tab_4-4" class="tab-pane">

														<div style="height: auto;" id="accordion4-4" class="accordion collapse">

															<form action="#">

																<div class="profile-settings row-fluid">

																	<div class="span9">

																		<p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus..</p>

																	</div>

																	<div class="control-group span3">

																		<div class="controls">

																			<label class="radio">

																			<input type="radio" name="optionsRadios1" value="option1" />

																			Yes

																			</label>

																			<label class="radio">

																			<input type="radio" name="optionsRadios1" value="option2" checked />

																			No

																			</label>  

																		</div>

																	</div>

																</div>

																<!--end profile-settings-->

																  <div class="profile-settings row-fluid">

																	<div class="span9">

																		<p>Enim eiusmod high life accusamus terry richardson ad squid wolf moon</p>

																	</div>

																	<div class="control-group span3">

																		<div class="controls">

																			<label class="checkbox">

																			<input type="checkbox" value="" /> All

																			</label>

																			<label class="checkbox">

																			<input type="checkbox" value="" /> Friends

																			</label>

																		</div>

																	</div>

																</div>

																<!--end profile-settings-->

																  <div class="profile-settings row-fluid">

																	<div class="span9">

																		<p>Pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson</p>

																	</div>

																	<div class="control-group span3">

																		<div class="controls">

																			<label class="checkbox">

																			<input type="checkbox" value="" /> Yes

																			</label>

																		</div>

																	</div>

																</div>

																<!--end profile-settings-->

																  <div class="profile-settings row-fluid">

																	<div class="span9">

																		<p>Cliche reprehenderit enim eiusmod high life accusamus terry</p>

																	</div>

																	<div class="control-group span3">

																		<div class="controls">

																			<label class="checkbox">

																			<input type="checkbox" value="" /> Yes

																			</label>

																		</div>

																	</div>

																</div>

																<!--end profile-settings-->

																  <div class="profile-settings row-fluid">

																	<div class="span9">

																		<p>Oiusmod high life accusamus terry richardson ad squid wolf fwopo</p>

																	</div>

																	<div class="control-group span3">

																		<div class="controls">

																			<label class="checkbox">

																			<input type="checkbox" value="" /> Yes

																			</label>

																		</div>

																	</div>

																</div>

																<!--end profile-settings-->

																  <div class="space5"></div>

																<div class="submit-btn">

																	<a href="#" class="btn green">Save Changes</a>

																	<a href="#" class="btn">Cancel</a>

																</div>

															</form>

														</div>

													</div>

												</div>

											</div>

											<!--end span9-->                                   

										 </div>

									</div>

								</div>

								<!--end tab-pane-->
								<!--第三个结束  -->
								<!--  <div class="tab-pane" id="tab_1_4">

									<div class="row-fluid add-portfolio">

										<div class="pull-left">

											<span>502 Items sold this week</span>

										</div>

										<div class="pull-left">

											<a href="#" class="btn icn-only green">Add a new Project <i class="m-icon-swapright m-icon-white"></i></a>                          

										</div>

									</div>

									<!--end add-portfolio-->

									<!--  <div class="row-fluid portfolio-block">

										<div class="span5 portfolio-text">

											<img src="media/image/logo_metronic.jpg" alt="" />

											<div class="portfolio-text-info">

												<h4>Metronic - Responsive Template</h4>

												<p>Lorem ipsum dolor sit consectetuer adipiscing elit.</p>

											</div>

										</div>

										<div class="span5" style="overflow:hidden;">

											<div class="portfolio-info">

												Today Sold

												<span>187</span>

											</div>

											<div class="portfolio-info">

												Total Sold

												<span>1789</span>

											</div>

											<div class="portfolio-info">

												Earns

												<span>$37.240</span>

											</div>

										</div>

										<div class="span2 portfolio-btn">

											<a href="#" class="btn bigicn-only"><span>Manage</span></a>                      

										</div>

									</div>

									<!--end row-fluid-->

									<!--  <div class="row-fluid portfolio-block">

										<div class="span5 portfolio-text">

											<img src="media/image/logo_azteca.jpg" alt="" />

											<div class="portfolio-text-info">

												<h4>Metronic - Responsive Template</h4>

												<p>Lorem ipsum dolor sit consectetuer adipiscing elit.</p>

											</div>

										</div>

										<div class="span5">

											<div class="portfolio-info">

												Today Sold

												<span>24</span>

											</div>

											<div class="portfolio-info">

												Total Sold

												<span>660</span>

											</div>

											<div class="portfolio-info">

												Earns

												<span>$7.060</span>

											</div>

										</div>

										<div class="span2 portfolio-btn">

											<a href="#" class="btn bigicn-only"><span>Manage</span></a>                      

										</div>

									</div>

									<!--end row-fluid-->

									<!--  <div class="row-fluid portfolio-block">

										<div class="span5 portfolio-text">

											<img src="media/image/logo_conquer.jpg" alt="" />

											<div class="portfolio-text-info">

												<h4>Metronic - Responsive Template</h4>

												<p>Lorem ipsum dolor sit consectetuer adipiscing elit.</p>

											</div>

										</div>

										<div class="span5" style="overflow:hidden;">

											<div class="portfolio-info">

												Today Sold

												<span>24</span>

											</div>

											<div class="portfolio-info">

												Total Sold

												<span>975</span>

											</div>

											<div class="portfolio-info">

												Earns

												<span>$21.700</span>

											</div>

										</div>

										<div class="span2 portfolio-btn">

											<a href="#" class="btn bigicn-only"><span>Manage</span></a>                      

										</div>

									</div>

									<!--end row-fluid-->

								<!--  </div>-->

								<!--end tab-pane-->
								<!-- 第四个结束 -->
								<!--  <div class="tab-pane row-fluid" id="tab_1_6">

									<div class="row-fluid">

										<div class="span12">

											<div class="span3">

												<ul class="ver-inline-menu tabbable margin-bottom-10">

													<li class="active">

														<a data-toggle="tab" href="#tab_1">

														<i class="icon-briefcase"></i> 

														General Questions

														</a> 

														<span class="after"></span>                                    

													</li>

													<li><a data-toggle="tab" href="#tab_2"><i class="icon-group"></i> Membership</a></li>

													<li><a data-toggle="tab" href="#tab_3"><i class="icon-leaf"></i> Terms Of Service</a></li>

													<li><a data-toggle="tab" href="#tab_1"><i class="icon-info-sign"></i> License Terms</a></li>

													<li><a data-toggle="tab" href="#tab_2"><i class="icon-tint"></i> Payment Rules</a></li>

													<li><a data-toggle="tab" href="#tab_3"><i class="icon-plus"></i> Other Questions</a></li>

												</ul>

											</div>

											<div class="span9">

												<div class="tab-content">

													<div id="tab_1" class="tab-pane active">

														<div style="height: auto;" id="accordion1" class="accordion collapse">

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_1" data-parent="#accordion1" data-toggle="collapse" class="accordion-toggle collapsed">

																	Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry ?

																	</a>

																</div>

																<div class="accordion-body collapse in" id="collapse_1">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_2" data-parent="#accordion1" data-toggle="collapse" class="accordion-toggle collapsed">

																	Pariatur cliche reprehenderit enim eiusmod highr brunch ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_2">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_3" data-parent="#accordion1" data-toggle="collapse" class="accordion-toggle collapsed">

																	Food truck quinoa nesciunt laborum eiusmod nim eiusmod high life accusamus  ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_3">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_4" data-parent="#accordion1" data-toggle="collapse" class="accordion-toggle collapsed">

																	High life accusamus terry richardson ad ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_4">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_5" data-parent="#accordion1" data-toggle="collapse" class="accordion-toggle collapsed">

																	Reprehenderit enim eiusmod high life accusamus terry quinoa nesciunt laborum eiusmod ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_5">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_6" data-parent="#accordion1" data-toggle="collapse" class="accordion-toggle collapsed">

																	Wolf moon officia aute non cupidatat skateboard dolor brunch ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_6">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																	</div>

																</div>

															</div>

														</div>

													</div>

													<div id="tab_2" class="tab-pane">

														<div style="height: auto;" id="accordion2" class="accordion collapse">

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_2_1" data-parent="#accordion2" data-toggle="collapse" class="accordion-toggle collapsed">

																	Cliche reprehenderit, enim eiusmod high life accusamus enim eiusmod ?

																	</a>

																</div>

																<div class="accordion-body collapse in" id="collapse_2_1">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_2_2" data-parent="#accordion2" data-toggle="collapse" class="accordion-toggle collapsed">

																	Pariatur cliche reprehenderit enim eiusmod high life non cupidatat skateboard dolor brunch ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_2_2">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_2_3" data-parent="#accordion2" data-toggle="collapse" class="accordion-toggle collapsed">

																	Food truck quinoa nesciunt laborum eiusmod ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_2_3">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_2_4" data-parent="#accordion2" data-toggle="collapse" class="accordion-toggle collapsed">

																	High life accusamus terry richardson ad squid enim eiusmod high ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_2_4">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_2_5" data-parent="#accordion2" data-toggle="collapse" class="accordion-toggle collapsed">

																	Reprehenderit enim eiusmod high life accusamus terry quinoa nesciunt laborum eiusmod ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_2_5">

																	<div class="accordion-inner">

																		<p>

																			Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																		</p>

																		<p> 

																			moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmodBrunch 3 wolf moon tempor

																		</p>

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_2_6" data-parent="#accordion2" data-toggle="collapse" class="accordion-toggle collapsed">

																	Wolf moon officia aute non cupidatat skateboard dolor brunch ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_2_6">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_2_7" data-parent="#accordion2" data-toggle="collapse" class="accordion-toggle collapsed">

																	Reprehenderit enim eiusmod high life accusamus terry quinoa nesciunt laborum eiusmod ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_2_7">

																	<div class="accordion-inner">

																		<p>

																			Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																		</p>

																		<p> 

																			moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmodBrunch 3 wolf moon tempor

																		</p>

																	</div>

																</div>

															</div>

														</div>

													</div>

													<div id="tab_3" class="tab-pane">

														<div style="height: auto;" id="accordion3" class="accordion collapse">

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_3_1" data-parent="#accordion3" data-toggle="collapse" class="accordion-toggle collapsed">

																	Cliche reprehenderit, enim eiusmod ?

																	</a>

																</div>

																<div class="accordion-body collapse in" id="collapse_3_1">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_3_2" data-parent="#accordion3" data-toggle="collapse" class="accordion-toggle collapsed">

																	Pariatur skateboard dolor brunch ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_3_2">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_3_3" data-parent="#accordion3" data-toggle="collapse" class="accordion-toggle collapsed">

																	Food truck quinoa nesciunt laborum eiusmod ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_3_3">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_3_4" data-parent="#accordion3" data-toggle="collapse" class="accordion-toggle collapsed">

																	High life accusamus terry richardson ad squid enim eiusmod high ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_3_4">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_3_5" data-parent="#accordion3" data-toggle="collapse" class="accordion-toggle collapsed">

																	Reprehenderit enim eiusmod high  eiusmod ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_3_5">

																	<div class="accordion-inner">

																		<p>

																			Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																		</p>

																		<p> 

																			moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmodBrunch 3 wolf moon tempor

																		</p>

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_3_6" data-parent="#accordion3" data-toggle="collapse" class="accordion-toggle collapsed">

																	Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_3_6">

																	<div class="accordion-inner">

																		Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_3_7" data-parent="#accordion3" data-toggle="collapse" class="accordion-toggle collapsed">

																	Reprehenderit enim eiusmod high life accusamus aborum eiusmod ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_3_7">

																	<div class="accordion-inner">

																		<p>

																			Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																		</p>

																		<p> 

																			moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmodBrunch 3 wolf moon tempor

																		</p>

																	</div>

																</div>

															</div>

															<div class="accordion-group">

																<div class="accordion-heading">

																	<a href="#collapse_3_8" data-parent="#accordion3" data-toggle="collapse" class="accordion-toggle collapsed">

																	Reprehenderit enim eiusmod high life accusamus terry quinoa nesciunt laborum eiusmod ?

																	</a>

																</div>

																<div class="accordion-body collapse" id="collapse_3_8">

																	<div class="accordion-inner">

																		<p>

																			Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor.

																		</p>

																		<p> 

																			moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmodBrunch 3 wolf moon tempor

																		</p>

																	</div>

																</div>

															</div>

														</div>

													</div>

												</div>

											</div>

											<!--end span9-->                                   

										<!--  </div>

									</div>

								</div>

								<!--end tab-pane-->
								<!-- 第六个结束 -->
							</div>

						</div>

						<!--END TABS-->

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
	
	
	
	<script src="${pageContext.request.contextPath }/js/dwz.ajax.js" type="text/javascript"></script>
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

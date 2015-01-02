<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
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

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/bootstrap-fileupload.css" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/jquery.gritter.css" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/chosen.css" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/select2_metro.css" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/jquery.tagsinput.css" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/clockface.css" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/bootstrap-wysihtml5.css" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/datepicker.css" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/timepicker.css" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/colorpicker.css" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/bootstrap-toggle-buttons.css" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/daterangepicker.css" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/datetimepicker.css" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/multi-select-metro.css" />

	<link href="${pageContext.request.contextPath }/media/css/bootstrap-modal.css" rel="stylesheet" type="text/css"/>

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="${pageContext.request.contextPath }/media/image/favicon1.ico" />

	<script src="${pageContext.request.contextPath }/js/dateTimePicker.js" type="text/javascript" language="javascript"></script>
  </head>
  
 <body class="page-header-fixed">

	<c:if test="${!empty message}">
		<script type="text/javascript">
			alert("${message}");
		</script>
	</c:if>

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
							
								<li><a href="#"><i class="icon-user"></i>个人信息</a></li>

								<li><a href="#"><i class="icon-calendar"></i>我的预约</a></li>
	
								<li><a href="#"><i class="icon-edit"></i>修改密码</a></li>

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

				<li class="">

					<a href="#">

					<i class="icon-home"></i> 

					<span class="title">首页</span>


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

					</ul>

				</li>

				<li class=" start active ">

					<a href="javascript:;">

					<i class="icon-qrcode"></i> 

					<span class="title">场地预约</span>
					
					<span class="selected"></span>

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

							<a href="page_timeline.html">

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

							<a href="extra_profile.html">

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


				<li class="">

					<a href="javascript:;">

					<i class="icon-user"></i> 

					<span class="title">个人中心</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li >

							<a href="login.html">

							个人信息</a>

						</li>
						<li >

							<a href="login.html">

							我的预约</a>

						</li>

						<li >

							<a href="login_soft.html">

							修改密码</a>

						</li>

					</ul>

				</li>


			</ul>

			<!-- END SIDEBAR MENU -->

		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<div id="portlet-config" class="modal hide">

				<div class="modal-header">

					<button data-dismiss="modal" class="close" type="button"></button>

					<h3>Widget Settings</h3>

				</div>

				<div class="modal-body">

					Widget settings form goes here

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

						<h3 class="page-title" style="font-family: 微软雅黑;">

							场地预约 <small>请认真填写预约表单</small>

						</h3>

						<!-- <ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#">Dashboard</a></li>


						</ul> -->

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->
				
				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN PORTLET-->   

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-reorder"></i>场地预约表单</div>


							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form action="${pageContext.request.contextPath }/site/clientAddSiteOrder.action" class="form-horizontal" method="post">
								
								<div class="control-group">

										<label class="control-label">选择场地</label>

										<div class="controls">

											<select class="span3 m-wrap" data-placeholder="Choose a Category" tabindex="1" name="siteOrder.siteId">

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

										</div>

									</div>

									<div class="control-group">

										<label class="control-label">预约开始时间</label>

										<div class="controls">

											<div class="input-append date ">

												<input size="16" type="text" value="" readonly  class="m-wrap" name="siteOrder.stratTime" onclick="SetDate(this,'yyyy-MM-dd hh:mm:ss')">

												<span class="add-on"><i class="icon-calendar"></i></span>

											</div>

										</div>
									</div>
										<div class="control-group">

										<label class="control-label">预约结束时间</label>

										<div class="controls">

											<div class="input-append date ">

												<input size="16" type="text" value="" readonly class="m-wrap" name="siteOrder.endTime" onclick="SetDate(this,'yyyy-MM-dd hh:mm:ss')">

												<span class="add-on"><i class="icon-calendar"></i></span>

											</div>

										</div>

									</div>
									<div class="form-actions">

										<button type="submit" class="btn blue">提交</button>

										<button type="button" class="btn">取消</button>                            

									</div>
								</form>

								

								<!-- END FORM-->  

							</div>

						</div>

						<!-- END PORTLET-->

					</div>

				</div>

			</div>
		</div>
	</div>
				<!-- END PAGE CONTENT-->   

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

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/ckeditor.js"></script>  

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/bootstrap-fileupload.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/chosen.jquery.min.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/select2.min.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/wysihtml5-0.3.0.js"></script> 

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/bootstrap-wysihtml5.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/jquery.tagsinput.min.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/jquery.toggle.buttons.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/bootstrap-datepicker.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/bootstrap-datetimepicker.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/clockface.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/date.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/daterangepicker.js"></script> 

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/bootstrap-colorpicker.js"></script>  

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/bootstrap-timepicker.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/jquery.inputmask.bundle.min.js"></script>   

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/jquery.input-ip-address-control-1.0.min.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/jquery.multi-select.js"></script>   

	<script src="${pageContext.request.contextPath }/media/js/bootstrap-modal.js" type="text/javascript" ></script>

	<script src="${pageContext.request.contextPath }/media/js/bootstrap-modalmanager.js" type="text/javascript" ></script> 

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${pageContext.request.contextPath }/media/js/app.js"></script>

	<script src="${pageContext.request.contextPath }/media/js/form-components.js"></script>     

	<!-- END PAGE LEVEL SCRIPTS -->

	<script>

		jQuery(document).ready(function() {       

		   // initiate layout and plugins

		   App.init();

		   FormComponents.init();

		});

	</script>

	<!-- END JAVASCRIPTS -->  

	<!-- END JAVASCRIPTS -->

</body>
</html>

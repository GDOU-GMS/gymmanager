<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>体育馆管理系统</title>

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

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/media/css/select2_metro.css" />

	<link rel="stylesheet" href="${pageContext.request.contextPath }/media/css/DT_bootstrap.css" />

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="${pageContext.request.contextPath }/media/image/favicon1.ico" />

	<script type="text/javascript">
		function confirmDelete(){
			confirm("您确定要删除这一条数据吗？");
		}
	</script>
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

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


				<li class="start active ">

					<a href="javascript:;">

					<i class="icon-user"></i> 

					<span class="title">个人中心</span>
					
					<span class="selected"></span>

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

							我的预约<small></small>

						</h3>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-edit"></i>预约记录</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

								</div>

							</div>

							<div class="portlet-body">

								<div class="clearfix">

									<div class="btn-group">

										<a id="" class="btn green" href="${pageContext.request.contextPath }/site/clientGetDataForAddSiteOrder.action">

										预约场地 <i class="icon-plus"></i>

										</a>

									</div>

								</div>

								<table class="table table-striped table-hover table-bordered" id="sample_editable_1">

									<thead>

										<tr>

											<th>预约ID</th>

											<th>开始时间</th>

											<th>结束时间</th>

											<th>场地名称</th>

											<th>预约时间</th>
											
											<th>状态</th>

											<th>删除</th>

										</tr>

									</thead>

									<tbody>
									
										<c:forEach items="${siteOrders }" var="siteOrder">
										
											<tr class="">

												<td>${siteOrder.id }</td>
	
												<td>${siteOrder.stratTime }</td>
	
												<td>${siteOrder.endTime }</td>
	
												<td class="">${siteOrder.sitename }</td>
												
												<td class="">${siteOrder.orderTime }</td>
												
												<td class="">
													<c:if test="${siteOrder.statue eq 'passed' }">
														<span class="label label-warning">已过期</span>
													</c:if>
													<c:if test="${siteOrder.statue eq 'unpassed' }">
														<span class="label label-success">未过期</span>
													</c:if>
												</td>
	
												<td><a class="" href="${pageContext.request.contextPath }/site/clientDeleteSiteOrder.action?id=${siteOrder.id}" onclick="return confirmDelete();">删除</a></td>

											</tr>
										
										</c:forEach>

									</tbody>

								</table>

							</div>

						</div>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT -->

			</div>

			<!-- END PAGE CONTAINER-->

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<div class="footer">

		<div class="footer-inner">

			2013 &copy; Metronic by keenthemes.Collect from <a href="http://www.cssmoban.com/" title="网站模板" target="_blank">网站模板</a> - More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>

		</div>

		<div class="footer-tools">

			<span class="go-top">

			<i class="icon-angle-up"></i>

			</span>

		</div>

	</div>

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

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/select2.min.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/jquery.dataTables.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/DT_bootstrap.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${pageContext.request.contextPath }/media/js/app.js"></script>

	<script src="${pageContext.request.contextPath }/media/js/table-editable.js"></script>    

	<script>

		jQuery(document).ready(function() {       

		   App.init();

		   TableEditable.init();

		});

	</script>

</body>

<!-- END BODY -->

</html>

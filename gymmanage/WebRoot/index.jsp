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
<%
	if (request.getAttribute("flag") == null) {
		response.sendRedirect("forwardToIndex.action");
	}
%>
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

	<link href="${pageContext.request.contextPath }/media/css/promo.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath }/media/css/animate.css" rel="stylesheet" type="text/css"/>

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

								<li><a href="#"><i class="icon-calendar"></i>我的预约</a></li>
	
								<li><a href="#"><i class="icon-edit"></i>修改密码</a></li>

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

				<li class="start active ">

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

							<a href="${pageContext.request.contextPath}/useraction/checkBeforeUpdatePassword.action">

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
        
        
        
        <div class="page-container row-fluid">

		<!-- BEGIN EMPTY PAGE SIDEBAR -->

		<div class="page-sidebar nav-collapse collapse visible-phone visible-tablet">

			<ul class="page-sidebar-menu">

				<li class="visible-phone visible-tablet">

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

				<li>

					<a class="active" href="index.html">

					Dashboard                        

					</a>

				</li>

				<li  class="active">

					<a href="javascript:;">

					Layouts

					<span class="arrow open"></span>   

					<span class="selected"></span>   

					</a>

					<ul class="sub-menu">

						<li>

							<a href="layout_horizontal_sidebar_menu.html">

							Horzontal & Sidebar Menu                     </a>

						</li>

						<li >

							<a href="layout_horizontal_menu1.html">

							Horzontal Menu 1                    </a>

						</li>

						<li >

							<a href="layout_horizontal_menu2.html">

							Horzontal Menu 2                    </a>

						</li>

						<li >

							<a href="layout_promo.html">

							Promo Page                     

							</a>

						</li>

						<li >

							<a href="layout_email.html">

							Email Templates                     </a>

						</li>

						<li >

							<a href="layout_ajax.html">

							Content Loading via Ajax</a>

						</li>

						<li >

							<a href="layout_sidebar_closed.html">

							Sidebar Closed Page                    </a>

						</li>

						<li >

							<a href="layout_blank_page.html">

							Blank Page                    </a>

						</li>

						<li >

							<a href="layout_boxed_page.html">Boxed Page</a>

						</li>

						<li >

							<a href="layout_boxed_not_responsive.html">

							Non-Responsive Boxed Layout                     </a>

						</li>

						<li >

							<a href="layout_blank_page.html">

							Blank Page                    </a>

						</li>

						<li>

							<a href="javascript:;">

							More options

							<span class="arrow"></span>

							</a>

							<ul class="sub-menu">

								<li><a href="#">Second level link</a></li>

								<li>

									<a href="javascript:;">More options<span class="arrow"></span></a>

									<ul class="sub-menu">

										<li><a href="index.html">Third level link</a></li>

										<li><a href="index.html">Third level link</a></li>

										<li><a href="index.html">Third level link</a></li>

										<li><a href="index.html">Third level link</a></li>

										<li><a href="index.html">Third level link</a></li>

									</ul>

								</li>

								<li><a href="index.html">Second level link</a></li>

								<li><a href="index.html">Second level link</a></li>

								<li><a href="index.html">Second level link</a></li>

							</ul>

						</li>

					</ul>

				</li>

				<li>

					<a href="">Tables</a>

				</li>

				<li>

					<a href="">Extra

					<span class="arrow"></span>

					</a>

					<ul class="sub-menu">

						<li><a href="index.html">About Us</a></li>

						<li><a href="index.html">Services</a></li>

						<li><a href="index.html">Pricing</a></li>

						<li><a href="index.html">FAQs</a></li>

						<li><a href="index.html">Gallery</a></li>

						<li><a href="index.html">Registration</a></li>

						<li><a href="index.html">2 Columns (Left)</a></li>

						<li><a href="index.html">2 Columns (Right)</a></li>

					</ul>

				</li>

			</ul>

		</div>

		<!-- END EMPTY PAGE SIDEBAR -->

		<!-- BEGIN PAGE -->

		<div class="page-content no-min-height">

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

			<div class="container-fluid promo-page">

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<div class="block-grey">

							<div class="container">

								<div id="promo_carousel" class="carousel slide">

									<div class="carousel-inner">

										<div class="active item">

											<div class="row-fluid">

												<!--<div class="span7 margin-top-10 animated rotateInUpRight">  -->
												<div class="span7 margin-bottom-20 animated rotateInUpRight">
													<h1>欢迎来到海大体育馆管理系统</h1>

													<!--  <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique. Pellentesque viverra vehicula sem ut volutpat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat.</p>

													<p>Lunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero consectetur adipiscing elit magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat.</p>
													-->
													<p>广东海洋大学体育馆始建于2005年，于2005年5月施工到2010年10份正式竣工，于2010年11月17日正式投入使用。该馆共投入4000余万元。主校区体育馆位于校园中心区域，依山傍海，气势恢宏，与周围错落有致的楼群及雕塑相映成趣，构成一幅中西风格相统一、自然与人文相协调的和谐风景。</p>
													<p>体育馆占地面积1万4平方米，建筑面积高达13500平方米，共有四层。首层作为主场馆，共设有2397个座位，主场馆内最多可以容纳5717人。主场馆内除了设有体育学院办公室、运动器材室、运动员休息室和会议室以外，还有一个标准篮球场，其面积等同于12个羽毛球场和两个排球场。除了日常可供师生进行体育锻炼外，也可举行军训动员大会、大型文艺演出等大型活动。值得注意的是，第二层除了设有台球、健身房外，还设有保龄球馆。第三、四层则分别设有乒乓球室和武术馆、体操馆。</p>
													<!-- <a href="${pageContext.request.contextPath}/index.jsp" class="btn red big xlarge">

													欢迎使用

													 <i class="m-icon-big-swapright m-icon-white"></i>    -->                            

													</a>

												</div>

												<div class="span4 animated rotateInDownLeft">

													<a href="index.jsp"><img src="${pageContext.request.contextPath}/media/image/view11.png" alt=""></a>

												</div>

											</div>

										</div>

										<div class="item">

											<div class="row-fluid">

												<div class="span5 margin-bottom-50 animated rotateInUpRight">

													<a href="index.jsp"><img src="${pageContext.request.contextPath}/media/image/view13.png" alt=""></a>

												</div>

												<div class="span5 margin-bottom-20 animated rotateInDownLeft">

													<h1>Welcome to GYM</h1>

													<!--  <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique. Pellentesque viverra vehicula sem ut volutpat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat.</p>

													<p>Lunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Ut non libero consectetur adipiscing elit magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat.</p>
													-->
													<p>广东海洋大学体育馆始建于2005年，于2005年5月施工到2010年10份正式竣工，于2010年11月17日正式投入使用。该馆共投入4000余万元。主校区体育馆位于校园中心区域，依山傍海，气势恢宏，与周围错落有致的楼群及雕塑相映成趣，构成一幅中西风格相统一、自然与人文相协调的和谐风景。</p>
													<p>体育馆占地面积1万4平方米，建筑面积高达13500平方米，共有四层。首层作为主场馆，共设有2397个座位，主场馆内最多可以容纳5717人。主场馆内除了设有体育学院办公室、运动器材室、运动员休息室和会议室以外，还有一个标准篮球场，其面积等同于12个羽毛球场和两个排球场。除了日常可供师生进行体育锻炼外，也可举行军训动员大会、大型文艺演出等大型活动。值得注意的是，第二层除了设有台球、健身房外，还设有保龄球馆。第三、四层则分别设有乒乓球室和武术馆、体操馆。</p>
													<!-- <a href="index.html" class="btn green big xlarge">

													But it today

													<i class="m-icon-big-swapright m-icon-white"></i>                                

													</a> -->

												</div>

											</div>

										</div>

									</div>

									<a class="carousel-control left" href="#promo_carousel" data-slide="prev">

									<i class="m-icon-big-swapleft m-icon-white"></i>

									</a>

									<a class="carousel-control right" style="margin-right:85px;"href="#promo_carousel" data-slide="next">

									<i class="m-icon-big-swapright m-icon-white"></i>

									</a>

								</div>

							</div>

						</div>

						<div class="block-yellow">

							<div class="container">

								<div class="row-fluid">

									<div class="span4 margin-bottom-20">

										<a href="index.html"><img src="${pageContext.request.contextPath}/media/image/board.png" alt=""></a>

									</div>

									<div class="span7">

										<h2>场馆公告栏</h2>
										<ul>
											<c:forEach items="${notices }" var="notice">
												<a><li>${notice.title }</li></a>
												
											</c:forEach>
										</ul>

										<!-- <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique. Pellentesque viverra vehicula sem ut volutpat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat.</p>

										<p>Lunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero consectetur adipiscing elit magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat.</p>
 -->
										<a href="#" class="btn blue big xlarge">

										更多

										<i class="m-icon-big-swapright m-icon-white"></i>                                

										</a>

									</div>

								</div>

							</div>

						</div>

						<div class="block-transparent">

							<div class="container">

								<div class="row-fluid margin-bottom-20">

									<div class="span6 margin-bottom-20">

										<h2>场馆动态</h2>

										<!-- <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos <a href="#">ellentesque la vehi</a> dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique. Pellentesque viverra vehicula sem ut volutpat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat.</p>

										<p>Lunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita <a href="#">distinctio lorem ipsum dolor</a> sit amet, consectetur adipiscing elit. Ut non libero consectetur adipiscing elit magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat.</p>
										 -->
										 <ul >
										 	<li> 体育馆安全检查活动圆满举办 </li>
										 	<li> 艰难卓绝，不辱使命—体育馆党员《天河》观影活动 </li>
										 	<li> 普及安全知识，共筑平安校园—体育馆圆满举办消防知识培训</li>
										 	<li> “知党史，缅先烈”体育馆党小组赴中国人民抗日战争纪念馆参观学习</li>
										 	<li> 2014年“迎春，梦想起航”体育馆大家庭联欢晚会圆满落幕</li>
										 	<li> 广东海洋大学体育馆2014年“筑梦”员工运动会圆满举办</li>
										 	<li> 圆奥运之梦想，扬体育之荣光——记广东海洋大学体育馆开馆周年庆</li>
										 	<li> 体育馆组织参观高等教育领域职务犯罪警示教育展</li>
										 	<li> 广东海洋大学体育馆召开2014年度年终总结会</li>
										 	<li> 熔炼团队，提升自我—体育馆开展员工素质拓展培训</li>
										 	
										 </ul>
									</div>

									<div class="span5 margin-bottom-20">

										<a href="index.html"><img src="media/image/img3.png" alt=""></a>

									</div>

								</div>

								<!--  <div class="row-fluid">

									<div class="span5">

										<a href="index.html"><img src="media/image/img4.png" alt=""></a>

									</div>

									<div class="span6 margin-bottom-20">

										<h2>Vero eos iusto odio..</h2>

										<p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et <a href="#">quas molestias excepturi sint</a> occaecati cupiditate non provident, similique. Pellentesque viverra vehicula sem ut volutpat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat.</p>

										<p>Lunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero consectetur adipiscing elit magna. Sed et <a href="#">quam lacus eusce condimentum </a> eleifend enim a feugiat.</p>

									</div>

								</div>-->

								<hr>

								<div class="row-fluid">

									<div class="span3">

										<h3><a href="${pageContext.request.contextPath}/client/badmintonHall.jsp">羽毛球馆</a></h3>

										<p>20片羽毛球场，2400平方米的通透环境、光导管自然光照明、羽丰专业防滑地胶、victor球架，静默通风，让您的运动之旅在酣畅淋漓中感受远离都市般的宁静。</p>

									</div>

									<div class="span3">

										<h3><a href="${pageContext.request.contextPath}/client/tableTennnisHall.jsp">乒乓球馆</a></h3>

										<p>15张乒乓球台，红双喜05/06世乒赛比赛用台、超高天穹吊顶、多源无影照明，让您运动无极限！</p>

									</div>

									<div class="span3">

										<h3><a href="${pageContext.request.contextPath}/client/billiardsHall.jsp">台球厅</a></h3>

										<p>VICTOR球网、独立优雅环境、通透全覆盖照明，隔音装饰材料，带给您全新运动体验</p>

									</div>

									<div class="span2">

										<h3><a href="${pageContext.request.contextPath}/client/fitness.jsp">健身房</a></h3>

										<p>全新的设备，新的体验，新的享受，让您与您的朋友尽情释放激情！</p>

									</div>

								</div>

							</div>

						</div>

						<div class="block-footer">

							<div class="container">

								<div class="row-fluid">

									<div class="span3">

										<h3>搜索</h3>

										<p></p>

										<form class="form-search" action="#">

											<div class="input-append">

												<input type="text" class="m-wrap" placeholder=""><button type="button" class="btn blue">GO!</button>

											</div>

										</form>

									</div>

									<div class="span4">

										<h3>校园风采</h3>

										<ul class="unstyled blog-images">

											<li><a href="#"><img src="media/image/1.jpg" alt=""></a></li>

											<li><a href="#"><img src="media/image/2.jpg" alt=""></a></li>

											<li><a href="#"><img src="media/image/3.jpg" alt=""></a></li>

											<li><a href="#"><img src="media/image/4.jpg" alt=""></a></li>

											<li><a href="#"><img src="media/image/5.jpg" alt=""></a></li>

											<li><a href="#"><img src="media/image/6.jpg" alt=""></a></li>

											<li><a href="#"><img src="media/image/8.jpg" alt=""></a></li>

											<li><a href="#"><img src="media/image/10.jpg" alt=""></a></li>

											<li><a href="#"><img src="media/image/11.jpg" alt=""></a></li>

											<li><a href="#"><img src="media/image/1.jpg" alt=""></a></li>

											<li><a href="#"><img src="media/image/2.jpg" alt=""></a></li>

											<li><a href="#"><img src="media/image/7.jpg" alt=""></a></li>

										</ul>

									</div>

									<div class="span4">

										<h3>友情链接</h3>

										<ul class="social-icons">

											<li><a href="#" data-original-title="amazon" class="amazon"></a></li>

											<li><a href="#" data-original-title="behance" class="behance"></a></li>

											<li><a href="#" data-original-title="blogger" class="blogger"></a></li>

											<li><a href="#" data-original-title="deviantart" class="deviantart"></a></li>

											<li><a href="#" data-original-title="dribbble" class="dribbble"></a></li>

											<li><a href="#" data-original-title="dropbox" class="dropbox"></a></li>

											<li><a href="#" data-original-title="facebook" class="facebook"></a></li>

											<li><a href="#" data-original-title="forrst" class="forrst"></a></li>

											<li><a href="#" data-original-title="github" class="github"></a></li>

											<li><a href="#" data-original-title="Goole Plus" class="googleplus"></a></li>

											<li><a href="#" data-original-title="jolicloud" class="jolicloud"></a></li>

											<li><a href="#" data-original-title="last-fm" class="last-fm"></a></li>

											<li><a href="#" data-original-title="linkedin" class="linkedin"></a></li>

											<li><a href="#" data-original-title="picasa" class="picasa"></a></li>

											<li><a href="#" data-original-title="pintrest" class="pintrest"></a></li>

											<li><a href="#" data-original-title="rss" class="rss"></a></li>

											<li><a href="#" data-original-title="skype" class="skype"></a></li>

											<li><a href="#" data-original-title="spotify" class="spotify"></a></li>

											<li><a href="#" data-original-title="stumbleupon" class="stumbleupon"></a></li>

											<li><a href="#" data-original-title="tumblr" class="tumblr"></a></li>

											<li><a href="#" data-original-title="twitter" class="twitter"></a></li>

											<li><a href="#" data-original-title="vimeo" class="vimeo"></a></li>

											<li><a href="#" data-original-title="wordpress" class="wordpress"></a></li>

											<li><a href="#" data-original-title="xing" class="xing"></a></li>

											<li><a href="#" data-original-title="yahoo" class="yahoo"></a></li>

											<li><a href="#" data-original-title="youtube" class="youtube"></a></li>

											<li><a href="#" data-original-title="vk" class="vk"></a></li>

											<li><a href="#" data-original-title="instagram" class="instagram"></a></li>

										</ul>

									</div>

								</div>

							</div>

						</div>

					</div>

				</div>

			</div>

			<!-- END PAGE CONTENT-->

		</div>

		<!-- END PAGE CONTAINER--> 

	</div>

	<!-- END PAGE --> 
		
				
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

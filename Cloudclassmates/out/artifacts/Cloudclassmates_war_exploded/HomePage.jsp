<%@ page language="java" import="java.util.*" import="model.Users"
	contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Users user=(Users)session.getAttribute("loginUser");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>首页</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/search-form.css">
<link rel="stylesheet" type="text/css" href="css/show.css">
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript" src="js/my.js"></script>
<script type="text/javascript" src="js/showImage.js"></script>
<style type="text/css">
        *{ margin: 0; padding: 0; text-decoration: none;}
        #image { width: 800px; height: 500px; border: 3px solid #333; overflow: hidden; position: absolute;left:280px;}
        #imagelist { width: 4200px; height: 400px; position: absolute; z-index: 1;}
        #imagelist img { float: left;}
        #imagebuttons { position: absolute; height: 10px; width: 100px; z-index: 2; bottom: 20px; left: 350px;}
        #imagebuttons span { cursor: pointer; float: left; border: 1px solid #fff; width: 10px; height: 10px; border-radius: 50%; background: #333; margin-right: 5px;}
        #imagebuttons .on {  background: orangered;}
        .arrow { cursor: pointer; display: none; line-height: 39px; text-align: center; font-size: 36px; font-weight: bold; width: 40px; height: 40px;  position: absolute; z-index: 2; top: 250px; background-color: RGBA(0,0,0,.3); color: #fff;}
        .arrow:hover { background-color: RGBA(0,0,0,.7);}
        #image:hover .arrow { display: block;}
        #prev { left: 20px;}
        #next { right: 20px;}
    </style>
</head>
<body style="background:#f0f0f0">
	<!-- head begin -->
	<div class="header-banner">
		<div class="container">
			<div class="home">
				<a href="HomePage.jsp"><span class="glyphicon glyphicon-home"></span>
				</a>
			</div>
			<div class="header-top">
				<span class="menu"><img src="images/nav.png" alt="" />
				</span>
				<div class="top-menu">
					<ul>
						<nav class="cl-effect-13">
						</li>
						<li> 欢迎用户: <%=user.getUsername()%></li>
						<li><a href=#>您的余额为：<%=user.getMoney()%><%="$"%></a></li>
						<li><a href="charge.jsp">充值</a></li>
						</li>
						<!-- 登陆 --> <c:if test="${sessionScope.loginUser==null}">
							<li><a href="<%=path%>/Login.jsp">登录</a>
							</li>
						</c:if> <c:if test="${sessionScope.loginUser!=null}">
							<li><a href="<%=path%>/servlet/LoginServlet">已登录</a>
							</li>
						</c:if>
						<li><a class="scroll" href="<%=path%>/servlet/LogOut">注销</a>
						</li>
						<li><a href="<%=path%>/servlet/ShowCarServlet">我的购买</a>
						</li>
						<li><a href="load.jsp">求助他人</a></li>
						<li><a href="load1.jsp">求助老师</a></li>
						
						</nav>
				
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
			<div class="banner-info text-center">
				<h1>
					<a href="HomePage.jsp"></a>
				</h1>
			</div>
			<div class="header-bottom-grids text-center">
				<div class="header-bottom-grid1">
					<span class="glyphicon glyphicon-camera"></span>
					<h4>
						<a style="text-decoration:none"
							href="<%=path%>/servlet/LimitByTypeServlet?pageNum=1&itemType=问题模块#location">问题模块</a>
					</h4>
				</div>
				<div class="header-bottom-grid2">
					<span class="glyphicon glyphicon-book"></span>
					<h4>
						<a style="text-decoration:none"
							href="<%=path%>/servlet/LimitByTypeServlet?pageNum=1&itemType=图书教材#location">图书教材</a>
					</h4>
				</div>
				<div class="header-bottom-grid3">
					<span class="glyphicon glyphicon-user"></span>
					<h4>
						<a style="text-decoration:none"
							href="<%=path%>/servlet/LimitByTypeServlet?pageNum=1&itemType=虚拟教室#location">虚拟教室</a>
					</h4>
				</div>
				<div class="header-bottom-grid4">
					<span class="glyphicon glyphicon-cutlery"></span>
					<h4>
						<a style="text-decoration:none"
							href="<%=path%>/servlet/LimitByTypeServlet?pageNum=1&itemType=自习教室#location">自习教室</a>
					</h4>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- head end -->

	<!-- content-section-starts -->
	

</body>
</html>

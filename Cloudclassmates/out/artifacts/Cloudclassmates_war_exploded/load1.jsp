<%@ page language="java" import="java.util.*" import="model.Users"
	contentType="text/html; charset=utf-8"%>
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

<title>求助老师</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/search-form.css">
<link rel="stylesheet" type="text/css" href="css/show.css">
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript" src="js/my.js"></script>
<script>
function load(){
	var file = $("#file").val();  
    var name = $("#name").val(); 
    var price = $("#price").val(); 
    var discription = $("#discription").val();
    var contact = $("#contact").val();
    var pattern = /(^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$)|(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
    var checkFile = /\w+([.jpg|.png|.gif|.swf|.bmp|.jpeg]){1}$/;
    var checkPrice = /^[0-9]*$/;
    if (!new RegExp(checkFile).test(file)) {  
    	alert("请上传图片");
    	return false; 
    }else if(name == "" || name == null){
        alert("商品名称不能为空");  
        return false;     	
    }else if((price==""||price ==null)||(!new RegExp(checkPrice).test(price))){
    	alert("请输入正确的商品价格");
    	return false;
    }else if(discription == "" || discription == null){
    	alert("商品描述不能为空");  
        return false;  
    }else if(!new RegExp(pattern).test(contact)){
    	alert("请输入正确的手机号码");  
        return false;
    }else {  
        return true;  
    }  
}
</script>
</head>

<body style="background-color:#f0f0f0;">
	<!-- head begin -->
	 <div class="about-header-banner">
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
						<li> 欢迎: <%=user.getUsername()%></li>
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
		</div>
	</div>
	<!-- head end -->
	<div class="container">
		<div class="services-top-grids text-center">

			<div align="center">
				<h1>
					<strong>向老师求助</strong>
				</h1>
				
				<br>
				<form
					action="<%=path%>/servlet/addItemServlet"
					enctype="multipart/form-data" method="post">
					<ul style="font-size: 22px;list-style-type:none;">
						<li style="margin-bottom:20px;"><p>上传问题图片：注意图片名称要英文命名</p><input type="file"
							name="file1" id="file" />
						</li>
						<li style="margin-bottom:20px;">问题名称：<input type="text" 
							name="name" id="name"/>
						</li>
						<li style="margin-bottom:20px;">问题奖赏：<input type="text"
							name="price" id="price"/>
						</li>
						<li style="margin-bottom:20px;">问题描述：<input type="text"
							name="discription" id="discription"/>
						</li>
						<li style="margin-bottom:20px;">手机号码：<input type="text"
							name="contact" id="contact"/>
						</li>
						<li style="margin-bottom:20px;">问题类别： <select 
							name="type" >
								<OPTION value='高数'>高数</OPTION>
								<OPTION value='英语'>英语</OPTION>
								<OPTION value='数据结构'>数据结构</OPTION>
								<OPTION value='组成原理'>组成原理</OPTION>
								<OPTION value='线性代数'>线性代数</OPTION>
								<OPTION value='概率论'>概率论</OPTION>
								<OPTION value='工商管理'>工商管理</OPTION>
								<OPTION value='通信'>通信</OPTION>
								<OPTION value='会计'>会计</OPTION>
								<OPTION value='工程力学'>工程力学</OPTION>
						</select></li>
							<li style="margin-bottom:20px;">可选老师信息： <select 
							name="type" >
								<OPTION value='信息管理何老师'>信息管理何老师</OPTION>
								<OPTION value='数学申老师'>数学申老师</OPTION>
								<OPTION value='英语杨老师'>英语杨老师</OPTION>
								<OPTION value='数据结构薛老师'>数据结构薛老师</OPTION>
								<OPTION value='组成原理楚老师'>组成原理楚老师</OPTION>
								<OPTION value='线性代数徐老师'>线性代数徐老师</OPTION>
								<OPTION value='概率论梁老师'>概率论梁老师</OPTION>
								
								<OPTION value='通信陈老师'>通信陈老师</OPTION>
								<OPTION value='会计廖老师'>会计廖老师</OPTION>
								<OPTION value='工程力学王老师'>工程力学王老师</OPTION>
						</select></li>						
					</ul>
					<input type="submit" value="提交" onClick="return load();"/>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

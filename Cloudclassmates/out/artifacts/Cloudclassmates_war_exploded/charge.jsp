<%@ page language="java" import="java.util.*" import="model.Users"
	contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:%100;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>充值</title>
</head>
<body style="background-image: url(images/backgroundcharge1.jpg)">
	<%
	Users user=(Users)session.getAttribute("loginUser");
	%>
	<p>
		<h1 align="center">充值页面</h1>
	</p>
	<p>
		<h3 align="center">您好！<%=user.getUsername()%>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp您的余额为：<%=user.getMoney() %>$</h3>
	</p>
	<div style="margin:auto;text-align:center;height:200px;line-height:90px">
		
		 <form id="form" action="<%=request.getContextPath()%>/servlet/chargeServlet" method="post">
	        <!--   *商户订单 :-->
	           *付款金额 :
	           <input type="text" name="total_amount" value="300" ><br>
	           
	           
	           <input type="submit" value="支付宝支付" >
	    </form>
	</div>
	<div style="margin:30;text-align:center;">
		<a href="HomePage.jsp"><button>返回</button></a>
	</div>

</body>
</html>
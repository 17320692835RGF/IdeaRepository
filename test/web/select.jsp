<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ren.entity.Goods" %>
<%@ page language="java"  pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>JSP</title>


</head>

<body>
<%
    ArrayList userlist=(ArrayList)request.getAttribute("ListGoods");
%>
<h2 align="center">商品列表</h2>
<table align="center">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>adress</th>
        <th>abroad</th>
    </tr>
    <%for(int i=0;i<userlist.size();i++){
    Goods user=(Goods)userlist.get(i);%>
    <tr><th><%=user.getId() %></th>
        <th><%=user.getName() %></th>
        <th><%=user.getAdress() %></th>
        <th><%=user.getBroad() %></th>
            <%
        } %>
</table>
</body>
</html>

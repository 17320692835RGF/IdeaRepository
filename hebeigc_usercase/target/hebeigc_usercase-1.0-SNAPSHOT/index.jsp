<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>用户首页</title>
</head>
<body>
<c:if test="${not empty user.name}">
    <h1>${user.name}, 欢迎您登录</h1>
<%--    <a href="/userListServlet">点击查询所有用户信息</a>--%>
    <a href="/findUserByPageServlet">点击查询所有用户信息</a>
</c:if>
<c:if test="${empty user.name}">
    <h1>欢迎您, 请您先<a href="/loginServlet">登录</a></h1>
</c:if>

</body>
</html>
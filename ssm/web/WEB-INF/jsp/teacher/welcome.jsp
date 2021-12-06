<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/14 0014
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>xxxx管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/css.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery1.9.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/sdmenu.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/laydate/laydate.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#btn").click(function(){
                top.mainFrame.location="table.html";
            });
        });
    </script>
</head>
<body>
<div class="right" id="mainFrame">
    <div class="right_cont">
        <ul class="breadcrumb">
            当前位置：<a>首页</a>
            <span class="divider">/</span>系统信息总览
        </ul>
        <div class="title_right">
            <strong>系统信息总览</strong>
        </div>
        <div style="width:900px; margin:auto">
            <table class="table table-bordered">
                <tr>
                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">课程总数：</td>
                    <td width="38%">15</td>
                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">学生总数：</td>
                    <td width="38%">15</td>
                </tr>
                <tr>
                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">成绩不及格人数：</td>
                    <td width="38%">15</td>
                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">成绩优秀人数：</td>
                    <td width="38%">15</td>
                </tr>
            </table>
        </div>
    </div>
</div><!-- 底部 -->
<div id="footer">
    <div id="footer">版权所有：vvv &copy; 2015&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" target="_blank">vvv</a></div>
</div>
<script>
    !function(){
        laydate.skin('molv');
        laydate({
            elem: '#Calendar'
        });
        laydate.skin('molv');
        laydate({
            elem: '#Calendar2'
        });
    }();
</script>
</body>
</html>


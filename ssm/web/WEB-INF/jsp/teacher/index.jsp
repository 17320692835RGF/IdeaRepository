<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/14 0014
  Time: 15:09
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
</head>
<body>
<!-- header开始 -->
<div class="header">
    <div class="logo"><img src="img/logo.png" /></div>
    <div class="header-right">
        <i class="icon-user icon-white"></i>
        <a href="#">${teacher.name}</a>
        <i class="icon-envelope icon-white"></i>
        <a id="modal-973558" role="button">注销</a>
    </div>
</div>
<!-- header结束 -->
<div id="middle">
    <div class="left">
        <script type="text/javascript">
            //菜单
            var myMenu;
            window.onload = function(){
                myMenu = new SDMenu("my_menu");
                myMenu.init();
            };
        </script>
        <div id="my_menu" class="sdmenu">
            <div >
                <span>课程管理</span>
                <a href="teacher/courseAddJSP.action" target="mainFrame">添加课程信息</a>
                <a href="teacher/toCourseList.action" target="mainFrame">课程信息列表</a>
            </div>
            <div class="collapsed">
                <span>学生管理</span>
                <a href="" target="mainFrame">添加学生信息</a>
                <a href="" target="mainFrame">学生信息列表</a>
            </div>
            <div class="collapsed">
                <span>成绩管理</span>
                <a href="teacher/toGradeList.action" target="mainFrame">成绩信息列表</a>
            </div>
        </div>
    </div>
    <div class="Switch"></div>
    <script type="text/javascript">
        //菜单折叠
        $(document).ready(function(e){
            $(".Switch").click(function(){
                $(".left").toggle();
            });
        });
    </script>
    <!-- 菜单栏结束 -->
    <div class="right" id="mainFrame" name="mainFrame">
        <iframe name="mainFrame" frameborder="no" width="99%" height="99%" src="teacher/welcomeJSP.action"></iframe>
    </div>
</div>
<!-- 主显示区结束-->
<div id="footer">版权所有：vvv &copy; 2015&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" target="_blank">vvv</a></div>
<script>
    !function(){
        laydate.skin('molv');
        laydate({
            elem: '#Calendar'
        });
    }();
</script>
</body>
</html>


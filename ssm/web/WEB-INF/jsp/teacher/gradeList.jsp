<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/15 0015
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.dialog.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.dialog.js"></script>
    <style type="text/css">
        #vvv{text-align:right;margin:0;padding:0;}
    </style>
    <script type="text/javascript">
        $(function(){
            $("#btnAdd").click(function(){
                var obj = '<iframe name="myFrame" src="form2.html" frameborder="0" scrolling="no" height="450" width="950" style="margin:0;padding:0;"/></iframe>';
                $(obj).dialog({
                    title : "我的表单"
                });
            });
        });
        function mydel(id) {
            var flag=confirm("您确定删除该条信息吗？");
            if(flag){
                top.mainFrame.location="courseDel.action?id="+id;
            }
        }
        function myupd(id) {
            var obj = '<iframe name="myFrame" src="toCourseUpd.action?id='+id+'" frameborder="0" scrolling="no" height="300" width="950" style="margin:0;padding:0;"/></iframe>';
            $(obj).dialog({
                title : "课程信息修改"
            });
        }
    </script>
</head>
<body>
<div class="right" id="mainFrame">
    <div class="right_cont">
        <ul class="breadcrumb">
            当前位置：<a>首页</a>
            <span class="divider">/</span>
            <a>成绩管理</a>
            <span class="divider">/</span>成绩信息列表
        </ul>
        <div class="title_right">
            <strong>成绩信息列表</strong>
        </div>
        <div style="width:99%;margin:auto;text-align:left;">
            <form action="courseSearch.action" method="post">
                关键字：<input type="text" name="keyword" class="span3"/>
                <input type="submit" class="btn btn-info" value="检索" style="width:80px;"/>
            </form>
        </div>
        <div style="width:99%; margin:auto">
            <!--表格开始-->
            <table class="table table-bordered table-striped table-hover">
                <tbody>
                <tr align="center">
                    <td><strong>id</strong></td>
                    <td><strong>学号</strong></td>
                    <td><strong>姓名</strong></td>
                    <td><strong>课程编号</strong></td>
                    <td><strong>课程名称</strong></td>
                    <td><strong>学期</strong></td>
                    <td><strong>成绩</strong></td>
                    <td><strong>操作</strong></td>
                </tr>
                <c:forEach items="${gradeExes}" var="g">
                <tr align="left">
                    <td>${g.id}</td>
                    <td>${g.sno}</td>
                    <td>${g.sname}</td>
                    <td>${g.cno}</td>
                    <td>${g.cname}</td>
                    <td>${g.state==1?"上学期":"下学期"}</td>
                    <td>${g.mark}</td>
                    <td>
                        <a href="">修改</a> |
                        <a href="">删除</a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
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


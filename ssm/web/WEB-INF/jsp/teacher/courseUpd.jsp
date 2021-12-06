<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/15 0015
  Time: 09:09
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
        });
    </script>
</head>
<body>
<div class="right" id="mainFrame">
    <div class="right_cont">
        <div class="title_right">
            <strong>课程信息修改</strong>
        </div>
        <div style="width:900px; margin:auto">
            <form action="courseUpd.action" method="post">
                <input type="hidden" name="id" value="${course.id}"/>
            <table class="table table-bordered">
                <tr>
                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">课程编号：</td>
                    <td width="38%"><input type="text" name="cno" class="span1-1" value="${course.cno}"/></td>
                    <td width="12%" align="right" bgcolor="#f1f1f1">课程名称：</td>
                    <td><input type="text" name="name" class="span1-1" value="${course.name}"/></td>
                </tr>
                <tr>
                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">课程类型：</td>
                    <td>
                        <select name="type">
                            <option value="java类" ${course.type=="java类"?"selected='selected'":""}>java类</option>
                            <option value="基础类" ${course.type=="基础类"?"selected='selected'":""}>基础类</option>
                            <option value="数据库类" ${course.type=="数据库类"?"selected='selected'":""}>数据库类</option>
                            <option value="网页类" ${course.type=="网页类"?"selected='selected'":""}>网页类</option>
                        </select>
                    </td>
                    <td align="right" bgcolor="#f1f1f1">学分：</td>
                    <td><input type="text" name="point" class="span1-1" value="${course.point}"/></td>
                </tr>
                <tr>
                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">内容简介：</td>
                    <td colspan="3">
                        <textarea name="contents" id="input9" class="span10">${course.contents}</textarea>
                    </td>
                </tr>
            </table>
            <table class="margin-bottom-20 table  no-border">
                <tr>
                    <td class="text-center">
                        <input type="submit" value="修改" class="btn btn-info " style="width:80px;"/>
                    </td>
                </tr>
            </table>
            </form>
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


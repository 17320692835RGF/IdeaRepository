<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/14 0014
  Time: 09:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>xxxx管理系统</title>
    <link rel="stylesheet" href="css/bootstrap.css" />

    <script type="text/javascript" src="js/jquery1.9.0.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <style type="text/css">
        body{ background:#0066A8 0px;}
        .tit{ margin:auto; margin-top:170px; text-align:center; width:350px; padding-bottom:20px;}
        .login-wrap{ width:220px; padding:30px 50px 0 330px; height:220px; background:#fff url(img/20150212154319.jpg) no-repeat 30px 40px; margin:auto; overflow: hidden;}
        .login_input{ display:block;width:210px;}
        .login_sel{width:218px;}
        .login_user{ background: url(img/input_icon_1.png) no-repeat 200px center; font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif}
        .login_password{ background: url(img/input_icon_2.png) no-repeat 200px center; font-family:"Courier New", Courier, monospace}
        .btn-login{ background:#40454B; box-shadow:none; text-shadow:none; color:#fff; border:none;height:35px; line-height:26px; font-size:14px; font-family:"microsoft yahei";}
        .btn-login:hover{ background:#333; color:#fff;}
        .copyright{ margin:auto; margin-top:10px; text-align:center; width:370px; color:#CCC}
    </style>
</head>

<body>
<div class="tit"><img src="img/tit.png" alt="" /></div>
<div class="login-wrap">
    <form action="login.action" method="post">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td height="20" valign="bottom">类型：</td>
        </tr>
        <tr>
            <td>
                <select name="logintype" class="login_sel">
                    <option value="tea" selected="selected">教师</option>
                    <option value="stu">学生</option>
                    <option value="adm">管理员</option>
                </select>
            </td>
        </tr>
        <tr>
            <td height="20" valign="bottom">账号：</td>
        </tr>
        <tr>
            <td><input name="loginname" type="text" class="login_input login_user" value="ttt" /></td>
        </tr>
        <tr>
            <td height="20" valign="bottom">密码：</td>
        </tr>
        <tr>
            <td><input name="loginpwd" type="password"  class="login_input login_password" value="ttt" /></td>
        </tr>
        <tr>
            <td height="45" valign="bottom"><input type="submit" value="登录" class="btn btn-block btn-login"/></td>
        </tr>
    </table>
    </form>
</div>
<div class="copyright">建议使用IE8以上版本或谷歌浏览器</div>
</body>
</html>


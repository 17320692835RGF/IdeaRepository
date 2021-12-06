<%--
  Created by IntelliJ IDEA.
  User: ericli
  Date: 2021/8/30
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理系统</title>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" , rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        td. th {
            text-align: center;
        }

        #container {
            width: 90%;
            margin: 0 auto;
        }

        #right {
            float: right;
        }

    </style>
    <script>
        function deleteUser(id) {
            if (confirm("确定删除此信息？")) {
                // 交给后端
                location.href = "/deleteUserServlet?id=" + id;
            }
        }

        // 窗口打开会自动执行
        window.onload = function () {
            // 给删除按钮添加单击事件
            document.getElementById("delSelected").onclick = function () {
                let flag = false;
                if (confirm("确定删除所选信息 ")) {
                    var guids = document.getElementsByName("uid");

                    console.log(guids)
                    //
                    for (var i = 0; i < guids.length; i++) {
                        console.log(guids[i].checked)
                        if (guids[i].checked) {
                            // 这个判断只要有一个选中就可以了
                            flag = true;
                            break;
                        }
                    }

                    if (flag) {
                        document.getElementById("form").submit();
                    }
                }
            }
            // 全选和反选
            document.getElementById("firstCb").onclick = function () {
                var guids = document.getElementsByName("uid");
                for (var i = 0; i < guids.length; i++) {
                    guids[i].checked = this.checked;
                }
            }
        }
    </script>

</head>
<body>
<div id="container">
    <h3 style="text-align: center"><a href="#">用户信息列表</a></h3>
    <div style="float: left;">

        <form class="form-inline" action="#" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" value="" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" name="address" value="" class="form-control" id="exampleInputName3">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="text" name="email" value="" class="form-control" id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="/addUserServlet">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>

    </div>
    <form id="form" action="/deleteSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pb.list}" var="user" varStatus="s">
                <tr>
                        <%--          <td><input type="checkbox" id="uid" value="${user.id}"></td>--%>
                        <%--          //todo--%>
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>
                    <td>${s.count}</td>
                    <td> ${user.name}</td>
                    <td> ${user.gender}</td>
                    <td> ${user.age}</td>
                    <td> ${user.address}</td>
                    <td> ${user.qq}</td>
                    <td> ${user.email}</td>
                    <td><a class="btn btn-default btn-sm" href="/findUserServlet?id=${user.id}">修改</a>
                        <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id})">删除</a></td>
                </tr>

            </c:forEach>
        </table>

    </form>
    <%--    分页按钮--%>
    <div id="right">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <%--    左箭头--%>
                <c:if test="${pb.currentPage == 1}">
                    <li class="disabled"></li>
                </c:if>
                <c:if test="${pb.currentPage != 1}">
                    <li><a aria-label="Previous"
                           href="/findUserByPageServlet?currentPage=${pb.currentPage-1}&rows=5"><span
                            aria-hidden="true">上一页</span></a></li>
                </c:if>
                <%--        分页列表--%>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <%--         当前页--%>
                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="/findUserByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                    </c:if>
                    <%--        其他页--%>
                    <c:if test="${pb.currentPage != i}">
                        <li><a href="/findUserByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                    </c:if>
                </c:forEach>
                <%--  右箭头--%>
                <c:if test="${pb.currentPage == pb.totalPage}">
                    <li class="disabled"></li>
                </c:if>
                <c:if test="${pb.currentPage != pb.totalPage}">
                    <li><a aria-label="Next" href="/findUserByPageServlet?currentPage=${pb.currentPage+1}&rows=5"><span
                            aria-hidden="true">  下一页 </span></a></li>
                </c:if>
                <span style="font-size: 25px;margin-left: 5px;">
      共${pb.totalCount}条记录， 共${pb.totalPage}页
    </span>

            </ul>
        </nav>


    </div>

</div>

</body>
</html>

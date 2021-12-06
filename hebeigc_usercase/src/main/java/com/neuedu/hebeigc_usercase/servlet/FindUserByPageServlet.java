package com.neuedu.hebeigc_usercase.servlet;

import com.neuedu.hebeigc_usercase.domain.PageBean;
import com.neuedu.hebeigc_usercase.domain.User;
import com.neuedu.hebeigc_usercase.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "findUserByPageServlet", value = "/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");// 当前页
        String rows = request.getParameter("rows"); // 一页几条
        if (currentPage == null || "".equals(currentPage))
            currentPage = "1";
        if (rows == null || "".equals(rows))
            rows = "5";

        Map<String, String[]> condition = request.getParameterMap();
        // 调用分页查询
        UserServiceImpl userService = new UserServiceImpl();
        PageBean<User> pb = userService.findUserByPage(currentPage, rows, condition);
        System.out.println("pb = " + pb);

        request.setAttribute("pb", pb);
        request.setAttribute("condition", condition);
        request.getRequestDispatcher("./list.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

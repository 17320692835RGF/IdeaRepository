package com.neuedu.hebeigc_usercase.servlet;

import com.neuedu.hebeigc_usercase.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "deleteSelectedServlet", value = "/deleteSelectedServlet")
public class DeleteSelectedServletServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uids = request.getParameterValues("uid");
        System.out.println("Arrays.toString(uids) = " + Arrays.toString(uids));
        UserServiceImpl userService = new UserServiceImpl();
        userService.deleteSelectedUser(uids);
        response.sendRedirect("/findUserByPageServlet");

    }
}

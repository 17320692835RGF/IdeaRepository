package com.neuedu.hebeigc_usercase.servlet;

import com.neuedu.hebeigc_usercase.service.impl.UserServiceImpl;
import org.omg.PortableServer.THREAD_POLICY_ID;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteUserServlet", value = "/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        UserServiceImpl userService = new UserServiceImpl();
        userService.deleteUser(id);
        response.sendRedirect("/findUserByPageServlet");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

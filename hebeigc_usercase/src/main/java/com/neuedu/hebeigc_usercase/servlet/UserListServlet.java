package com.neuedu.hebeigc_usercase.servlet;

import com.neuedu.hebeigc_usercase.domain.User;
import com.neuedu.hebeigc_usercase.service.UserService;
import com.neuedu.hebeigc_usercase.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "userListServlet", value = "/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        List<User> userList = service.findAll();
        for (User user : userList){
            System.out.println(user);
        }
        request.setAttribute("user", userList);
        request.getRequestDispatcher("./list.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

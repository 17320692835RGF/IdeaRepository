package com.neuedu.hebeigc_usercase.servlet;

import com.neuedu.hebeigc_usercase.domain.User;
import com.neuedu.hebeigc_usercase.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "addUserServlet", value = "/addUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("./add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();

        try {
            BeanUtils.copyProperties(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);
        response.sendRedirect("/findUserByPageServlet");
    }
}

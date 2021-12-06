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

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //登录逻辑操作
        // 设置编码方式
        request.setCharacterEncoding("utf-8");
        // 获取请求参数
        String verifycode = request.getParameter("verifycode");
        // 验证码逻辑校验
        HttpSession session = request.getSession();
        String checkcode_server =(String)session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if (!checkcode_server.equals(verifycode)){
            request.setAttribute("login_msg", "验证码错误");
            request.getRequestDispatcher("./login.jsp").forward(request, response);
            return;
        }
        // 校验用户名和密码
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        //populate(Object bean, Map properties):根据指定的名称/值对填充指定bean的java bean属性。
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserServiceImpl userService = new UserServiceImpl();
        User loginUser = userService.login(user);
        if (loginUser!= null){
           session.setAttribute("user", loginUser);
            // 重定向
            response.sendRedirect("index.jsp");
            return;
        }else {
            request.setAttribute("login_msg", "用户名或者密码错误");
            request.getRequestDispatcher("./login.jsp").forward(request, response);
            return;
        }
    }
}

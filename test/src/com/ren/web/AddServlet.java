package com.ren.web;

import com.ren.entity.Goods;
import com.ren.service.IGoodsService;
import com.ren.service.impl.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 继承父类 HttpServlet
 * 2. 重写方法 doXXX
 * 3. 配置Servlet ，注解 或者 xml
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {

    //创建业务对象
    private IGoodsService studentService = new GoodsService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求数据的中文乱码问题
        req.setCharacterEncoding("UTF-8");//客户端网页我们控制为UTF-8
        //获取请求中的数据
        String name = req.getParameter("name");
        String adress = req.getParameter("adress");
        String broad = req.getParameter("broad");
        //调用业务方法
        System.out.println(name);
        System.out.println(adress);
        System.out.println(broad);
        studentService.add(new Goods(0,name,adress,broad));
        resp.sendRedirect("index.jsp");
    }
}

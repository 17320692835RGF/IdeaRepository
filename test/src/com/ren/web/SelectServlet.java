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
import java.util.List;

/**
 * 1. 继承父类 HttpServlet
 * 2. 重写方法 doXXX
 * 3. 配置Servlet ，注解 或者 xml
 */
@WebServlet("/select")
public class SelectServlet extends HttpServlet {

    //创建业务对象
    private IGoodsService studentService = new GoodsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //请求数据的中文乱码问题
//        req.setCharacterEncoding("UTF-8");//客户端网页我们控制为UTF-8
//        //获取请求中的数据
//        Integer id =Integer.parseInt(req.getParameter("id"));
        List<Goods> goodsList=studentService.select(1);
        req.setAttribute("ListGoods",goodsList);
        for(Goods it:goodsList){
            System.out.println(it);
        }

        req.getRequestDispatcher("/select.jsp").forward(req, resp);
    }
}

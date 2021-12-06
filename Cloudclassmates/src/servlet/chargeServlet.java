package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;
import util.JdbcUtil;
import model.Users;

/**
 * Servlet implementation class chargeServlet
 */
@WebServlet("/servlet/chargeServlet")
public class chargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chargeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users user=(Users)request.getSession().getAttribute("loginUser");
		UserService loginService = new UserServiceImpl();
		Users loginUser = new Users();
		JdbcUtil jdbcutil=new JdbcUtil();
		jdbcutil.getConnection(); // 获取数据库链接
		int money=Integer.valueOf(request.getParameter("total_amount"))+user.getMoney();//通过key，返回一个value。
		String strmoney=String.valueOf(money);
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(strmoney);
		paramList.add(String.valueOf(user.getUserID()));
		try {
			jdbcutil.updateByPreparedStatement("update users set  money=? where userID=?",paramList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().removeAttribute("loginUser");
		loginUser=loginService.findAllUsers(user);
		request.getSession().setAttribute("loginUser",loginUser);
		response.sendRedirect(request.getContextPath()+"/zhifubao.jsp");
	}

}

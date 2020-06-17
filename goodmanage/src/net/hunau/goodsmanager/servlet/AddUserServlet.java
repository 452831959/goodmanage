package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.dao.UserDao;

public class AddUserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("passWord");
		String roleType = request.getParameter("roleType");
		PrintWriter out = response.getWriter();
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		user.setRoles(Integer.valueOf(roleType));
		user.setValidateFlag(1);
		UserDao ud = new UserDao();
		String toPage = request.getContextPath()+"/content/userManager/userManager.jsp";
		if(!ud.checkUser(userName) && userName !=null && userName != "" ){
			ud.addUser(user);
			out.print(false);
			response.sendRedirect(toPage);
		}else{	
			out.print(true);
		}
	
	}

}

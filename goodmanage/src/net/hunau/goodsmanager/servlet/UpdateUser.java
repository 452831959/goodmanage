package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.dao.UserDao;

public class UpdateUser extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String roleType = request.getParameter("roleType");
		String flag = request.getParameter("validateFlag");
		int intFlag = 0;
		if(flag!=null){
			intFlag = Integer.parseInt(flag);
		}
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		user.setValidateFlag(intFlag);
		user.setRoles(Integer.parseInt(roleType));
		UserDao ud = new UserDao();
		ud.updateUser(user);
		String toPage = request.getContextPath()+"/content/userManager/userManager.jsp";
		response.sendRedirect(toPage);
	}

}

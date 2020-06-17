package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.biz.UserBiz;
import net.hunau.goodsmanager.exception.UserAuthException;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User loginUser = new User();
		loginUser.setUsername(userName);
		loginUser.setPassword(password);
		UserBiz ub = new UserBiz();
		String toPage = "index.jsp";
		HttpSession session = request.getSession();
		try {
			loginUser = ub.userLogin(loginUser);
			session.setAttribute("errorMessage", "");
			toPage = "main.html";
		} catch (UserAuthException e) {
			// TODO Auto-generated catch block
			session.setAttribute("errorMessage", e.getMessage());
			e.printStackTrace();
		}
		response.sendRedirect(toPage);
	}

}

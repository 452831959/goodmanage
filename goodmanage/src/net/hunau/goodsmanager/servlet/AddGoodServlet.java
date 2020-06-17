package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.bean.GoodsDao;
import net.hunau.goodsmanager.biz.GoodsBiz;

public class AddGoodServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ProductName = request.getParameter("ProductName");
		String productPrice = request.getParameter("productPrice");
		String productNumber = request.getParameter("productNumber");
		String description = request.getParameter("description");
		String goodsType = request.getParameter("goodsType");
		Goods goodss = new Goods();
		goodss.setGoodname(ProductName);
		goodss.setGoodprice(Double.parseDouble(productPrice));
		goodss.setGoodcount(Integer.parseInt(productNumber));
		goodss.setGoodtype(goodsType);
		goodss.setGoodDep(description);
		GoodsBiz goodsBiz = new GoodsBiz();
		goodsBiz.addGoods(goodss);
		String toPage=request.getContextPath()+"/servlet/ScanGoodServlet";
		GoodsDao goodDao = new GoodsDao();
		List<Goods> goods = goodDao.getGoods();
		HttpSession session = request.getSession();
		session.setAttribute("goods", goods);
		response.sendRedirect(toPage);
	}

}

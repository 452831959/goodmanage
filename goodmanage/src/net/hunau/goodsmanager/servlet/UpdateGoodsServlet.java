package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.bean.GoodsDao;

public class UpdateGoodsServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");
		String productName = request.getParameter("productName");
		String productPrice = request.getParameter("productPrice");
		String productCount = request.getParameter("productCount");
		String productType = request.getParameter("productType");
		String productDep = request.getParameter("productDep");
		System.out.println(productPrice);
		GoodsDao gd = new GoodsDao();
		Goods goods = new Goods();
		goods.setGoodname(productName);
		goods.setId(Integer.parseInt(productId));
		goods.setGoodprice(Double.valueOf(productPrice.trim()));
		goods.setGoodcount(Integer.valueOf(productCount));
		goods.setGoodtype(productType);
		goods.setGoodDep(productDep);
		gd.updateGoods(goods);
		String toPage = request.getContextPath()+"/servlet/ScanGoodServlet";
		response.sendRedirect(toPage);
	}

}

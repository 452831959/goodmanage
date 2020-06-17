package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.biz.GoodsBiz;

public class ScanGoodServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String productID = request.getParameter("productID");
		String productName = request.getParameter("productName");
		List<Goods> goods = new ArrayList<Goods>();
		GoodsBiz goodsBiz = new GoodsBiz();
		if((productID ==null || productID.equals("")) && (productName ==null || productName.equals(""))){
			goods = goodsBiz.getGoods();
		}else{
			Goods Goods = new Goods();
			if(productID!=null && !productID.equals("")){
				Goods.setId(Integer.valueOf(productID));
			}
			if(productName !=null && !productName.equals("")){
				Goods.setGoodname(productName);
			}
			goods = goodsBiz.findGoods(Goods);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("goodss", goods);
		String toPage = "/content/goodsManager/searchGoods.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(toPage);
		rd.forward(request, response);
	}

}

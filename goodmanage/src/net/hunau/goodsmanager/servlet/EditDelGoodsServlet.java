package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.bean.GoodsDao;
import net.hunau.goodsmanager.bean.GoodsType;
import net.hunau.goodsmanager.dao.TypeDao;

public class EditDelGoodsServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goodsID = request.getParameter("goodsid");
		String op = request.getParameter("op");
		System.out.println(op);
		int intGoodsId =0;
		if(goodsID != null && !goodsID.equals("") ){
			intGoodsId = Integer.parseInt(goodsID);
		}
		
		GoodsDao goodDao = new GoodsDao();
		HttpSession session = request.getSession();
		String toPage = "ScanGoodServlet";
		if("del".equals(op)){
			goodDao.delGoods(intGoodsId);		
		}else{
			Goods goods =  goodDao.getGoods(intGoodsId);
			TypeDao typeDao = new TypeDao();
			List<GoodsType> goodsType = typeDao.scanAllGoodsType();
			session.setAttribute("goods", goods);
			session.setAttribute("goodsType", goodsType);
			toPage = "/content/goodsManager/updateGoods.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(toPage);
		rd.forward(request, response);
		/*response.sendRedirect(toPage);*/
	}

}

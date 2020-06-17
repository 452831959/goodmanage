package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hunau.goodsmanager.bean.GoodsType;
import net.hunau.goodsmanager.dao.TypeDao;

public class AddGoodsType extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String typeID = request.getParameter("typeID");
		String typeName = request.getParameter("typeName");
		String typeDec = request.getParameter("typeDec");
		PrintWriter out = response.getWriter();
		TypeDao tp = new TypeDao();
		GoodsType goodsType  = new GoodsType();
		goodsType.setId(Integer.valueOf(typeID));
		goodsType.setTypeName(typeName);
		goodsType.setTypeDec(typeDec);
		String toPage = request.getContextPath()+"/content/goodsManager/searchGoods.jsp";
		System.out.println(tp.isExsit(Integer.valueOf(typeID)));
		
		if(tp.isExsit(Integer.valueOf(typeID)) == false){
			
			out.print(false);
			tp.addType(goodsType);
			response.sendRedirect(toPage);
		}else if(tp.isExsit(Integer.valueOf(typeID)) == true){	
			out.print(true);
		}
	}

}

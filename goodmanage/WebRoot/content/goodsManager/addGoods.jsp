<%@ page language="java" import="java.util.*,net.hunau.goodsmanager.bean.GoodsType" pageEncoding="utf-8" %>
<%@ page import="java.util.*,net.hunau.goodsmanager.dao.TypeDao" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%

String path = request.getContextPath();
TypeDao typedao = new TypeDao();
List<GoodsType> goodstype =  typedao.scanAllGoodsType();
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="../../css/biz.css" type=text/css rel=stylesheet>
</HEAD>
<BODY>
<SCRIPT type=text/javascript>
function check(){
    var productName = document.getElementById("productName").value;
    var productPrice = document.getElementById("productPrice").value;
    var productNumber = document.getElementById("productNumber").value;
    var description = document.getElementById("description").value;
    
    
      if(productName ==  null || productName == ''){
        alert("商品名字不能为空");
        return false;
   }
      if(productPrice ==  null || productPrice == ''){
        alert("商品价格不能为空");
        return false;
   }
    if(productNumber ==  null || productNumber == ''){
        alert("商品数量不能为空");
        return false;
   }
    if(description ==  null || description == ''){
        alert("商品描述不能为空");
        return false;
   }
   return true;
}
</SCRIPT>
	<DIV>
		<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR class="bg_header" height=47>
					<TD width=10><SPAN class="main_hl"></SPAN>
					</TD>
					<TD><SPAN class="main_hl2"></SPAN> <SPAN class="main_hb">添加商品
					</SPAN> <SPAN class="main_hr"></SPAN></TD>
					<TD class="main_rc " width=10></TD>
				</TR>
				<TR>
					<TD class="main_ls">&nbsp;</TD>
					<TD class="main_nu" vAlign=top align=middle>
						<DIV>
							<form action="<%=path %>/servlet/AddGoodServlet" method="post" onsubmit="return check()">
							<input type="hidden" value='add' name='op'>
								<TABLE class=gridView
									style="WIDTH: 80%; BORDER-COLLAPSE: collapse" cellSpacing=0
									rules=all border=1>
									<TBODY>
										<TR>
											<TH class=gridViewHeader colspan="4">商品信息</TH>
										</TR>
										<TR>
											
											<TD class=gridViewItem>商品名称&nbsp;<font color="red">*</font></TD>
											<TD class=gridViewItem><input class=gridViewItem
												type="text" name="ProductName" id="productName">
											</TD>
										</TR>
										<TR>
											<TD class=gridViewItem>商品价格&nbsp;<font color="red">*</font></TD>
											<TD class=gridViewItem><input class=gridViewItem
												name="productPrice" id="productPrice">
											</TD>
											<TD class=gridViewItem>商品数量&nbsp;<font color="red">*</font></TD>
											<TD class=gridViewItem><input class=gridViewItem
												type="text" name="productNumber" id="productNumber">
											</TD>
										</TR>
										<TR>
											<TD class=gridViewItem>商品描述&nbsp;<font color="red">*</font></TD>
											<TD class=gridViewItem><input class=gridViewItem
												name="description" id="description">
											</TD>

											<TD class=gridViewItem>商品类型</TD>
											<TD class=gridViewItem><select name="goodsType"
												style="WIDTH:45% ;color:#566984">
													<option value="-1">请选择</option>	
													<%
														for(GoodsType gt:goodstype){
													 %>
													<option value="<%= gt.getId()%>"><%=gt.getTypeName() %></option>	
														<%
														
														}
														 %>
											</select></TD>


										</TR>
										<TR>
											<TD class=gridViewItem colspan="4"><input
												class=cmdField type="submit" value="提交">&nbsp;&nbsp;&nbsp;<input
												class=cmdField type="reset"></Td>
										</TR>
									</TBODY>
								</TABLE>
							</form>
						</DIV></TD>
					<TD class="main_rs"></TD>
				</TR>
				<TR class="main_fs" height=10>
					<TD class="main_lf"></TD>
					<TD class="main_fs"></TD>
					<TD class="main_rf"></TD>
				</TR>
			</TBODY>
		</TABLE>
	</DIV>
</BODY>
</HTML>

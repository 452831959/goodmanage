<%@ page language="java" import="java.util.*,net.hunau.goodsmanager.bean.Goods,net.hunau.goodsmanager.bean.GoodsType" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();

String goodstype = ((Goods)session.getAttribute("goods")).getGoodtype();
 %>
<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="<%=path%>/css/biz.css" type=text/css rel=stylesheet>
</HEAD>
<BODY>
<SCRIPT type=text/javascript>
function check(){
   var productName = document.getElementById("productName").value;
    var productPrice = document.getElementById("productPrice").value
    var productCount = document.getElementById("productCount").value
    var productDep = document.getElementById("productDep").value
    
    
      if(productName ==  null || productName == ''){
        alert("商品名称不能为空");
        return false;
   }
    if(productPrice ==  null || productPrice == ''){
        alert("商品价格不能为空");
        return false;
   }
    if(productCount ==  null || productCount == ''){
        alert("商品数量不能为空");
        return false;
   }
   
    if(productDep ==  null || productDep == ''){
        alert("商品描述不能为空");
        return false;
   }
   
     
   return true;
}
</SCRIPT>
<DIV>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR  class="bg_header"  height=47>
        <TD width=10><SPAN class="main_hl"></SPAN></TD>
        <TD>
        <SPAN class="main_hl2"></SPAN>
        <SPAN class="main_hb">修改商品 </SPAN>
        <SPAN class="main_hr"></SPAN>
      	</TD>
        <TD  class="main_rc " width=10></TD>
      </TR>
      <TR>
        <TD class="main_ls">&nbsp;</TD>
        <TD class="main_nu" vAlign=top align=middle>
           <DIV>
          <form action="UpdateGoodsServlet"  method='post' onsubmit="return check()">
          <input type='hidden' name='productID' value="${goods.id }">
            <TABLE class=gridView style="WIDTH: 80%; BORDER-COLLAPSE: collapse"  cellSpacing=0 rules=all  border=1>
              <TBODY>
                <TR>
                  <TH class=gridViewHeader  colspan="4" >商品信息</TH>
                </TR>
                <TR>
                  <TD class=gridViewItem>商品ID </TD>
                  <TD class=gridViewItem><input class=gridViewItem value="${goods.id }" type="text" id='productId' name="productId"></TD>
                   
                  <TD class=gridViewItem>商品名称 </TD>
                  <TD class=gridViewItem><input class=gridViewItem value="${goods.goodname }" type="text" id='productName' name="productName"></TD>
                    </TR>
               <TR>
                  <TD class=gridViewItem>商品价格</TD>
                  <TD class=gridViewItem><input  class=gridViewItem type="text" id='productPrice' value="${goods.goodprice }" name="productPrice"></TD>
             
                  <TD class=gridViewItem> 商品数量</TD>
                  <TD class=gridViewItem><input class=gridViewItem id='productCount' value='${goods.goodcount }' name="productCount"></TD>
                    </TR>
                 <TR>
				  <TD class=gridViewItem >商品类型 </TD>
                  <TD class=gridViewItem>
						<select name="productType" style="WIDTH:45% ;color:#566984" >			
						   <c:forEach items='${goodsType }' var = "gType">
						   <option value="${gType.id }" 
						   <%if(goodstype.equals(((GoodsType)pageContext.findAttribute("gType")).getTypeName())){out.print("selected");}%>>${gType.typeName }</option>  	
							</c:forEach>
						</select>  
				  </TD>
                  <TD class=gridViewItem>商品描述</TD>
                  <TD class=gridViewItem><input   class=gridViewItem type="text" value='${goods.goodDep }' id='productDep' name="productDep"></TD>
              
                </TR>
                <TR>
                  <TD class=gridViewItem  colspan="4" >
					 <input class=cmdField type="submit" value="提交">&nbsp;&nbsp;&nbsp;<input class=cmdField type="reset">
                  </Td>
                </TR>
              </TBODY>
            </TABLE>
            </form>
          </DIV>
        </TD>
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

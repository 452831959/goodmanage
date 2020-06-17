<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page import="net.hunau.goodsmanager.bean.Roles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();

%>
<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="<%=path %>/css/biz.css" type=text/css rel=stylesheet>
</HEAD>
<BODY >
<SCRIPT type=text/javascript>
function Goto(){
   alert("test");
}
function deleteCurrentRow(obj){
   var tr=obj.parentNode.parentNode;
   var tbody=tr.parentNode;
   tbody.removeChild(tr);
}
</SCRIPT>
<DIV>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR  class="bg_header"  height=47>
        <TD width=10><SPAN class="main_hl"></SPAN></TD>
        <TD>
        <SPAN class="main_hl2"></SPAN>
        <SPAN class="main_hb">角色管理 </SPAN>
        <SPAN class="main_hr"></SPAN>
      	</TD>
        <TD  class="main_rc" width=10></TD>
      </TR>
      <TR>
        <TD class="main_ls">&nbsp;</TD>
        <TD class="main_nu" vAlign=top align=middle>
          <DIV>
            <TABLE class=gridView   style="WIDTH: 100%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all  border=1>
              <TBODY>
                <TR>
                  <TH class=gridViewHeader style="WIDTH: 50px" scope=col>&nbsp;</TH>
                  <TH class=gridViewHeader scope=col>角色Id</TH>
                  <TH class=gridViewHeader scope=col>角色名称</TH>    
                  <TH class=gridViewHeader scope=col>角色描述</TH>
                  <TH class=gridviewHeader scope=col>更新</TH>
                  <TH class=gridviewHeader scope=col>删除</TH>
                </TR>
                                
                <TR>
                  <TD class=gridViewItem style="WIDTH: 50px"><IMG  src="<%=path %>/images/bg_users.gif"> </TD>
                  <TD class=gridViewItem>####</TD>
                  <TD class=gridViewItem>####</TD>
                  <TD class=gridViewItem>####</TD>
                  <TD class=gridViewItem><A class=cmdField   href="updataRole.html">编辑</A></TD>
                  <TD class=gridViewItem><a  class=cmdField  href="javascript:Goto();" onclick='{if(confirm("确定要删除吗?")) {deleteCurrentRow(this); }else {}}'>删除</a></TD>
                </TR>
                
               
              </TBODY>
            </TABLE>
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
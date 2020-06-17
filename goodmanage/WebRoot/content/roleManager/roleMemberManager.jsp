<%@ page language="java" import="java.util.*,net.hunau.goodsmanager.bean.Roles" pageEncoding="utf-8" %>
<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="../../css/biz.css" type=text/css rel=stylesheet>
</HEAD>
<BODY >
<SCRIPT type=text/javascript>
</SCRIPT>
<DIV>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR  class="bg_header"  height=47>
        <TD width=10><SPAN class="main_hl"></SPAN></TD>
        <TD>
        <SPAN class="main_hl2"></SPAN>
        <SPAN class="main_hb">角色成员管理 </SPAN>
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
                  <TH class=gridviewHeader scope=col>查询成员</TH>
                  <TH class=gridviewHeader scope=col>添加成员</TH>
                </TR>
                <TR>
                  <TD class=gridViewItem style="WIDTH: 50px"><IMG  src="../../images/bg_users.gif"> </TD>
                  <TD class=gridViewItem>1001</TD>
                  <TD class=gridViewItem>系统管理员</TD>
                  <TD class=gridViewItem>进行商品项目后台管理</TD>
                  <TD class=gridViewItem><A class=cmdField   href="roleMember.html">查询</A></TD>
                  <TD class=gridViewItem><A class=cmdField  href="addRoleMember.html">添加</A> </TD>
                </TR>
                <TR>
                  <TD class=gridViewItem style="WIDTH: 50px"><IMG  src="../../images/bg_users.gif"> </TD>
                  <TD class=gridViewItem>1002</TD>
                  <TD class=gridViewItem>普通用户</TD>
                  <TD class=gridViewItem>进行商品订购</TD>
                   <TD class=gridViewItem><A class=cmdField   href="roleMember.html">查询</A></TD>
                  <TD class=gridViewItem><A class=cmdField  href="addRoleMember.html">添加</A> </TD>
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
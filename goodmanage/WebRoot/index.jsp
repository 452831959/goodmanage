<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String errorMessage = (String)session.getAttribute("errorMessage");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
    <TITLE>欢迎登陆商品管理系统</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <LINK href="css/public.css" type=text/css rel=stylesheet>
    <LINK href="css/login.css" type=text/css rel=stylesheet> 
   	<script type="text/javascript">
   	function checkLogin(){
   		var userName = document.getElementById("userName");
   		var password = document.getElementById("password");
   		if(userName.value == ""){
   			alert("请输入用户名");
   			userName.focus();
   			return false;	
   		}
   		if(password.value == ""){
   			alert("请输入密码");
   			password.focus();
   			return false;
   		}
   			return true;
   	}
   	
   	
   	
   	</script>

</HEAD>
<BODY>
<DIV id=div1>

	
  <TABLE id=login height="100%" cellSpacing=0 cellPadding=0 width=800 align=center>
    <TBODY>
      <TR id=main>
        <TD>
        <form action="${pageContext.request.contextPath }/LoginServlet" onsubmit='return checkLogin()' method='post'>
          <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
            <TBODY>
              <TR>
                <TD colSpan=4>&nbsp;</TD>
              </TR>
              <TR height=30>
                <TD width=380>&nbsp;</TD>
                <TD>&nbsp;</TD>
                <TD>&nbsp;</TD>
                <TD>&nbsp;</TD>
              </TR>
              <TR height=40>
                <TD rowSpan=4></TD>
                <TD>用户名：</TD>
                <TD>
                  <INPUT class=textbox id="userName" name="userName">
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>
              <TR height=40>
                <TD>密　码：</TD>
                <TD>
                  <INPUT class=textbox id="password" type=password 
            name="password">
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>
              <TR height=40>
                <TD><!-- 验证码：--></TD>
                <TD vAlign=center colSpan=2>
                 <!-- <INPUT id=txtSN size=4 name=txtSN> &nbsp; <IMG src="images/default.gif" border=0> <A id=LinkButton1 href="#">不清楚，再来一张</A>-->
                 <font color='red'><%= errorMessage==null?"":errorMessage %></font>
                </TD>
              </TR>
              <TR height=40>
                <TD></TD>
                <TD align=right>
                  <INPUT id=btnLogin type=submit value=" 登 录 " >
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>
              <TR height=110>
                <TD colSpan=4>&nbsp;</TD>
              </TR>
            </TBODY>
          </TABLE>
          </form>
        </TD>
      </TR>
      <TR id=root height=104>
        <TD>&nbsp;</TD>
      </TR>
    </TBODY>
  </TABLE>
</DIV>
<DIV id=div2 style="DISPLAY: none"></DIV>

</BODY>
</HTML>

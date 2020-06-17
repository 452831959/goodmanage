<%@page import="net.hunau.goodsmanager.dao.RoleDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page import="net.hunau.goodsmanager.bean.Roles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
Roles roles  = new Roles();
RoleDao roleDao = new RoleDao();
List<Roles> roleAll = roleDao.getRoles();
session.setAttribute("roleAll", roleAll);
 %>
<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="../../css/biz.css" type=text/css rel=stylesheet>
<script type="text/javascript">
   function check(){
   		var userName = document.getElementById("userName").value;
   		var password = document.getElementById("passWord").value;
   		var repassword = document.getElementById("repassword").value;
   		if(userName == '' || userName == null){
   			alert("请输入用户名");
   			
   			return false;	
   		}
   		if(password == '' || password == null){
   			alert("请输入密码");
   			
   			return false;
   		}
   		if(repassword == '' || repassword == null){
   			alert("请输入重复密码")
   			
   			return false;
   		}
   		if(password != repassword){
   			alert("两次密码不一致");
   			
   			return false;
   		}
   		
   		
   	}
   	</script>
	<script type="text/javascript">
	function getXMLHttpRequest(){
	var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		return xmlhttp;
	}
	function ckName(obj) {
		//获取用户名
		var name = document.getElementById("userName");
		//alert(name).value;
		var msg = document.getElementById("msg_user");
		var roleType = document.getElementById("roleType");
		//创建XMLHttpRequst对象
		var xhr = getXMLHttpRequest();
		
		//处理结果
		xhr.onreadystatechange = function(){
		
			if(xhr.readyState==4){
				if(xhr.status==200){
				
					if(xhr.responseText=="true"){
						/* msg.innerHTML = "<font color='red'>用户名已存在</font>"; */
						alert("用户名已存在");
						name.value="";
						return false;
					}else if(name.value=="" || name.value == null){
						msg.innerHTML = "<font color='red'>用户名不能为空</font>";
						return false
					}else{
						msg.innerHTML = "用户名可用";
						return true;
					}
				}
			}
		}
		//创建连接
		xhr.open("get","${pageContext.request.contextPath}/servlet/AddUserServlet?userName="+name.value+"&"+"roleType="+roleType.value);
		
		//发送请求
		xhr.send(null);
		
	}
	</script>
</HEAD>
<BODY>

<DIV>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR  class="bg_header"  height=47>
        <TD width=10><SPAN class="main_hl"></SPAN></TD>
        <TD>
        <SPAN class="main_hl2"></SPAN>
        <SPAN class="main_hb">添加用户 </SPAN>
        <SPAN class="main_hr"></SPAN>
      	</TD>
        <TD  class="main_rc " width=10></TD>
      </TR>
      <TR>
        <TD class="main_ls">&nbsp;</TD>
        <TD class="main_nu" vAlign=top align=middle>
          <DIV>
		  <form action="<%=path %>/servlet/AddUserServlet" method="post" onsubmit="return check();">
            <TABLE class=gridView style="WIDTH: 80%; BORDER-COLLAPSE: collapse"  cellSpacing=0 rules=all  border=1>
              <TBODY>
                <TR>
                  <TH class=gridViewHeader  colspan="4" >用户信息</TH>
                </TR>
                <TR>
                  <TD class=gridViewItem >用户名 <font color="red">*</font> </span> </TD>
                  <TD class=gridViewItem><input class=gridViewItem type="text" id="userName" name="userName" onblur="ckName();"  ><span id="msg_user"></span></TD>
                  <TD class=gridViewItem >用户类型 </TD>
                  <TD class=gridViewItem>
						<select name="roleType" style="WIDTH:45% ;color:#566984" id="roleType">
						<c:forEach items='${roleAll }' var="roles">
						<option value="${roles.id }">${roles.roleName }</option>  
						</c:forEach>
						</select>  
						
				  </TD>
                </TR>
               <TR>
                  <TD class=gridViewItem >密码&nbsp;<font color="red">*</font> </TD>
                  <TD class=gridViewItem><input  class=gridViewItem type="password" id="passWord" name="passWord"></TD>
                  <TD class=gridViewItem>确认密码&nbsp;<font color="red">*</font></TD>
                  <TD class=gridViewItem><input   class=gridViewItem type="password" id="repassword" name="repassword"></TD>
                </TR>
  
                <TR>
                  <TD class=gridViewItem  colspan="4" >
                	<input class=cmdField type="submit" value="提交" >&nbsp;&nbsp;&nbsp;<input class=cmdField type="reset">
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

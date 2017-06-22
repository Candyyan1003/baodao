<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<base href="<%=basePath %>"/>
<TITLE>新生报道管理系统</TITLE>
<LINK href="web.files/css.css" type=text/css 
rel=stylesheet>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2900.5880" name=GENERATOR>
<style type="text/css">

	#downid{
		border-style:none;
		background-color: #00AAEE;
		color: white;
		border-radius:3px;
		width: 80px;
		height: 29px;
	}
	#manager td{
		height:50px;
	}
</style>
</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0 height="140px;">
  <TBODY>
  	<TR>
      <TD align="center" height=35>
     <font size="13px">${biaoti }</font>
      </TD>
    </TR>
  
    <TR>
    
       <form action="${url }" method="post">
      <TD align="right" height=20>
	<input  onclick="javascript:window.location.href='<%=basePath %>${url2 }add?xueyuan=${xueyuan.depart }';" class="buttoncss" id="downid" type="button" value="新生登记" />
     &nbsp;&nbsp;&nbsp;
       学号:<input type="text" size="10"  name="xuehao"  value="${xuehao }"/>&nbsp;&nbsp; 
       姓名:<input type="text" size="10"  name="name"  value="${name }"/>&nbsp;&nbsp; 
       身份证:<input type="text" size="10"  name="sfz"  value="${sfz }"/>&nbsp;&nbsp; 
   专业:<input type="text" name="zhuanye" value="${zhuanye }" size="10"/>
       <input type="hidden" size="10"  name="xueyuan"  value="${xueyuan }"/>&nbsp;&nbsp; 
       <input id="downid" type="submit"  value="查询" />    
      </TD>
      </form>
    </TR>
  </TBODY>
</TABLE>
<br/>

<TABLE id="manager" width="100%" cellSpacing=1 borderColorDark=#ffffff cellPadding=0  align=center bgColor=#cccccc borderColorLight=#999999 border=0>
  <TBODY>
  已报到：${total }人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;未报到：${number-total }人
    <TR >
      
      <TD align=middle  bgColor=#F2F9FD height=20>学号</TD>
      <TD align=middle  bgColor=#F2F9FD height=20>姓名</TD>
      <TD align=middle  bgColor=#F2F9FD height=20>性别</TD>
      <TD align=middle  bgColor=#F2F9FD height=20>身份证</TD>
      <TD align=middle  bgColor=#F2F9FD height=20>学院</TD>
      <TD align=middle  bgColor=#F2F9FD height=20>专业</TD>
      <TD align=middle  bgColor=#F2F9FD height=20>手机号码</TD>
    
      <TD align=middle  bgColor=#F2F9FD height=23>操作</TD>
    </TR>
    
    <c:forEach items="${list}"  var="bean">
    <TR bgColor=#ffffff>
    <TD align=middle>
     ${bean.xuehao }
     </TD>
    
      <TD align=middle>
     ${bean.name }
      </TD>
      
      <TD align=middle>
     ${bean.sex }
      </TD>
      
      <TD align=middle>
     ${bean.sfz }
      </TD>
      
       <TD align=middle>
     ${bean.xueyuan.depart }
      </TD>
      
       <TD align=middle>
     ${bean.zhuanye.depart }
      </TD>
      
      <TD align=middle>
     ${bean.tel }
      </TD>
     
      
      <TD borderColorLight=#c0c0c0 align=middle bgColor=#ffffff height=23>
      <DIV align=center>
      <a href="${url2 }update3?id=${bean.id }">查看</a> &nbsp; &nbsp; &nbsp;
      <a href="${url2 }update?id=${bean.id }&xueyuan=${xueyuan.depart}">修改</a> &nbsp; &nbsp; &nbsp;
  	<a href="${url2 }delete?id=${bean.id }&xueyuan=${xueyuan.depart}" onclick="return confirm('确定要删除吗?'); ">删除</a>
      </DIV>
      </TD>
      
    </TR>
    </c:forEach>
    
    
    <TR bgColor=#ffffff>
      <TD borderColorLight=#c0c0c0 align=middle colSpan=20 height=23>${pagerinfo }</TD>
    </TR>
  </TBODY>
</TABLE>
</BODY>
</HTML>


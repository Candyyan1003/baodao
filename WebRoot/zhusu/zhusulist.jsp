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
<style>

#downid{
		
		border-style:none;
		background-color: #00AAEE;
		color: white;
		border-radius:3px;
		width: 80px;
		height: 29px;
	
	}
	#massage td{
		text-align: center;
		height: 50px;
	}
</style>
</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0 height="140px">
  <TBODY>
  	<TR>
      
      <TD align="center" height=20>
     <font size="13px">${biaoti }</font>
      </TD>
    
    </TR>
  
    <TR>
       <form action="${url }" method="post">
      <TD align="right" height=20>
      学号:<input type="text" size="10"  name="xuehao"  value="${xuehao }"/>&nbsp;&nbsp; 
      姓名:<input type="text" size="10"  name="name"  value="${name }"/>&nbsp;&nbsp; 
      身份证:<input type="text" size="10"  name="sfz"  value="${sfz }"/>&nbsp;&nbsp; 
      
       <input type="submit" id="downid" value="查询" />    
      </TD>
      </form>
    </TR>
  </TBODY>
</TABLE>
<br/>

<TABLE id="massage" width="100%" cellSpacing=1 borderColorDark=#ffffff cellPadding=0  align=center bgColor=#cccccc borderColorLight=#999999 border=0>
  <TBODY>
  已报到：${total2 }人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已住宿：${total }人
    <TR bgcolor="#F2F9FD">
      
      <TD >学号</TD>
      <TD >姓名</TD>
      <TD >身份证</TD>
     
      <TD >手机号码</TD>
    
  	  <TD>宿舍楼号</TD>
  	  <TD >宿舍楼层</TD>
  	  <TD >宿舍编号</TD>
  	  <TD >分配时间</TD>
  	 
  
     
    
    </TR>
    
    <c:forEach items="${list}"  var="bean">
    <TR bgColor=#ffffff>
    <TD align=middle>
     ${bean.student.xuehao }&nbsp;
     </TD>
    
      <TD align=middle>
     ${bean.student.name }&nbsp;
      </TD>
      
      <TD align=middle>
     ${bean.student.sfz }&nbsp;
      </TD>
      
       
      
      <TD align=middle>
     ${bean.student.tel }&nbsp;
      </TD>
      
      <TD align=middle>
     ${bean.sushe.louhao }&nbsp;
      </TD>
      
      <TD align=middle>
    ${bean.sushe.ceng }&nbsp;
      </TD>
      
      <TD align=middle>
     ${bean.sushe.bianhao }&nbsp;
      </TD>
      
      
      
     <TD align=middle>
     ${bean.ctime }&nbsp;
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


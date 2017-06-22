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
		height: 40px;
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
<input  onclick="javascript:window.location.href='<%=basePath %>${url2 }add';" class="buttoncss" type="button" id="downid" value="添加宿舍" />
     &nbsp;&nbsp;&nbsp;
       宿舍编号:<input type="text" size="10"  name="bianhao"  value="${bianhao }"/>&nbsp;&nbsp; 
      专业：<input type="text" name="zhuanye" value="${zhuanye }"/>
       <input type="submit" id="downid" value="查询" />    
      </TD>
      </form>
    </TR>
  </TBODY>
</TABLE>
<br/>

<TABLE id="massage" width="100%" cellSpacing=1 borderColorDark=#ffffff cellPadding=0  align=center bgColor=#cccccc borderColorLight=#999999 border=0>
  <TBODY>
  <TBODY>
    <TR bgcolor="#F2F9FD">
      
      <TD >楼号</TD>
      <TD >层</TD>
      <TD >宿舍编号</TD>
      <TD>宿舍类型</TD>
      <TD>专业班级</TD>
      
      <TD>最大可住人数</TD>
      <TD >已住人数</TD>
      <TD >剩余人数</TD>
  
  
     
      <TD >操作</TD>
    </TR>
    
    <c:forEach items="${list}"  var="bean">
    <TR bgColor=#ffffff>
    <TD align=middle>
     ${bean.louhao }&nbsp;
     </TD>
    
      <TD align=middle>
     ${bean.ceng }&nbsp;
      </TD>
       <TD align=middle>
     ${bean.bianhao }&nbsp;
      </TD>
       <TD align=middle>
     ${bean.leixing }&nbsp;
      </TD>
      <TD align=middle>
     ${bean.banji.zhuanye.depart }${bean.banji.bianhao }&nbsp;
      </TD>
	<TD align=middle>
     ${bean.renshu }&nbsp;
      </TD>
      
      <TD align=middle>
     ${bean.yizhu }&nbsp;
      </TD>
      
      <TD align=middle>
     ${bean.shengyu }&nbsp;
      </TD>
     
      
      <TD borderColorLight=#c0c0c0 align=middle bgColor=#ffffff height=23>
      <DIV align=center>
   		<a href="${url2 }delete?id=${bean.id }" onclick="return confirm('确定要删除吗?'); ">删除</a>
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


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
	#tab td{
		text-align: center;
		
		height: 40px;
	}
</style>
</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
  <TBODY>
  	<TR>
      
      <TD align="center" height=20>
     <font size="18px">${biaoti }</font>
      </TD>
    
    </TR>
  
   
  </TBODY>
</TABLE>
<br/>

<TABLE id="tab" width="100%" cellSpacing=1 borderColorDark=#ffffff cellPadding=0  align=center bgColor=#cccccc borderColorLight=#999999 border=0>
  <TBODY>
    <TR bgColor=#F2F9FD>
      
      <TD >学号</TD>
      <TD >姓名</TD>
      <TD>身份证</TD>
     
      <TD>手机号码</TD>
    
  	  <TD >宿舍楼号</TD>
  	  <TD >宿舍楼层</TD>
  	  <TD >宿舍编号</TD>
  	  <TD >分配时间</TD>
  	 
  
     
    
    </TR>
    

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

 
  </TBODY>
</TABLE>
</BODY>
</HTML>


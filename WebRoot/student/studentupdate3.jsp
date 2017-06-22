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
	span{
		font-size: 15px;
	}
	#tab td{
		height: 40px;
	}
</style>
</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width=800 align=center border=0>
  <TBODY>
    <TR>
      
      <TD align=middle height=20>
     <font size="13px">${biaoti }</font>
      </TD>
    
    </TR>
  </TBODY>
</TABLE>
<br/>


<TABLE cellSpacing=0  cellPadding=0 align=center   border=0 id="tab" height="400px">
  <TBODY>
  
    
    <TR>
      <TD width=300  >
        <DIV align=center>
      <span> 姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</span>
        </DIV>
      </TD>
      <TD width=300  >
     <span>${bean.name }</span>
      </TD>
     
    </TR>
    
     <TR>
      <TD width=300  >
        <DIV align=center>
      <span> 身&nbsp;&nbsp;份&nbsp;&nbsp;证:</span>
        </DIV>
      </TD>
      <TD width=300 >
      <span>${bean.sfz }</span>
      </TD>
     
    </TR>
    
    <TR>
      <TD width=300 >
        <DIV align=center>
       <span>照&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片:</span>
        </DIV>
      </TD>
      <TD width=300  >
     <img  src="uploadfile/${bean.photo }" width="100" height="100" />
      </TD>
     
    </TR>
    
    
    <TR>
      <TD width=300  >
        <DIV align=center>
       <span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
        </DIV>
      </TD>
      <TD width=300  >
      <span>${bean.sex }</span>
      </TD>
     
    </TR>
     
    
     <TR>
      <TD width=300  >
        <DIV align=center>
       <span>民&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;族:</span>
        </DIV>
      </TD>
      <TD width=300 >
    <span> ${bean.minzu }</span>
      </TD>
     
    </TR>
    
    
    <TR>
      <TD width=300  >
        <DIV align=center>
       <span>政治面貌:</span>
        </DIV>
      </TD>
      <TD width=300  >
    <span>${bean.zzmm }</span>
      </TD>
     
    </TR>
    
    <TR>
      <TD width=300  >
        <DIV align=center>
       <span>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院:</span>
        </DIV>
      </TD>
      <TD width=300  >
     <span>${bean.xueyuan.depart }</span>
      </TD>
     
    </TR>
    
    <TR>
      <TD width=300 >
        <DIV align=center>
      <span>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</span>
        </DIV>
      </TD>
      <TD width=300 >
      <span>${bean.zhuanye.depart }</span>
      </TD>
     
    </TR>
    
   
    
    <TR>
      <TD width=300  >
        <DIV align=center>
       <span>手机号码:</span>
        </DIV>
      </TD>
      <TD width=300  >
    <span>${bean.tel }</span>
      </TD>
     
    </TR>
    
    <TR>
      <TD width=300  >
        <DIV align=center>
     <span>  家庭&nbsp;地址:</span>
        </DIV>
      </TD>
      <TD width=300  >
      <span>${bean.address }</span>
      </TD>
     
    </TR>
   
    
    <TR>
    
      <TD width=300   align="center" colspan=2>
     			<input  onclick="javascript:history.go(-1);" id="downid" type="button" value="返回" />
                                    
      </TD>
     
    </TR>
    
  </TBODY>
</TABLE>


</BODY>
</HTML>


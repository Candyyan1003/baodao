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

.fontstyle{
	color: #F45A1E;
	font-size: 13px;
}

	#downid{
		border-style:none;
		background-color: #00AAEE;
		color: white;
		border-radius:3px;
		width: 80px;
		height: 29px;
	}
	span{
		font-size: 16px;
	}
	
	#tab td{
		height:65px;
		
	}
</style>
<script src="./js/jquery-1.7.2.js"></script> 
<script language="javascript" type="text/javascript">



</script>

</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width=780 align=center border=0>
  <TBODY>
    <TR>
      
      <TD align=middle height=20>
    <font size="13px">${biaoti }</font>
      </TD>
    
    </TR>
  </TBODY>
</TABLE>
<br/>

<form action="${url }&xueyuan=${bean.xueyuan.depart}" method="post" onsubmit="return checkform()" enctype="multipart/form-data">
<TABLE  id="tab"cellSpacing=0 cellPadding=0 align=center  border=0 >
  <TBODY>
    
    <TR>
      <TD width=300>
        <DIV align=center>
       <span>学生学号:</span>
        </DIV>
      </TD>
      <TD width=300>
      <span>${bean.xuehao }</span>
      </TD>
     
    </TR>
    
   
    <TR>
      <TD width=300 >
        <DIV align=center>
       <span>学生姓名:</span>
        </DIV>
      </TD>
      <TD width=300 >
      <span>${bean.name }</span>
      </TD>
     
    </TR>
    
     <TR>
      <TD width=300 >
        <DIV align=center>
       <span>学生身份证:</span>
        </DIV>
      </TD>
      <TD width=300>
      <span>${bean.sfz }</span>
      </TD>
     
    </TR>
    
    <TR>
      <TD width=300>
        <DIV align=center>&nbsp;
       <span>学生性别:</span>
        </DIV>
      </TD>
      <TD width=300 >
      <span>${bean.sex }</span>
      </TD>
     
    </TR>
     <TR>
      <TD width=300 >
     <DIV align=center>&nbsp;
       <span>学生所在学院:</span>
       </DIV>
      </TD>
      <TD width=300>
      <span>${bean.xueyuan.depart }</span>
      </TD>
     
    </TR>
     <TR>
      <TD width=300>
        <DIV align=center>
      <span> 分配的班级:</span>
        </DIV>
      </TD>
      <TD width=300 >
      <span>所在专业:${banji.zhuanye.depart }<br>
      	班级编号:${banji.bianhao }</span>
      <input type="hidden" name="banjiid" value="${banji.id }"/>
      </TD>
     
    </TR>
    
    <TR>
     
      <TD width=300 align="center" colspan=2>
     <input type="submit" value="确认分配" id="downid" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input  onclick="javascript:history.go(-1);"id="downid" type="button" value="返回" />
                                    
      </TD>
     
    </TR>
    
  </TBODY>
</TABLE>
</form>

</BODY>
</HTML>


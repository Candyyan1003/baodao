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
	span{
		font-size: 15px;
	}
	#tab td{
		height: 50px;
	}
</style>
<script language="javascript" type="text/javascript">

function checkform()
{
	 
	

	if (document.getElementById('usernameid').value=="")
	{
		alert("账户不能为空");
		return false;
	}
	
	
	
	if (document.getElementById('nameid').value=="")
	{
		alert("姓名不能为空");
		return false;
	}
	
	
	
	return true;
	
}


</script>

</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width=780 align=center border=0 >
  <TBODY>
    <TR>
      
      <TD align=middle height=20>
     <font size="13px">${biaoti }</font>
      </TD>
    
    </TR>
  </TBODY>
</TABLE>
<br/>

<form action="${url }" method="post" onsubmit="return checkform()">
<TABLE cellSpacing=0 cellPadding=0 align=center  border=0 id="tab">
  <TBODY>
    
 
    
     <TR>
      <TD width=300 >
        <DIV align=center>
       <span>姓名:</span>
        </DIV>
      </TD>
      <TD width=300>
      <input  type="text" name="name"  id='nameid'  size="30"  value="${bean.name }" readonly="readonly"/>
      </TD>
     
    </TR>
    
    
     <TR>
      <TD width=300>
        <DIV align=center>
       <span>手机号码:</span>
        </DIV>
      </TD>
      <TD width=300>
      <input  type="text" name="tel"  id='telid'  size="30"  value="${bean.tel }"  readonly="readonly" />
      </TD>
     
    </TR>
      <TR>
      <TD width=300>
        <DIV align=center>
      <span> 学院:</span>
        </DIV>
      </TD>
      <TD width=300>
      <input  type="text" name="xueyuan"  id='xueyuanid'  size="30"  value="${bean.depart.depart }"  readonly="readonly" />
      </TD>
     
    </TR>
    
 
    
    <TR>
    
      <TD width=300 align="center" colspan="2"/>

				<input  onclick="javascript:history.go(-1);" id="downid" type="button" value="返回" />
                                    
      </TD>
     
    </TR>
    
  </TBODY>
</TABLE>
</form>

</BODY>
</HTML>


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
		font-size: 15px;
	}
	select{
		width:210px;
		border:solid 1px #ABADB3;
		 appearance:none;
  		-moz-appearance:none;
  		-webkit-appearance:none;
  		background: url("./images/ar2.png") no-repeat scroll right center transparent;
  		padding-right: 14px;
	}
</style>
<script src="./js/jquery-1.7.2.js"></script> 
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
	if($("#depart").val()=="0"){
		alert("请选择部门");
		return false;
	}
	if($("#telid").val()==""){
		alert("手机号不能为空");
		return false;
	}else if(!(/^1[34578]\d{9}$/.test($("#telid").val()))){
		alert("手机号格式不正确");
		return false;
	}
	return true;
	
}


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

<form action="${url }" method="post" onsubmit="return checkform()">
<TABLE id="tab" cellSpacing=0  cellPadding=0 align=center  border=0 height="300px">
  <TBODY>
    
  
    <TR>
      <TD width=300 >
        <DIV align=center>
       <span>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户:</span>
        </DIV>
      </TD>
      <TD width=300>
      <input  type="text" name="username"  id='usernameid'  size="30"  />
      </TD>
     
    </TR>
    
     <TR>
      <TD width=300>
        <DIV align=center>
       <span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</span>
        </DIV>
      </TD>
      <TD width=300>
      <input  type="text" name="name"  id='nameid'  size="30"  />
      </TD>
     
    </TR>
    
     
    
     <TR>
      <TD width=300>
        <DIV align=center>
       <span>手机号码:</span>
        </DIV>
      </TD>
      <TD width=300>
      <input  type="text" name="tel"  id='telid'  size="30"  />
      </TD>
     
    </TR>
    <TR>
     <TD width=300>
        <DIV align=center>
      <span>学院或部门:</span>
        </DIV>
      </TD>
      <TD width=300 >
     <select name="depart" id="depart">
     	<option value="0">--请选择--</option>
     	<c:forEach items="${list }" var="one">
     		<option value="${one.id }">${one.depart }</option>
     	</c:forEach>
     </select>
      </TD>
     
    </TR>
    
    
    <TR>
      
      <TD width=300 colspan="2" align="center">
     <input type="submit" value="提交" id="downid" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input  onclick="javascript:history.go(-1);" id="downid" type="button" value="返回" />
                                    
      </TD>
     
    </TR>
    
  </TBODY>
</TABLE>
</form>

</BODY>
</HTML>


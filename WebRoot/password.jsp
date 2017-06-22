<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>

<TITLE>新生报道管理系统</TITLE>
<LINK href="web.files/css.css" type=text/css 
rel=stylesheet>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2900.5880" name=GENERATOR>
<style type="text/css">
	#tab td{
		height: 50px;
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
		font-size: 17px;
	}
	img{
		width: 14px;
		height: 14px;
	}
	.fontstyle{
		color: #F45A1E;
		font-size: 13px;
	}
</style>
 <script src="./js/jquery-1.7.2.js"></script> 
<script language="javascript" type="text/javascript">

//验证旧密码
function checkOld(){
	var password=$("#password1id").val();
	if(password==""){
		$("#oldPwd").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>请输入原始密码！</font>");
		$("#oldPwd").css("float", "right");
		return false;
	}else{
		$("#oldPwd").html("");
		return true;
	}
	
}
//检查新密码
function checkNew(){
	var password2=$("#password2id").val();
	if(password2==""){
		$("#newPwd").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>请输入新密码！</font>");
		$("#newPwd").css("float", "right");
		return false;
	}else if(password2.length<6){
		$("#newPwd").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>密码长度不能少于6位！</font>");
		$("#newPwd").css("float", "right");
		return false;
	}else{
		$("#newPwd").html("<img src='./images/check.png'>");
		$("#newPwd").css("float", "right");
		return true;
	}
	return true;
}

//检查确认密码、
function checkCof(){

	var password2=$("#password2id").val();
	var password3=$("#password3id").val();
	if(password3==""){
		$("#newPwd2").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>请输入确认密码！</font>");
		$("#newPwd2").css("float", "right");
		return false;
	}else if(password2!=password3){
		$("#newPwd2").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>两次输入密码不一致</font>");
		$("#newPwd2").css("float", "right");
		return false;
	}else{
		
		$("#newPwd2").html("<img src='./images/check.png'>");
		$("#newPwd2").css("float", "right");
		return true;
	}
	return true;
}


	
</script>

</HEAD>
<BODY>
<form  action="method!changepwd2">
<TABLE cellSpacing=0 cellPadding=0 width=500 align=center border=0>
  <TBODY>
    <TR>
      
      <TD align=middle height=20>
    ${biaoti }
      </TD>
    
    </TR>
  </TBODY>
</TABLE>
<br/>


<TABLE cellSpacing=0 cellPadding=0 align=center  id="tab" border=0>
  <TBODY>
    
    <TR>
      <TD width=300 >
        <DIV align=center>
        <span>原密码:</span>
        </DIV>
      </TD>
      <TD width=300>
      <input type="password" name="password1" id="password1id" size="30"  onblur="checkOld();"/>
      <div id="oldPwd">
      </div>
      </TD>
     
    </TR>
    
    <TR>
      <TD width=300>
        <DIV align=center>
        <span> 新密码:</span>
        </DIV>
      </TD>
      <TD width=300 >
      <input type="password" name="password2" id="password2id" size="30" onblur="checkNew();" />
      <div id="newPwd">
      </div>
      </TD>
     
    </TR>
    
    
    <TR>
      <TD width=300>
        <DIV align=center>
        <span>确认新密码:</span>
        </DIV>
      </TD>
      <TD width=300 >
      <input type="password" name="password3" id="password3id" size="30" onblur="checkCof();" />
      <div id="newPwd2">
      </div>
      </TD>
     
    </TR>
    
    <TR>
      
      <TD width=300 align="center" colspan="2">
      <input type="submit" value="提交" id="downid" onclick="checkPwd();"/>
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


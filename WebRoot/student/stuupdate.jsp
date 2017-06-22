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
#tab{
	margin-left: 180px;
}
 div img{
	width: 14px;
	height:14px;
}

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
		margin-right: 60px;
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
<script language="javascript" type="text/javascript">

//验证姓名
function checkName(){

	var name=$("#nameid").val();
	
	if(name==""){
		$(".errorName").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>姓名不能为空</font>");
		$(".errorName").css("float","right");
		return false;
	}else{
		$(".errorName").html("<img src='./images/check.png'>");
		$(".errorName").css("float","right");
		return true;
	}
}
//验证身份证
function checkSfz(){
	var sfz=$("#sfzid").val();
	if(sfz==""){
		$(".sfznull").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>身份证不能为空</font>");
		$(".sfznull").css("float", "right");
		return false;
	}else if(!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(sfz))){
		$(".sfznull").html("<img src='./images/close_delete.png'/><font class='fontstyle'>身份证格式有误</font>");
		$(".sfznull").css("float", "right");
		return false;
	}else{
		$(".sfznull").html("<img src='./images/check.png'>");
		$(".sfznull").css("float", "right");
		return true;
	}
}

//验证照片
function checkPhoto(){
	var photo=$("#uploadfileid").val();
	if(photo==""){
		$(".photoError").html("<img src='./images/close_delete.png'><font class='fontstyle'>请上传照片</font>");
		$(".photoError").css("float", "right");
		return false;
	}else{//检测上传照片
		var end=photo.substring(photo.lastIndexOf(".")+1,photo.length);
		if(!( end=="jpg" || end=="png" )){
			$(".photoError").html("<img src='./images/close_delete.png'><font class='fontstyle'>照片格式只能是jpg或png</font>");
			$(".photoError").css("float", "right");
			return false;
		}else{
			$(".photoError").html("<img src='./images/check.png'>");
			$(".photoError").css("float", "right");
			return true;
		}
	}
}
//验证手机号
function checkTel(){
	var value=$("#telid").val();
	if(value==""){
		$(".telError").html("<img src='./images/close_delete.png'><font class='fontstyle'>手机号不能为空</font>");
		$(".telError").css("float", "right");
		return false;
	}else{
		if(value.length!=11){
			$(".telError").html("<img src='./images/close_delete.png'><font class='fontstyle'>手机号长度必须11位</font>");
			$(".telError").css("float", "right");
			return false;
		}else if(!(/^1[34578]\d{9}$/.test(value))){
			$(".telError").html("<img src='./images/close_delete.png'><font class='fontstyle'>手机号格式错误</font>");
			$(".telError").css("float", "right");
			return false;
		}else{
			$(".telError").html("<img src='./images/check.png'>");
			$(".telError").css("float", "right");
			return true;
		}
	}
}

function checkZhuanye(){
	var value=$("#zhuanyeid").val();
	if(value==""){
		$(".zhuanyeError").html("<img src='./images/close_delete.png'><font class='fontstyle'>专业不能为空</font>");
		$(".zhuanyeError").css("float", "right");
		return false;
	}else{
		$(".zhuanyeError").html("<img src='./images/check.png'>");
		$(".zhuanyeError").css("float", "right");
		return true;
	}

}
function checkform()
{
	checkName();
	checkSfz();
	//checkPhoto();
	checkTel();
	checkZhuanye();
	
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

<form action="${url }" method="post" onsubmit="return checkform()" enctype="multipart/form-data">
<TABLE cellSpacing=0  cellPadding=0    border=0 id="tab" height="500px"> 
  <TBODY>
    
    
     <TR>
      <TD width=150  height=40>
        <DIV align="right">
      	<span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</span>
        </DIV>
      </TD>
      <TD width=400  height=40>
      	<input  type="text" name="name"  id='nameid'  size="30" readonly="readonly" value="${bean.name }" onblur="checkName()" />
      	<!-- 错误信息 -->
      	 <div class="errorName">
	     	
    	 </div>
      </TD>
    </TR>
    <TR>
      <TD width=150 height=40>
        <DIV align=right>
      <span> 手机号码:</span>
        </DIV>
      </TD>
      <TD width=400  height=40>
      <input  type="text" name="tel"  id='telid'  size="30" value="${bean.tel }" onblur="checkTel()"/>
      <div class="telError">
      </div>
      </TD>
     
    </TR>
     <TR>
      <TD width=150  height=40>
        <DIV align=right>
    <span>家庭地址:</span>   
        </DIV>
      </TD>
      <TD width=400 height=40>
      <input  type="text" name="address"  id='addressid'  size="30" value="${bean.address }" />
      </TD>
     
    </TR>
     <TR>
      <TD width=150  height=40>
        <DIV align=right>
     <span>政治面貌:</span>  
        </DIV>
      </TD>
      <TD width=400 height=40>
      
      <select name="zzmm">
      	<option value="团员" <c:if test="${bean.zzmm=='团员' }">selected</c:if>>团员</option>
      	<option value="预备党员" <c:if test="${bean.zzmm=='预备党员' }">selected</c:if>>预备党员</option>
      	<option value="党员" <c:if test="${bean.zzmm=='党员' }">selected</c:if>>党员</option>
      	<option value="其他" <c:if test="${bean.zzmm=='其他' }">selected</c:if>>其他</option>
      </select>
      
      </TD>
     
    </TR>
    
    
    <TR>
      <TD width=150  height=40>
        <DIV align="right">
       <span>照&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片:</span>
        </DIV>
      </TD>
      <TD width=300  height=40>
     <img  src="uploadfile/${bean.photo }" width="100" height="100"  />
      </TD>
     
    </TR>
    
    <TR>
      <TD width=150 height=40>
        <DIV align=right>
       <span>重新上传照片:</span>
        </DIV>
      </TD>
      <TD width=400 height=40>
      <input  name="uploadfile"  type="file"  id='uploadfileid'  size="30" />
      <!-- 照片错误信息 -->
	      <div class="photoError">
	      
	      </div>
      </TD>
     
    </TR>
    <TR >
      
      <TD width=400  height=40 colspan=2 >
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="submit" value="提交"  id="downid"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input  onclick="javascript:history.go(-1);"  type="button" value="返回"  id="downid"/>
                                    
      </TD>
     
    </TR>
    
  </TBODY>
</TABLE>
</form>
</BODY>
</HTML>


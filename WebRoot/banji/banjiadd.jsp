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
<LINK href="web.files/css.css" type=text/css rel=stylesheet>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2900.5880" name=GENERATOR>
<script src="./js/jquery-1.7.2.js"></script> 
<style>
	img{
		width: 14px;
		height:14px;
	}
	#downid{
		border-style:none;
		background-color: #00AAEE;
		color: white;
		border-radius:3px;
		width: 80px;
		height: 29px;
	}
	
	#tab td{
	
		height: 50px;
		width: 250px;
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
	.fontstyle{
	color: #F45A1E;
	font-size: 13px;
}
	</style>
<script type="text/javascript">
//检查班级编号
function checkBianhao(){
	var bianhao=$("#bianhaoid").val();
	if(bianhao==""){
		$("#showMsg").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>编号不能为空</font>");
		$("#showMsg").css("float","right");
		return false;
	}else if(bianhao.length!=4){
	
		$("#showMsg").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>编号必须为4位</font>");
		$("#showMsg").css("float","right");
		return false;
	}else{
		$("#showMsg").html("<img src='./images/check.png'>");
		$("#showMsg").css("float","right");
	}
	return true;
}
//检查学院
function checkXy(){
	var value=$("#xueyuanid").val();
	if(value=="0"){
		$("#Xy").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>请选择学院</font>");
		$("#Xy").css("float","right");
		return false;
	}else{
		$("#Xy").html("<img src='./images/check.png'>");
		$("#Xy").css("float","right");
	}
	return true;
}
//检查专业
function checkZy(){
	var value=$("#zhuanyeid").val();
	if(value=="0"){
		$("#Zy").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>专业不能为空</font>");
		$("#Zy").css("float","right");
		return false;
	}else{
		$("#Zy").html("<img src='./images/check.png'>");
		$("#Zy").css("float","right");
	}
	return true;
}
//检查人数
function checkRs(){

	var renshu=$("#renshuid").val();
	
	if(renshu==""){
		
		$("#Rs").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>必须填写人数</font>");
		$("#Rs").css("float","right");
		return false;
	}else if(/^[1-4]{1}[0-9]{1}$/.test(renshu)){
		$("#Rs").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>人数不能超过50</font>");
		$("#Rs").css("float","right");
		return false;
	}else{
		$("#Rs").html("<img src='./images/check.png'>");
		$("#Rs").css("float","right");
	}
	return true;
}
//表单提交
function checkform()
{
	checkBianhao();
	checkXy();
	checkZy();
	checkRs();
}

function seleZhuanye(){

	var xueyuan=$("#xueyuanid").val();
	if(xueyuan=="0"){
		alert("请选择学院");
		return false;
	}else{
		$.ajax({
			type:"get",
			dataType:"json",
			url:"method!seleZhuanye?xueyuan="+xueyuan,
			success:function(json){
				var dataMsg=eval(json);
				
				var inner="";
				for(var i=0;i<dataMsg.length;i++){
					var zy=dataMsg[i];
					inner+="<option value='"+zy.id+"'>"+zy.depart+"</option>";
				}
				$("#zhuanyeid").html(inner);
			}
		});
	}
}
</script>

</HEAD>

<BODY>
<TABLE cellSpacing=0 cellPadding=0 width=300 align=center border=0>
  <TBODY>
    <TR align="center">
      
      <TD  height=20>
    <font size="13px">${biaoti }</font>
      </TD>
    
    </TR>
  </TBODY>
</TABLE>
<br/>

<form action="${url }" method="post" onsubmit="return checkform()">
<TABLE cellSpacing=1  cellPadding=0 align=center  border=0 id="tab">
  <TBODY>
    
    <TR>
      <TD >
        <DIV align=center>
      <span> 编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</span>
        </DIV>
      </TD>
      <TD>
      <input  type="text" name="bianhao"  id='bianhaoid'  size="30"  onblur="checkBianhao();"/>
      <div id="showMsg"></div>
      </TD>
     
     	
     
    </TR>
    
     <TR>
      <TD >
        <DIV align=center>
       <span>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院:</span>
        </DIV>
      </TD>
      <TD>
      <select name="xueyuan" id="xueyuanid" onchange="seleZhuanye();">
     	<option value="0">--请选择--</option>
     	<c:forEach items="${list }" var="one">
     		<option value="${one.id }">${one.depart }</option>
     	</c:forEach>
     </select>
      <div id="Xy">		</div>
	
      </TD>
     
		
    </TR>
    
     <TR>
      <TD >
        <DIV align=center>
     <span> 专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</span>
        </DIV>
      </TD>
      <TD >
      <select name="zhuanye" id="zhuanyeid">
      	<option value="0">--请选择--</option>
      	
      </select>
      <div id="Zy">
     	
     	</div>
      </TD>
  
     	

    </TR>
    <TR>
      <TD >
        <DIV align=center>
       <span>最大人数:</span>
        </DIV>
      </TD>
      <TD>
      <input type="text" name="renshu" id="renshuid" size="30" onblur="checkRs();" >
      <div id="Rs">
     	
     	</div>
      </TD>
     
     	
     
    </TR>
    <TR align="center">
      
      <TD  colspan=2 align="center">
     <input type="submit" value="提交"  id="downid"  />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input  onclick="javascript:history.go(-1);" id="downid" type="button" value="返回" />
                                    
      </TD>
    </TR>
    
  </TBODY>
</TABLE>
</form>

</BODY>
</HTML>


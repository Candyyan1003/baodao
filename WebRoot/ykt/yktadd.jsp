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
		height:60px;
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
</style>
<script language="javascript" type="text/javascript">

function checkform()
{
	//验证文件的后缀名
	var b= document.getElementById("uploadfileid");
	
	if(b.value==""){
	
	alert('请上传开通凭证！');
	return false;
	}
	
	var FileName = b.value;
	
	var extension=new String (FileName.substring(FileName.lastIndexOf(".")+1,FileName.length));

	if(!(extension=="jpg"  || extension=="png" )){
		alert('必须上传jpg格式或者png格式的图片');
		return false;
	
	}
	
	return true;
	
}


</script>

</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width=800 align=center border=0>
  <TBODY>
    <TR>
      
      <TD align=middle height=20>
     <font size="18px">${biaoti }</font>
      </TD>
    
    </TR>
  </TBODY>
</TABLE>
<br/>

<form action="${url }" method="post" onsubmit="return checkform()" enctype="multipart/form-data">
<TABLE cellSpacing=0 id="tab" cellPadding=0 align=center  border=0>
  <TBODY>
    
    
    
    <TR>
      <TD width=300 >
        <DIV align=center>
       <span>学生学号:</span>
        </DIV>
      </TD>
      <TD width=300>
      <input  type="text" name="name"  id='nameid'  size="30"  value="${bean.xuehao }" readonly="readonly" />
      </TD>
     
    </TR>
    
   
    
    <TR>
      <TD width=300>
        <DIV align=center>
       <span>学生姓名:</span>
        </DIV>
      </TD>
      <TD width=300 >
      <input  type="text" name="name"  id='nameid'  size="30"  value="${bean.name }" readonly="readonly" />
      </TD>
     
    </TR>
    
     <TR>
      <TD width=300>
        <DIV align=center>&nbsp;
      <span> 学生身份证:</span>
        </DIV>
      </TD>
      <TD width=300>
      <input  type="text" name="sfz"  id='sfzid'  size="30"  value="${bean.sfz }" readonly="readonly" />
      </TD>
     
    </TR>
    
    
    
     
    
     <TR>
      <TD width=300 >
        <DIV align=center>
      <span> 一卡通卡号:</span>
        </DIV>
      </TD>
      <TD width=300 >
      <input  type="text" name="kahao"    size="30"  value="${kahao }" readonly="readonly" />
      </TD>
     
    </TR>
    
    
    
    
    <TR>
      <TD width=300>
        <DIV align=center>
       <span>开通凭证:</span>
        </DIV>
      </TD>
      <TD width=300 >
      <input  name="uploadfile"  type="file"  id='uploadfileid'  size="30"  />
      </TD>
     
    </TR>
    
    <TR>
      <TD width=300 align="center" colspan="2">
     <input type="submit" value="确认开通" id="downid" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input  onclick="javascript:history.go(-1);" id="downid" type="button" value="返回" />
                                    
      </TD>
     
    </TR>
    
  </TBODY>
</TABLE>
</form>

</BODY>
</HTML>


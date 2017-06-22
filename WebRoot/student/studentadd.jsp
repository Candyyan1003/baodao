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
 <script src="./js/jquery-1.7.2.js"></script> 
 <script src="./js/student.js"></script> 
 
<style type="text/css">
#tab{
	margin-left: 200px;
}
img{
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

<form action="${url }" method="post" onsubmit="return checkform();" enctype="multipart/form-data">
<TABLE cellSpacing=0  cellPadding=0    border=0 id="tab" height="500px"> 
  <TBODY >
    
    <TR>
      <TD width=150  height=40>
        <DIV align="right">
      	<span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</span>
        </DIV>
      </TD>
      <TD width=400  height=40>
      	<input  type="text" name="name"  id='nameid'  size="30" onblur="checkName();" />
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
      <input  type="text" name="tel"  id='telid'  size="30" onblur="checkTel()"/>
      <div class="telError">
      </div>
      </TD>
     
    </TR>
    
     <TR>
      <TD width=150  height=40>
        <DIV align=right>
      		<span> 身&nbsp;&nbsp;份&nbsp;&nbsp;证:</span>
        </DIV>
      </TD>
      <TD width=400  height=40>
      	<input  type="text" name="sfz"  id='sfzid'  size="30"  onblur="checkSfz()"/>
      	<!-- 身份证错误提示信息 -->
      	<div class="sfznull" >
	     		
    	 </div>
      </TD>
    </TR>
    
    
    
     
     <TR>
      <TD width=150 height=40>
        <DIV align=right>
      <span> 性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
        </DIV>
      </TD>
      <TD width=400  height=40>
      <select name="sex">
      <option value="男">男</option>
      <option value="女">女</option>
      </select>
      </TD>
     
    </TR>
     
    
     <TR>
      <TD width=150  height=40>
        <DIV align=right>
      	<span> 民&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;族:</span>
        </DIV>
      </TD>
      <TD width=400  height=40>
      
      <input  type="text" name="minzu"  id='minzuid'  size="30"  />
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
      	<option value="团员">团员</option>
      	<option value="预备党员">预备党员</option>
      	<option value="党员">党员</option>
      	<option value="其他">其他</option>
      </select>
      
      </TD>
     
    </TR>
    
    <input type="hidden" value="${xueyuan.depart }" name="xueyuan"/>
    <TR>
      <TD width=150  height=40>
        <DIV align=right>
        
      		<span>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</span>
        </DIV>
      </TD>
      <TD width=400  height=40>
      	<select name="zhuanye" id="zhuanyeid" onchange="checkZhuanye()">
      		<option value="0">--请选择--</option>
      		<c:forEach items="${zhuanyelist }" var="one">
      			<option value="${one.id }">${one.depart }</option>
      		</c:forEach>
      		
      	</select>
      	
      
      	<!-- 专业错误信息 -->
      	<div class="zhuanyeError">
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
      <input  type="text" name="address"  id='addressid'  size="30"  />
      </TD>
     
    </TR>
   
    <TR>
      <TD width=150 height=40>
        <DIV align=right>&nbsp;
       <span>照&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片:</span>
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


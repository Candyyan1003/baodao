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
#tt td{
	height: 40px;
}
img{
	width: 14px;
	height:14px;
	
}

.fontstyle{
	color: #F45A1E;
	font-size: 13px;
	
}
.errorMsg {
	float: right;
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
 <script src="./js/sushe.js"></script> 
 
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
<TABLE id="tt" cellSpacing=0  cellPadding=0 align=center  border=0 height="400px">
  <TBODY>
    <TR>
      <TD width=300 >
        <DIV align=center>
       <span>楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</span>
        </DIV>
      </TD>
      <TD width=300>
      <input  type="text" name="louhao"  id='louhaoid'  size="30" onblur="checkBH();" />
      <div class="errorMsg"></div>
      </TD>
     
    </TR>
    
     <TR>
      <TD width=300>
        <DIV align=center>
       <span>层:</span>
        </DIV>
      </TD>
      <TD width=300>
      <select name="ceng" id="cengid">
      <option value="0">--请选择--</option>
      	<option value="1">1</option>
      	<option value="2">2</option>
      	<option value="3">3</option>
      	<option value="4">4</option>
      	<option value="5">5</option>
      	
      </select>
      </TD>
     
    </TR>
    
     <TR>
      <TD width=300 >
        <DIV align=center>
      <span> 宿舍编号:</span>
        </DIV>
      </TD>
      <TD width=300>
      <input  type="text" name="bianhao"  id='bianhaoid'  size="30"  onblur="checkSu()"/>
      <div class="SSmsg"></div>
      </TD>
     
    </TR>
    
    
    <TR>
      <TD width=300 >
        <DIV align=center>
       <span>宿舍类型:</span>
        </DIV>
      </TD>
      <TD width=300 >
     <input type="radio" name="leixing" value="男生宿舍"/><span>男生宿舍</span>
     <input type="radio" name="leixing" value="女生宿舍"/><span>女生宿舍</span>
     <div class="lxmsg"></div>
      </TD>
     
    </TR>
    <TR>
      <TD width=300 >
        <DIV align=center>
       <span>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</span>
        </DIV>
      </TD>
      <TD width=300 >
      <select name="zhuanye" id="zhuanyeid">
     	<option value="0">--请选择--</option>
     	<c:forEach items="${listZy }" var="one">
     		<option value="${one.id }">${one.depart }</option>
     	</c:forEach>
     </select>
      <div class="Zymsg"></div>
      </TD>
     
    </TR>
    <TR>
      <TD width=300 >
        <DIV align=center>
      	 <span>班级编号:</span>
        </DIV>
      </TD>
      <TD width=300 >
      <input  type="text" name="banjibianhao"  id='banjibianhaoid'  size="30" onblur="checkBj();" />
      <div class="Bjmsg"></div>
      </TD>
     
    </TR>
    <TR>
      <TD width=300>
        <DIV align=center>
      <span> 最大可住人数:</span>
        </DIV>
      </TD>
      <TD width=300 >
      <select name="renshu" id="renshuid">
      <option value="0">--请选择--</option>
      <option value="8">8</option>
      <option value="6">6</option>
      <option value="4">4</option>
      <option value="2">2</option>
      </select>
      </TD>
     
    </TR>
   
    
    <TR>
     
      <TD width=300 align="center" colspan=2>
     <input type="submit" value="提交" id="downid" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input  onclick="javascript:history.go(-1);" id="downid" type="button" value="返回" />
                                    
      </TD>
     
    </TR>
    
  </TBODY>
</TABLE>
</form>

</BODY>
</HTML>


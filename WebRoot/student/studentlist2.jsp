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
	#massage td{
		height: 50px;
		text-align: center;
	}
	#downid{
		border-style:none;
		background-color: #00AAEE;
		color: white;
		border-radius:3px;
		width: 80px;
		height: 29px;
	}
</style>
</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0 height="140px">
  <TBODY>
  	<TR>
      
      <TD align="center" height=20>
     <font size="13px">${biaoti }</font>
      </TD>
    
    </TR>
  
    <TR>
       <form action="${url }" method="post">
      <TD align="right" height=20>
    &nbsp;&nbsp;&nbsp;
       学号:<input type="text" size="10"  name="xuehao"  value="${xuehao }"/>&nbsp;&nbsp; 
       姓名:<input type="text" size="10"  name="name"  value="${name }"/>&nbsp;&nbsp; 
       身份证:<input type="text" size="10"  name="sfz"  value="${sfz }"/>&nbsp;&nbsp; 
      学院：<input type="text" size="10" name="xueyuan"/>&nbsp;&nbsp;
       <input type="submit"  id="downid" value="查询" />    
      </TD>
      </form>
    </TR>
  </TBODY>
</TABLE>
<br/>

<TABLE id="massage" width="100%" cellSpacing=1 borderColorDark=#ffffff cellPadding=0 align=center bgColor=#cccccc borderColorLight=#999999 border=0>
  <TBODY>
    <TR bgColor=#F2F9FD>
      
      <TD >学号</TD>
      <TD >姓名</TD>
      <TD >性别</TD>
      <TD >身份证</TD>
     
      <TD >手机号码</TD>
    
  	  <TD >是否缴费</TD>
  	  <TD >分配宿舍</TD>
  	  <TD >分配班级</TD>
  	  <TD>开通一卡通</TD>
  	  <TD >转移档案</TD>
  	  <TD >体检报告</TD>
  
     
      <TD >操作</TD>
    </TR>
    
    <c:forEach items="${list}"  var="bean">
    <TR bgColor=#ffffff>
    <TD align=middle>
     ${bean.xuehao }
     </TD>
    
      <TD align=middle>
     ${bean.name }
      </TD>
      
      <TD align=middle>
     ${bean.sex }
      </TD>
      
      <TD align=middle>
     ${bean.sfz }
      </TD>
      
      
      
      <TD align=middle>
     ${bean.tel }
      </TD>
      
      <TD align=middle>
      <c:if test="${bean.jiaofei==0 }">未缴费</c:if>
      <c:if test="${bean.jiaofei==1 }">已缴费</c:if>
    
      </TD>
      
      <TD align=middle>
      <c:if test="${bean.sushe==0 }">未分配</c:if>
      <c:if test="${bean.sushe==1 }">已分配</c:if>
     
      </TD>
      <TD align=middle>
      <c:if test="${bean.banji==0 }">未分配</c:if>
      <c:if test="${bean.banji==1 }">已分配</c:if>
    
      </TD>
      <TD align=middle>
      <c:if test="${bean.ykt==0 }">未开通</c:if>
      <c:if test="${bean.ykt==1 }">已开通</c:if>
     
      </TD>
      
      <TD align=middle>
      <c:if test="${bean.dangan==0 }">未转入</c:if>
      <c:if test="${bean.dangan==1 }">已转入</c:if>
     
      </TD>
      
      <TD align=middle>
      <c:if test="${bean.tijian==0 }">未提交</c:if>
      <c:if test="${bean.tijian==1 }">已提交</c:if>
     
      </TD>
      
      <TD borderColorLight=#c0c0c0 align=middle bgColor=#ffffff height=23>
      <DIV align=center>
      <a href="${url2 }update3?id=${bean.id }">查看详情</a>
      
      <c:if test="${bean.jiaofei==0&&user.depart.depart=='财务部' }" var="pi">
       &nbsp;<a href="method!jiaofeiadd?studentid=${bean.id }">缴费管理</a>
      </c:if>
      <c:if test="${!pi&&bean.jiaofei==0 }">
      
      </c:if>
      
       <c:if test="${bean.banji==0&&(userDepart=='学院') }" var="pi2">
      	 &nbsp; <a href="method!fenbanadd?studentid=${bean.id }&xueyuan=${xueyuan}">分配班级</a> 
      </c:if>
      <c:if test="${!pi2&&bean.banji==0 }">
      		
      </c:if>
      
      <c:if test="${bean.sushe==0&&user.depart.depart=='公寓管理部' }"  var="pi1" >
       &nbsp; <a href="method!zhusuadd?studentid=${bean.id }">分配宿舍</a>
      </c:if>
      <c:if test="${!pi1&&bean.sushe==0 }">
      		
      </c:if>
      
      
      <c:if test="${bean.ykt==0&&user.depart.depart=='餐饮部' }"  var="pi3">
       &nbsp;<a href="method!yktadd?studentid=${bean.id }">开通校园一卡通</a>
      </c:if>
      <c:if test="${!pi3&&bean.ykt==0 }">
      		
      </c:if>
      
      
      <c:if test="${bean.dangan==0&&user.depart.depart=='教务处' }" var="pi4">
      	 &nbsp; &nbsp;<a href="method!danganadd?studentid=${bean.id }">转档案管理</a>
     </c:if>
     <c:if test="${!pi4&&bean.dangan==0 }">
     	
     </c:if>
     
     
     <c:if test="${bean.tijian==0&&user.depart.depart=='校医院' }" var="pi5">
      &nbsp; &nbsp; <a href="method!tijianadd?studentid=${bean.id }">体检管理</a>
     </c:if>
     <c:if test="${!pi5&&bean.tijian==0 }">
     	
     </c:if>
    
      </DIV>
      </TD>
      
    </TR>
    </c:forEach>
    
    <TR bgColor=#ffffff>
      <TD borderColorLight=#c0c0c0 align=middle colSpan=20 height=23>${pagerinfo }</TD>
    </TR>
  </TBODY>
</TABLE>
</BODY>
</HTML>


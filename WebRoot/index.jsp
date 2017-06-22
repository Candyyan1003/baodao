<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
	
	<link rel="stylesheet" href="/baodao/css/pintuer.css">
    <link rel="stylesheet" href="/baodao/css/admin.css">
    <script src="./js/jquery-1.7.2.js"></script>   
	<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  });
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  });
});
</script>
  </head>
  
  <body style="background-color:#f2f9fd;">
    <div class="header bg-main" style="height:230px">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="/baodao/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />新生报到系统后台管理中心</h1>
  </div>
  <div class="head-l">

<a href="method!changepwd" target="main" class="button button-little bg-blue"><span class="icon-wrench"></span> 修改密码</a>
   &nbsp;&nbsp;
 
 <a class="button button-little bg-red" href="method!loginout"><span class="icon-power-off"></span> 退出登录</a> 
  </div>
</div>
<div class="leftnav" style="width:200px;top:80px">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>
  	<c:if test="${user.role==1}">
	  管理员管理
	</c:if>
	<c:if test="${user.role==2}">
	${user.depart.depart }<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;老师登录
	</c:if>
  </h2>
  <ul style="display:block">
  
  	 <c:if test="${user.role==1}">
    <li><a href="method!userlist" target="main"><span class="icon-caret-right"></span>工作人员管理</a></li>
    <li><a href="method!sushelist" target="main"><span class="icon-caret-right"></span>宿舍管理</a></li>
    <li><a href="method!banjilist" target="main"><span class="icon-caret-right"></span>班级管理</a></li>
    </c:if>
    
    
    <c:if test="${user.role==2}">
    
     <c:if test="${userDepart=='学院' }">
     
     	<li><a href="method!studentlist?xueyuan=${user.depart.depart }" target="main">
     	<span class="icon-caret-right"></span>新生登记</a></li>
     </c:if>
     
    	<li><a href="method!studentlist2?xueyuan=${user.depart.depart }" target="main">
    	<span class="icon-caret-right"></span>新生报道管理</a></li>
    </c:if>
  </ul>   
  <h2><span class="icon-pencil-square-o"></span>查询功能</h2>
  <ul>
  <c:if test="${user.role==1 }">
  
   	<li><a href="method!tongjilist" target="main"><span class="icon-caret-right"></span>数据统计</a></li>
   	<li><a href="method!jiaofeilist" target="main"><span class="icon-caret-right"></span>缴费记录查询</a></li>
    <li><a href="method!zhusulist" target="main"><span class="icon-caret-right"></span>宿舍分配查询</a></li>
    <li><a href="method!fenbanlist" target="main"><span class="icon-caret-right"></span>班级分配查询</a></li>
    <li><a href="method!yktlist" target="main"><span class="icon-caret-right"></span>一卡通开通记录查询</a></li>        
    <li><a href="method!tijianlist" target="main"><span class="icon-caret-right"></span>体检报告查询</a></li>
    <li><a href="method!danganlist" target="main"><span class="icon-caret-right"></span>转档案记录查询</a></li>
   </c:if> 
   <c:if test="${user.role==2 }">
	   	<c:if test="${user.depart.depart=='财务部' }">
	   		<li><a href="method!jiaofeilist" target="main">
	   		<span class="icon-caret-right"></span>缴费记录查询</a></li>
	   	</c:if>
	   
	   <c:if test="${userDepart=='学院' }">
	   		<li><a href="method!fenbanlist?xueyuan=${user.depart.depart }" target="main">
	   		<span class="icon-caret-right"></span>班级分配查询</a></li>
	   	</c:if>
   	
	   	<c:if test="${user.depart.depart=='公寓管理部' }">
	   		<li><a href="method!zhusulist" target="main"><span class="icon-caret-right"></span>宿舍分配查询</a></li>
	   	</c:if>
	   	
	   	<c:if test="${user.depart.depart=='校医院' }">
	   		<li><a href="method!tijianlist" target="main"><span class="icon-caret-right">
	   		</span>体检报告查询</a></li>
	   	</c:if>
   	
	   	<c:if test="${user.depart.depart=='教务处' }">
	   		<li><a href="method!danganlist" target="main"><span class="icon-caret-right"></span>转档案记录查询</a></li>
	   	</c:if>
   	
	   	<c:if test="${user.depart.depart=='餐饮部' }">
	   		<li><a href="method!yktlist" target="main"><span class="icon-caret-right"></span>一卡通开通记录查询</a></li>        
	   	</c:if>
   	
   </c:if>       
  </ul>  
</div>

<div class="admin">
   <IFRAME id=main  style="Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 100%"  name=main src="web.jsp" frameBorder=0  scrolling=yes></IFRAME>
</div>
  </body>
</html>

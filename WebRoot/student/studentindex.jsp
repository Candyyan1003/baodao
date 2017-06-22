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
	
	
	<link rel="stylesheet" href="/baodao/css/pintuer.css">
    <link rel="stylesheet" href="/baodao/css/admin.css">
    <script src="/baodao/js/jquery-1.7.2.js"></script>   
	
  </head>
  
  <body style="background-color:#f2f9fd;">
    <div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="/baodao/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />学生登录</h1>
  </div>
  <div class="head-l">

 
 <a class="button button-little bg-red" href="method!loginout"><span class="icon-power-off"></span> 退出登录</a> 
  </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>

		欢迎${stu.name }登录

  </h2>
  <ul style="display:block">
  	
  
    <li><a href="method!selebaodao" target="main"><span class="icon-caret-right"></span>选择报到流程</a></li>
    <li><a href="method!studetail?studentid=${stu.id }" target="main"><span class="icon-caret-right"></span>查看个人详细信息</a></li>
    <li><a href="method!stuupdate?studentid=${stu.id }" target="main"><span class="icon-caret-right"></span>修改个人信息</a></li>
    <input type="hidden" name="studentid" value="${stu.id }">
   
   
  </ul>   
  <h2><span class="icon-pencil-square-o"></span>其他功能</h2>
  <ul>
    <li><a href="method!yktstu?studentid=${stu.id }" target="main"><span class="icon-caret-right"></span>一卡通开通记录查询</a></li>        
    <li><a href="method!tijianstu?studentid=${stu.id }" target="main"><span class="icon-caret-right"></span>体检报告查询</a></li>
    <li><a href="method!danganstu?studentid=${stu.id }" target="main"><span class="icon-caret-right"></span>转档案记录查询</a></li>
    <li><a href="method!jiaofeistu?studentid=${stu.id }" target="main"><span class="icon-caret-right"></span>缴费记录查询</a></li>
    <li><a href="method!zhusustu?studentid=${stu.id }" target="main"><span class="icon-caret-right"></span>宿舍分配查询</a></li>
    <li><a href="method!fenbanstu?studentid=${stu.id }" target="main"><span class="icon-caret-right"></span>班级分配查询</a></li>
          
            
  </ul>  
</div>

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

<div class="admin">
  
   <IFRAME id=main  style="Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 100%"  name=main src="web2.jsp" frameBorder=0  scrolling=yes></IFRAME>
</div>
  </body>
</html>

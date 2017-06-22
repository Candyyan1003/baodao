<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>统计页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	#downid{
		border-style:none;
		background-color: #00AAEE;
		color: white;
		border-radius:3px;
		width: 80px;
		height: 29px;
	}
	table td{
		text-align: center;
		
		height: 60px;
		
	}
	table{
		margin-top: 130px;
	}
	
</style>
  </head>
  
  <body>
    <table  width="100%" cellSpacing=1 borderColorLight=#999999 border=1 cellPadding=0  bgColor=#cccccc borderColorLight=#999999>
    
    	<tr >
    	<td  colspan="7" bgColor="#ffffff" align="left">应报到：3000人</td>
    	</tr>
   
    	<tr>
    		<td bgColor="#F2F9FD">已/未（报到）</td>
    		<td bgColor="#F2F9FD">已/未（分班）</td>
    		<td bgColor="#F2F9FD">已/未（分宿舍）</td>
    		<td bgColor="#F2F9FD">已/未（缴费）</td>
    		<td bgColor="#F2F9FD">已/未（体检）</td>
    		<td bgColor="#F2F9FD">已/未（开通一卡通）</td>
    		<td bgColor="#F2F9FD">已/未（转档案）</td>
    	</tr>
    	<tr >
    		<td bgColor="#ffffff">${studenttotal }/${3000-studenttotal }</td>
    		<td bgColor="#ffffff">${fenbantotal }/${3000-fenbantotal }</td>
    		<td bgColor="#ffffff">${zhusutotal }/${3000-zhusutotal }</td>
    		<td bgColor="#ffffff">${jiaofeitotal }/${3000-jiaofeitotal }</td>
    		<td bgColor="#ffffff">${tijiantotal }/${3000-tijiantotal }</td>
    		<td bgColor="#ffffff">${ykttotal }/${3000-ykttotal }</td>
    		<td bgColor="#ffffff">${dangantotal }/${3000-dangantotal }</td>
    	</tr>
    	
    	
    </table>
    
  </body>
</html>

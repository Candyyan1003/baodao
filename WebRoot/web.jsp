<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>新生报道管理系统</TITLE>

<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2900.5880" name=GENERATOR>
<style>
	table tr{
		height: 60px;
	}
	table {
		width:780px;
	}
</style>
</HEAD>
<BODY>
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#B5CFD9" align="center" style="margin-top:40px;font-size: 15px;" >
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#F2F9FD';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td >操作系统版本：</td>
		    <td><%=System.getProperty("os.name") %>&nbsp;&nbsp;<%=System.getProperty("os.version") %></td>
</tr>
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#F2F9FD';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	 <td >操作系统类型：</td>
		    <td><%=System.getProperty("os.arch") %><!-- x32,x86 --></td>
</tr>
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#F2F9FD';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	 <td >用户,目录,临时目录：</td>
		    <td><%=application.getRealPath("/")%></td>
</tr>
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#F2F9FD';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	 <td >JDK版本：</td>
		    <td><%=System.getProperty("java.version") %></td>
</tr>
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#F2F9FD';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	  <td >JDK安装目录：</td>
		    <td><%=System.getProperty("java.home") %></td>
</tr>

</table>

</BODY>
</HTML>


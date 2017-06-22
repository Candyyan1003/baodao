<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="./js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="./js/login.js"></script>
	
	<style type="text/css">
	body{
		padding: 0px;
		margin: 0px;
		}
	#header{
		width: auto;
		min-height: 70px;
		line-height: 70px;
		}
	#header{
		border-bottom: medium solid #39A631;
	}
	span.title_con{
		font-family:"微软雅黑";
		font-style: normal;
		font-size: 2em;
		font-weight:800 ;
		color: #39A631;
		padding-left: 1em;
	}
	#content{
		width: auto;
		height:36em;
		text-align: center;
		background-image: url(./images/login_bg.jpg);
		background-size:100% 100%;
		}
	#footer{
		width: auto;
		min-height: 60px;
		line-height:60px;
		}
	#footer{
		border-top: thin solid #39A631;
		}
	.con{
		border: thin solid #8EC172;
		margin-top: 90px;
		width: 500px;
		
		}
	.con_title{
		background-color: #8EC172;
		width: auto;
		height: 3.5em;
		line-height: 3.5em;
		text-align: center;
		}
	.con_title_sp{
		
		font-family: "微软雅黑";
		font-size: 1.5em;
		font-weight: 800;
		color: #FFF;
		}
	.con_input{
		margin: 2em 0 1em 0;
	}
	.con_error{
		font-size: 10px;
		color: red;
	}
	.submit-btn{
		width: 8em;
		height: 2em;
		background-color: #62ab00;
		border-radius: 4px;
		border: 0px;
		color: #fff;
		font-family:"微软雅黑";
		font-size: 1em;
		font-weight: bold;
		}
	.con_input span{
		font-family: "微软雅黑";
		font-size: 1em;
		font-weight: bold;
		color: #333;
		}
	.con_input input{
		width: 15em;
		padding: 0.5em 1em;
		border: 1px solid #bbb;
		}
	.submit-btn{
		margin: 1em 0 1em 0;
	}
	.con_select{
		margin-left: 2em;
		font-family:"微软雅黑";
		font-size: 1em;
		color: #333;
		}
		
		img{
			width: 14px;
			height: 14px;
		}
		
		.errorMsg{
			color: #F45A1E;
			font-size: 13px;
		}
	</style>
	
	
  </head>
  
  <body>
   
    <div id="header">
	<div class="header_title">
		<span class="title_con">新生报到系统</span>
	</div>
</div>

<div id="content">
	<center>
		<div class="con">
		<div class="con_title">
			<span class="con_title_sp">欢迎登录新生报到系统</span>
		</div>
		
		<div class="con_panel">
		
			
			<div class="con_input">
				<span>用户名：</span><input type="text"  name="username" onblur="checkUsername()"/>
				<div class="usernamemsg" style="display:none">
					<font class="errorMsg" ><img src="./images/close_delete.png">用户名不能为空</font>
				</div>
			</div>
			
			<div class="con_input">
				<span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
				<input type="password"  name="password" onblur="checkPwd()"/>
				<div class="passwordmsg" style="display:none">
					<font class="errorMsg" ><img src="./images/close_delete.png">密码不能为空</font>
				</div>
				
			</div>
			<div class="con_select">
				<input type="radio" name="status" value="学生"/>学生
				<input type="radio" name="status" value="2"/>工作人员
				<input type="radio" name="status" value="1"/>管理员
				<div class="rolemsg" style="display:none">
					<font class="errorMsg"  >
					<img src="./images/close_delete.png">请选择登录角色</font>
				</div>
				<div class="namepwdmsg" style="display:none">
					<font class="errorMsg"  >
					<img src="./images/close_delete.png">用户名或密码错误</font>
				</div>
				
			</div>
				
			<input type="button" value="登    录" class="submit-btn" onclick="checkUser();"/>
		</div>
	
	</div>
	</center>
</div>
    
  </body>
</html>

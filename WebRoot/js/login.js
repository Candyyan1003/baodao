/**
 * 
 */
//检查用户名
		 function checkUsername(){
		 	var showmsg=false;
		 	var username=$(".con_input input[name=username]").val();
		 	if(username==""){
		 		showmsg=true;
		 	}
	 		if(showmsg==true){
	 			$(".usernamemsg").show();
		 		
	 		}else{
		 		$(".usernamemsg").hide();
	 		}
		 }
		 
		 //检查密码
		 function checkPwd(){
			var showmsg=false;
		 	var password=$(".con_input input[name=password]").val();
		 	if(password==""){
		 		showmsg=true;
		 	}else{
		 		showmsg=false;
		 	}
	 		if(showmsg==true){
	 			$(".passwordmsg").show();
		 		
	 		}else{
		 		$(".passwordmsg").hide();
	 		}
		 }
		 //检查角色的选择
		 
		 function checkUser(){
			 //先检查用户名和密码为空的情况
		 	checkUsername();
			checkPwd();
			
		 	//获取到三个参数的值
		 	
		 	var username=$(".con_input input[name=username]").val();
		 	var password=$(".con_input input[name=password]").val();
		 	var value=$("input:radio[name='status']:checked").val();
		 	
		 	if(value=="学生"){//学生登录
		 		
		 		$.ajax({
	 					type:"get",
	 					dataType:"text",
	 					url:"method!stuLogin?username="+username+"&password="+password,
	 					success:function(responseContextstu){
		 					if(responseContextstu==""){
		 						location.href="./student/studentindex.jsp";
		 					}else{
		 							$(".namepwdmsg").show();
		 						}	
	 					}
		 			});
		 		}else if(typeof value=="undefined"){
		 			$(".rolemsg").show();
		 		}else{
		 		//判断是工作人员或者管理员
		 		//alert(value);
		 		$.ajax({
	 					type:"get",
	 					dataType:"text",
	 					url:"method!login?username="+username+" &password="+password+"&status="+value,
	 					success:function(responseContext){
	 						if(responseContext==""){
	 							window.location.href="index.jsp";
	 						}else{
	 							$(".rolemsg").hide();
	 							$(".namepwdmsg").show();
	 						}
	 					}
	 					
		 			});
		 		}
		 	}
 	
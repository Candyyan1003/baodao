/**
 * 
 */
//验证姓名
function checkName(){

	var name=$("#nameid").val();
	
	if(name==""){
		$(".errorName").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>姓名不能为空</font>");
		$(".errorName").css("float","right");
		alert("姓名不能为空");
		return false;
	}else{
		$(".errorName").html("<img src='./images/check.png'>");
		$(".errorName").css("float","right");
		return true;
	}
}
//验证身份证
function checkSfz(){
	var sfz=$("#sfzid").val();
	if(sfz==""){
		$(".sfznull").html("<img  src='./images/close_delete.png' /><font class='fontstyle'>身份证不能为空</font>");
		$(".sfznull").css("float", "right");
		return false;
	}else if(!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(sfz))){
		$(".sfznull").html("<img src='./images/close_delete.png'/><font class='fontstyle'>身份证格式有误</font>");
		$(".sfznull").css("float", "right");
		return false;
	}else{
		$(".sfznull").html("<img src='./images/check.png'>");
		$(".sfznull").css("float", "right");
		return true;
	}
}

//验证照片
function checkPhoto(){
	var photo=$("#uploadfileid").val();
	if(photo==""){
		$(".photoError").html("<img src='./images/close_delete.png'><font class='fontstyle'>请上传照片</font>");
		$(".photoError").css("float", "right");
		return false;
	}else{//检测上传照片
		var end=photo.substring(photo.lastIndexOf(".")+1,photo.length);
		if(!( end=="jpg" || end=="png" )){
			$(".photoError").html("<img src='./images/close_delete.png'><font class='fontstyle'>照片格式只能是jpg或png</font>");
			$(".photoError").css("float", "right");
			return false;
		}else{
			$(".photoError").html("<img src='./images/check.png'>");
			$(".photoError").css("float", "right");
			return true;
		}
	}
}
//验证手机号
function checkTel(){
	var value=$("#telid").val();
	if(value==""){
		$(".telError").html("<img src='./images/close_delete.png'><font class='fontstyle'>手机号不能为空</font>");
		$(".telError").css("float", "right");
		return false;
	}else{
		if(value.length!=11){
			$(".telError").html("<img src='./images/close_delete.png'><font class='fontstyle'>手机号长度必须11位</font>");
			$(".telError").css("float", "right");
			return false;
		}else if(!(/^1[34578]\d{9}$/.test(value))){
			$(".telError").html("<img src='./images/close_delete.png'><font class='fontstyle'>手机号格式错误</font>");
			$(".telError").css("float", "right");
			return false;
		}else{
				
			$.ajax({
				type:"get",
				dataType:"text",
				url:"method!checkTel?tel="+value,
				success:function(msg){
					alert(msg);
					if(msg!=""){
						$(".telError").html("<img src='./images/close_delete.png'><font class='fontstyle'>"+msg+"</font>");
						$(".telError").css("float", "right");
						return false;
					}else{
						
						$(".telError").html("<img src='./images/check.png'>");
						$(".telError").css("float", "right");
						return true;
					}
					
				}
			});
			
		}
	}
}

function checkZhuanye(){
	var value=$("#zhuanyeid").val();
	if(value=="0"){
		$(".zhuanyeError").html("<img src='./images/close_delete.png'><font class='fontstyle'>请选择专业</font>");
		$(".zhuanyeError").css("float", "right");
		return false;
	}else{
		$(".zhuanyeError").html("<img src='./images/check.png'>");
		$(".zhuanyeError").css("float", "right");
		return true;
	}

}

function checkform()
{
	alert("11");
	return false;
	
}
 	
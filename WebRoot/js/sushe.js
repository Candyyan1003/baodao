/**
 * 
 */
function checkBH(){
	if($("#louhaoid").val()==""){
		$(".errorMsg").html("<img src='./images/close_delete.png'><font class='fontstyle'>不能为空</font>");
		return false;
		
	}else if($("#louhaoid").val()>13||$("louhaoid").val()<0){
		$(".errorMsg").html("<img src='./images/close_delete.png'><font class='fontstyle'>楼号错误</font>");
		return false;
	}else{
		$(".errorMsg").html("<img src='./images/check.png'>");
		return true;
	}
}

function checkSu(){
	if($("#bianhaoid").val()==""){
		$(".SSmsg").html("<img src='./images/close_delete.png'><font class='fontstyle'>不能为空</font>");
		$(".SSmsg").css("float", "right");
		return false;
	}else{
		$(".SSmsg").html("<img src='./images/check.png'>");
		$(".SSmsg").css("float", "right");
		return true;
	}
}

function checkZy(){
	if($("#zhuanyeid").val()==""){
		$(".Zymsg").html("<img src='./images/close_delete.png'><font class='fontstyle'>不能为空</font>");
		$(".Zymsg").css("float", "right");
		return false;
	}else{
		$(".Zymsg").html("<img src='./images/check.png'>");
		$(".Zymsg").css("float", "right");
		return true;
	}
}



function checkBj(){
	if($("#banjibianhaoid").val()==""){
		$(".Bjmsg").html("<img src='./images/close_delete.png'><font class='fontstyle'>不能为空</font>");
		$(".Bjmsg").css("float", "right");
		return false;
	}else{
		$(".Bjmsg").html("<img src='./images/check.png'>");
		$(".Bjmsg").css("float", "right");
		return true;
	}
}

function checkform()
{
	if($("input:radio[name='leixing']:checked").val()==""){
		$(".lxmsg").html("<img src='./images/close_delete.png'><font class='fontstyle'>请选择宿舍类型</font>");
		$(".lxmsg").css("float", "right");
		return false;
	}
	checkBH();
	checkSu();
	
	checkZy();
	checkBj();
	if($("#cengid").val()=="0"){
		alert("未选择层数！");
		return false;
	}
	if($("zhuanyeid").val()=="0"){
		alert("未选择专业");
		return false;
	}
	if($("renshuid").val()=="0"){
		
		alert("未选择人数");
		return false;
	}
}


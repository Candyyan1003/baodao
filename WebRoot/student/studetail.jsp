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
#tab{
	margin:0;
	text-align: center;
}
#tab td{
	width:180px;
	height: 50px;
}
 div img{
	width: 14px;
	height:14px;
}

.fontstyle{
	color: #F45A1E;
	font-size: 13px;
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
	
</style>

</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width=780 align=center border=0 >
  <TBODY>
    <TR>
      
      <TD align=middle height=20>
     <font size="13px">${biaoti }</font>
      </TD>
    
    </TR>
  </TBODY>
</TABLE>
<br/>


<TABLE cellSpacing=0  cellPadding=0  border=0 id="tab"> 
  <TBODY>
  <TR>
  	<TD>
  		<span>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</span>
  	</TD>
  	<TD align="left"><span>${bean.xuehao }</span></TD>
  	<TD rowspan="4" colspan="2" >
      		 <img  src="uploadfile/${bean.photo }" width="130" height="150"  />
      </TD>
  </TR>
     <TR>
      <TD>
        
      	<span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</span>
       
      </TD>
      
      <td align="left">
      	<span>${bean.name }</span>
      </td>
      
      
    </TR>
    <TR>
      <TD >
        
      <span> 性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
       
      </TD>
      <TD align="left"><span>${bean.sex }</span></TD>
     
    </TR>
    <TR>
    	<TD><span>身份证号码:</span></TD>
    	<TD align="left"><span>${bean.sfz }</span></TD>
    </TR>
     <TR>
    <TR>
      <TD >
      <span> 手机号码:</span>
       
      </TD>
      <TD align="left">
      <span>${bean.tel }</span>
      </TD>
      <td><span>家庭地址:</span>   </td>
      <TD align="left"><span>${bean.address }</span></TD>
    </TR>
    
    
     <TR>
      <TD >
       
    	<span>政治面貌:</span>
       
      </TD>
      <TD align="left">
      <span>${bean.zzmm }</span>
      </TD>
     <TD> <span>民&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;族:</span></TD>
     <TD align="left"><span>${bean.minzu }</span></TD>
    </TR>
    <TR>
    	<TD><span> 学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院:</span></TD>
    	<TD align="left"><span>${bean.xueyuan.depart }</span></TD>
    	<TD><span>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</span></TD>
    	<TD align="left"><span>${bean.zhuanye.depart }</span></TD>
    </TR>
     <TR>
      <TD>
      <span>班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级:</span> 
      </TD>
      <TD align="left">
      	<c:if test="${bean.banji==0 }" >
      	 <span>未分配</span>
      	</c:if>
      	<c:if test="${bean.banji==1 }">
      		<span>${banji.bianhao }</span>
      	</c:if>
      </TD>
      <TD >
      <span>宿&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;舍:</span>
      </TD>
      <TD align="left">
      	<c:if test="${bean.sushe==0 }">
      		<span>未分配</span>
      	</c:if>
      	<c:if test="${bean.sushe==1 }">
      		<span>${sushe.louhao }号公寓${sushe.bianhao }</span>
      	</c:if>
      </TD>
    </TR>
    <TR>
    <TD><span>缴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费:</span></TD>
    <TD align="left">
    	<c:if test="${bean.jiaofei==0 }">
    		<span>未缴费</span>
    	</c:if>
    	<c:if test="${bean.jiaofei==1 }">
    		<span>金额:${jiaofei.total }</span>
    	</c:if>
    </TD>
    	<TD>
    		<span>一卡通开通:</span>
    	</TD>
    	<TD align="left">
    		<c:if test="${bean.ykt==0 }">
    			<span>未开通</span>
    		</c:if>
    		<c:if test="${bean.ykt==1 }">
    			<span>卡号:${ykt.kahao }</span>
    		</c:if>
    	</TD>
    	
    </TR>
    
    <TR>
    	<TD>
    	<span>体检情况:</span>
    	</TD>	
    	<TD align="left">
    	<c:if test="${bean.tijian==0 }">
    		<span>未体检</span>
    	</c:if>
    	<c:if test="${bean.tijian==1 }">
    		<span><a href="uploadfile/${tijian.path }">下载体检报告</a></span>
    	</c:if>
    		
    	</TD>	
    	<TD><span>转档案情况:</span></TD>	
    	<TD align="left">
    		<c:if test="${bean.dangan==0 }">
    			<span>未转档案</span>
    		</c:if>
    		<c:if test="${bean.dangan==1 }">
    			<span>转档案时间:<br>${dangan.ctime }</span>
    		</c:if>
    	</TD>	
    </TR>
    
  	<TR>
      <TD colspan=4 align="center">
		<input  onclick="javascript:history.go(-1);"  type="button" value="返回"  id="downid"/>
      </TD>
     
    </TR>
    
  </TBODY>
</TABLE>

</BODY>
</HTML>


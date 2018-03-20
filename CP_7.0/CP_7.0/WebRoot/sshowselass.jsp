<%@ page language="java" import="cn.jxufe.domain.TUser,java.util.*,cn.jxufe.util.*,cn.jxufe.domain.TSelAss" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	TSelAss tJobAss=(TSelAss)session.getAttribute("tSelAss");
	
	String userNum=(String)session.getAttribute("userNum");
 %>

 <script>
 var colName="";
 var colValue="";
function aclick(id){	
  	 if(id=="ochater"){	  	
  	  	colName="chater";
  	 }else if(id=="ospeciality"){		
  		colName="speciality";
  	 }else if(id=="ointerest"){		
  		colName="interest";
  	 }else if(id=="oemotionSituation"){		
  		colName="emotionSituation";
  	 }else if(id=="owillpower"){		
  		colName="willpower";
  	 }else if(id=="oenglish"){		
  		colName="english";
  	 }else if(id=="ocomputer"){
  		colName="computer";
  	 }else{
  	 window.location.href="login.jsp";
  	 }
  
}
function update(){
	colValue= $("#model_alter_id").val();
	alert(colValue);
	alert(colName);
	console.log(colValue);
	console.log(colName);
	window.location.href="UpdateSelAssessServlet?colName="+colName+"&colValue="+colValue+"&content=sselAss.jsp";
}
function submit(){
	colName="submit";
	colValue="1"; //写入确认提交标识符
	//alert("确认提交么，提交后不可修改！");
	window.location.href="UpdateJobAssessServlet?colName="+colName+"&colValue="+colValue+"&content=ssubmit.jsp";
}
function update1(){
colValue= $("#model_alter_id").val();
$.ajax({ 
    type : "POST", 
    contentType : "application/json", 
    url : "UpdateSelAssessServlet?colName="+colName+"&colValue="+colValue+"&content=selAss.jsp", 
    dataType : 'json', 
    success : function(result) { 
        alert(result); 
        //document.getElementById(colName).innerHTML=xmlhttp.responseText;
    } 
}); 
}
</script>
<div  class="text-center">
<h2><strong><%=userNum%>自我认识</strong></h2>
</div>

<!-- 学生   -->   
<!-- 设置项目和操作的最小宽度，防止内容挤压变形 -->
<table class="table table-bordered" style="padding-top:300px;">
	<!-- 项目 内容  分数  操作 （时间已过就没有权限修改 ，只能查看） -->
	<tr>
	<td><strong>项目</strong></td>
	<td><strong>内容</strong></td>

	</tr>
	
	<tr>
	<td><strong>性格</strong></td>
	<td id="chater">
	<c:choose>
	<c:when test="${ empty  tSelAss.getChater() }">
		<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tSelAss.getChater()}"></c:out>
	</c:otherwise>
	</c:choose>

       </td>
	<!--提交后显示 分数列  -->

	
	</tr>
	<tr>
	<td><strong>特长</strong></td>
	<td id="speciality">
	<c:choose>
	<c:when test="${ empty  tSelAss.getSpeciality() }">
		<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tSelAss.getSpeciality()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>

	
	</tr><tr>
	<td><strong>兴趣</strong></td>
	<td id="interest">
	<c:choose>
	<c:when test="${ empty  tSelAss.getInterest() }">
		<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tSelAss.getInterest()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>

	
	</tr>
	<tr>
	<td><strong>情绪状况</strong></td>
	<td id="emotionSituation">
	<c:choose>
	<c:when test="${ empty  tSelAss.getEmotionSituation() }">
		<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tSelAss.getEmotionSituation()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>

	
	</tr>
	<tr>
	<td><strong>意志力状况</strong></td>
	<td id="willpower">
	<c:choose>
	<c:when test="${ empty  tSelAss.getWillpower() }">
		<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tSelAss.getWillpower()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>

	
	</tr>
	<tr>
	<td><strong>外语水平</strong></td>
	<td id="english">
	<c:choose>
	<c:when test="${ empty  tSelAss.getEnglish() }">
		<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tSelAss.getEnglish()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>

	
	</tr>
	<tr>
	<td> <strong>计算机水平</strong></td>
	<td id="computer">
	<c:choose>
	<c:when test="${ empty  tSelAss.getComputer() }">
		<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tSelAss.getComputer()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>


	</tr>
</table>

<!-- 留言框 -->



<!-- <input type="button" id="submit_button" value="确认提交" onclick="submit()"></input> -->
<!-- <input type="button" id="submit_button" value="保存" onclick="submit()"></input> -->
<input type="button" value="返回" onclick="javascript:history.go(-1);"></input>

<div>
	<h3>
		<strong>其他信息</strong>
	</h3>
</div>
<ul class="nav nav-list">
	<li class="divider"></li>
</ul>
<div>
	<a href="ShowJobAssServlet" class="btn btn-primary btn-lg"role="button">职业认识</a> 
	<a href="SelectTarServlet?termNum=1"class="btn btn-primary btn-lg" role="button">第一学期规划</a> 
	<a href="SelectTarServlet?termNum=2" class="btn btn-primary btn-lg"role="button">第二学期规划</a> 
	<a href="SelectTarServlet?termNum=3"class="btn btn-primary btn-lg" role="button">第三学期规划</a>
    <a href="SelectTarServlet?termNum=4" class="btn btn-primary btn-lg"role="button">第四学期规划</a>
</div>
</div>
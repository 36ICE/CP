<%@ page language="java" import="cn.jxufe.domain.TUser,java.util.*,cn.jxufe.util.*,cn.jxufe.domain.TSelAss" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	TSelAss tSelAss=(TSelAss)request.getAttribute("tSelAss");
	
	String userNum=(String)session.getAttribute("userNum");
	String paruserNum=(String)request.getAttribute("paruserNum");
 %>

 <script>
 var colName="";
 var colValue="";
 
 function box1(){
 alert("确认提交么，提交后不可修改！");
		window.location.href="ShowJobAssServlet?userNum=<%=paruserNum %>";
 }
function aclick(id){
  	
  	 if(id=="ochater"){
  	  	//alert(id);
  	  	colName="chater";
  	 }else if(id=="ospeciality"){
  		 alert(id);
  		colName="speciality";
  	 }else if(id=="ointerest"){
  		// alert(id);
  		colName="interest";
  	 }else if(id=="oemotionSituation"){
  		// alert(id);
  		colName="emotionSituation";
  	 }else if(id=="owillpower"){
  		// alert(id);
  		colName="willpower";
  	 }else if(id=="oenglish"){
  		// alert(id);
  		colName="english";
  	 }else if(id=="ocomputer"){
  		// alert(id);
  		colName="computer";
  	 }else{
  	 window.location.href="login.jsp";
  	 }
  
}
function update(){
	colValue= $("#model_alter_id").val();
	//alert(colValue);
	//alert(colName);
	console.log(colValue);
	console.log(colName);
	window.location.href="UpdateSelAssessServlet?colName="+colName+"&colValue="+colValue+"&content=sselAss.jsp";
}
function submit(){
	colName="submit";
	colValue="1"; //写入确认提交标识符
	//
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
<h2><strong>学号:<%=paruserNum %>  自我认识</strong></h2>
</div>

<!-- 学生   -->   
<!-- 设置项目和操作的最小宽度，防止内容挤压变形 -->
<table class="table table-bordered" style="padding-top:300px;">
	<!-- 项目 内容  分数  操作 （时间已过就没有权限修改 ，只能查看） -->
	<tr>
	<td>项目</td>
	<td>内容</td>
	
	</tr>
	
	<tr>
	<td>性格</td>
	<td id="chater">
	<c:choose>
	<c:when test="${ empty  tSelAss.getChater() }">
		<font color=red><c:out value="未填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tSelAss.getChater()}"></c:out>
	</c:otherwise>
	</c:choose>

       </td>
	<!--提交后显示 分数列  -->

	
	</tr>
	<tr>
	<td>特长</td>
	<td id="speciality">
	<c:choose>
	<c:when test="${ empty  tSelAss.getSpeciality() }">
		<font color=red><c:out value="未填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tSelAss.getSpeciality()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>

	
	</tr><tr>
	<td>兴趣</td>
	<td id="interest">
	<c:choose>
	<c:when test="${ empty  tSelAss.getInterest() }">
		<font color=red><c:out value="未填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tSelAss.getInterest()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>

	
	</tr>
	<tr>
	<td>情绪状况</td>
	<td id="emotionSituation">
	<c:choose>
	<c:when test="${ empty  tSelAss.getEmotionSituation() }">
		<font color=red><c:out value="未填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tSelAss.getEmotionSituation()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>

	
	</tr>
	<tr>
	<td>意志力状况</td>
	<td id="willpower">
	<c:choose>
	<c:when test="${ empty  tSelAss.getWillpower() }">
		<font color=red><c:out value="未填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tSelAss.getWillpower()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>

	
	</tr>
	<tr>
	<td>外语水平</td>
	<td id="english">
	<c:choose>
	<c:when test="${ empty  tSelAss.getEnglish() }">
		<font color=red><c:out value="未填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tSelAss.getEnglish()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>


	</tr>
	<tr>
	<td> 计算机水平</td>
	<td id="computer">
	<c:choose>
	<c:when test="${ empty  tSelAss.getComputer() }">
		<font color=red><c:out value="未填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tSelAss.getComputer()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>

	
	</tr>
</table>

<!-- 留言框 -->

<div class="row">

	<div
		class="col-dm-4></div>
	
	<div class="col-dm-4>
	
	<input type="button" class="btn btn-success " style=" border:0px solid gray;"  value="返回" onclick="javascript:history.go(-1);">
<!-- <input type="button" id="submit_button" value="确认" onclick="submit()"></input> -->
<!-- <input type="button" value="留言" data-toggle="modal"data-target="#evaluate"></input> -->
	
	</div>
</div>
<div>
<div>
<h3><strong>其他信息</strong></h3>
</div>
	<ul class="nav nav-list"><li class="divider"></li>	</ul>
	<div>
	
	<%-- <a href="ShowSelAssServlet?paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">职业认识</a> --%>
	<a href="ShowJobAssServlet?paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">职业认识</a>
	<a href="SelectTarServlet?termNum=1&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第一学期规划</a>
	<a href="SelectTarServlet?termNum=2&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第二学期规划</a>
	<a href="SelectTarServlet?termNum=3&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第三学期规划</a>
	<a href="SelectTarServlet?termNum=4&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第四学期规划</a>
	<!-- <a href="SelectTarServlet?termNum=3" class="btn btn-primary btn-lg" role="button">学期规划</a> -->
	</div>
	</div>
<!-- <div class="form-group  has-feedback" style="padding-top:15px;">
	<div class="col-md-6 col-md-offset-3 text-center ">
		<input type="button" value="提交" data-toggle="modal"
			data-target="#myModal"></input>
		教师评价或留言
		<input type="button" value="留言" data-toggle="modal"
			data-target="#evaluate"></input>
		管理员有删除权限
		<input type="button" value="删除" data-toggle="modal"
			data-target="#evaluate"></input>
	</div>
	
</div> -->
<%
String str="文本框的默认值！";
%>
<!-- 模态框（Modal） -->

<%-- <div class="modal fade" id="myModal" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					&times;</button>
				<h4 class="modal-title">修改</h4>
			</div>
			<!-- 如果是 -->
			
			<table class="table table-bordered">
			<tr>
			<td><textarea id="model_alter_id" class="form-control" rows="6"><%= str %></textarea></td>
			</tr>
			</table>
			
			<div class="modal-footer " >
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" onclick="update()">保存</button>
			</div>
		</div>
	</div>
</div> --%>


<div class="modal fade" id="evaluate" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					&times;</button>
				<h4 class="modal-title">留言</h4>
			</div>
			<textarea class="form-control" rows="6"></textarea>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">提交更改</button>
			</div>
		</div>
	</div>
</div> 
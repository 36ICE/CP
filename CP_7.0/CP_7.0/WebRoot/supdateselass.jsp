<%@ page language="java" import="cn.jxufe.domain.TUser,java.util.*,cn.jxufe.util.*,cn.jxufe.domain.TSelAss" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	TSelAss tJobAss=(TSelAss)request.getAttribute("tSelAss");
	
	String userNum=(String)session.getAttribute("userNum");
 %>

 <script>
 var colName="";
 var colValue="";
function aclick(id){
  	
  	 if(id=="ochater"){
  	  	//alert(id);
  	  	colName="chater";
  	 }else if(id=="ospeciality"){
  		// alert(id);
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
  	 }else if(id=="submit_button"){
  	 	//alert(id);
  	 	colName = "submit";
  	 	
  	 	colValue="success";
		console.log(colValue);
		window.location.href="UpdateSelAssessServlet?colName="+colName+"&colValue="+colValue+"&content=ssubmit.jsp";
  	 }else{
  	 window.location.href="login.jsp";
  	 }
  
}

function myupdate(){
	
	
	//alert(colName);
	console.log(colName);
	if(colName!="submit"){
		colValue= $("#model_alter_id").val();
		//alert(colValue);
		window.location.href="UpdateSelAssessServlet?colName="+colName+"&colValue="+colValue+"&content=supdateselass.jsp";
	}else{
		colValue="success";
		console.log(colValue);
		window.location.href="UpdateSelAssessServlet?colName="+colName+"&colValue="+colValue+"&content=ssubmit.jsp";
	}
	
}

</script>
<div  class="text-center">
<h2><strong><%=userNum %>自我认识</strong></h2>
</div>

<!-- 学生   -->   
<!-- 设置项目和操作的最小宽度，防止内容挤压变形 -->
<table class="table table-bordered" style="padding-top:300px;">
	<!-- 项目 内容  分数  操作 （时间已过就没有权限修改 ，只能查看） -->
	<tr>
	<td>项目</td>
	<td>内容</td>
	<td>操作</td>
	</tr>
	
	<tr>
	<td>性格</td>
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

	<td>
		<a href="#" data-toggle="modal" data-target="#myModal" id="ochater" onclick="aclick(this.id)"> 
			<c:choose>
					<c:when test="${ empty  tSelAss.getChater() }">
					
						<c:out value="填写"></c:out>
					</c:when>
					<c:otherwise>
						<c:out value="修改"></c:out>
					</c:otherwise>
			</c:choose>
		</a>
	</td>
	</tr>
	<tr>
	<td>特长</td>
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

	<td>	
     <a href="#" data-toggle="modal" data-target="#myModal" id="ospeciality" onclick="aclick(this.id)"> 
			<c:choose>
					<c:when test="${ empty  tSelAss.getSpeciality() }">
					
						<c:out value="填写"></c:out>
					</c:when>
					<c:otherwise>
						<c:out value="修改"></c:out>
					</c:otherwise>
			</c:choose>
		</a>
	</td>
	</tr><tr>
	<td>兴趣</td>
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

	<td>
  <a href="#" data-toggle="modal" data-target="#myModal" id="ointerest" onclick="aclick(this.id)"> 
			<c:choose>
					<c:when test="${ empty  tSelAss.getInterest() }">
					
						<c:out value="填写"></c:out>
					</c:when>
					<c:otherwise>
						<c:out value="修改"></c:out>
					</c:otherwise>
			</c:choose>
		</a>
	</td>
	</tr>
	<tr>
	<td>情绪状况</td>
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

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="oemotionSituation" onclick="aclick(this.id)"> 
			<c:choose>
					<c:when test="${ empty  tSelAss.getEmotionSituation() }">
					
						<c:out value="填写"></c:out>
					</c:when>
					<c:otherwise>
						<c:out value="修改"></c:out>
					</c:otherwise>
			</c:choose>
		</a>
	</td>
	</tr>
	<tr>
	<td>意志力状况</td>
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

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="owillpower" onclick="aclick(this.id)"> 
			<c:choose>
					<c:when test="${ empty  tSelAss.getWillpower() }">
					
						<c:out value="填写"></c:out>
					</c:when>
					<c:otherwise>
						<c:out value="修改"></c:out>
					</c:otherwise>
			</c:choose>
		</a>
	</td>
	</tr>
	<tr>
	<td>外语水平</td>
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

	<td>
	
	<a href="#" data-toggle="modal" data-target="#myModal" id="oenglish" onclick="aclick(this.id)"> 
			<c:choose>
					<c:when test="${ empty  tSelAss.getEnglish() }">
					
						<c:out value="填写"></c:out>
					</c:when>
					<c:otherwise>
						<c:out value="修改"></c:out>
					</c:otherwise>
			</c:choose>
		</a>
	</td>
	</tr>
	<tr>
	<td> 计算机水平</td>
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

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="ocomputer" onclick="aclick(this.id)"> 
			<c:choose>
					<c:when test="${ empty  tSelAss.getComputer() }">
					
						<c:out value="填写"></c:out>
					</c:when>
					<c:otherwise>
						<c:out value="修改"></c:out>
					</c:otherwise>
			</c:choose>
		</a>
	</td>
	</tr>
</table>

<!-- 留言框 -->


<input type="button" value="返回" onclick="javascript:history.go(-1);"></input>
<input type="button" id="submit_button" value="确认提交" onclick="aclick(this.id)"></input>


<div>
<h3><strong>其他信息</strong></h3>
</div>
	<ul class="nav nav-list"><li class="divider"></li>	</ul>
	<div>
	
	<%-- <a href="ShowSelAssServlet?paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">职业认识</a> --%>
	<!-- <a href="SelectSelAssessServlet" class="btn btn-primary btn-lg" role="button">自我认识</a> -->
	<a href="SelectJobAssessServlet" class="btn btn-primary btn-lg" role="button">职业认识</a>
	
	 <a href="SelectExcTarServlet" class="btn btn-primary btn-lg" role="button">预期规划</a>
	<a href="SelectReaTarServlet" class="btn btn-primary btn-lg" role="button">实际情况</a>
	
	<!-- <a href="SelectTarServlet?termNum=3" class="btn btn-primary btn-lg" role="button">学期规划</a> -->
	</div>
	</div>

<%
String str="文本框的默认值！";
%>
<!-- 模态框（Modal） -->

<div class="modal fade" id="myModal" tabindex="-1">
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
				<button type="button"  id="but_update1"class="btn btn-primary" onclick="myupdate();">保存</button>
			</div>
		</div>
	</div>
</div>


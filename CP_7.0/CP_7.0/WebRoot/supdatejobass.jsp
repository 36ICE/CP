<%@ page language="java" import="java.util.*,cn.jxufe.domain.TJobAss" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	TJobAss tJobAss=(TJobAss)request.getAttribute("tJobAss");
	
	String userNum=(String)session.getAttribute("userNum");
 %>
 
 <script>
 var colName="";
 var colValue="";
function aclick(id){
  	//alert(id);
  	 if(id=="oemploySituation"){
  	  	//alert(id);
  	  	colName="employSituation";
  	 }else if(id=="oqualifications"){
  		// alert(id);
  		colName="qualifications";
  	 }else if(id=="oknowledge"){
  		// alert(id);
  		colName="knowledge";
  	 }else if(id=="oskills"){
  		// alert(id);
  		colName="skills";
  	 }else if(id=="ocredentials"){
  		// alert(id);
  		colName="credentials";
  	 }else if(id=="oincome"){
  		// alert(id);
  		colName="income";
  	 }else if(id=="oprospects"){
  		// alert(id);
  		colName="prospects";
  	 }else if(id=="osuggest"){
  		// alert(id);
  		colName="suggest";
  	 }else if(id="submit_button"){
  	 	colName="submit";
  	 	colValue="success";
		window.location.href="UpdateJobAssessServlet?colName="+colName+"&colValue="+colValue+"&content=ssubmit.jsp";
  	 }else{
  	 window.location.href="error.jsp";
  	 }
  
}

function update(){

	if(colName!="submit"){
		colValue= $("#model_alter_id").val();
		console.log(colValue);
		console.log(colName);
		window.location.href="UpdateJobAssessServlet?colName="+colName+"&colValue="+colValue+"&content=supdatejobass.jsp";
	}else{
		colValue="success";
		window.location.href="UpdateJobAssessServlet?colName="+colName+"&colValue="+colValue+"&content=ssubmit.jsp";
	}
}
</script>
<div  class="text-center">
<h2><strong><%=userNum %>职业认识</strong></h2>
</div>
<!-- 学生   -->   
<!-- 设置项目和操作的最小宽度，防止内容挤压变形 -->
<table class="table table-bordered">
	<!-- 项目 内容  分数  操作 （时间已过就没有权限修改 ，只能查看） -->
	<tr>
	<td>项目</td>
	<td>内容</td>
	<td>操作</td>
	</tr>
	
	<tr>
	<td>就业形势</td>
	<td id="employSituation">
	
	<c:choose>
	<c:when test="${ empty  tJobAss.getEmploySituation() }">
		
		<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tJobAss.getEmploySituation()}"></c:out>
	</c:otherwise>
	</c:choose>
       </td>
	<!--提交后显示 分数列  -->

	<td>
	<!-- 如果没有数据显示填写 -->
	<!-- <a href="#" data-toggle="modal" data-target="#myModal"> 填写</a> -->
	<!-- 如果有数据显示修改 -->
		<a href="#" data-toggle="modal" data-target="#myModal" id="oemploySituation" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tJobAss.getEmploySituation() }">
						
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
	<td>素质要求</td>
	<td id="qualifications">
	<c:choose>
	<c:when test="${empty tJobAss.getQualifications() }">
		
		<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tJobAss.getQualifications()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>
		
	<td>	
     <a href="#" data-toggle="modal" data-target="#myModal" id="oqualifications" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tJobAss.getQualifications() }">
						
						<c:out value="填写"></c:out>
					</c:when>
					<c:otherwise>
						<c:out value="修改"></c:out>
					</c:otherwise>
				</c:choose>
	</a>
	</td>
	</tr><tr>
	<td>知识要求</td>
	<td id="knowledge">
	<c:choose>
	<c:when test="${empty tJobAss.getKnowledge() }">
		
		<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tJobAss.getKnowledge()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>

	<td >
   <a href="#" data-toggle="modal" data-target="#myModal" id="oknowledge" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tJobAss.getKnowledge() }">
						
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
	<td> 技能要求</td>
	<td id="skills">
		<c:choose>
	<c:when test="${empty tJobAss.getSkills() }">
		
		<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tJobAss.getSkills()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="oskills" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tJobAss.getSkills() }">
						
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
	<td> 证书要求</td>
	<td id="credentials">
	     <c:choose>
				<c:when test="${empty tJobAss.getCredentials() }">

				<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${tJobAss.getCredentials()}"></c:out>
				</c:otherwise>
		</c:choose>
	</td>

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="ocredentials" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tJobAss.getCredentials() }">
						
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
	<td>收入状况</td>
	<td id="income">
	  <c:choose>
				<c:when test="${empty tJobAss.getIncome() }">

					<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${tJobAss.getIncome()}"></c:out>
				</c:otherwise>
		</c:choose>
	</td>

	<td>
	
	<a href="#" data-toggle="modal" data-target="#myModal" id="oincome" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tJobAss.getIncome() }">
						
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
	<td> 职业前景</td>
	<td id="prospects">
		  <c:choose>
				<c:when test="${empty tJobAss.getProspects() }">

				<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${tJobAss.getProspects()}"></c:out>
				</c:otherwise>
		</c:choose>
	</td>

	<td>
		<a href="#" data-toggle="modal" data-target="#myModal" id="oprospects" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tJobAss.getProspects() }">
						
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
	<td>对学校的建议</td>
	<td id="suggest">
		<c:choose>
				<c:when test="${empty tJobAss.getSuggest() }">

					<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${tJobAss.getSuggest()}"></c:out>
				</c:otherwise>
		</c:choose>
	</td>

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="osuggest" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tJobAss.getSuggest() }">
						
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



<input type="button" id="submit_button" value="确认提交" onclick="aclick(this.id)"></input>
<input type="button" value="返回" onclick="javascript:history.go(-1);"></input>
<div>
<h3><strong>其他信息</strong></h3>
</div>
	<ul class="nav nav-list"><li class="divider"></li>	</ul>
	<div>
	
	<%-- <a href="ShowSelAssServlet?paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">职业认识</a> --%>
	<a href="SelectSelAssessServlet" class="btn btn-primary btn-lg" role="button">自我认识</a>
	<!-- <a href="SelectJobAssessServlet" class="btn btn-primary btn-lg" role="button">职业认识</a> -->
	
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
			<td><textarea id="model_alter_id" class="form-control" rows="6" id="avalue"><%= str %></textarea></td>
			</tr>
			</table>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" id="asaveJobAss"onclick="update()">保存</button>
			</div>
		</div>
	</div>
</div>



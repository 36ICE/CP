<%@ page language="java" import="java.util.*,cn.jxufe.domain.TJobAss" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	TJobAss tJobAss=(TJobAss)request.getAttribute("tJobAss");
	System.out.print("TJobAss tJobAss=(TJobAss)session.getAttribute"+tJobAss.getEmploySituation());
	String userNum=(String)session.getAttribute("userNum");
	String paruserNum=(String)request.getAttribute("paruserNum");
 %>
 
 <script>
 var colName="";
 var colValue="";
function aclick(id){
  	
  	 if(id=="oemploySituation"){
  	  	//alert(id);
  	  	colName="employSituation";
  	 }else if(id=="qualifications"){
  		// alert(id);
  		colName="qualifications";
  	 }else if(id=="knowledge"){
  		// alert(id);
  		colName="knowledge";
  	 }else if(id=="skills"){
  		// alert(id);
  		colName="skills";
  	 }else if(id=="credentials"){
  		// alert(id);
  		colName="credentials";
  	 }else if(id=="income"){
  		// alert(id);
  		colName="income";
  	 }else if(id=="prospects"){
  		// alert(id);
  		colName="prospects";
  	 }else if(id=="suggest"){
  		// alert(id);
  		colName="suggest";
  	 }else{
  	 window.location.href="error.jsp";
  	 }
  
}
function submit(){
	colName="submit";
	colValue="1"; //写入确认提交标识符
	window.location.href="UpdateJobAssessServlet?colName="+colName+"&colValue="+colValue+"&content=jobAss.jsp";
}
function update(){
	colValue= $("#model_alter_id").val();
	//alert(colValue);
	//alert(colName);
	console.log(colValue);
	console.log(colName);
	window.location.href="UpdateJobAssessServlet?colName="+colName+"&colValue="+colValue+"&content=jobAss.jsp";
	//onclick="window.location.href='<%=path %>/ShowSelAssListServlet'"
}
function update1(){
colValue= $("#model_alter_id").val();
$.ajax({ 
    type : "POST", 
    contentType : "application/json", 
    url : "UpdateJobAssessServlet?colName="+colName+"&colValue="+colValue+"&content=jobAss.jsp", 
    dataType : 'json', 
    success : function(result) { 
        //alert(result); 
        //document.getElementById(colName).innerHTML=xmlhttp.responseText;
    } 
}); 
}
</script>
<div  class="text-center">
<h2><strong>学号:<%=paruserNum %>职业认识</strong></h2>
</div>
<!-- 学生   -->   
<!-- 设置项目和操作的最小宽度，防止内容挤压变形 -->
<table class="table table-bordered">
	<!-- 项目 内容  分数  操作 （时间已过就没有权限修改 ，只能查看） -->
	<tr>
	<td>项目</td>
	<td>内容</td>
<!-- 	<td>操作</td> -->
	</tr>
	
	<tr>
	<td>就业形势</td>
	<td id="employSituation">
	
	<c:choose>
	<c:when test="${ empty  tJobAss.getEmploySituation() }">
		
		<font color=red><c:out value="未填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tJobAss.getEmploySituation()}"></c:out>
	</c:otherwise>
	</c:choose>
       </td>
	<!--提交后显示 分数列  -->
	</tr>
	<tr>
	<td>素质要求</td>
	<td id="qualifications">
	<c:choose>
	<c:when test="${empty tJobAss.getQualifications() }">
		
		<font color=red><c:out value="未填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tJobAss.getQualifications()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>
		
	
	</tr><tr>
	<td>知识要求</td>
	<td id="knowledge">
	<c:choose>
	<c:when test="${empty tJobAss.getKnowledge() }">
		
		<font color=red><c:out value="未填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tJobAss.getKnowledge()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>

	
	</tr>
	<tr>
	<td> 技能要求</td>
	<td id="skills">
		<c:choose>
	<c:when test="${empty tJobAss.getSkills() }">
		
		<font color=red><c:out value="未填写!"></c:out></font>
	</c:when>
	<c:otherwise>
		<c:out value="${tJobAss.getSkills()}"></c:out>
	</c:otherwise>
	</c:choose>
	</td>

	
	</tr>
	<tr>
	<td> 证书要求</td>
	<td id="credentials">
	     <c:choose>
				<c:when test="${empty tJobAss.getCredentials() }">

				<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${tJobAss.getCredentials()}"></c:out>
				</c:otherwise>
		</c:choose>
	</td>

	
	</tr>
	<tr>
	<td>收入状况</td>
	<td id="income">
	  <c:choose>
				<c:when test="${empty tJobAss.getIncome() }">

					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${tJobAss.getIncome()}"></c:out>
				</c:otherwise>
		</c:choose>
	</td>

	
	</tr>
	<tr>
	<td> 职业前景</td>
	<td id="prospects">
		  <c:choose>
				<c:when test="${empty tJobAss.getProspects() }">
				<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${tJobAss.getProspects()}"></c:out>
				</c:otherwise>
		</c:choose>
	</td>
	</tr>
	<tr>
	<td>对学校的建议</td>
	<td id="suggest">
		<c:choose>
				<c:when test="${empty tJobAss.getSuggest() }">
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${tJobAss.getSuggest()}"></c:out>
				</c:otherwise>
		</c:choose>
	</td>

	
	</tr>
</table>

<!-- 留言框 -->


<input type="button" value="返回" onclick="javascript:history.go(-1);"></input>
<!-- <input type="button" id="submit_button" value="确认" "></input> -->
<!-- <input type="button" value="留言" data-toggle="modal"data-target="#evaluate"></input> -->


<div>
<h3><strong>其他信息</strong></h3>
</div>
	<ul class="nav nav-list"><li class="divider"></li>	</ul>
	<div>
	<%-- <a href="ShowSelAssServlet?paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">职业认识</a> --%>
	<a href="ShowSelAssServlet?paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">自我认识</a>
	<a href="ShowTarServlet?termNum=1&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第一学期规划</a>
	<a href="ShowTarServlet?termNum=2&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第二学期规划</a>
	<a href="ShowTarServlet?termNum=3&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第三学期规划</a>
	<a href="ShowTarServlet?termNum=4&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第四学期规划</a>
	<!-- <a href="SelectTarServlet?termNum=3" class="btn btn-primary btn-lg" role="button">学期规划</a> -->
	</div>
	</div>

<%
String str="文本框的默认值！";
%>



<div class="modal fade" id="evaluate" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					&times;</button>
				<h4 class="modal-title">留言</h4>
			</div>
			<textarea id="model_alter_id" class="form-control" rows="6"><%= str %></textarea>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">提交更改</button>
			</div>
		</div>
	</div>
</div> 
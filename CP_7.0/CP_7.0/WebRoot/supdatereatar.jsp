<%@ page language="java" import="java.util.*,cn.jxufe.domain.TReaTar" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	TReaTar tReatar=(TReaTar)session.getAttribute("tReatar");
	String userNum=(String)session.getAttribute("userNum");
	int termNum=1;
 %>
<script>
 var colName="";
 var colValue="";
function aclick(id){
  	
  	 if(id=="orProLea"){
  	  	//alert(id);
  	  	colName="rproLea";
  	 }else if(id=="orExtraLearn"){
  		// alert(id);
  		colName="rextraLearn";
  	 }else if(id=="orPhyHealth"){
  		// alert(id);
  		colName="rphyHealth";
  	 }else if(id=="orMentalHealth"){
  		// alert(id);
  		colName="rmentalHealth";
  	 }else if(id=="orManageMoney"){
  		// alert(id);
  		colName="rmanageMoney";
  	 }else if(id=="orInterpersonal"){
  		// alert(id);
  		colName="rinterpersonal";
  	 }else if(id=="orClubEvent"){
  		// alert(id);
  		colName="rclubEvent";
  	 }else if(id=="orSocialEvent"){
  		// alert(id);
  		colName="rsocialEvent";
  	 }else if (id="submit_button"){
  	 	colName="submit";
  	 	colValue="success";
		window.location.href="UpdateReaTarServlet?colName="+colName+"&colValue="+colValue+"&content=ssubmit.jsp&termNum="+<%=termNum%>;
  	 }else{
  	 window.location.href="login.jsp";
  	 }
  
}
function update(){

	if(colName!="submit"){
	colValue= $("#model_alter_id").val();
	//alert(colValue);
	//alert(colName);
	console.log(colValue);
	console.log(colName);
	window.location.href="UpdateReaTarServlet?colName="+colName+"&colValue="+colValue+"&content=supdatereatar.jsp&termNum="+<%=termNum%>;
	}else{
		colValue="success";
		window.location.href="UpdateReaTarServlet?colName="+colName+"&colValue="+colValue+"&content=ssubmit.jsp&termNum="+<%=termNum%>;
	}
	
}

</script>


<div  class="text-center">
<h2><strong><%=userNum %>实际情况</strong></h2>
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
	<td> 专业学习</td>
	<td id="rProLea">
		<c:choose>
		<c:when test="${ empty  tReaTar.getrProLea() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tReaTar.getrProLea()}"></c:out>
		</c:otherwise>
		</c:choose>

     </td>
	<!--提交后显示 分数列  -->

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="orProLea" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tReaTar.getrProLea() }">
						
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
	<td>非专业学习</td>
	<td id="rNonProLea">
		<c:choose>
		<c:when test="${ empty  tReaTar.getrNonProLea() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tReaTar.getrNonProLea()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>	
    <a href="#" data-toggle="modal" data-target="#myModal" id="orNonProLea" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tReaTar.getrNonProLea() }">
						
						<c:out value="填写"></c:out>
					</c:when>
					<c:otherwise>
						<c:out value="修改"></c:out>
					</c:otherwise>
				</c:choose>
		</a>
	</td>
	</tr><tr>
	<td>课外学习</td>
	<td id="rExtraLearn">
		<c:choose>
		<c:when test="${ empty  tReaTar.getrExtraLearn() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tReaTar.getrExtraLearn()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>
    <a href="#" data-toggle="modal" data-target="#myModal" id="orExtraLearn" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tReaTar.getrExtraLearn() }">
						
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
	<td> 身体健康</td>
	<td id="rPhyHealth">
		<c:choose>
		<c:when test="${ empty  tReaTar.getrPhyHealth() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tReaTar.getrPhyHealth()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="orPhyHealth" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tReaTar.getrPhyHealth() }">
						
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
	<td> 心理健康</td>
	<td id="rMentalHealth">
		<c:choose>
		<c:when test="${ empty  tReaTar.getrMentalHealth() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tReaTar.getrMentalHealth()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="orMentalHealth" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tReaTar.getrMentalHealth() }">
						
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
	<td> 理财</td>
	<td id="rManageMoney">
		<c:choose>
		<c:when test="${ empty  tReaTar.getrManageMoney() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tReaTar.getrManageMoney()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>
	
	<a href="#" data-toggle="modal" data-target="#myModal" id="orManageMoney" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tReaTar.getrManageMoney() }">
						
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
	<td> 人际沟通</td>
	<td id="rInterpersonal">
		<c:choose>
		<c:when test="${ empty  tReaTar.getrInterpersonal() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tReaTar.getrInterpersonal()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="orInterpersonal" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tReaTar.getrInterpersonal() }">
						
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
	<td> 社团部门</td>
	<td id="rClubEvent">
		<c:choose>
		<c:when test="${ empty  tReaTar.getrClubEvent() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tReaTar.getrClubEvent()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="orClubEvent" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tReaTar.getrClubEvent() }">
						
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
	<td> 社会</td>
	<td id="rSocialEvent">
		<c:choose>
		<c:when test="${ empty  tReaTar.getrSocialEvent() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tReaTar.getrSocialEvent()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="orSocialEvent" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tReaTar.getrSocialEvent() }">
						
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
	<a href="SelectJobAssessServlet" class="btn btn-primary btn-lg" role="button">职业认识</a>
	
	<!-- <a href="SelectExcTarServlet" class="btn btn-primary btn-lg" role="button">预期规划</a> -->
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
				<h4 class="modal-title text-center">修改</h4>
			</div>
			<!-- 如果是 -->
			
			<table class="table table-bordered">
			<tr>
			<td>
			 <textarea  id="model_alter_id" class="form-control" rows="6"><%= str %></textarea> 
			 
			</td>
			</tr>
			</table>
			
			<div class="modal-footer ">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" onclick="update()">保存</button>
			</div>
		</div>
	</div>
</div>



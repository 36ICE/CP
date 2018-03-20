<%@ page language="java" import="java.util.*,cn.jxufe.domain.TExcTar" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	TExcTar tExcTar=(TExcTar)request.getAttribute("tExcTar");
	
	String userNum=(String)session.getAttribute("userNum");
	int termNum=1;
 %>
<script>
 var colName="";
 var colValue="";
function aclick(id){
  	
  	 if(id=="oeProLea"){
  	  	//alert(id);
  	  	colName="eProLea";
  	 }else if(id=="oeExtraLearn"){
  		// alert(id);
  		colName="eExtraLearn";
  	 }else if(id=="oePhyHealth"){
  		// alert(id);
  		colName="ePhyHealth";
  	 }else if(id=="oeMentalHealth"){
  		// alert(id);
  		colName="eMentalHealth";
  	 }else if(id=="oeManageMoney"){
  		// alert(id);
  		colName="eManageMoney";
  	 }else if(id=="oeInterpersonal"){
  		// alert(id);
  		colName="eInterpersonal";
  	 }else if(id=="oeClubEvent"){
  		// alert(id);
  		colName="eClubEvent";
  	 }else if(id=="oeSocialEvent"){
  		// alert(id);
  		colName="eSocialEvent";
  	 }else if(id="submit_button"){
  	 	colName="submit";
  	 	colValue="success";
		window.location.href="UpdateExcTarServlet?colName="+colName+"&colValue="+colValue+"&content=supdateexctar.jsp";
  	 }else{
  	 window.location.href="login.jsp";
  	 }
  
}
function update(){
	if(colName != "submit"){
		colValue= $("#model_alter_id").val();
		//alert(colValue);
		//alert(colName);
		console.log(colValue);
		console.log(colName);
		window.location.href="UpdateExcTarServlet?colName="+colName+"&colValue="+colValue;
	}else{
		colValue="success";
		window.location.href="UpdateExcTarServlet?colName="+colName+"&colValue="+colValue;
	}
	

}

</script>
<div  class="text-center">
<h2><strong><%=userNum %>预期规划</strong></h2>
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
	<td id="eProLea">
		<c:choose>
		<c:when test="${ empty  tExcTar.geteProLea() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tExcTar.geteProLea()}"></c:out>
		</c:otherwise>
		</c:choose>

     </td>
	<!--提交后显示 分数列  -->

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="oeProLea" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tExcTar.geteProLea() }">
						
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
	<td id="eNonProLea">
		<c:choose>
		<c:when test="${ empty  tExcTar.geteNonProLea() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tExcTar.geteNonProLea()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>	
    <a href="#" data-toggle="modal" data-target="#myModal" id="oeNonProLea" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tExcTar.geteNonProLea() }">
						
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
	<td id="eExtraLearn">
		<c:choose>
		<c:when test="${ empty  tExcTar.geteExtraLearn() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tExcTar.geteExtraLearn()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>
    <a href="#" data-toggle="modal" data-target="#myModal" id="oeExtraLearn" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tExcTar.geteExtraLearn() }">
						
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
	<td id="ePhyHealth">
		<c:choose>
		<c:when test="${ empty  tExcTar.getePhyHealth() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tExcTar.getePhyHealth()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="oePhyHealth" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tExcTar.getePhyHealth() }">
						
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
	<td id="eMentalHealth">
		<c:choose>
		<c:when test="${ empty  tExcTar.geteMentalHealth() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tExcTar.geteMentalHealth()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="oeMentalHealth" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tExcTar.geteMentalHealth() }">
						
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
	<td id="eManageMoney">
		<c:choose>
		<c:when test="${ empty  tExcTar.geteManageMoney() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tExcTar.geteManageMoney()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>
	
	<a href="#" data-toggle="modal" data-target="#myModal" id="oeManageMoney" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tExcTar.geteManageMoney() }">
						
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
	<td id="eInterpersonal">
		<c:choose>
		<c:when test="${ empty  tExcTar.geteInterpersonal() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tExcTar.geteInterpersonal()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="oeInterpersonal" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tExcTar.geteInterpersonal() }">
						
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
	<td id="eClubEvent">
		<c:choose>
		<c:when test="${ empty  tExcTar.geteClubEvent() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tExcTar.geteClubEvent()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="oeClubEvent" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tExcTar.geteClubEvent() }">
						
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
	<td id="eSocialEvent">
		<c:choose>
		<c:when test="${ empty  tExcTar.geteSocialEvent() }">
			
			<font color=red><c:out value="暂时无数据，请填写!"></c:out></font>
		</c:when>
		<c:otherwise>
			<c:out value="${tExcTar.geteSocialEvent()}"></c:out>
		</c:otherwise>
		</c:choose>
	</td>

	<td>
	<a href="#" data-toggle="modal" data-target="#myModal" id="oeSocialEvent" onclick="aclick(this.id)"> 
				<c:choose>
					<c:when test="${ empty  tExcTar.geteSocialEvent() }">
						
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
				<h4 class="modal-title">修改</h4>
			</div>
			<!-- 如果是 -->
			
			<table class="table table-bordered">
			<tr>
			<td><textarea id="model_alter_id" class="form-control" rows="6"><%= str %></textarea></td>
			</tr>
			</table>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" onclick="update()">保存</button>
			</div>
		</div>
	</div>
</div>

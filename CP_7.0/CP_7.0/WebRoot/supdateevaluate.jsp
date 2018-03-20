<%@ page language="java" import="java.util.*,cn.jxufe.domain.ventity.*,net.sf.json.JSONArray" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	VEva vEva=(VEva)session.getAttribute("vEva");
	int evaluaterId=(Integer)session.getAttribute("eveluaterId");
	//int evaluaterId=Integer.getInteger(str_evaluaterId);
	String userNum=(String)session.getAttribute("userNum");
	
	String paruserNum=(String)request.getAttribute("paruserNum");
 %>
 <link rel="stylesheet" href="assets/css/star-rating.css" media="all" rel="stylesheet" type="text/css"/>
 <script src="assets/js/star-rating.js" type="text/javascript"></script>

<script type="text/javascript">
 var colName="";
 var colValue="";
 function jump(){
	var gProLea= $('#gProLea').val();
	var gNonProLea=$('#gNonProLea').val();
	var gExtraLearn=$('#gExtraLearn').val();
	var gPhyHealth=$('#gPhyHealth').val();
	var gMentalHealth=$('#gMentalHealth').val();
	var gManageMoney=$('#gManageMoney').val();
	var gInterpersonal=$('#gInterpersonal').val();
	var gClubEvent=$('#gClubEvent').val();
	var gSocialEvent=$('#gSocialEvent').val();

	 //alert($('#gProLea').val());
	 window.location.href="UpdateEvaServlet?paruserNum="+<%=paruserNum%>+
	 					"&gProLea="+gProLea+
	 					"&gNonProLea="+gNonProLea+
	 					"&gExtraLearn="+gExtraLearn+
	 					"&gPhyHealth="+gPhyHealth+
	 					"&gMentalHealth="+gMentalHealth+
	 					"&gManageMoney="+gManageMoney+
	 					"&gInterpersonal="+gInterpersonal+
	 					"&gClubEvent="+gClubEvent+
	 					"&gSocialEvent="+gSocialEvent+
	 					"&eveluaterId=<%=evaluaterId%>" ;
 }
function aclick(){
  	
  	
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
  	 window.location.href="login.jsp";
  	 }
  
}
function update(){
	colValue= $("#model_alter_id").val();
	
	console.log(colValue);
	console.log(colName);
	window.location.href="UpdateJobAssessServlet?colName="+colName+"&colValue="+colValue+"&content=jobAss.jsp";
	
	}
</script> 

<div  class="text-center">
<h2><strong>学号：<%=paruserNum %>的规划</strong></h2>
<h4 class="text-right">评价人：<%=userNum %></h4>
</div>
<!-- 学生   -->   
<!-- 设置项目和操作的最小宽度，防止内容挤压变形 -->
<table class="table table-bordered">
	<!-- 项目 内容  分数  操作 （时间已过就没有权限修改 ，只能查看） -->
	<tr>
		<td><strong>项目</strong></td>
		<td><strong>预期目标</strong></td>
		<td><strong>实际情况</strong></td>
		<td><strong>评价</strong></td>
	</tr>
	
	<tr>
		<td><strong>专业学习</strong></td>
		<td >
			<c:choose>
				<c:when test="${ empty  vEva.geteProLea().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${ vEva.geteProLea().trim() }"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       
		<td >
			<c:choose>
				<c:when test="${ empty   vEva.getrProLea().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${ vEva.getrProLea().trim() }"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
		
		<td>
		<input type="number" class="input-medium" id="gProLea" min="0" max="10" value="0" step="0.5" />
		</td>
			
	</tr>
	
	<tr>
		<td><strong>非专业学习</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.geteNonProLea().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.geteNonProLea().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.getrNonProLea().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.getrNonProLea().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<input type="number" class="input-medium" id="gNonProLea" min="0" max="10" value="0" step="0.5" />
       	</td>
       	
       	
	</tr>
	
	<tr>
		<td><strong>课外学习</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.geteExtraLearn().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.geteExtraLearn().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>

		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.getrExtraLearn().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.getrExtraLearn().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<input type="number"  class="input-medium" id="gExtraLearn" min="0" max="10" value="0" step="0.5" />
       	</td>
	</tr>
	
	<tr>
		<td><strong> 身体健康</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.getePhyHealth().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.getePhyHealth().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>

		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.getrPhyHealth().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.getrPhyHealth().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<input type="number" class="input-medium" id="gPhyHealth" min="0" max="10" value="0" step="0.5" />
       	</td>
	</tr>
	
	<tr>
		<td><strong> 心里健康</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.geteMentalHealth().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.geteMentalHealth().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>

		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.getrMentalHealth().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.getrMentalHealth().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<input type="number" class="input-medium" id="gMentalHealth" min="0" max="10" value="0" step="0.5" />
       	</td>
	</tr>
	
	<tr>
		<td><strong>理财</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.geteManageMoney().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.geteManageMoney().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.getrManageMoney().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.getrManageMoney().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>

		<td id="employSituation">
			<input type="number"  class="input-medium" id="gManageMoney" min="0" max="10" value="0" step="0.5" />
       	</td>
	</tr>
	
	<tr>
		<td> <strong>人际沟通</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.geteInterpersonal().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.geteInterpersonal().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>

		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.getrInterpersonal().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.getrInterpersonal().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<input type="number"  class="input-medium" id="gInterpersonal" min="0" max="10" value="0" step="0.5" />
       	</td>
	</tr>
	
	<tr>
		<td><strong>社团部门</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.geteClubEvent().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.geteClubEvent().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>

		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.getrClubEvent().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.getrClubEvent().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<input type="number"  class="input-medium"id="gClubEvent" min="0" max="10" value="0" step="0.5" />
       	</td>
	</tr>
	
	<tr>
		<td><strong>社会</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.geteSocialEvent().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.geteSocialEvent().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vEva.getrSocialEvent().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vEva.getrSocialEvent().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<input type="number" class="input-medium" id="gSocialEvent" min="0" max="10" value="0" step="0.5" />
       	</td>
		
	</tr>
	
</table>

<!-- 留言框 -->
<div class="row">
	<div class="col-dm-4></div>
	<div class="col-dm-4>
	<input type="button" class="btn btn-success " style=" border:0px solid gray;"  value="返回" onclick="javascript:history.go(-1);">
	<!-- window.location.href='login.jsp' -->
	<a href="javascript:jump();"><input type="button" id="submit_button" value="确认提交" ></input></a>
	<!-- <input type="button" id="submit_button" value="批注" data-toggle="modal" data-target="#evaluate"></input> -->
	</div>
</div>


<%
String str="写下你的建议或留言吧！";
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


 
<div class="modal fade" id="evaluate" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					&times;</button>
				<h4 class="modal-title">批注</h4>
			</div>
			<textarea id="model_alter_id" class="form-control" rows="6"><%= str %></textarea>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">确定</button>
			</div>
		</div>
	</div>
</div>
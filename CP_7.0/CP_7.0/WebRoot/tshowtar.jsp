<%@ page language="java" import="java.util.*,cn.jxufe.domain.ventity.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	VTar vTar=(VTar)request.getAttribute("vTar");
	
	String userName=(String)request.getAttribute("userName");
	System.out.print("tshowtar.jsp输出："+userName);
	Integer termNum=(Integer)request.getAttribute("termNum");
	System.out.print(termNum);
	String paruserNum=(String)request.getAttribute("paruserNum");
	System.out.print(paruserNum);
 %>

<div  class="text-center">
<h2><strong>第<%=termNum %>学期  <%=paruserNum %>规划详情</strong></h2>
</div>
<!-- 学生   -->   
<!-- 设置项目和操作的最小宽度，防止内容挤压变形 -->
<table class="table table-bordered">
	<!-- 项目 内容  分数  操作 （时间已过就没有权限修改 ，只能查看） -->
	<tr>
		<td><strong>项目</strong></td>
		<td><strong>预期目标</strong></td>
		<td><strong>实际规划</strong></td>
		<td><strong>分数</strong></td>
	</tr>
	
	<tr>
		<td><strong>专业学习</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty vTar.geteProLea().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${ vTar.geteProLea().trim() }"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty   vTar.getrProLea().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${ vTar.getrProLea().trim() }"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
		
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty   vTar.getgProLea()  }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${ vTar.getgProLea() }"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
	</tr>
	
	<tr>
		<td><strong>非专业学习</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.geteNonProLea().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.geteNonProLea().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getrNonProLea().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getrNonProLea().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getgNonProLea() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getgNonProLea()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
	</tr>
	
	<tr>
		<td><strong>课外学习</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.geteExtraLearn().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.geteExtraLearn().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>

		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getrExtraLearn().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getrExtraLearn().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getgExtraLearn() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise> 
					<c:out value="${vTar.getgExtraLearn()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
	</tr>
	
	<tr>
		<td> <strong>身体健康</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getePhyHealth().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getePhyHealth().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>

		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getrPhyHealth().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getrPhyHealth().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getgPhyHealth() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getgPhyHealth()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
	</tr>
	
	<tr>
		<td><strong> 心里健康</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.geteMentalHealth().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.geteMentalHealth().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>

		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getrMentalHealth().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getrMentalHealth().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getgMentalHealth() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getgMentalHealth()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
	</tr>
	
	<tr>
		<td><strong>理财</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.geteManageMoney().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.geteManageMoney().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getrManageMoney().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getrManageMoney().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>

		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getgManageMoney() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getgManageMoney()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
	</tr>
	
	<tr>
		<td> <strong>人际沟通</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.geteInterpersonal().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.geteInterpersonal().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>

		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getrInterpersonal().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getrInterpersonal().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<c:choose>
				<c:when test="${ empty vTar.getgInterpersonal() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getgInterpersonal()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
	</tr>
	
	<tr>
		<td><strong>社团部门</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.geteClubEvent().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.geteClubEvent().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>

		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getrClubEvent().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getrClubEvent().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getgClubEvent() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getgClubEvent() }"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
	</tr>
	
	<tr>
		<td><strong>社会</strong></td>
		<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.geteSocialEvent().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.geteSocialEvent().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getrSocialEvent().trim() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getrSocialEvent().trim()}"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
       	
       	<td id="employSituation">
			<c:choose>
				<c:when test="${ empty  vTar.getgSocialEvent() }">	
					<font color=red><c:out value="未填写!"></c:out></font>
				</c:when>
				<c:otherwise>
					<c:out value="${vTar.getgSocialEvent() }"></c:out>
				</c:otherwise>
			</c:choose>
       	</td>
		
	</tr>
	
</table>

<!-- 留言框 -->


	<input type="button" class="btn btn-success " style=" border:0px solid gray;"  value="返回" onclick="javascript:history.go(-1);">
<!-- <input type="button" value="留言" data-toggle="modal"data-target="#evaluate"></input> -->
<div>
<h3><strong>其他信息</strong></h3>
</div>
	<ul class="nav nav-list"><li class="divider"></li>	</ul>
	
	<div>
	<a href="ShowSelAssServlet?paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">自我认识</a>
	<a href="ShowSelAssServlet?paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">职业认识</a>
	<% if(termNum -1 != 0){ %>
	<a href="ShowTarServlet?termNum=1&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第一学期规划</a>
	<% } %>
	<% if(termNum -2 != 0){ %>
	<a href="ShowTarServlet?termNum=2&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第二学期规划</a>
	<% } %>
	<% if(termNum -3 != 0){ %>
	<a href="ShowTarServlet?termNum=3&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第三学期规划</a>
	<% } %>
	<% if(termNum -4 != 0){ %>
	<a href="ShowTarServlet?termNum=4&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第四学期规划</a>
	<% } %>
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

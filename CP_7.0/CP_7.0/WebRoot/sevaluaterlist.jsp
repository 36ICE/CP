<%@page import="net.sf.json.JSONArray"%>
<%@ page language="java" 
import="java.util.*,cn.jxufe.domain.TUser,org.apache.commons.beanutils.BeanUtils,
org.apache.commons.beanutils.PropertyUtilsBean,
net.sf.json.JSONObject,cn.jxufe.domain.ventity.VInfo" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	ArrayList<VInfo> vInfos_fail=(ArrayList<VInfo>)request.getAttribute("vInfos_fail");
	
	
	ArrayList<VInfo> vInfos_success=(ArrayList<VInfo>)request.getAttribute("vInfos_success");
	
	int termNum=(Integer)request.getAttribute("termNum");
 %>

<!-- Latest compiled and minified CSS -->
<!-- <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.css"> -->
<link rel="stylesheet" href="assets/css/bootstrap-table.min.css">

<link rel="stylesheet" href="assets/css/bootstrap-editable.css">
<!-- Latest compiled and minified JavaScript -->
<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.js"></script> -->
<script src="assets/js/bootstrap-table.min.js"></script>

<!-- Latest compiled and minified Locales -->
<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/locale/bootstrap-table-zh-CN.min.js"></script> -->
<script src="assets/js/bootstrap-table-zh-CN.min.js" ></script>


 <div class="" style="padding-top:60px;">
  <ul id="myTab" class="nav nav-tabs">
   <li class="active"><a href="#home" data-toggle="tab">已评价</a>
   </li>
   <li ><a href="#home2" data-toggle="tab">  未评价</a>
   </li>
   </ul>
 
 </div>

<div id="myTabContent" class="tab-content row">
	<div class="tab-pane fade in active" id="home">
		<!--   <p>W3Cschoool菜鸟教程是一个提供最新的web技术站点，本站免费提供了建站相关的技术文档，帮助广大web技术爱好者快速入门并建立自己的网站。菜鸟先飞早入行——学的不仅是技术，更是梦想。</p> -->
		<div>
		
		<% if(vInfos_success!=null){ %>
		<%for(int i=0;i<vInfos_success.size();i++) {%>
			<div class="col-md-3" style="border:1px solid #CCC; margin-top: 20px;">

				<div class="row">
					<div class="col-md-4 ">
						<img src="assets/pic/5.png" class="img-responsive "
							alt="Responsive image">
					</div>
					<div class="col-md-8 ">
						<h4><%=vInfos_success.get(i).getUserName() %></h4>
						<br>
						<h6>截至时间:2016-08-01</h6>
					</div>
				</div>
				<div>
				<div class="col-md-4">
				<h6><font color=red></font></h6>
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-4"  >
			
					<%-- <input type="button" class="btn btn-success btn-xs" id=<%=vInfos_success.get(i).getEveluaterId()%> 
					
						style="border:0px solid gray;"  onclick="javascrtpt:window.location.href='SelectEvaServlet?eveluaterId=<%=vInfos_success.get(i).getEveluaterId()%>&termNum=<%=termNum%>&paruserNum=<%=vInfos_success.get(i).getUserNum()%>' " value="查看"  "> --%>
				</div>
				</div>
			</div>
			
				<div class="col-md-1"></div>
				<%} %>
				<%} else{%>
				
				
				<h4>暂无数据！</h4>
				<%} %>
		</div>

	</div>
	<div class="tab-pane" id="home2">
		<div>
		<% if(vInfos_fail!=null) {%>
		<%for(int i=0;i<vInfos_fail.size();i++) {%>
			<div class="col-md-3 " style="border:1px solid #CCC;  margin-top: 20px;">

				<div class="row">
					<div class="col-md-4 ">
						<img src="assets/pic/5.png" class="img-responsive "
							alt="Responsive image">
					</div>
					<div class="col-md-8 ">
						<h4>****</h4>
						<br>
						<h6>截至时间:2016-08-01</h6>
					</div>
				</div>
				<div class="row">
				<div class="col-md-4">
				<h6><font color=red><%=vInfos_fail.get(i).getUserNum()%></font></h6>
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-4"">
				
					<input type="button" class="btn btn-success btn-xs"
						style="border:0px solid gray;"
						 onclick="javascrtpt:window.location.href='SelectEvaServlet?eveluaterId=<%=vInfos_fail.get(i).getEveluaterId()%>&termNum=<%=termNum%>&paruserNum=<%=vInfos_fail.get(i).getUserNum()%>' " value="查看">
				</div>
				</div>

			</div>
			<%} %>
			<%}else{ %>
			<h4>暂无数据</h4>
			<%} %>
		</div>


	</div>
</div>




<script type="text/javascript">

function show_tar(obj){
		//alert(obj.classname);
		alert(obj.id);
		eveluaterId=obj.id;
		
	window.location.href="SelectEvaServlet?eveluaterId="+eveluaterId+"&termNum=<%=termNum%>";
	}

</script>


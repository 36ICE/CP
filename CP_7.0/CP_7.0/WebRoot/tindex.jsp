<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="utf-8" />
<title>职业生涯系统</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0" maximum-scale=1, user-scalable=no />
<!-- basic styles -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
 <link rel="stylesheet" href="assets/css/font-awesome.min.css" />


 <link rel="stylesheet" href="assets/css/ace.min.css" />
<!--<link rel="stylesheet" href="assets/css/ace-rtl.min.css" /> -->
<!-- <link rel="stylesheet" href="assets/css/ace-skins.min.css" /> -->


<script src="assets/js/jquery-1.9.1.js"></script>

<script src="assets/js/ace-extra.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

</head>

<body>

<div id="container">
	<div class="navbar navbar-inverse" id="navbar"> 

	<jsp:include page="nav.jsp"></jsp:include>

		
 	</div> 
 	<!--  style="margn-right:12px;"-->
<div class="row" >
	<!-- 主要内容 -->
	<div class="main-container" id="main-container">

		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed');}catch(e){}
		</script>

		<!-- <div class="main-container-inner"> -->
	
				<!--
			 <a class="menu-toggler" id="menu-toggler" href="#">
			 <span class="menu-text"></span>
			</a> 
			 -->
				<!-- 左侧菜单栏sidebar  -->
				<div class="col-sm-1">
				<div class="sidebar" id="sidebar" >
		
					<jsp:include page="tsidebar.jsp"></jsp:include>
				</div>
				</div>
<% 
		//String content="jobAss.jsp";
		//String content=request.getParameter("content");
		String content=(String)request.getAttribute("content");
		System.out.print("这是index的content输出："+content);
 %>
 			<div class="col-sm-10"  >
				<!-- 右侧内容 id="res_main"-->
				<div class="main-content row" id="res_main">

					<jsp:include page="<%=content%>"></jsp:include>
				</div>
				<div class="text-center" style="padding-top:60px;">
					<ul class="nav nav-list">

						<li class="divider"></li>

					</ul>
					<p>( 京ICP证110024号|京网文[2011]0019-007号|北京公安备案:1101082242 )</p>
					
					
					<p>GMT+8, 2016-5-14 23:43 , Processed in 0.158261 second(s), 13 queries , Gzip On, Memcache On</p>
					
					<p>@****工作室      如有疑问  详询tel:123456789  QQ:159357745 </p>
				</div>
			</div>
			</div>
		</div>
	
	</div> 

	

	<script type="text/javascript">
		//JS判断浏览器是否支持触屏事件，如果支持就调用
		if ("ontouchend" in document)
			document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "script>");
	</script>
		

	<script src="assets/js/typeahead-bs2.min.js"></script>

	
	<!-- ace scripts -->

	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script> 
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='utf-8'></script></div>
</body>

</html>
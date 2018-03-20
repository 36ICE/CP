<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shouye.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div class="container-fluid">
  <!-- <div class="row">
  
  	<h2 class="text-center">学生首页</h2>
  </div> -->
  	<div class="row">
  	<div>
	  	<div class="col-md-12 text-danger text-center">
	  	<h2> 迷惘的我们因规划而让人生不迷惘</h2>
	  	</div>
  	</div>
  		<div class="col-md-6">
  		<img src="assets/pic/3.jpg" class="img-responsive " alt="Responsive image">
  		</div>
  		<div class="col-md-6">
  		<img src="assets/pic/6.jpg" class="img-responsive " alt="Responsive image">
  		</div>
  	</div>
  	<div class="row text-center">
  		<div class="col-md-1">
  		
  		</div>
  		<div class="col-md-5 text-primary" >
  		<h3>当前排名</h3>
  		</div>
  		<div class="col-md-5 text-danger">
  		<h3>优秀的规划</h3>
  		...
  		</div>
  		<div class="col-md-1">
  		
  		</div>
  	</div>
  </div>
    
    
  </body>
</html>

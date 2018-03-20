<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>


<form class="form-horizontal">
	<div class="form-group has-success has-feedback">

		<div class="text-center">

			<h2 class="text-center">修改基本信息</h2>
			<br>
			<br>
			<br>
		</div>
		<div class="form-group has-success has-feedback">
			<label class="control-label col-sm-3">原密码</label>
			<div class="col-sm-6">
				<input type="password" class="form-control" id="inputPassword3"
					placeholder="Password">
			</div>
		</div>
			<br>
		<div class="form-group has-success has-feedback">
			<label class="control-label col-sm-3">新密码</label>
			<div class="col-sm-6">
				<input type="password" class="form-control" id="inputPassword3"
					placeholder="Password">
			</div>
		</div>
			<br>
		<div class="form-group has-success has-feedback">
			<label class="control-label col-sm-3">确认密码</label>
			<div class="col-sm-6">
				<input type="password" class="form-control" id="inputPassword3"
					placeholder="Password">
			</div>
		</div>
			<br>
		   <br>
		<div class="form-group has-success has-feedback">
			<div class="col-md-6 col-md-offset-3 text-center ">
				<button type="submit" class="btn btn-primary btn-lg btn-block">修改</button>
			</div>
		</div>
	</div>
</form>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>


<form class="form-horizontal">
     <div class="form-group has-success has-feedback">
		
		<div class="text-center">
			
		<h2 class="text-center">修改基本信息</h2>
		</div>
	</div>
	<div class="form-group has-success has-feedback">
		<label class="control-label col-sm-3">出生年月</label>
		<div class="col-sm-6">
			<input type="date" class="form-control" min="2000-01-01"
				max="2020-01-01" />
		</div>
	</div>
	<div class="form-group has-success has-feedback">
		<label class="control-label col-sm-3" for="inputGroupSuccess2">email</label>
		<div class="col-sm-6">

			<input type="email" class="form-control" required autofocus  />
		</div>
	</div>
	<div class="form-group has-success has-feedback">
		<label class="control-label col-sm-3" for="inputGroupSuccess2">手机号码</label>
		<div class="col-sm-6">
			<input type="tel" class="form-control" pattern="[0-9]{7,11}" />
		</div>
	</div>
	<div class="form-group has-success has-feedback">
		<label class="control-label col-sm-3" for="inputGroupSuccess2">QQ</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" min="2000-01-01"
				max="2020-01-01" />
		</div>
	</div>
	<div class="form-group has-success has-feedback">
		<label class="control-label col-sm-3" for="inputGroupSuccess2">性别</label>
		<div class="col-sm-6">
			<label class="radio-inline"> <input type="radio"
				name="inlineRadioOptions" id="inlineRadio1" value="option1">
				男
			</label> <label class="radio-inline"> <input type="radio"
				name="inlineRadioOptions" id="inlineRadio2" value="option2">
				女
			</label>
		</div>
	</div>
		<div class="form-group has-success has-feedback">
		<div class="col-md-6 col-md-offset-3 text-center ">
			<button type="submit" class="btn btn-primary btn-lg btn-block">修改</button>
		</div>
	</div>
 		
</form>
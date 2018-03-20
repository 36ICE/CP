<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
  <script src="assets/js/jquery-1.9.1.js"></script>
  
<%-- <jsp:include page="tem_head_html.jsp"></jsp:include> --%>

<title>职业规划系统</title>

<link rel="stylesheet" type="text/css" href="bs/css/bootstrap.min.css" />

<style type="text/css">
html,body {
	height: 100%;
}

.box {
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF',
	endColorstr='#6699FF'); /*  IE */
	background-image: linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image: -o-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image: -moz-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image: -webkit-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image: -ms-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	margin: 0 auto;
	position: relative;
	width: 100%;
	height: 100%;
}

.login-box {
	width: 100%;
	max-width: 500px;
	height: 400px;
	position: absolute;
	top: 50%;
	margin-top: -200px;
	/**/
}

@media screen and (min-width:500px) {
	.login-box {
		left: 50%;
		
		margin-left: -250px;
	}
}

.form {
	width: 100%;
	max-width: 500px;
	height: 275px;
	margin: 25px auto 0px auto;
	padding-top: 25px;
}

.login-content {
	height: 300px;
	width: 100%;
	max-width: 500px;
	background-color: rgba(255, 250, 2550, .6);
	float: left;
}

.input-group {
	margin: 0px 0px 30px 0px !important;
}

.form-control,.input-group {
	height: 40px;
}

.form-group {
	margin-bottom: 0px !important;
}

.login-title {
	padding: 20px 10px;
	background-color: rgba(0, 0, 0, .6);
}

.login-title h1 {
	margin-top: 10px !important;
}

.login-title small {
	color: #fff;
}

.link p {
	line-height: 20px;
	margin-top: 30px;
}

.btn-sm {
	padding: 8px 24px !important;
	font-size: 16px !important;
}
</style>
<script>


	$(function() {
		$("input:password").bind("copy cut paste", function(e) {
			alert("禁止复制粘贴！");
			return false;
		});
	});
	function Valid() {

		if (formlogin.userNum.value == "") {
			alert("用户名不能为空！");
			this.formlogin.userNum.focus();
			return false;
		}
		var reg1 = new RegExp("^[0-9]*$");

		if (!reg1.test(formlogin.userNum.value)) {
			alert("用户名只能包含数字！");
			this.formlogin.userNum.focus();
			return false;
		}

		if (formlogin.code.value == "") {
			alert("密码不能为空！");
			this.formlogin.code.focus();
			return false;
		}
		if (formlogin.userNum.value.length != 7) {
			alert("用户名长度为7位,请检查是否有误！");
			this.formlogin.userNum.focus();
			return false;
		}
		if (formlogin.code.value.length > 16) {
			alert("密码长度不得超过16位，请检查是否有误！");
			this.formlogin.code.focus();
			return false;
		}
		if (formlogin.code.value.length < 6) {
			alert("密码长度不得少于6位，请检查是否有误！");
			this.formlogin.code.focus();
			return false;
		}

		var regu = "^[0-9a-zA-Z\_]+$";
		var re = new RegExp(regu);
		if (!re.test(formlogin.code.value)) {
			alert("密码只由英文字母和数字和下划线组成 ，请检查是否有误！");
			this.formlogin.code.focus();
			return false;
		}

		return true;
	}
</script>

</head>

<body>
	<div class="box">
		<div class="login-box">
			<div class="login-title text-center">
				<h1>
					<small>职业规划系统</small>
				</h1>
			</div>
			<div class="login-content ">
				<div class="form">
					<form name="formlogin" action="LoginServlet" method="post" >
						<div class="form-group">
							<div class="col-xs-12  ">
								<div class="input-group">
									<span class="input-group-addon">
									<span class="glyphicon glyphicon-user"></span>
									</span> 
									<input type="text" id="userNum" name="userNum" class="form-control" placeholder="ID" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12  ">
								<div class="input-group">
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-lock"></span></span> <input
										type="password" id="code" name="code"
										class="form-control" placeholder="password" />
								</div>
							</div>
						</div>
						<div class="form-group form-actions">
							<div class="col-xs-4 col-xs-offset-4 ">
								<button type="submit" class="btn btn-sm btn-info" onclick="return Valid()">
									<span class="glyphicon glyphicon-off"> 登录</span>
								</button>
							</div>
						</div>
						<!-- <div class="form-group">
							<div class="col-xs-6 link">
								<p class="text-center remove-margin">
									<small>忘记密码？</small> <a href="javascript:void(0)"><small>找回</small></a>
								</p>
							</div>
							<div class="col-xs-6 link">
								<p class="text-center remove-margin">
									<small>还没注册?</small> <a href="javascript:void(0)"><small>注册</small></a>
								</p>
							</div>
						</div> -->
					</form>
				</div>
			</div>
		</div>
		
	</div>
	<div style="text-align:center;">
		<p>@江西财经大学软件与通信学院工作室  如有疑问 请联系QQ:635727914</p>
	</div>
	
	
	
</body>
</html>
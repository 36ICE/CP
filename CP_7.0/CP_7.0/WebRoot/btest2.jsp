<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="content" content="text/html;charset=utf-8">
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
<script src="assets/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	function sub() {

		$.ajax({
			type : "post",//请求方式
			url : "AjaxTest2Servlet",//发送请求地址
			data : {//发送给数据库的数据
				username : $("#username").val(),
				content : $("#content").val()
			},
			//请求成功后的回调函数有两个参数
			success : function(data, textStatus) {
				$("#resText").html(data);
			}
		});

	}
</script>
</head>

<body>

	<form action="AjaxTest2Servlet" id="form1" method="post">
		<p>评论：</p>
		<p>
			姓名：<input type="text" name="username" id="username" />
		</p>
		<p>
			内容：
			<textarea name="content" id="content" rows="2" cols="20"></textarea>
		</p>
		<p>
			<input type="button" id="send" value="提交" onclick="sub();" />
		</p>
	</form>
	<div class="comment">已有评论：</div>
	<div id="resText"></div>

</body>
</html>
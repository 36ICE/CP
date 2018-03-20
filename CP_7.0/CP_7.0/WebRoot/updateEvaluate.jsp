<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<textarea class="form-control" rows="3"></textarea>
<button type="button" class="btn btn-primary">确定</button>
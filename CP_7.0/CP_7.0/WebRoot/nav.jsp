<%@ page language="java" import="java.util.*,cn.jxufe.domain.TUser,cn.jxufe.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style>

.navbar navbar-default{
	background-color;
}
td{
min-width:55px;
}
</style>
<!---  -->

<%
	String userNum=(String)session.getAttribute("userNum");
	String userName=(String)session.getAttribute("userName");
%>
<div class="container-fluid ">
	<!-- 	<div class="row "> -->

	<div class="navbar-left  col-xs-2">
		<a class="menu-toggler" id="menu-toggler" href="#"> <span
			class="menu-text"></span>
		</a>
	</div>
	<div class="navbar-header col-md-6 col-sm-7 col-xs-8 ">
		<div class="navbar-brand ">
			<h2 style="font-size: 2vw; width: 80vmin;"><strong>职业规划系统</strong></h2>
		</div>
	</div>
 <div class="navbar-right">
              <ul class="nav navbar-nav">
                <li><a data-toggle="modal" data-target="#register" >
              <%=userName +userNum%>   
             </a></li>
               <!--  <li><a data-toggle="modal" data-target="#signin" href="login.jsp"><strong>注销</strong></a></li> -->
                 <li><a  href="login.jsp"> 
         		    注销
                 </a></li>
                <!-- <button type="submit" class="btn btn-default">搜索</button> -->
              </ul>
            </div>
	<!--  <button class="btn btn-small btn-inverse" type="button">注销</button> -->


</div>
<!--end 全屏布局-->

<style>

</style>



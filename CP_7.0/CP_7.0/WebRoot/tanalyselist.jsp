<%@page import="net.sf.json.JSONArray"%>
<%@ page language="java" 
import="java.util.*,cn.jxufe.domain.TUser,org.apache.commons.beanutils.BeanUtils,
org.apache.commons.beanutils.PropertyUtilsBean,
net.sf.json.JSONObject" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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


<%
      JSONArray jsArr=	(JSONArray)request.getAttribute("jsArr");
      String unitName=(String)request.getAttribute("unitName");
    	System.out.print("test1.jsp输出对象转json："+jsArr);
 %>
<div class="text-center row-fluid" style="position:relative">
	<h2>
		<strong>班级:<%=unitName %>职业规划分析</strong>
	</h2>
	<div>
<script>
    var $table = $('#table'),
        $button = $('#button');

    $(function () {
        $button.click(function () {
            alert(JSON.stringify($table.bootstrapTable('getData')));
        });
    });
</script>
	<table id="table" 
	 data-toolbar="#toolbar" 
           data-show-footer="true"
           data-search="true"
           data-sort-name="userNum"
           data-sort-order="desc"
           data-response-handler="responseHandler" >
<thead>

  <!--   <tr style="text-align: center;align:center"> -->
        <th data-field="state" data-checkbox="true"></th>
        <th data-field="userNum" data-sortable="true">学号</th>
        <th data-field="userName" data-sortable="true">姓名</th>
         <th data-field="grade" data-sortable="true">成绩</th> -->
        <th data-field="action" data-formatter="actionFormatter" data-events="actionEvents">查看详情</th>
  <!--   </tr> -->
    </thead>
	</table>
	</div>
	
</div>

<input type="button" value="返回" onclick="javascript:history.go(-1);"></input>
<script type="text/javascript">
  var $table = $('#table'), $remove = $('#re_send_selected');


      function actionFormatter(value, row, index) {
        return [
            '<a class="show" href="javascript:void(0)" title="Remove">',
            '<i class="icon-list-alt"></i>',
            '</a>'
        ].join('');
    } 
    window.actionEvents = {
        'click .show': function (e, value, row, index) {
         console.log(value, row, index);
   		 window.location.href="BroadwiseServlet?content=Line1.jsp&paruserNum="+eval(row).userNum;
 }
};
</script>

<script type="text/javascript">
	$('#table').bootstrapTable({
		 bFilter: true,     //过滤功能
         bSort: true,     //排序功能 
	     pagination: true,
	     pageSize: 10,
	     showToggle: true,
	      sortable: true,                     //是否启用排序
	      //checkbox: true,
	    data: <%=jsArr%>
	});
	 /* function operateFormatter(value, row, index) {
        return [
            '<a class="like" href="javascript:void(0)" title="Like">',
            '<i class="glyphicon glyphicon-heart"></i>',
            '</a>  ',
            '<a class="remove" href="javascript:void(0)" title="Remove">',
            '<i class="glyphicon glyphicon-remove"></i>',
            '</a>'
        ].join('');
    } */
	
</script> 

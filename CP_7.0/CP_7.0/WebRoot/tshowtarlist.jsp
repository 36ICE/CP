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
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.css">
<link rel="stylesheet" href="assets/css/bootstrap-table.min.css">

<link rel="stylesheet" href="assets/css/bootstrap-editable.css">
<!-- Latest compiled and minified JavaScript -->
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.js"></script>
<script src="assets/js/bootstrap-table.min.js"></script>

<!-- Latest compiled and minified Locales -->
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="assets/js/bootstrap-table-zh-CN.min.js" ></script>


<%
      JSONArray jsArr=	(JSONArray)request.getAttribute("jsArr");
      String unitName=(String)request.getAttribute("unitName");
      Integer termNum=(Integer)request.getAttribute("termNum");
 %>
<div class="text-center row-fluid" style="position:relative">
	<h2>
		<strong><%=unitName %>第<%=termNum %>学期规划</strong>
	</h2>
	<div>
	
	      <div id="toolbar">
            <button id="button" class="btn btn-default">getData</button>
        </div>
<script>
    var $table = $('#table'),
        $button = $('#button');

    $(function () {
        $button.click(function () {
            alert(JSON.stringify($table.bootstrapTable('getData')));
        });
    });
</script>
	<table id="table" data-toolbar="#toolbar"
           data-show-footer="true"
           data-search="true"
           data-response-handler="responseHandler" class="txet-center;">
<thead>

    <tr style="text-align: center;align:center">
        <th data-field="state" data-checkbox="true"></th>
        <th data-field="userNum">学号</th>
        <th data-field="userName">姓名</th>
        <th data-field="unitName">班级</th>
        <th data-field="action" data-formatter="actionFormatter" data-events="actionEvents">查看详情</th>
    </tr>
    </thead>
	</table>
	</div>
	
</div>
<input type="button" value="返回" onclick="javascript:history.go(-1);"></input>

<script type="text/javascript">
  var $table = $('#table'), $remove = $('#re_send_selected');

    $(function () {
        $table.on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table', function () {
            $remove.prop('disabled', !$table.bootstrapTable('getSelections').length);
        });
        $remove.click(function () {
            var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
                return row.id
            });
            alert('重新发送选中邀请, rows: ' + ids);
            $remove.prop('disabled', true);
        });
    });


     function actionFormatter(value, row, index) {
        return [
           /*  '<a class="message" href="javascript:void(0)" title="Like">',
            '<i class="icon-envelope"></i>',
            '</a>  ', */
            '<a class="show" href="javascript:void(0)" title="Remove">',
            '<i class="icon-list-alt"></i>',
            '</a>'
        ].join('');
    }
    window.actionEvents = {
        'click .show': function (e, value, row, index) {
           // alert('查看详情, row: ' +eval(row).userName);
            console.log(value, row, index);
           /*  
            JSON.stringify(row)
           $.ajax({
		    type:"POST",
		    url:"SelectJobAssessServlet", //你的请求程序页面随便啦
		    async:false,//同步：意思是当有返回值以后才会进行后面的js程序。
		    data: eval(row).userNum,   //请求需要发送的处理数据
		    success:function(msg){
		        if (msg) {//根据返回值进行跳转
		            window.location.href = '你的跳转的目标地址';
		        }
  
            
        } 
      
    });*/  window.location.href="ShowTarServlet?content=tshowtar.jsp&paruserNum="+eval(row).userNum+"&termNum=<%=termNum%>";
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
	      checkbox: true,
	    data: <%=jsArr%>
	  
	});
	
	
</script> 

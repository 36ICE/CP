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

<script src="assets/js/bootstrap-table-export.js"></script>
<script src="assets/js/tableExport.js"></script>
<script src="assets/js/bootstrap-table-key-events.js"></script>
<%
      JSONArray jsArr=	(JSONArray)request.getAttribute("jsArr");
      String unitName=(String)request.getAttribute("unitName");
    	System.out.print("test1.jsp输出对象转json："+jsArr);
    	

 %>
<div class="text-center row-fluid" style="position:relative">
	<h2>
		<strong><%=unitName%>学生清单</strong>
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


	</div>
	<table  id="table" 
			data-toolbar="#toolbar"
			data-show-toggle="true"
			
            data-show-footer="true"
            data-search="true"
            data-response-handler="responseHandler"
            data-show-export="true"
            data-key-events="true"
            data-click-to-select="true"
            
            >
<thead>

    <tr style="text-align: center;align:center">
        <th data-field="state" data-checkbox="true"></th>
        <th data-field="userNum">学号</th>
        <th data-field="userName">姓名</th>
        <th data-field="unitName">班级</th>
        <th data-field="action" data-formatter="actionFormatter" data-events="actionEvents">操作</th>
    </tr>
    </thead>
	</table>
	</div>
	<div class="row">
	<ul class="nav nav-list"><li class="divider"></li></ul>
	<h3><strong>导入学生</strong></h3>
	<!-- <div >
		 <form action="ImportExcelServlet" enctype="multipart/form-data"method="post">
				<div class="input-group input-group-lg "><input type="file"  class="form-control"    placeholder="file" name="excel" > </div>
				<div class="col-md-4"><input type="submit"  class="btn btn-lg btn-primary btn-block" value="导入学生" /></div>
				 
	</form>
	<div> -->
	<div>
		<form action="ImportExcelServlet" enctype="multipart/form-data"
			method="post">
			
				<input id="lefile" type="file" style="display:none">
				<div class="input-append">
				<div class="col-md-5">
					<input id="photoCover" class="input-large" type="text"> 
					<a class="btn" onclick="$('input[id=lefile]').click();">Browse</a>
				</div>
				<div class="col-md-3">
					<input type="submit" class="btn btn-mg btn-primary btn-block"
						value="导入学生" />
				</div>
			</div>
		</form>
		<script type="text/javascript">
					$('input[id=lefile]').change(function() {
						$('#photoCover').val($(this).val());
					});
				</script>
			</div>
	</div>
	<!-- 开启规划功能 -->
<div class="row" style="padding-top:20px;">

	<ul class="nav nav-list">
		<li class="divider"></li>
	</ul>
	<h3>
		<strong>班级规划</strong>
	</h3>

	<div class="form-group has-success has-feedback">
		<div class="row">
			<label class=" col-sm-3">开始时间</label>
			<div class="col-sm-6">
				<input type="datetime-local" class="form-control"
					min="2000-01-01 00:00:00" max="2020-01-01" id="tar_start_time" />
			</div>
		</div>
		<div class="row" style="padding-top:20px;">
			<label class=" col-sm-3">结束时间</label>
			<div class="col-sm-6">
				<input type="datetime-local" class="form-control"
					min="2000-01-01 00:00:00" max="2020-01-01" id="tar_end_time" />
			</div>
		</div>

	</div>

	<button class="btn btn-large btn-block btn-primary" type="button"
		id="openTar_btn">开启规划</button>

</div>



<div class="row" style="padding-top:20px;">
	<ul class="nav nav-list">
		<li class="divider"></li>
	</ul>
	<h3>
		<strong>班级互评</strong>
	</h3>

	<div class="form-group has-success has-feedback">
		<div class="row">
			<label class=" col-sm-3">开始时间</label>
			<div class="col-sm-6">
				<input type="datetime-local" class="form-control"
					min="2000-01-01 00:00:00" max="2020-01-01" id="start_time" />
			</div>
		</div>
		<div class="row" style="padding-top:20px;">
			<label class=" col-sm-3">结束时间</label>
			<div class="col-sm-6">
				<input type="datetime-local" class="form-control"
					min="2000-01-01 00:00:00" max="2020-01-01" id="end_time" />
			</div>
		</div>
		<div class="row" style="padding-top:20px;">
			<label class="col-sm-3">互评人数</label>
			<div class="col-sm-6">
				<select class="form-control" id="eva_num">
					<option>1</option>
					<option>2</option>
					<option>3</option>
				</select>
			</div>
		</div>
		<div class="row" style="padding-top:20px;">
			<label class="col-sm-3" for="inputGroupSuccess2">是否自评</label>
			<div class="col-sm-6">
				<label class="radio-inline" id="eva_self"> <input
					type="radio" name="inlineRadioOptions" id="inlineRadio1"
					value="option1"> 是
				</label> <label class="radio-inline"> <input type="radio"
					name="inlineRadioOptions" id="inlineRadio2" value="option2">
					否
				</label>
			</div>
		</div>
	</div>

	<button class="btn btn-large btn-block btn-primary" type="button"
		id="openEva_btn">开启互评</button>

</div>




<script type="text/javascript">

		$('#openTar_btn').click( function() {
		
		//window.location.href='OpenTarAndAssServlet';
		
		var aj = $.ajax({
			url : 'OpenTarAndAssServlet',// 跳转到 action  

			type : 'post',
			cache : false,
			
			success : function(data) {
				if (data == "true") {

					alert("开启成功！");

				} else {
					alert("修改成功！");
				}
			},
			error : function() {

				alert("开启失败，确认是否已开启！");
			}
		});

	} );


	$('#openEva_btn').click(function() {
	
	
	/* window.location.href='OpenEvaServlet?num=3'; */
	
		 var aj = $.ajax({
			url : 'OpenEvaServlet?num=3',// 跳转到 action  
		
			type : 'post',
			cache : false,
		
			success : function(data) {
				if (data == "true") {

					alert("修改成功！");

				} else {
					alert("修改成功！");
				}
			},
			error : function() {

				alert("开启失败，是否已开启！");
			}
		});

	} );

	var $table = $('#table'), $remove = $('#re_send_selected');

	$(function() {
		$table
				.on(
						'check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table',
						function() {
							$remove.prop('disabled', !$table
									.bootstrapTable('getSelections').length);
						});
		$remove.click(function() {
			var ids = $.map($table.bootstrapTable('getSelections'), function(
					row) {
				return row.id;
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
		'<a class="show" href="javascript:void(0)" title="查看">',
				'<i class="icon-list-alt"></i>', '</a>'/* ,
				'<a class="del" href="javascript:void(0)" title="删除">',
				'<i class="icon-remove"></i>', '</a>' */ ].join('');
	}
	window.actionEvents = {
		'click .show' : function(e, value, row, index) {
			alert('查看详情, row: ' + eval(row).userName);
			console.log(value, row, index);
			window.location.href = "ShowJobAssServlet?content=tshowjobass.jsp&paruserNum="
					+ eval(row).userNum;
		},
		'click .del' : function(e, value, row, index) {
			alert("你将删除该学生！");
			window.location.href = "DeleteStudentServlet?content=tstudent.jsp&paruserNum="
					+ eval(row).userNum;
		}

	};
</script>

<script type="text/javascript">
	$('#table').bootstrapTable({
		 bFilter: true,     //过滤功能
         bSort: true,     //排序功能 
	
	     pagination: true,
	     pageSize: 10,
	     //showToggle: true,
	      sortable: true,                     //是否启用排序
	      checkbox: true,
	      striped: true,                      //是否显示行间隔色
	       pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
	      data: <%=jsArr%>

	});
	

    $(function () {
        buildTable($table, 8, 1);
    });

    function expandTable($detail, cells) {
        buildTable($detail.html('<table></table>').find('table'), cells, 1);
    }

    function buildTable($el, cells, rows) {
        var i, j, row,
                columns = [],
                data = [];

        for (i = 0; i < cells; i++) {
            columns.push({
                field:  i,
                title: 'Cell' + i,
                sortable: true
            });
        }
        for (i = 0; i < rows; i++) {
            row = {};
            for (j = 0; j < cells; j++) {
                row['field' + j] = 'Row-' + i + '-' + j;
            }
            data.push(row);
        }
        $el.bootstrapTable({
            columns: columns,
            data: data,
            detailView: cells > 1,
            onExpandRow: function (index, row, $detail) {
                expandTable($detail, cells - 1);
            }
        });
    }
</script> 

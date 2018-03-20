<%@ page language="java" import="java.util.*,cn.jxufe.domain.ventity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <script src="dist/Chart.bundle.js"></script>
 
  
 <%
	ArrayList<VEvaDatas> vEvaDatass=(ArrayList<VEvaDatas>)request.getAttribute("vEvaDatass");
 	String paruserNum=(String)request.getAttribute("paruserNum");
 %>
    <div style="width:75%;">
        <canvas id="canvas"></canvas>
    </div>
    
    <%-- <jsp:include page="tbroadwise.jsp"></jsp:include> --%>
    <br>
    <br>
    <input type="button" value="返回" onclick="javascript:history.go(-1);"></input>
    <input type="button" value="留言" data-toggle="modal"data-target="#evaluate"></input>
    
    <div>
<h3><strong>其他信息</strong></h3>
</div>
	<ul class="nav nav-list"><li class="divider"></li>	</ul>
	<div>
	
	<a href="ShowSelAssServlet?paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">职业认识</a>
	<a href="ShowSelAssServlet?paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">自我认识</a>
	<a href="SelectTarServlet?termNum=1&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第一学期规划</a>
	<a href="SelectTarServlet?termNum=2&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第二学期规划</a>
	<a href="SelectTarServlet?termNum=3&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第三学期规划</a>
	<a href="SelectTarServlet?termNum=4&paruserNum=<%=paruserNum %>" class="btn btn-primary btn-lg" role="button">第四学期规划</a>
	<!-- <a href="SelectTarServlet?termNum=3" class="btn btn-primary btn-lg" role="button">学期规划</a> -->
	</div>
	</div>
    
    
    
   <!--  <button id="randomizeData">Randomize Data</button>
    <button id="addDataset">Add Dataset</button>
    <button id="removeDataset">Remove Dataset</button>
    <button id="addData">Add Data</button>
    <button id="removeData">Remove Data</button> -->
    <script>
    function test(){
	alert("sss");
	$.ajax({
	type:post,
	url:'AjaxTestServlet',
	async:false,
	success:function(data){
	alert(data);
	}});
}
    
        var MONTHS = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
        var randomScalingFactor = function() {
            return Math.round(Math.random() * 100 * (Math.random() > 0.5 ? -1 : 1));
        };
        var randomColorFactor = function() {
            return Math.round(Math.random() * 255);
        };
        var randomColor = function(opacity) {
            return 'rgba(' + randomColorFactor() + ',' + randomColorFactor() + ',' + randomColorFactor() + ',' + (opacity || '.3') + ')';
        };

        var config = {
            type: 'line',
            data: {
                labels:  ["社团部门", "课外学习", "人际沟通", "理财", "心理健康", "非专业学习", "身体健康", "专业学习", "社会实践"],
                datasets: [
                
                  <% for(int i=0;i<vEvaDatass.size();i++){ 
                    	   ArrayList<Integer> datas=new ArrayList<Integer>();
                    	   datas.add((int)vEvaDatass.get(i).gClubEvent);
                    	   datas.add((int)vEvaDatass.get(i).gExtraLearn);
                    	   datas.add((int)vEvaDatass.get(i).gInterpersonal);
                    	   datas.add((int)vEvaDatass.get(i).gManageMoney);
                    	   datas.add((int)vEvaDatass.get(i).gMentalHealth);
                    	   datas.add((int)vEvaDatass.get(i).gNonProLea);
                    	   datas.add((int)vEvaDatass.get(i).gPhyHealth);
                    	   datas.add((int)vEvaDatass.get(i).gProLea);
                    	   datas.add((int)vEvaDatass.get(i).gSocialEvent);
                    	   System.out.print(datas);
                 %> 
                {
                    label: '第<%=(int)vEvaDatass.get(i).getTermNum() %>学期规划成绩',
                   // data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()],
                    data:<%=datas%>,
                    fill: false,
                    borderDash: [5, 5],
                } 
                
                <%  if((i+1) < vEvaDatass.size()){ %>
                    	   ,
                  <% }%>
                 
                 <%	}	%> 
                ],
            },
            options: {
                responsive: true,
                legend: {
                    position: 'bottom',
                },
                hover: {
                    mode: 'label',
                },
               /*  scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Month'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Value'
                        }
                    }]
                }, */
               scaleOverride :true ,   //是否用硬编码重写y轴网格线
			   scaleSteps : 15,        //y轴刻度的个数
			   scaleStepWidth : 1,   //y轴每个刻度的宽度
			   scaleStartValue : 0,    //y轴的起始值
               title: {
                    display: true,
                    text: '<%=paruserNum %>学生规划人生轨迹',
                }
            }
        };

        $.each(config.data.datasets, function(i, dataset) {
            var background = randomColor(0.5);
            dataset.borderColor = background;
            dataset.backgroundColor = background;
            dataset.pointBorderColor = background;
            dataset.pointBackgroundColor = background;
            dataset.pointBorderWidth = 1;
        });

        window.onload = function() {
            var ctx = document.getElementById("canvas").getContext("2d");
            window.myLine = new Chart(ctx, config);
        };

        $('#randomizeData').click(function() {
            $.each(config.data.datasets, function(i, dataset) {
                dataset.data = dataset.data.map(function() {
                    return randomScalingFactor();
                });

            });

            window.myLine.update();
        });

        $('#addDataset').click(function() {
            var background = randomColor(0.5);
            var newDataset = {
                label: 'Dataset ' + config.data.datasets.length,
                borderColor: background,
                backgroundColor: background,
                pointBorderColor: background,
                pointBackgroundColor: background,
                pointBorderWidth: 1,
                fill: false,
                data: [],
            };

            for (var index = 0; index < config.data.labels.length; ++index) {
                newDataset.data.push(randomScalingFactor());
            }

            config.data.datasets.push(newDataset);
            window.myLine.update();
        });

        $('#addData').click(function() {
            if (config.data.datasets.length > 0) {
                var month = MONTHS[config.data.labels.length % MONTHS.length];
                config.data.labels.push(month);

                $.each(config.data.datasets, function(i, dataset) {
                    dataset.data.push(randomScalingFactor());
                });

                window.myLine.update();
            }
        });

        $('#removeDataset').click(function() {
            config.data.datasets.splice(0, 1);
            window.myLine.update();
        });

        $('#removeData').click(function() {
            config.data.labels.splice(-1, 1); // remove the label first

            config.data.datasets.forEach(function(dataset, datasetIndex) {
                dataset.data.pop();
            });

            window.myLine.update();
        });
    </script>
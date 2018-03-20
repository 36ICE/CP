<%@ page language="java" import="java.util.*,cn.jxufe.domain.ventity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <script src="dist/Chart.bundle.js"></script>
 
 <%
	
	ArrayList<Integer> vTardatas=(ArrayList<Integer>)request.getAttribute("vTardatas");
	
 	String paruserName=(String)request.getAttribute("paruserName");
	System.out.print("bar.jsp输出 vTardatas"+vTardatas);	 
	
 %>
<div id="container" style="width: 75%;">
 <canvas id="canvas"></canvas>
</div>
  <input type="button" value="返回" onclick="javascript:history.go(-1);"></input>
    <script>
    

  
    
        var label = ["社团部门", "课外学习", "人际沟通", "理财", "心理健康", "非专业学习", "身体健康", "专业学习", "社会实践"];

        var randomScalingFactor = function() {
            return (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100);
        };
        var randomColorFactor = function() {
            return Math.round(Math.random() * 255);
        };
        var randomColor = function() {
            return 'rgba(' + randomColorFactor() + ',' + randomColorFactor() + ',' + randomColorFactor() + ',.7)';
        };

        var barChartData = {
            labels: label,
            datasets: [{
           		label: <%=paruserName %>, 
                label:'规划成绩分析',
                backgroundColor: 'rgba(220,220,220,0.5)',
                data:<%=vTardatas%> 
                
               // data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
            }]
        };

        window.onload = function() {
            var ctx = document.getElementById("canvas").getContext("2d");
            window.myBar = new Chart(ctx, {
                type: 'bar',
                data: barChartData,
                options: {
                    // Elements options apply to all of the options unless overridden in a dataset
                    // In this case, we are setting the border of each bar to be 2px wide and green
                    elements: {
                        rectangle: {
                            borderWidth: 2,
                            borderColor: 'rgb(0, 255, 0)',
                            borderSkipped: 'bottom'
                        }
                    },
                    responsive: true,
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: <%=paruserName %>+"学生规划评价结果横向分析数据"
                    }
                }
            });

        };

      

        
    </script>
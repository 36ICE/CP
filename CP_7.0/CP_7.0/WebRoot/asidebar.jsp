<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String userNum=(String)request.getAttribute("userNum");
int termNum=1;
 %>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>


					<!-- #sidebar-shortcuts -->

					<ul class="nav nav-list">
						<li class="active">
							<a onclick="window.location.href='<%=path %>/SkipServlet?content=ashouye.jsp'" href="javascript:goto();">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 管理员首页 </span>
							</a>
						</li>		
							
								<li>
									<a>
										<i class="icon-double-angle-right"></i>
										待开发,敬请期待！
									</a>
								</li>

							
					<!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
	
<script type="text/javascript">
/* 		function tojobAss(){
		
		}
			function test() {
		
			//ajax局部刷新
				//var value = document.getElementById("userid").value;
				//兼容性写法创建请求实例,IE5 6支持else里面的方法
				if (window.XMLHttpRequest){
				xmlhttp = new XMLHttpRequest();
				}else {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				//设置传送方式,地址,以及同步还是异步
				xmlhttp.open("GET","test6.jsp",true);
				xmlhttp.onreadystatechange = callback;//状态改变的时候执行这个函数,用来判断是否请求完毕
				xmlhttp.send();//请求服务器
			}
			
	function callback() {
		//请求完成表示
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			//alert(xmlhttp.responseText);//相应返回的text
			// alert(xmlhttp.responseXML);//相应返回的xml
			if (xmlhttp.responseText) {//这里直接判断不为空,应该根据数据库返回值来进行不同的显示
				var spanid = document.getElementById("res_main");
				//var script_obj=document.createElement("script");
				spanid.innerHTML = xmlhttp.responseText;
			}
		}
	}
	
 */
	//因为你的js只是加载进来，没有执行，应该用ajax请求json数据，然后用js生成dom。然后绑定dom对象。
	function test1() {
		$.ajax({
			type : "post",// 指定是post还是get
			//data:"username="+username+"&userpass="+userpass,//发送到服务器的数据 
			url : "tarlist.jsp?termNum=1",//发送请求的地址
			dataType : "html",
			error : function(err) {//如果确定能正确运行,可不写
				alert("错误");
			},
			success : function(data) {
			alert("aaa");
				var node = document.getElementById("res_main");
				node.innerHTML = data;
				document.body.appendChild(node);

				var scriptNodes = node.getElementsByTagName('script');

				var len = scriptNodes.length;

				var styleNodes = node.getElementsByTagName('style');

				var len1 = scriptNodes.length;

				for (var i = 0; i < len; i++) {

					var scriptNode = document.createElement('script');

					if (scriptNodes[0].getAttribute('src') != ''
							&& scriptNodes[0].getAttribute('src') != null) {

						scriptNode.setAttribute('src', scriptNodes[0]
								.getAttribute('src'));

					} else {

						scriptNode.innerHTML = scriptNodes[0].innerHTML;

					}

					document.body.appendChild(scriptNode);

					node.removeChild(scriptNodes[0]);

				}
				for (var i = 0; i < len1; i++) {

					var styleNode = document.createElement('style');

					if (styleNodes[0].getAttribute('src') != ''
							&& styleNodes[0].getAttribute('src') != null) {

						styleNode.setAttribute('src', styleNodes[0]
								.getAttribute('src'));

					} else {

						styleNode.innerHTML = styleNodes[0].innerHTML;

					}

					document.head.appendChild(styleNode);

					node.removeChild(styleNodes[0]);

				}

			}
		});
	}
</script>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String userNum=(String)session.getAttribute("userNum");
int termNum=1;
 %>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<!-- <div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<button class="btn btn-success">
								<i class="icon-signal"></i>
							</button>

							<button class="btn btn-info">
								<i class="icon-pencil"></i>
							</button>

							<button class="btn btn-warning">
								<i class="icon-group"></i>
							</button>

							<button class="btn btn-danger">
								<i class="icon-cogs"></i>
							</button>
						</div>

						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div> -->
					<!-- #sidebar-shortcuts -->

					<ul class="nav nav-list">
						<li class="active">
							<a onclick="window.location.href='<%=path %>/SkipServlet?content=sshouye.jsp'" href="javascript:goto();">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 学生首页 </span>
							</a>
						</li>

						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-text-width"></i>
								<span class="menu-text"> 我的任务 </span>
								<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
							<!--  content=supdateselass.jsp&-->
								<li>
									<a href="SelectSelAssessServlet?content=supdateselass.jsp">
										<i class="icon-double-angle-right"></i>
										自我认识
									</a>
								</li>
								
								<li>
									<a href="SelectJobAssessServlet?content=supdatejobass.jsp&userNum=<%=userNum%>">
										<i class="icon-double-angle-right"></i>
										职业认识
									</a>
								</li>
								<li><!-- ?content=supdateexctar.jsp&termNum=<%=termNum%> -->
									<a href="SelectExcTarServlet">
										<i class="icon-double-angle-right"></i>
									预期规划
									</a>
								</li>
								<li><!-- ?content=supdatereatar.jsp&termNum=<%=termNum%> -->
									<a href="SelectReaTarServlet">
										<i class="icon-double-angle-right"></i>
									实际规划
									</a>
								</li>
								<li><!-- ?content=sevaluaterlist.jsp -->
									<a href="SelectEvaListServlet">
										<i class="icon-double-angle-right"></i>
									互评任务
									</a>
								</li>
								
							</ul>
						</li>

						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-desktop"></i>
								<span class="menu-text"> 规划详情 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="ShowSelAssServlet?content=sshowselass.jsp&userNum=<%=userNum %>">
										<i class="icon-double-angle-right"></i>
										自我认识
									</a>
								</li>
								<li>
									<a href="ShowJobAssServlet?content=sshowjobass.jsp&userNum=<%=userNum %>">
										<i class="icon-double-angle-right"></i>
										职业认识
									</a>
								</li>
								<li>
									<a href="SelectTarServlet?termNum=1">
										<i class="icon-double-angle-right"></i>
										大一上学期
									</a>
								</li>

								<li>
									<a href="SelectTarServlet?termNum=2">
										<i class="icon-double-angle-right"></i>
										<!-- 按钮 &amp; 图表 -->
										大一下学期
									</a>
								</li>

								<li>
									<a href="SelectTarServlet?termNum=3">
										<i class="icon-double-angle-right"></i>
										<!-- 树菜单 -->
										大二上学期
									</a>
								</li>

								<li>
									<a href="SelectTarServlet?termNum=4">
										<i class="icon-double-angle-right"></i>
										<!-- jQuery UI -->
										大二下学期
									</a>
								</li>

								<li>
									<a href="SelectTarServlet?termNum=5">
										<i class="icon-double-angle-right"></i>
										<!-- 可拖拽列表 -->
										大三上学期
									</a>
								</li>

								<li>
									<a href="SelectTarServlet?termNum=6" class="dropdown-toggle">
									<!-- 	<i class="icon-double-angle-right"></i> -->

										<!-- 三级菜单 -->
										大三下学期
										<b class="arrow icon-angle-down"></b>
									</a>
<!-- 
									<ul class="submenu">
										<li>
											<a href="#">
												<i class="icon-leaf"></i>
												第一级
											</a>
										</li>

										<li>
											<a href="#" class="dropdown-toggle">
												<i class="icon-pencil"></i>

												第四级
												<b class="arrow icon-angle-down"></b>
											</a>

											<ul class="submenu">
												<li>
													<a href="#">
														<i class="icon-plus"></i>
														添加产品
													</a>
												</li>

												<li>
													<a href="#">
														<i class="icon-eye-open"></i>
														查看商品
													</a>
												</li>
											</ul>
										</li>
									</ul> -->
								</li>
									<li>
									<a href="SelectTarServlet?termNum=7">
										<i class="icon-double-angle-right"></i>
										<!-- 可拖拽列表 -->
										大四上学期
									</a>
								</li>
									<li>
									<a href="SelectTarServlet?termNum=8">
										<i class="icon-double-angle-right"></i>
										<!-- 可拖拽列表 -->
										大四下学期
									</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text"> 规划分析</span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">

								<li>
									<a href="BroadwiseServlet">
										<i class="icon-double-angle-right"></i>
										<!-- jqGrid plugin -->
										横向分析
									</a>
								</li>
								<li>
									<a href="BroadwiseServlet?content=bar.jsp&termNum=1&paruserNum=0144206">
										<i class="icon-double-angle-right"></i>
										<!-- jqGrid plugin -->
										纵向分析
									</a>
								</li>
							</ul>
						</li>
<!-- 
						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-edit"></i>
								<span class="menu-text"> 基础资料 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="form-elements.html">
										<i class="icon-double-angle-right"></i>
										学校管理
									</a>
								</li>

								<li>
									<a href="form-wizard.html">
										<i class="icon-double-angle-right"></i>
										向导提示 &amp; 验证
										部门管理
									</a>
								</li>

								<li>
									<a href="wysiwyg.html">
										<i class="icon-double-angle-right"></i>
										单位管理
									</a>
								</li>

								<li>
									<a href="dropzone.html">
										<i class="icon-double-angle-right"></i>
										用户管理
									</a>
								</li>
								<li>
									<a href="dropzone.html">
										<i class="icon-double-angle-right"></i>
										角色管理
									</a>
								</li>
								<li>
									<a href="dropzone.html">
										<i class="icon-double-angle-right"></i>
										权限管理
									</a>
								</li>
								<li>
									<a href="dropzone.html">
										<i class="icon-double-angle-right"></i>
										用户组管理
									</a>
								</li>
								<li>
									<a href="dropzone.html">
										<i class="icon-double-angle-right"></i>
										页面管理
									</a>
								</li>
								<li>
									<a href="dropzone.html">
										<i class="icon-double-angle-right"></i>
										菜单管理
									</a>
								</li>
								<li>
									<a href="dropzone.html">
										<i class="icon-double-angle-right"></i>
										文件管理
									</a>
								</li>
							</ul>
						</li>
 -->
						<!-- <li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-edit"></i>
								<span class="menu-text"> 消息管理 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="form-elements.html">
										<i class="icon-double-angle-right"></i>
										我的留言
									</a>
								</li>
								<li>
									<a href="form-elements.html">
										<i class="icon-double-angle-right"></i>
										申请管理
									</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#">
								
										个人信息
							</a>
						</li> -->

						<!-- <li>
							<a href="calendar.html">
								<i class="icon-calendar"></i>

								<span class="menu-text">
									日历
									<span class="badge badge-transparent tooltip-error" title="2&nbsp;Important&nbsp;Events">
										<i class="icon-warning-sign red bigger-130"></i>
									</span>
								</span>
							</a>
						</li>

						<li>
							<a href="gallery.html">
								<i class="icon-picture"></i>
								<span class="menu-text"> 相册 </span>
							</a>
						</li>
 -->
						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-tag"></i>
								<span class="menu-text"> 更多功能 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="profile.html">
										<i class="icon-double-angle-right"></i>
										用户信息
									</a>
								</li>
								<li>
									<a href="profile.html">
										<i class="icon-double-angle-right"></i>
										待开发
									</a>
								</li>

								<!-- <li>
									<a href="inbox.html">
										<i class="icon-double-angle-right"></i>
										收件箱
									</a>
								</li> -->

								<!-- <li>
									<a href="pricing.html">
										<i class="icon-double-angle-right"></i>
										售价单
									</a>
								</li>

								<li>
									<a href="invoice.html">
										<i class="icon-double-angle-right"></i>
										购物车
									</a>
								</li>

								<li>
									<a href="timeline.html">
										<i class="icon-double-angle-right"></i>
										时间轴
									</a>
								</li>

								<li>
									<a href="login.html">
										<i class="icon-double-angle-right"></i>
										登录 &amp; 注册
									</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-file-alt"></i>

								<span class="menu-text">
									其他页面
									<span class="badge badge-primary ">5</span>
								</span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="faq.html">
										<i class="icon-double-angle-right"></i>
										帮助
									</a>
								</li>

								<li>
									<a href="error-404.html">
										<i class="icon-double-angle-right"></i>
										404错误页面
									</a>
								</li>

								<li>
									<a href="error-500.html">
										<i class="icon-double-angle-right"></i>
										500错误页面
									</a>
								</li>

								<li>
									<a href="grid.html">
										<i class="icon-double-angle-right"></i>
										网格
									</a>
								</li>

								<li>
									<a href="blank.html">
										<i class="icon-double-angle-right"></i>
										空白页面
									</a>
								</li>
							</ul>
						</li> -->
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
	
<script type="text/javascript">
		function tojobAss(){
		
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
			/**

			* 回调函数
			 */

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
	

	//因为你的js只是加载进来，没有执行，应该用ajax请求json数据，然后用js生成dom。然后绑定dom对象。
	function test1() {
		$.ajax({
			type : "post",// 指定是post还是get
			//data:"username="+username+"&userpass="+userpass,//发送到服务器的数据 
			url : "jobAss.jsp",//发送请求的地址
			dataType : "html",
			error : function(err) {//如果确定能正确运行,可不写
				alert("错误");
			},
			success : function(data) {
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
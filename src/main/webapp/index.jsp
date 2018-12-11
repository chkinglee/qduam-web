<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>daxuesheng社团管理系统</title>
<!-- 包含 bootstrap 样式表 -->
<link rel="stylesheet" href="tools/bootstrap/css/bootstrap.css">
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-xs-12 column">
				<img alt="logo" src="image/logo.jpg"
					class="img-rounded img-responsive" />
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-xs-121 column">
				<div class="row clearfix">
					<div class="col-xs-2 column">
						<div align="center" class="panel panel-default">
							<div class="panel-heading">
								<span class="today"> <script type="text/javascript"
										class="panel-title">
							        today = new Date();
							        document.write(today.getFullYear(),"年","",today.getMonth()+1,"月","",today.getDate(),"日 ");
							        var week = today.getDay();
							        document.write(getWeek(week));
							        function getWeek(week){ 
							           if(week == 0) return "星期日";
							           if(week == 1) return "星期一";
							           if(week == 2) return "星期二";
							           if(week == 3) return "星期三";
							           if(week == 4) return "星期四";
							           if(week == 5) return "星期五";
							           if(week == 6) return "星期六";
							        }
							    </script>
								</span>
							</div>
						</div>


						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title" align="center">栏目名称</h3>
							</div>
							<div class="panel-body">
								<ul class="nav nav-pills nav-stacked">
									<li><a href="index.jsp">首页</a></li>
									<li><a href="Article_Overview_contents.jsp" target="main">社团概览</a>
									</li>
									<li><a href="Article_News_contents.jsp?typeId=1"
										target="main">纳新动态</a></li>
									<li><a href="Article_News_contents.jsp?typeId=2"
										target="main">赛事要闻</a></li>
									<li><a href="Article_News_contents.jsp?typeId=3"
										target="main">公益传播</a></li>
									<li><a href="Article_News_contents.jsp?typeId=5"
										target="main">师生风采</a></li>
								</ul>
							</div>
						</div>

						<div class="row clearfix">
							<div class="col-xs-12 column">
								<a id="modal-273188" href="#modal-container-273188"
									data-toggle="modal"><img alt="服务指南"
									src="image/kstd_pic1.jpg" class="img-thumbnail" /></a>
								<div class="modal fade" id="modal-container-273188"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">×</button>
												<h4 class="modal-title" id="myModalLabel">服务指南</h4>
											</div>
											<div class="modal-body">
												<div class="panel-group" id="accordion">
													<div class="panel panel-info">
														<div class="panel-heading">
															<h4 class="panel-title">
																<a data-toggle="collapse" data-parent="#accordion"
																	href="#collapseOne"> 文章系统使用说明 </a>
															</h4>
														</div>
														<div id="collapseOne" class="panel-collapse collapse">
															<div class="panel-body">
																<p>学生端：
																<p>&nbsp;&nbsp;社团信息-
																<p>&nbsp;&nbsp;&nbsp;&nbsp;社团概览：查看各个社团的简介。
																<p>&nbsp;&nbsp;&nbsp;&nbsp;社团动态：查看所参加社团的动态，其中包括纳新动态、赛事要闻、公益传播、换届公告、师生风采以及其他消息。
																
																<p>社团端：
																<p>&nbsp;&nbsp;社团管理-
																<p>&nbsp;&nbsp;&nbsp;&nbsp;社团简介发布：查看本社团简介，主席团账号可以修改该简介。
																
																<p>&nbsp;&nbsp;&nbsp;&nbsp;社团动态发布：查看已发布动态和发布新动态，其中包括纳新动态、赛事要闻、公益传播、换届公告、师生风采以及其他消息。
																
																<p>管理员端：
																<p>&nbsp;&nbsp;系统管理-
																<p>&nbsp;&nbsp;&nbsp;&nbsp;网站通知发布：查看已发布网站动态和发布新动态。
															</div>
														</div>
													</div>
													<div class="panel panel-info">
														<div class="panel-heading">
															<h4 class="panel-title">
																<a data-toggle="collapse" data-parent="#accordion"
																	href="#collapseTwo"> 工作系统使用说明 </a>
															</h4>
														</div>
														<div id="collapseTwo" class="panel-collapse collapse">
															<div class="panel-body">
																<p>学生端：
																<p>&nbsp;&nbsp;活动入口-
																<p>&nbsp;&nbsp;&nbsp;&nbsp;已发布的工作：查看所有已发布的工作，包括已完成、未完成的
																
																<p>&nbsp;&nbsp;&nbsp;&nbsp;已完成的工作：查看已完成的工作
																<p>&nbsp;&nbsp;&nbsp;&nbsp;未完成的工作：查看未完成的工作
																<p>&nbsp;&nbsp;&nbsp;&nbsp;工作反馈记录：对发布的工作做反馈
																<p>社团端:
																<p>&nbsp;&nbsp;工作系统-
																<p>&nbsp;&nbsp;&nbsp;&nbsp;查看所有活动：对发布的活动进行查看
																<p>&nbsp;&nbsp;&nbsp;&nbsp;发布新活动：发布新的活动
																<p>&nbsp;&nbsp;&nbsp;&nbsp;评价已完成活动：对已完成的活动进行评价
															</div>
														</div>
													</div>
													<div class="panel panel-info">
														<div class="panel-heading">
															<h4 class="panel-title">
																<a data-toggle="collapse" data-parent="#accordion"
																	href="#collapseThree"> 纳新系统使用说明 </a>
															</h4>
														</div>
														<div id="collapseThree" class="panel-collapse collapse">
															<div class="panel-body">
																<p>学生端：
																<p>&nbsp;&nbsp;报名系统-
																<p>&nbsp;&nbsp;&nbsp;&nbsp;查看已报名的信息，新增报名信息.
																<p>社团端：
																<p>&nbsp;&nbsp;招录系统-
																<p>&nbsp;&nbsp;&nbsp;&nbsp;全部报名信息：查看全部报名信息及对录取状态进行操作。
																
																<p>&nbsp;&nbsp;&nbsp;&nbsp;初试招录：查看进入初试的报名信息及对录取状态进行操作。
																
																<p>&nbsp;&nbsp;&nbsp;&nbsp;复试招录：查看进入复试的报名信息及对录取状态进行操作。
																
																<p>&nbsp;&nbsp;&nbsp;&nbsp;录取名单：查看全部录取名单信息及对录取状态进行操作。
																
															</div>
														</div>
													</div>
													<div class="panel panel-info">
														<div class="panel-heading">
															<h5 class="panel-title">
																<a data-toggle="collapse" data-parent="#accordion"
																	href="#collapseSix"> 个人信息系统使用说明 </a>
															</h5>
														</div>
														<div id="collapseSix" class="panel-collapse collapse">
															<div class="panel-body">
																<h6>
																	<p>学生端：
																	<p>&nbsp;&nbsp;个人信息-
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;查看个人信息：在此页面查看个人信息，不可修改和删除。
																	
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;修改个人信息：在此页面修改个人信息，学号姓名不可修改和删除。
																	
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;修改头像：在此页面修改个人头像，提交要上传的头像照片文件。
																	
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;修改密码：修改个人账号的密码。
																</h6>
															</div>
														</div>
													</div>
													<div class="panel panel-info">
														<div class="panel-heading">
															<h5 class="panel-title">
																<a data-toggle="collapse" data-parent="#accordion"
																	href="#collapseFour"> 社团管理系统使用说明 </a>
															</h5>
														</div>
														<div id="collapseFour" class="panel-collapse collapse">
															<div class="panel-body">
																<h6>
																	<p>社团端：
																	<p>&nbsp;&nbsp;社团管理-
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;社团简介发布：在此页面查看该组织已发布的社团简介，不可修改和删除。
																	
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;社团动态发布：在此页面查看该组织已发布的新动态，包括纳新动态、赛事要闻、公益传播、换届公告、师生风采及其他信息，可全部查看也可分类查看；主席团还可以发布新动态，对新动态既可以删除也可以修改。
																	
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;部长信息登记：前部是社团信息，登记本部门的部长信息，可新增信息也可删除。
																	
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;部门信息登记：在此界面查看该社团包括社团信息和部门信息
																		，部门信息包括部门编号部门名称，可查看详细及部门部长与副部长的信息；主席团还可以增添新部门也可删除整个部门
																	
																</h6>
															</div>
														</div>
													</div>
													<div class="panel panel-info">
														<div class="panel-heading">
															<h5 class="panel-title">
																<a data-toggle="collapse" data-parent="#accordion"
																	href="#collapseFive"> 站内信系统使用说明 </a>
															</h5>
														</div>
														<div id="collapseFive" class="panel-collapse collapse">
															<div class="panel-body">
																<h6>
																	<p>学生端：
																	<p>&nbsp;&nbsp;站内信-
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;收件箱:查询所有邮件信息。
																	<p>社团端：
																	<p>&nbsp;&nbsp;站内信-
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;发邮件：发送新邮件。
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;发件箱:查询所有发件信息。
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;收件箱：查询所有收件信息。
																	<p>管理员端：
																	<p>&nbsp;&nbsp;站内信-
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;发邮件：发送新邮件。
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;发件箱:查询所有发件信息。
																	<p>&nbsp;&nbsp;&nbsp;&nbsp;收件箱：查询所有收件信息
																</h6>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">关闭</button>
											</div>
										</div>
									</div>
								</div>
								<a href="Article_Notice_contents.jsp" target="main"><img
									alt="网站通知" src="image/kstd_pic3.jpg" class="img-thumbnail" /></a>
							</div>
						</div>
						<center>
							<button class="btn btn-primary btn-lg" data-toggle="modal"
								data-target="#myModal">点击加入社团</button>
						</center>
					</div>


					<div class="col-xs-8 column">
						<iframe name="main" width=100% frameborder="0" scrolling="no"
							src="indexMain.html" id="main"> </iframe>
						<script type="text/javascript">
						function reinitIframe(){
						var iframe = document.getElementById("main");
						try{
						var bHeight = iframe.contentWindow.document.body.scrollHeight;
						var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
						var height = Math.max(bHeight, dHeight);
						iframe.height = height;
						console.log(height);
						}catch (ex){}
						}
						window.setInterval("reinitIframe()", 200);
					</script>
					</div>
					<div class="col-xs-2 column">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title" align="center">站内搜索</h3>
							</div>
							<div class="panel-body">
								<form action="Article_Search_contents.jsp" target="main"
									method="get" role="form" class="form-inline">
									<div class="col-lg-12 input-group">
										<input type="text" name="title" class="form-control"
											placeholder="请输入关键字"> <span class="input-group-btn">
											<button class="btn btn-default" type="submit">搜索</button>
										</span>
									</div>
								</form>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title" align="center">用户登录</h3>
							</div>
							<div class="panel-body">
								<table align="center" class="table table-hover">
									<form action="login/doLogin" method="post">
										<tr>
											<td align="center"><input type="text" name="logname"
												placeholder="Username" class="form-control" required="" /></td>
										</tr>
										<tr>
											<td align="center"><input type="password"
												name="password" placeholder="Password" class="form-control"
												required="" /></td>
										</tr>
										<tr>
											<td colspan="2" align="center"><button type="submit"
													name="g" class="btn btn-default" class="form-control">
													登录</button></td>
										</tr>
									</form>
								</table>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title" align="center">友情链接</h3>
							</div>
							<div class="panel-body">
								<ul class="nav nav-pills nav-stacked">
									<li><a href="http://www.qdu.edu.cn/" target="_blank"
										title="学校主页">学校主页</a></li>
									<li><a href="http://lib.qdu.edu.cn/" target="_blank"
										title="图书馆">图书馆</a></li>
									<li><a href="http://xgzx.qdu.edu.cn/" target="_blank"
										title="学生工作部">学生工作部</a></li>
									<li><a href="http://nic.qdu.edu.cn/" target="_blank"
										title="信息化中心">信息化中心</a></li>
								</ul>
							</div>
						</div>

						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title" id="myModalLabel" align="center">请先登录</h4>
									</div>
									<div class="modal-body">
										<table align="center" class="table table-hover">
											<form action="login/doLogin" method="post">
												<tr>
													<td align="center"><input type="text" name="logname"
														placeholder="Username" class="form-control" required="" /></td>
												</tr>
												<tr>
													<td align="center"><input type="password"
														name="password" placeholder="Password"
														class="form-control" required="" /></td>
												</tr>
												<tr>
													<td colspan="2" align="center"><button type="submit"
															name="g" class="btn btn-default" class="form-control">
															登录</button></td>
												</tr>
											</form>
										</table>

									</div>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<div align="center" id="Footer" class="panel-title">
			<span>青岛大学</span>
		</div>
	</div>
	</div>
	<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
	<script
		src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
	<script src="tools/bootstrap/js/bootstrap.js"></script>
</body>
</html>

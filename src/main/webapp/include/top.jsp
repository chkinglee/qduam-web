<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<head>
<!-- 嵌入前端框css -->
<%@ include file="/include/css.txt"%>
</head>

<div class="top_nav">
	<div class="nav_menu">
		<nav>
			<div class="nav toggle">
				<a id="menu_toggle"><i class="fa fa-bars"></i></a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li class=""><a href="javascript:;"
					class="user-profile dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false"> <img
						src=<c:url value="/image/pic/${sessionScope.student.pic}"/>>${sessionScope.student.name}
						<span class=" fa fa-angle-down"></span>
				</a>
					<ul class="dropdown-menu dropdown-usermenu pull-right">
						<li><a href="${ctx}/student/personInfo/view"> 个人信息</a></li>
						<li><a href="javascript:;">帮助</a></li>
						<li><a href="${ctx}/login/doLogout"><i
								class="fa fa-sign-out pull-right"></i>退出登录</a></li>
					</ul></li>

				<li role="presentation" class="dropdown"><a href="javascript:;"
					class="dropdown-toggle info-number" data-toggle="dropdown"
					aria-expanded="false"> <i class="fa fa-envelope-o"></i> <span
						class="badge bg-green">6</span>
				</a>
					<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
						role="menu">
						<li><a> <span class="image"><img
									src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
										Smith</span> <span class="time">3 mins ago</span>
							</span> <span class="message"> Film festivals used to be
									do-or-die moments for movie makers. They were where... </span>
						</a></li>
						<li><a> <span class="image"><img
									src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
										Smith</span> <span class="time">3 mins ago</span>
							</span> <span class="message"> Film festivals used to be
									do-or-die moments for movie makers. They were where... </span>
						</a></li>
						<li><a> <span class="image"><img
									src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
										Smith</span> <span class="time">3 mins ago</span>
							</span> <span class="message"> Film festivals used to be
									do-or-die moments for movie makers. They were where... </span>
						</a></li>
						<li><a> <span class="image"><img
									src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
										Smith</span> <span class="time">3 mins ago</span>
							</span> <span class="message"> Film festivals used to be
									do-or-die moments for movie makers. They were where... </span>
						</a></li>
						<li>
							<div class="text-center">
								<a> <strong>See All Alerts</strong> <i
									class="fa fa-angle-right"></i>
								</a>
							</div>
						</li>
					</ul></li>
			</ul>
		</nav>
	</div>
</div>
</body>
</html>
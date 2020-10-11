
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Title</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
	border-right: 1px solid #bbb;
}

li:last-child {
	border-right: none;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not(.active) {
	background-color: #111;
}

.active {
	background-color: #4CAF50;
}

.demo {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	min-width: 1000px;
	z-index: -10;
	zoom: 1;
	background-color: #fff;
	background: url(img/hacker.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	-webkit-background-size: cover;
	-o-background-size: cover;
	background-position: center 0;
}
</style>
</head>
<body>
	<ul>
		<li><a class="active" href="#home">主页</a></li>
		<li><a href="GetDownloadListController">资源下载</a></li>
		<li><a href="userManager.jsp">用户管理</a></li>
		<li><a href="resourceManager.jsp">资源管理</a></li>
		<li><a href="user.jsp">个人中心</a></li>
		<li><a href="aboutUs.jsp">关于我们</a></li>
		<li style="float: right"><a href="ExitController"><span
				style="color: red">安全退出</span></a></li>
		<li style="float: right"><a href="#about">欢迎您，<span
				style="color: white">${username}</span></a></li>

	</ul>
	<HR style="border: 3 double #987cb9" width="100%" color=#987cb9 SIZE=3>
	<div class="demo"></div>
</body>
</html>
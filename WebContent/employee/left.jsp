<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航栏</title>
<link ref="stylesheet" type="text/css" href="../css/css.css" />
<style>
#leftpart {
	width: 230px;
	height: 500px;
	font-size: 12px;
	padding-left: 26px;
	padding-top: 10px;
	text-decoration: none;
}

#leftpart ul li {
	height: 40px;
	font-size: 14px;
}

#leftpart ul li a {
	color: #3CF;
	text-decoration: none;
	font-weight: bold;
}

#leftpart ul li a:hover {
	color: #0F3;
}
</style>
</head>
<body>
	<div id="leftpart">
		<ul>
			<li><a href="daycheckinit.action?empno=${normalempno }" target="main">快速打卡</a></li>
			<li><a href="salcheck.action?empno=${normalempno }" target="main">工资表发放情况</a></li>
			<li><a href="notice.action" target="main">公司公告</a></li>
		</ul>
	</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>管理界面</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"> 
setInterval("timer.innerHTML=new Date().toLocaleString()"); 
        window.onload = function (){
  setInterval("timer.innerHTML=new Date().toLocaleString()",1000); 
  };

</script>
<style>
* {
	margin:0px;
	padding:0px;}
.back {
	background-image: url(../images/login_03.jpg);
	background-repeat: repeat-x;
	width: auto;
	height: 165px;
	overflow: hidden;
}
.back #top {
	padding-left: 50px;
}
.back #top h2 {
	font-size: 24px;
	margin-top: 50px;
}
.back #top .who {
	width: 500px;
	float: right;
	height: auto;
}
</style>
</head>
<body>
<div class="back">
  <div id="top">
    <h2>ERP人力资源管理系统</h2>
    <div class="who">欢迎,&nbsp;<span>${name } </span>登录本系统<a href="#">退出</a><br />
      <div id="timer"></div>
    </div>
  </div>
</div>
</body>
</html>

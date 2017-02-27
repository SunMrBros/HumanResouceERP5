<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function test4() {
		alert("hello");
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var txt = xmlhttp.responseText;
				alert(txt);
				
			}
		}
		xmlhttp.open("POST", "listJob.action", true);
		xmlhttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlhttp.send("deptno="+1);

	}
</script>
<style>
#show {
	height: 200px;
	width: 500px;
	border: solid 1px #ccc;
}
</style>
</head>
<body>
	<div id="show"></div>
	
	<button onclick="test4()">ajaxTest4</button>
</body>
</html>
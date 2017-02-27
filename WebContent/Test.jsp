<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function fun() {
		var xmlhttp;

		var xmlhttp = new XMLHttpRequest();

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("show").innerHTML = xmlhttp.responseText;
				document.getElementById("show").innerHTML += "ccccccccc";
			}

		}
		xmlhttp.open("GET", "testAction.action", true);
		xmlhttp.send(null);

	}
	function test2() {
		var xmlhttp;
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("show").innerHTML = xmlhttp.responseText;
				var txt = xmlhttp.responseText;
				alert(txt);
				if (txt == "1") {
					alert("添加部门成功!");
				} else if (txt == "2") {
					alert("添加部门失败,部门已经存在了!");
				} else {
					alert("添加部门失败!");
				}
			}
		}
		xmlhttp.open("POST", "addDept.action", true);
		xmlhttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlhttp.send("dname=hello&location=bj&t=" + Math.random());

	}

	function test3() {
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("show").innerHTML = xmlhttp.responseText;
				var txt = xmlhttp.responseText;
				alert(txt);
			}
		}
		xmlhttp.open("POST", "ajax_jobs.action", true);
		xmlhttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlhttp.send("deptno=2&jobname=bj&t=" + Math.random());

	}
	//测试从struts2 返回的数据流 listDept流
	
			function test4() {
				alert("hello");
				var xmlhttp = new XMLHttpRequest();
				xmlhttp.onreadystatechange = function() {
					if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
						var txt = xmlhttp.responseText;
						alert(txt);
						var xmlDoc;
						if (window.DOMParser) {
							//非IE浏览器
							xmlDoc = (new DOMParser()).parseFromString(txt,
									"text/xml");
						} else {
							//IE浏览器
							xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
							xmlDoc.async = "false"; //不启用异步，保证加载文件成功之前不会进行下面操作
							xmlDoc.loadXML(txt);
						}
						alert(xmlDoc);
					}
				}
				xmlhttp.open("POST", "ajax_listDept.action", false);
				xmlhttp.setRequestHeader("Content-Type",
						"application/x-www-form-urlencoded");
				xmlhttp.send(null);

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
	<button onclick="fun()">ajax</button>
	<button onclick="test2()">ajaxTest2</button>
	<button onclick="test3()">ajaxTest3</button>
	<button onclick="test4()">ajaxTest4</button>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试页4</title>
<script src="js/addhuminit.js"></script>
<script>
	window.onload=initdept();
	var dept=document.getElementById("deptno");
	dept.onchange=function() {
		alert("hello");
	}
	/*	var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {

			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		var deptno = dept.value;
		alert(deptno);
		xmlhttp.onreadystatechange = function() {

			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				//动态生成select列表
				var str = xmlhttp.responseText;
				alert(str);
				var data = eval("(" + str + ")");
				alert(data.length);
				var job = document.getElementById("job");
				job.innerHTML = "";
				for ( var i = 0; i < data.length; i++) {
					var opt = document.createElement("option");
					opt.innerHTML = data[i].job;
					opt.value = data[i].jobid;
					job.appendChild(opt);
				}
			}
		}
		xmlhttp.open("POST","initjob.action",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("deptno=" + deptno+"&t="+Math.random());
	};
	*/
</script>
</head>
<body>
<button onclick="initjob1()">CLick初始化岗位</button>
<button onclick="initdept()">click 初始化部门信息</button>
<a href="initjob.action">发送一个action</a><br>
<select id="deptno" style="width:150px">
</select>
<select id="job" style="width:150px">
</select>
<div style="width:500px;height:200px" id="show"></div>
</body>
</html>
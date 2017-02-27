	
	function getXmlhttp(){
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {

			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		return xmlhttp;
		}
	function initjob1() {
		var xmlhttp=getXmlhttp();
		var deptno = document.getElementById("deptno").value;
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				//动态生成select列表
				var str = xmlhttp.responseText;
				var data = eval("(" + str + ")");
				var job = document.getElementById("job");
				job.innerHTML = "";
				for ( var i = 0; i < data.length; i++) {
					var opt = document.createElement("option");
					opt.innerHTML = data[i].job;
					opt.value = data[i].jobid;
					job.appendChild(opt);
				}
			}
		};
		xmlhttp.open("POST","initjob.action",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("deptno=" + deptno);
	}
	//初始化部门信息
	function initdept(){
		var xmlhttp=getXmlhttp();
		xmlhttp.onreadystatechange = function() {

			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				//动态生成select列表
				var str = xmlhttp.responseText;
				var data = eval("(" + str + ")");
				
				var dept = document.getElementById("deptno");
				dept.innerHTML = "";
				for ( var i = 0; i < data.length; i++) {
					var opt = document.createElement("option");
					opt.innerHTML = data[i].dname;
					opt.value = data[i].deptno;
					dept.appendChild(opt);
				}
			}
		};
		xmlhttp.open("POST","initdept.action",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send(null);
	}

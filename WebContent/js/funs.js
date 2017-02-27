
function addMgr(){
		var fo=document.forms[0];
		var name=document.getElementById("pass1").value;
		var pass=document.getElementById("pass1").value;
		var email=document.getElementById("email").value;
		if(name!=""&&pass!=""&&email!=""){
				fo.submit();
			}else{
				alert("请填写信息");
				}
	}
function chkpass() {
	var pass1 = doucment.getElementById("pass1").value;
	if (pass1 == '') {
		alert("密码不能为空");
		return;
	} else {

		var pass2 = doucment.getElementById("pass2").value;
		if (pass1 != pass2) {
			alert("两次密码不同");
			return;
		}
	}

}
function sub() {
	var dname = document.getElementById("dname").value;
	var loc = document.getElementById("loc").value;
	if (dname == '' || loc == '') {
		alert("信息不能为空");
		return;
	} else {
		// ajax浼犻�鏁版嵁
		if (confirm("部门:" + dname + "部门所在位置:" + loc)) {

			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					var txt = xmlhttp.responseText;
					if (txt == "1") {
						alert("添加部门成功");
					} else if (txt == "2") {
						alert("所填的部门已经存在");
					} else {
						alert("添加失败");
					}
				}
			};
			xmlhttp.open("POST", "addDept.action", false);
			xmlhttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			xmlhttp.send("dname=" + dname + "&location=" + loc + "&t="
					+ Math.random());
		}
	}

}
function delDept(){
	
	if(confirm("你确定要删除部门?")){
		document.forms[0].submit();
	}else{
		return;
	};
}
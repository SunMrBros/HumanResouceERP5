<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打卡表</title>
<link type="text/css" href="../css/css.css" />
<style type="text/css">
.whole form table tr td #but {
	height: 50px;
	width: 100px;
}

.whole form table tr td #islate {
	height: 25px;
}
</style>
<script>
	window.onload = function() {
		var myDate = new Date();
		
		var mytime = myDate.toLocaleTimeString(); //获取当前时间
		
		document.getElementById("time").innerText = mytime;
		var ischeck="${check}";
		if(ischeck=="yes"){
			
			var but=document.getElementById("but");
			
			but.value="已打卡";
			but.disabled=true;
		}
	
	};
</script>
</head>
<body>
	<div class="whole">

		<form action="check" method="post">
			<table width="690" height="350" border="0" style="text-align: center">
				<tr>
					<td colspan="2"><center>
							<h2>上班打卡</h2>
						</center></td>
				</tr>
				<tr>
					<td height="84"><input type="hidden"
						value="${normalempno}" name="empno" /></td>
					<td align="right"><input type="submit"
						id="but" value="打卡"></td>
				</tr>
				<tr>
					<td width="143" height="53">现在时间</td>
					<td width="537" id="time"></td>
				</tr>
				<tr>
					<td height="52">规定时间</td>
					<td>${ti }</td>
				</tr>
				<tr>
					<td height="52">是否迟到</td>
					<td><label for="textfield"></label> <input type="text"
						name="islate" value="${latevalue }" readonly></td>
				</tr>
				<tr>
					<td height="97"><p>迟到原因</p>
						<p>(没有迟到,不填)</p></td>
					<td><label for="textarea"></label> <textarea name="reason"
							cols="45" rows="7"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
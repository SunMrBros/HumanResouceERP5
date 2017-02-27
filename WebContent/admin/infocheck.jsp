<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息核实表</title>
<script src="../js/jquery.js"></script>
<script>
	window.onload = function() {
		var time = document.getElementById("time");
		var date = new Date();
		time.innerHTML = date;
	};

	$("#sure").click(function(){
		
		var checkboxs= $(":checkbox");
		for(var i=0;i<checkboxs.length;i++){
			checkboxs[i].checked=true;
		}
	});
</script>
<style type="text/css">
.whole .show form table tr td label {
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="whole">
		<div class="top">
			<center>
				<h2>员工考勤及工资信息核对</h2>
			</center>
		</div>
		<div class="show">
			<form name="form1" method="post" action="fagongzi">
				<table width="1033" height="156" border="1"
					style="text-align: center" align="center">
					<tr>
						<td width="111" height="45">员工编号</td>
						<td width="101">员工姓名</td>
						<td width="117">全勤奖励</td>
						<td width="120">迟到次数</td>
						<td width="230">迟到罚款</td>
						<td width="106">其他奖励</td>
						<td width="107">基本工资</td>
						<td width="89"><label for="sure">核实确认</label><input
							type="checkbox" name="empnos" id="sure"></td>
					</tr>
					<c:forEach var="salinfo" items="${listSal}">


						<tr>
							<td>${salinfo.empno}</td>
							<td>${salinfo.name}</td>
							<td>${salinfo.quanqin}</td>
							<td>${salinfo.latetimes}</td>
							<td>${salinfo.fakuan}*${salinfo.latetimes}</td>
							<td>${salinfo.other}</td>
							<td>${salinfo.money}</td>
							<td><input type="checkbox" name="empnos"
								value="${salinfo.empno}"></td>
						</tr>
					</c:forEach>
					<tr>
						<td height="51" colspan="8"><span id="time"></span> <input
							type="submit" value="确认发工资" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
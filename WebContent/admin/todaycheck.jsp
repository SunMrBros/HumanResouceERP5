<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/css.css">
<title>今天考勤情况</title>
</head>
<body>
	<div class="whole">
		<div>
			<center>
				<h3>今日打卡情况</h3>
			</center>
		</div>
		<div>
			<table width="884" border="1" align="center"
				style="text-align: center">
				<tr>
					<td width="90" height="58">员工编号</td>
					<td width="103">姓名</td>
					<td width="191">打卡时间</td>
					<td width="128">是否迟到</td>
					<td width="338">原因</td>
				</tr>
				<c:forEach var="today" items="${checklist}">
					<tr>
						<td height="34">${today.empno}</td>
						<td>${today.name} </td>
						<td>${today.check_time}</td>
						<td>${today.islate}</td>
						<td>${today.reason}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
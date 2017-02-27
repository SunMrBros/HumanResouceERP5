<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<title>考勤统计</title>
</head>
<body>
	<div class="whole">
		<center>
			<h3>本月目前为止迟到情况统计</h3>
		</center>
	
		<table width="700" border="1" align="center"
			style="text-align: center">
			<tr bgcolor="#33CCFF">
				<td width="141" height="46">员工编号</td>
				<td width="180">所在姓名</td>
				<td width="170">所在部门</td>
				<td width="181">本月迟到次数</td>
			</tr>
			<c:forEach var="hum" items="${list}">
					<tr>
						<td height="20">${hum.empno}</td>
						<td><a href="huminfo.action?empno=${hum.empno}">${hum.name}</a>
							</td>
						<td>${hum.dname}</td>
						<td>${hum.count}</td>
					</tr>
				</c:forEach>
		</table>

	</div>
</body>
</html>
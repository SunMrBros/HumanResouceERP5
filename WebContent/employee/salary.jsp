<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link ref="stylesheet" type="text/css" href="../css/css.css" />
<title>员工工资查看</title>
<script src="laydate/laydate.js"></script>

<script src="../js/jquery.js"></script>
<script src="../js/tab_odd_even.js"></script>
<style>
.whole {
	margin-top: 40px;
	margin-left: 40px;
	width: 850px;
	height: auto;
	overflow: hidden;
	border: solid 1px #CCC;
	padding-top: 20px;
	padding-right: 20px;
	padding-bottom: 50px;
	padding-left: 40px;
}

.whole .show #table2 {
	text-align: center;
}
</style>
</head>
<body>
	<div class="whole">
		<div>
			<form action="salwithdate" method="post">
				<table width="845" border="0" align="center">
					<tr>
						<td width="124" height="36">选择查询时间段</td>
						<td width="298">开始时间 <input name="start" class="laydate-icon" onclick="laydate()" readonly></td>
						<td width="298">结束时间<input name="end" class="laydate-icon" onclick="laydate()" readonly>
						<input type="hidden" name="empno" value="${sessionScope.normalempno}"/></td>
						<td width="97"><input type="submit" id="but" value="查询提交">
							</td>
					</tr>
				</table>

			</form>
		</div>
		<div class="show">
			<center>
				<h2>工资发放情况</h2>
			</center>
			<table width="762" border="1" align="center" id="table2">
				<tr>
					<td width="121" height="48">员工编号</td>
					<td width="163">应发工资</td>
					<td width="166">奖励/扣除</td>
					<td width="149">实发工资</td>
					<td width="129">发放时间</td>
				</tr>
				<c:forEach var="sal" items="${sallist}">
					<tr>
						<td height="24">${sal.empno }</td>
						<td>${sal.salary}</td>
						<td>${sal.other }</td>
						<td>${sal.finalsalary }</td>
						<td>${sal.sal_date}</td>
					</tr>
				</c:forEach>

			</table>

		</div>
	</div>
</body>
</html>
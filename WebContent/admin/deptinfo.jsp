<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门详细情况</title>
<script src="../js/jquery.js"></script>
<script src="../js/tab_odd_even.js"></script>
<link href="../css/css.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="whole">
    	<center><h3>公司部门及岗位情况</h3></center>
		<table id="table2" width="883" border="0" class="tab_sty" align="center">
			<tr class="tr_first">
				<td width="114" height="48">部门编号</td>
				<td width="227">部门名称</td>
				<td width="262">岗位编号</td>
				<td width="262">部门岗位</td>
			</tr>
			<c:forEach var="deptinfo" items="${deptinfo}">
				<tr>
					<td height="31">${deptinfo.deptno }</td>
					<td>${deptinfo.dname }</td>
					<td>${deptinfo.jobid }</td>
					<td>${deptinfo.job }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
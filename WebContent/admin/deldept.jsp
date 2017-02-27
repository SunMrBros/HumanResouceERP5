<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>删除部门</title>
<script src="../js/jquery.js"></script>
<script src="../js/tab_odd_even.js"></script>
<script src="../js/funs.js"></script>
<link href="../css/css.css" rel="stylesheet" type="text/css"/>
</head>

<body>
	<div class="whole">
		<div class="info">
		<center><H2>部门全部信息</H2>
				</center>
			<form method="post" action="delDept">
            
				<table width="619" border="1" id="table2" align="center">
									<tr style="background-color: #a5e8f8">
						<td width="50">选项 <input type="checkbox"></td>
						<td width="180" height="56">部门编号</td>
						<td width="140">部门名称</td>
						<td width="221">部门所在位置</td>
					</tr>
					<c:forEach var="dept" items="${deptlist}">
						<tr>
							<td height="41"><input name="deptchk" value="${dept.deptno}" type="checkbox"></td>
							<td>${dept.deptno}</td>
							<td>${dept.dname}</td>
							<td>${dept.location}</td>
						</tr>
					</c:forEach>
                    <tr><td height="69" colspan="4"><button onclick="delDept();">删除选中</button></td></tr>
				</table>
				
			</form>
		</div>
	</div>
</body>
</html>
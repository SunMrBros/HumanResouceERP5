<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>添加岗位 </title>
<link href="../css/css.css" rel="stylesheet" type="text/css">
<script src="../js/addjob.js"></script>
</head>

<body>
	<div class="whole">
		<h2>岗位添加</h2>
		<form method="post" action="addjob">
			<p>
				选择部门: <label for="select"></label>
				 <select name="deptno" id="deptno">
					<c:forEach var="dept" items="${deptlist}">
						<option value="${dept.deptno }">${dept.dname } 编号${dept.deptno }</option>
					</c:forEach>
				</select>
			</p>
			<p>
				要添加的岗位名称 <label for="textfield"></label> <input type="text"
					name="jobname" id="jobname">
			</p>
			<p>选择工资级别:
			  <label for="select2"></label>
			  <select name="level" id="salary" style="width:150px">
		      </select>
			</p>
			<p>
				<input type="submit" value="添加">
			</p>
		</form>
	</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>删除岗位</title>
<link href="../css/css.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../js/jquery.js"></script>

</head>
<body>
	<div class="whole">
		<p><h2>删除岗位</h2>&nbsp;</p>
		<form name="form1">
		<p>
		  <label for="select">选择部门</label> <select name="deptno" id="deptno"
					onchange="delJob();">
					<option value="0">----请选择部门----</option>
					<c:forEach var="dept" items="${showDept}">
						<option value="${dept.deptno}">${dept.dname }</option>

					</c:forEach>

				</select> 选择要删除的岗位: <select name="jobid" id="select2">
					<option value="0">-----请选择岗位----</option>
					<c:forEach var="job" items="${jobs}">
						<option value="${job.jobid}">${job.job }</option>

					</c:forEach>

				</select>
			</p>
			<p>
				<button onclick="del();">删除选中的岗位</button>
			</p>
		</form>
	</div>
	<script>
		//
		function delJob() {
			var val = document.getElementById("deptno").value;
			window.location.href = "ajax_listJob.action?deptno=" + val;
		}
		function del() {

			form = document.forms["form1"];
			form.action = "deljobact.action";
			form.submit();

		}
	</script>
</body>
</html>

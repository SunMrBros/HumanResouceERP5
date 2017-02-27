<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>添加员工信息</title>
<link href="../css/css.css" rel="stylesheet" type="text/css">
<script src="../js/jquery.js"></script>
<script src="../js/reg.js" /></script>
<script src="../js/calendar.js"></script>
<script src="../js/addhuminit.js"></script>

<script>
	window.onload = function() {
		initdept();

	}
</script>
</head>

<body>
	<div class="whole">

		<form enctype="multipart/form-data" action="regist.action" method="post">
			<table width="709" height="775" border="1" align="center">
				<tr><td height="52" colspan="5"><font size="5">员工注册页面</font></td></tr>
				<tr>
					<td width="105">所属部门</td>
					<td width="184" height="41"><label for="select"></label> <select style="width:150px"
						name="deptno" id="deptno" onchange="initjob1()">
							<option>------选择部门------</option>
					</select></td>
					<td width="66">职位: <label for="select3"></label></td>
					<td width="202"><select name="jobid" id="job"  style="width:150px">
							<option>------选择岗位------</option>
					</select></td>
					<td width="118" colspan="2" rowspan="5" align="center">: <label
						for="textfield4"></label></td>
				</tr>
				<tr>
					<td>姓名:</td>
					<td height="39"><input type="text" name="name" id="name"></td>
					<td>性别:</td>
					<td><label for="textfield2"> <select name="sex"
							id="sex">
								<option value="男">男</option>
								<option value="女">女</option>
						</select>
					</label></td>
				</tr>
				<tr>
					<td>电话:</td>
					<td height="41"><label for="select2"> <input
							type="text" name="phone" id="textfield3">
					</label></td>
					<td><label for="textfield5">民族: </label></td>
					<td><input type="text" name="nation" id="textfield4"></td>
				</tr>
				<tr>
					<td>电子邮箱:</td>
					<td height="41"><label for="textfield2"></label> <input
						type="text" name="email" id="email" onBlur="chkemail()"></td>
					<td>入职时间</td>
					<td><input type="text" name="hiredate"
						onClick="fPopCalendar(event,this,this)" onFocus="this.select()"
						readonly /></td>
				</tr>
				<tr>
					<td>政治面貌:</td>
					<td height="36"><label for="textfield2"></label> <input
						type="text" name="politic" id="politic"></td>
					<td>学历: <label for="select4"></label></td>
					<td><select name="degree" id="select">
							<option value="中专">中专</option>
							<option value="大专">大专</option>
							<option value="本科">本科</option>
							<option value="研究生">研究生</option>
							<option value="博士">博士</option>
					</select></td>
				</tr>
				<tr>
					<td height="33" align="left">详细住址: <label for="textfield3"></label></td>
					<td height="33" colspan="5" align="left"><input type="text"
						name="address" id="addr"></td>
				</tr>
				<tr>
					<td height="104">个人履历: <label for="fileField"></label> <label
						for="textarea"></label></td>
					<td height="104" colspan="5"><textarea name="resume" cols="80"
							rows="10" id="resume"></textarea></td>
				</tr>
				<tr>
					<td height="142">家庭关系:</td>
					<td height="142" colspan="5"><textarea name="family" cols="80"
							rows="10" id="family"></textarea></td>
				</tr>
				<tr>
					<td height="142">备&nbsp;&nbsp;注:</td>
					<td colspan="5"><textarea name="mark" cols="80" rows="10"
							id="textarea"></textarea></td>
				</tr>
				<tr>
					<td height="45" colspan="6" align="right"><input type="submit"
						value="添加用户" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>

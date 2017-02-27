<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/css.css" rel="stylesheet" type="text/css">
<style>
	#show{
		color:red;
	}
</style>
<script src="../js/funs.js"></script>
</head>

<body>	
	<div class="whole">
		<center><h3>增加部门</h3></center>

		<form>
			<table width="493" align="center">
				<tr>
					<td width="170" height="52">要增加的部门名称</td>
					<td width="253"><input type="text" id="dname" name="dname"
						class="inp"></td>
				</tr>
				<tr>
					<td height="51">部门所在的位置</td>
					<td><input type="text" name="location" id="loc" class="inp" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td><td><span id="show"></span></td>
				</tr>
				<tr>
					<td height="78" colspan="2"><input type="submit" id="button"
						value="添加" onclick="sub();" /></td>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>

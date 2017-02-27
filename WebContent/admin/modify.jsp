<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工详细信息表</title>
<link href="../css/css.css" rel="stylesheet" type="text/css">
<script src="../js/jquery.js"></script>
<script src="../js/tab_odd_even.js"></script>
<script src="../js/addhuminit.js"></script>
<script language="javascript" type="text/javascript">
	$(document).ready(function(e) {
		$("#whole").slideDown();
		initdept();
	});
</script>
</head>
<body>
<div class="whole" style="display:none">
  <form action="update" method="post" > 
 
     	<center> <h2>员工信息修改</h2></center>
        
    <table width="827" border="1" id="table2" align="center">
     
      
      <tr>
        <td width="113" height="49">员工编号</td>
        <td width="168"><input type="text" name="empno" readonly value="${human.empno }"/></td>
        <td width="78">部门编号</td>
        <td width="177">${human.deptno }
          <select id="deptno"  onchange="initjob1()" style="width:150px;height:25px">
			<option >请选择部门</option>
						</select></td>
        <td width="83">岗位编号</td>
        <td width="168">${human.jobid }<select name="jobid" id="job" style="width:150px;height:25px">
								<option value="0" selected="selected">选择岗位</option>
						</select></td>
      </tr>
      <tr>
        <td height="51">姓名 </td>
        
        <td><input type="text" name="name" value="${human.name }" readonly/></td>
        <td>性别</td>
        <td><input type="text" name="sex" value="${human.sex }"></td>
        <td>电话</td>
        <td><input type="text" name="phone" value="${human.phone }"></td>
      </tr>
      <tr>
        <td height="47">邮箱</td>
        <td><input type="text" name="email" value="${human.email }"></td>
        <td>民族</td>
        <td><input type="text" name="nation" value="${human.nation }"></td>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td height="43">政治面貌</td>
        <td><input type="text" name="politic" value="${human.politic }"></td>
        <td>学历</td>
        <td><input type="text" name="degree" value="${human.degree }"></td>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td height="39">住址</td>
        <td colspan="5" align="left"><input type="text" name="address" value="${human.address }" style="width:650px;"></td>
      </tr>
      <tr>
        <td height="108" align="left">家庭情况</td>
        <td colspan="5" align="left" valign="middle"><label for="textarea"></label>
          <textarea name="family" id="textarea" cols="90" rows="10">${human.family }</textarea></td>
      </tr>
      <tr>
        <td height="113" align="left">工作经历</td>
        <td colspan="5"><textarea name="resume" id="family" cols="90" rows="10">${human.resume }</textarea></td>
      </tr>
      <tr>
        <td height="89" align="left">备注</td>
        <td colspan="5"><textarea name="mark" id="family2" cols="90" rows="10">${human.mark }</textarea></td>
      </tr>
      <tr>
        <td height="26" align="left">入职时间</td>
        <td colspan="5"><input type="text" name="hiredate" value="${human.hiredate }"/></td>
      </tr>
      <tr>
        <td height="57" colspan="6" align="left"><input type="submit" value="确认修改"></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>

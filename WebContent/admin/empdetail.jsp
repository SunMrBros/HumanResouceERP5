<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工详细信息表</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery.js"></script>
<script src="../js/tab_odd_even.js"></script>

<script language="javascript">

	$(document).ready(function(e) {
        $("#whole").slideDown();
    });
</script>

</head>
<body>
	<div class="whole" id="whole">
   	  <catpion align="center"><h2>员工详细信息</h2></caption>
        
        <table width="827" border="1" id="table2" align="center">
  <tr >
    <td width="112" height="49">员工编号</td>
    <td width="134">${human.empno }</td>
    <td width="95">部门编号</td>
    <td width="115">${human.deptno }</td>
    <td width="114">岗位编号</td>
    <td width="217">${human.jobid }</td>
  </tr>
  <tr>
    <td height="51">姓名</td>
    <td>${human.name }</td>
    <td>性别</td>
    <td>${human.sex }</td>
    <td>电话</td>
    <td>${human.phone }</td>
    </tr>
  <tr>
    <td height="47">邮箱</td>
    <td>${human.email } </td>
    <td>民族</td>
    <td>${human.nation }</td>
    <td colspan="2">&nbsp;</td>
    </tr>
  <tr>
    <td height="43">政治面貌</td>
    <td>${human.politic }</td>
    <td>学历</td>
    <td>${human.degree }</td>
    <td colspan="2">&nbsp;</td>
    </tr>
  <tr>
    <td height="39">住址</td>
    <td colspan="5" align="left" >${human.address }</td>
    </tr>
  <tr>
    <td height="108" align="left" >家庭情况</td>
    <td colspan="5" align="left" valign="middle">${human.family }</td>
    </tr>
  <tr>
    <td height="113" align="left" >工作经历</td>
    <td colspan="5">${human.resume }</td>
    </tr>
  <tr>
    <td height="89" align="left">备注</td>
    <td colspan="5">${human.mark }</td>
  </tr>
  <tr>
    <td height="26" align="left">入职时间</td>
    <td colspan="5">${human.hiredate }</td>
    </tr>
</table>

    </div>
</body>
</html>

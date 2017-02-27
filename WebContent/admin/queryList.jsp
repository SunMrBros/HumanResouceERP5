<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery.js"></script>
<script src="../js/tab_odd_even.js"></script>
</head>
<body>
<div class="whole">
  <center>
    <h3>查询结果</h3>
  </center>
  <table id="table2" width="1034" height="119" border="1">
    <caption>
    <span>员工信息表</span>
    </caption>
    <tr id="fist">
      <td width="80" height="64">员工编号</td>
      <td width="102">姓名</td>
      <td width="60">性别</td>
      <td width="120">电话</td>
      <td width="103">所属部门</td>
      <td width="106">岗位</td>
      <td width="130">住址</td>
      <td width="127">操作</td>
    </tr>
    <c:forEach var="human" items="${list}">
      <tr>
        <td height="20">${human.empno}</td>
        <td><a href="huminfo.action?empno=${human.empno}">${human.name}</a> </td>
        <td>${human.sex}</td>
        <td>${human.phone}</td>
        <td>${human.dname}</td>
        <td>${human.job}</td>
        <td>${human.address}</td>
        <td><a href="modify?empno=${human.empno }">修改</a> <a
							href="delete?empno=${human.empno }">删除</a></td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
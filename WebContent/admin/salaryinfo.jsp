<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="../css/css.css"/>
<style type="text/css">
.whole .top {
	height: 50px;
}
</style>
<title>员工工资信息</title>

</head>
<body>
<div class="whole">
  <div class="top">
    <center>
      <h2>岗位与工资级别设置</h2>
    </center>
  </div>
  <div class="show">
    <form method="post" action="change">
      <table width="821" border="1" align="center" style="text-align: center">
        <tr>
          <td width="76" height="50">编号</td>
          <td width="108">岗位编号</td>
          <td width="163">岗位名称</td>
          <td width="120">工资级别</td>
          <td width="128">工资金额</td>
          <td width="186">操作</td>
        </tr>
        <c:forEach var="salinfo" items="${salinfo}">
          <tr>
            <td height="31">${salinfo.id}</td>
            <td>${salinfo.jobid}</td>
            <td>${salinfo.job}</td>
            <td>${salinfo.leval}</td>
            <td>${salinfo.money}</td>
            <td><a href="modsal.action?jobid=${salinfo.jobid}">更改工资级别</a></td>
          </tr>
        </c:forEach>
      </table>
    </form>
  </div>
</div>  
</body>
</html>
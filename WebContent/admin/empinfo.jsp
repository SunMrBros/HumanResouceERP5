<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工信息表</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery.js"></script>
<script src="../js/tab_odd_even.js"></script>

<script src="../js/addhuminit.js"></script>
<script>
var flag = true;
	$(document).ready(function(){
		
		initdept();
	});
	
	function show() {
		if (flag) {
			$("#more").show("slow");
			flag = !flag;
		} else {
			$("#more").hide("slow");
			flag = !flag;
		}
		
	}
	function sub() {
		var eno = document.getElementById("eno").value;
		var ena = document.getElementById("ena").value;
		if (eno.length == 0) {
			//如果为空则根据ename来查询,否则优先empno查询
			if (ena != "") {
				document.forms[0].action = "queryByName.action?ename="
						+ encodeURI(encodeURI(ena));
				document.forms[0].submit();
			} else {
				alert("	请输入员工姓名");
				return;
			}
		} else {
			if (isNaN(eno)) {
				alert("员工编号为数字");
				return;
			} else {
				
				document.forms[0].action = "queryById.action?empno=" + eno;
				document.forms[0].submit();
			}
		}
	}
	function del(no){
		if(confirm("确定删除编号'"+no+"'员工")){
			window.location.href="delete.action?empno="+no;
		}else{
			return;
		}
	}

</script>
</head>
<body>
	<div class="whole">
		<div class="search">
			<h4>条件查询</h4>
			<form name="form1" method="post">
				<table style="float: left; margin-right: 50px; clear: right">

					<tr>
						<td width="96">员工编号:</td>
						<td width="196"><input id="eno" type="text" /></td>
						<td width="82">员工姓名:</td>
						<td width="174"><input id="ena" type="text" /></td>
						<td width="47"><button style="width: 100px; height: 25px;"
								onclick="sub();">查询</button></td>
					</tr>

				</table>
			</form>
			<p>
				<button style="width: 100px; height: 25px;" onclick="show()">详细查询</button>
			</p>
		</div>
		<div id="more" style="display:none;">
			<form name="form2" method="post" action="queryByJobId.action">
				<table width="611">
					<tr>
						<td width="91" height="41">部门名称:</td>
						<td width="113"><select id="deptno"  onchange="initjob1()" style="width:150px;">
								<option >请选择部门</option>
						</select></td>
						<td width="105">岗位名称:</td>
						<td width="126"><select name="jobid" id="job" style="width:150px;">
								<option value="0" selected="selected">选择岗位</option>
						</select></td>
						<td width="119"><input type="submit" value="查询" /></td>
					</tr>

				</table>
			</form>
		</div>
		<div>
			<table id="table2" width="1034" height="119" border="1">
				<caption>
					<span>员工信息表</span>
				</caption>
				<tr id="fist">
					<td width="107" height="64">员工编号</td>
					<td width="93">姓名</td>
					<td width="86">性别</td>
					<td width="106">电话</td>
					<td width="129">所属部门</td>
					<td width="100">岗位</td>
					<td width="276">住址</td>
					<td width="85">操作</td>
				</tr>
				<c:forEach var="human" items="${list}">
					<tr>
						<td height="20">${human.empno}</td>
						<td><a href="huminfo.action?empno=${human.empno}">${human.name}</a>
							</td>
						<td>${human.sex}</td>
						<td>${human.phone}</td>
						<td>${human.dname}</td>
						<td>${human.job}</td>
						<td>${human.address}</td>
						<td><a href="modify?empno=${human.empno }">修改</a> <a
							href="javascript:void(0)" onclick="del(${human.empno})">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="page">
			共${pageCount }页 当前第${pageNow }页
			<button
				onclick="window.location.href='pageUp.action?pageNow=${pageNow}'">上一页</button>
			<button
				onclick="window.location.href='pageDown.action?pageNow=${pageNow}'">下一页</button>
		</div>
	</div>
</body>
</html>

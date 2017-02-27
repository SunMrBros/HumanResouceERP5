<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERROR Page!!</title>
<link href="../css/css.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="whole">
	<h2>ErrorPage!!</h2>
	<center style="line-height:2.8em"><font color="red" size="3">${ msg }
	${ msg2 }</font></center>
	<br>
	<input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回上一页">
</div>

</body>
</html>
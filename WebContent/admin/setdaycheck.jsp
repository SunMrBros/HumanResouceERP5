<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考勤设置页</title>
<link href="../css/css.css"/>
</head>
<body>
	<div class="whole">
    	<div class="top">
        	<center><h2>上班打卡时间</h2></center>
        </div>
        <div>
        	<form action="setTime" method="post">
           	  <table width="629" align="center" border="0" style="text-align:center">
  <tr>
    <td width="215" height="52">&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td height="47">设置打卡时间</td>
    <td width="233"><label for="textfield"></label>
      <input type="text" name="time" id="time" style="float:left;height:25px;"></td>
    <td width="159"><font color="red">格式&nbsp;&nbsp;HH:mm:ss</font></td>
  </tr>
  <tr>
    <td colspan="2" height="54"><input type="submit" value="提交修改"/></td>
   
  </tr>
</table>

            </form>
        </div>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  type="text/css" href="../css/css.css" />
<title>薪资设置</title>
</head>
<body>
<DIV class="whole">
  <center>
    <h3>薪资设置</h3>
  </center>
  <form name="form1" method="post" action="makechange">
    <table width="653" border="1" align="center" style="text-align:center">
      <tr>
        <td width="184" height="39">基本工资1</td>
        <td width="453"><input type="text" name="setting.base1" value="${set.base1}"></td>
      </tr>
      <tr>
        <td height="41">基本工资1</td>
        <td><label for="textfield"></label>
          <input type="text" name="setting.base2" value="${set.base2}"></td>
      </tr>
      <tr>
        <td height="44">基本工资3</td>
        <td><input type="text" name="setting.base3" value="${set.base3}"></td>
      </tr>
      <tr>
        <td height="44">基本工资4</td>
        <td><input type="text" name="setting.base4" value="${set.base4}"></td>
      </tr>
      <tr>
        <td height="44">其他奖励</td>
        <td><input type="text" name="setting.other" value="${set.other}"></td>
      </tr>
      <tr>
        <td height="37">全勤奖励</td>
        <td><input type="text" name="setting.quanqin" value="${set.quanqin}" ></td>
      </tr>
      <tr>
        <td height="48">迟到一次罚款</td>
        <td><input type="text" name="setting.fakuan" value="${set.fakuan}" ></td>
      </tr>
      <tr>
        <td height="48">&nbsp;</td>
        <td><input type="submit" id="button" value="提交更改"></td>
      </tr>
    </table>
  </form>
</DIV>
</body>
</html>
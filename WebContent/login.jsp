<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登录界面</title>
<style type="text/css">
.whole {
	background-image: url(images/login_06.gif);
	background-repeat: repeat-y;
	height: 700px;
	margin-right: auto;
	margin-left: auto;
	width: 1000px;
	top: 300px;
}
.mid {
	height: 500px;
	background-image: url(images/login_09.jpg);
	background-repeat: no-repeat;
}
.whole .mid {
	position: relative;
	top: 150px;
	left: 250px;
	width:480px;
	height:300px;
	padding-top: 100px;
	padding-left: 110px;
	font-size: 14px;
}
.whole .mid form table tr td #in {
	height: 22px;
	border: thin solid #cdcdcd;
	width: 200px;
}
.whole .mid form table tr td #ma {
	border: thin solid #cdcdcd;
	width: 50px;
	height: 20px;
}
.whole .mid form table tr td #but {
	background-image: url(images/login_05_03.gif);
	background-repeat: no-repeat;
	height: 27px;
	width: 81px;
}
</style>
</head>

<body>
<div class="whole">
  <div class="mid">
    <form method="post" action="login">
      <table width="339" height="176" border="0">
        <tr>
          <td width="61" height="43" align="right">用户名:</td>
          <td colspan="2"><label for="name"></label>
          <input type="text" name="name" id="in"></td>
        </tr>
        <tr>
          <td height="38" align="right">密码</td>
          <td colspan="2"><label for="textfield2"></label>
          <input type="password" name="pass" id="in"></td>
        </tr>
        <tr>
          <td height="36" align="right">验证码</td>
          <td width="80"><label for="textfield2"></label>
          <input type="text" name="checkCode" id="ma"></td>
          <td width="184"><img src="createImageAction.action" onclick="this.src='createImageAction.action?'+ Math.random()" title="点击图片刷新验证码"/>
          <span style="color:red;font-size:12px;">${yanzm }</span></td>
        </tr>
        <tr>
          <td height="49" align="right">&nbsp;</td>
          <td colspan="2" align="left"><input type="submit" id="but" value=" "> </td>
        </tr>
      </table>
    </form>
  </div>
</div>
</body>
</html>

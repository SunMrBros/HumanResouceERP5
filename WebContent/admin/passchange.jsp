
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>密码修改</title>
<link href="../css/css.css" rel="stylesheet" type="text/css"/>
<script>
	function checkpass(){
			var pass1=document.getElementById("renew").value;
			var pass2=document.getElementById("new").value;
			
			if(pass1!=''&&pass1==pass2){
				var f = document.forms[0];
				f.action = "passchange.action?password="+pass1+"&id=${id }";
				f.submit();
										
				}else{
						alert("两次输入密码不同");
					}
		}
</script>

</head>

<body>
	<div class="whole">
    	<form method="post">
    	密码修改界面
        <table width="339" height="157" align="center">
        	<tr><td align="right">新密码:</td><td><input type="password" id="renew"/></td></tr>
            <tr><td align="right">密码确认:</td><td><input type="password" id="new" /></td></tr>
          
            <tr><td></td><td><input type="submit" value="确认" onclick="checkpass()"/>&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="重填"/></td></tr>
        </table>
        
        </form>
    </div>
</body>
</html>

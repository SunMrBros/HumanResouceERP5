<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" href="../css/css.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工资级别修改页</title>
<script>
	window.onload=function(){
			var xmlhttp;
			if(window.XMLHttpRequest){
				xmlhttp=new XMLHttpRequest();
				
				}else{
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
					}
					xmlhttp.onreadystatechange=function(){
						
						if(xmlhttp.readyState ==4&&xmlhttp.status==200){
							
							var txt=xmlhttp.responseText;
							var data=eval("(" + txt + ")");
							initselect(data);
							}
						}
					xmlhttp.open("get","initsal.action",true);
					xmlhttp.send(null);
		}
		function initselect(obj){
				
				var sel=document.getElementById("salary");
				sel.innerHTML="";
				for(var i=0;i<obj.length;i++){
					var op=document.createElement("option");
					op.innerHTML="工资"+obj[i].money+"-->级别"+obj[i].leval;
					op.value=obj[i].leval;
					sel.appendChild(op);
				}
			}
</script>
</head>
<body>
<div class="whole">
  <div class="top">
    <center>
      <h2>工资等级修改</h2>
    </center>
  </div>
  <div class="show">
    <form name="form1" method="post" action="upmodsal">
      <table width="496" border="1" style="text-align:center" align="center">
        <tr>
          <td width="123" height="40">岗位编号</td>
          <td width="220"><input name="salset.jobid" type="text" value="${salset.jobid}" style="border:none;width:50px;height:20px;text-align:center"readonly>${salset.job}</td>
        </tr>
        <tr>
          <td height="35">工资级别</td>
          <td>${salset.level}</td>
        </tr>
        <tr>
          <td height="34">工资级别修改为:</td>
          <td><label for="select"></label>
            <select name="salset.level" id="salary" style="width:150px;">
            </select></td>
        </tr>
        <tr>
          <td height="43">&nbsp;</td>
          <td><input type="submit" value="提交修改"/>
            &nbsp;</td>
        </tr>
      </table>
    </form>
  </div>
</div>
</body>
</html>
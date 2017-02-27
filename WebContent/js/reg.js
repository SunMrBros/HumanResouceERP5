

function chkname(){
		var name=document.getElementById("name").value;
		if(name==""){
			alert("名字不能为空!");
			return;
			}
	}
function chkemail(){
	 var temp = document.getElementById("email");
             var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
             if(!myreg.test(temp.value))
             {
                  alert("邮箱格式不正确!");
                 temp.focus();
                  return false;
             }
    }

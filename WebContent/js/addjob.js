function getXmlhttp() {
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();

	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}

window.onload = function() {
	var xmlhttp = getXmlhttp();

	xmlhttp.onreadystatechange = function() {

		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

			var txt = xmlhttp.responseText;
			var data = eval("(" + txt + ")");
			initselect(data);
		}
	};
	xmlhttp.open("get", "initsal.action", true);
	xmlhttp.send(null);
};
function initselect(obj) {

	var sel = document.getElementById("salary");
	sel.innerHTML = "";
	for ( var i = 0; i < obj.length; i++) {
		var op = document.createElement("option");
		op.innerHTML = "工资" + obj[i].money + "-->级别" + obj[i].leval;
		op.value = obj[i].leval;
		sel.appendChild(op);
	}
}

$(document).ready(function() {
	$("#table2 tr:odd").addClass("odd");
	$("#table2 tr:even").addClass("even");
});
function trim(str){ 
    return str.replace(/(\s*$)/g, ""); 
}
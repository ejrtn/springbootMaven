function join(a){
	if(a==1)
$("#join").css("background-color","#9e9e9e8c");
	else
$("#join").css("background-color","");
}
function idpw(a){
	if(a==1)
$("#idpw").css("background-color","#9e9e9e8c");
	else
$("#idpw").css("background-color","");
}
function info(a){
	if(a==1)
$("#info").css("background-color","#9e9e9e8c");
	else
$("#info").css("background-color","");
}
function joinclick(){
	document.getElementById("modal1").style.display="block";
}
function idpwclick(){
	
}
function infoclick(){
	
}

$(function(){
$("#header").load("header.html")
})

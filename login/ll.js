
function validate()
{
var username = document.getElementById("username").value;
var password = document.getElementById("password").value;
if ( username == "" || password == "")
{
	alert("enter details");
return false;
}
else if ( username == "form" && password == "formg")
{

window.location="helo.html";
}
else
{
	alert("invalid details");
}
}
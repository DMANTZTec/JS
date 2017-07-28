function Submit(){
 var emailRegex= /^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,5}$/;
var ph=  new RegExp("^[0-9]{10}$");
 var fname = document.form.first.value,
  lname = document.form.last.value,
  femail = document.form.email.value,
  fpassword = document.form.pass.value,
rpass=document.form.rpass.value,
  fmonth = document.form.DOBMonth.value,
  fday = document.form.DOBDay.value,
  fyear = document.form.DOBYear.value,
fcount=document.form.country.value,
fcountry=document.form.country.selectedIndex,
fc= document.form.c.value,
fm=document.form.DOBMonth.selectedIndex,
fd=document.form.DOBDay.selectedIndex,
fy=document.form.DOBYear.selectedIndex,
fg=document.form.gender.selectedIndex,
fcou=document.form.c.selectedIndex,
fph=document.form.tel.value;

   
 if( fname == "" )
   {
     document.form.first.focus() ;
  document.getElementById("errorBox").innerHTML = "enter the first name";
     return false;
   }
 if( lname == "" )
   {
     document.form.last.focus() ;
   document.getElementById("errorBox").innerHTML = "enter the last name";
     return false;
   }
    
   if (femail == "" )
 {
  document.form.email.focus();
  document.getElementById("errorBox").innerHTML = "enter the email";
  return false;
  }
else if(!emailRegex.test(femail)){
  document.form.email.focus();
  document.getElementById("errorBox").innerHTML = "enter the valid email";
  return false;
  }
   
 if(fpassword == "")
  {
   document.form.pass.focus();
   document.getElementById("errorBox").innerHTML = "enter the password";
   return false;
  }
if(rpass=="")
{
document.form.rpass.focus();
document.getElementById("errorBox").innerHTML="enter confirm password";
return false;
}

   
  if(rpass !=  fpassword){
   document.form.pass.focus();
   document.getElementById("errorBox").innerHTML = "passwords are not matching, re-enter again";
   return false;
   }
   if (fm == "") {
        document.form.DOBMonth.focus();
  document.getElementById("errorBox").innerHTML = "select the birthday month";
        return false;
     }
  if (fd == "") {
        document.form.DOBDay.focus();
  document.getElementById("errorBox").innerHTML = "select the birthday day";
        return false;
     }
  if (fy == "") {
        document.form.DOBYear.focus();
  document.getElementById("errorBox").innerHTML = "select the birthday year";
        return false;
     }
  if(fg=="")
{
    document.getElementById("errorBox").innerHTML = "select your gender";
    return false;
   }
if(fcou=="")
{
document.form.c.focus();
document.getElementById("errorBox").innerHTML = "select country code";
return false;
}
if(fph=="")
{
document.form.tel.focus();
document.getElementById("errorBox").innerHTML = "enter mobile number";
return false;
}
else if(!ph.test(fph))
{
document.form.tel.focus();
  document.getElementById("errorBox").innerHTML = "enter the valid phone number";
  return false;
  }
if(fcountry=="")
{
document.form.country.focus();
document.getElementById("errorBox").innerHTML = "enter your country";
return false;
}

  if(fname != '' && lname != '' && femail != '' && fpassword != '' && rpass != '' && fm != '' && fd != '' && fy != '' && fg != '' && fcou!='' && fph!='' && fcountry!=''){
   document.getElementById("errorBox").innerHTML = "form submitted successfully";
   }
     
}
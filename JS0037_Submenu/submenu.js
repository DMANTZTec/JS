$(document).ready(function() {
 
$("#menu").click(function(){
  if($(this).attr("class") == "noactive")
  { 
    $(this).removeClass("noactive");         
    $("#submenu li").addClass("activeli");
  }
  else
  { 
    $(this).addClass("noactive");
    $("#submenu li").removeClass("activeli");
  }
  
});
});
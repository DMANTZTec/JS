console.log('hi')

$(document).ready(()=>{
$.get(' https://fmt0waurlb.execute-api.ap-south-1.amazonaws.com/items').then((data)=>{
  console.log(data)
}).catch (e);{
    statusCode = 400;
    body = err.message;
  } try {
    body = JSON.stringify(body);
  }

  finally {
    statusCode,
    body,
    headers
  };

});


console.log('bi')
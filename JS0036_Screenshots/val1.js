function getScreenshot() {
    html2canvas(document.body, {
      onrendered: function(canvas) {
      $('#box1').html("");
      $('#box1').append(canvas);


$('#test').attr('href', canvas.toDataURL("image/png"));
        $('#test').attr('download','Test file.png');
        $('#test')[0].click();			
       
      }
    });
}
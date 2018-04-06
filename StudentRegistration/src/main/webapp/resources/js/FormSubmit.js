$('#form').on('submit', function(e) { 
        debugger;
              e.preventDefault(); 
	
              $('#loadingmessage').show();
		
              var formData = new FormData(this);
              formData=$('#form').serialize();
              var url=$(this).attr('action');
              $.ajax({ url : url || window.location.pathname, 
                   type: "POST", 
                   data: formData,
                   enctype: 'multipart/form-data',
                  
                /*async: false,
              cache: false,
              contentType: false,
              enctype: 'multipart/form-data',
              processData: false,*/
                      success: function (data) { 
               		debugger;
               	 $('#loadingmessage').hide();
               			console.log(data);
               		
                      $("#frame_div").html(data);
                      
                   }, 
               error: function (jXHR, textStatus, errorThrown) {
            	   debugger;
                      console.log(textStatus+jXHR+errorThrown)
                   } 
          });
		


});
/*
formSubmit(formId)
{
	debugger;
    e.preventDefault(); 

    $('#loadingmessage').show();

    var formData = new FormData(this);
    
    $.ajax({ url : $("#formId").attr('action') || window.location.pathname, 
         type: "POST", 
         data: formData,
      async: false,
    cache: false,
    contentType: false,
    enctype: 'multipart/form-data',
    processData: false,
            success: function (data) { 
     		debugger;
     	 $('#loadingmessage').hide();
     			console.log(data);
     		
            $("#frame_div").html(data);
            
         }, 
     error: function (jXHR, textStatus, errorThrown) {
  	   debugger;
            console.log(textStatus+jXHR+errorThrown)
         } 
});



}*/
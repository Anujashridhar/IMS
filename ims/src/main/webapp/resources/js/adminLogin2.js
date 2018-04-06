 function doAjaxPost() {
	 alert("hii IN METHOD CALL");
        // get the form values
debugger;
	        var userid = $('#userid').val();
	        var password = $('#password').val();
	        $.ajax({
	     type: "POST",
	        url: "login",
	        data: "userId=" + userid + "&password=" + password,
	        success: function(response){
	        	alert(response.status);
	        // we have the response
	      /*  $('#userid').val('');
	        $('#password').val('');
	       */ 
	        if(response.status == true)	
	        	{
	        	 alert("hii"+response.forwardUrl);
	        	 getContent("dashboard");
	        	}else{
	        		getContent(dashboard);
	        	}
	        	alert('sucess: done'+userid+password );
	        },
	        error: function(e){
	        alert('Error: ' + e);
	
	        }
	     });
	
 }

	
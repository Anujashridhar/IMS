 function doAjaxPost() {

        // get the form values

	        var userid = $('#userid').val();
	        var password = $('#password').val();
	        $.ajax({
	     type: "POST",
	        url: "rest/login",
	        data: "userId=" + userid + "&password=" + password,
	        success: function(response){
	        	//alert(response.status);
	        // we have the response
	      /*  $('#userid').val('');
	        $('#password').val('');
	       */ 
	        if(response.status == true)	
	        	{
	        	 //alert("hii");
	        	 window.location.replace("dashboard");
	        	 //window.location.replace("SiteRegistration");
	        	}else{
	        		 window.location.replace("LoginForm");
	        	}
	        	//alert('sucess: done'+userid+password );
	        },
	        error: function(e){
	        alert('Error: ' + e);
	
	        }
	     });
	
 }

	
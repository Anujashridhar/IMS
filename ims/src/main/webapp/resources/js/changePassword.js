/*$(document).ready(function() {
	alert("CP");
*/

function validateChangePassword()
{
	//alert("change password");
var valid = 0;

var newPass=$("#new_password").val();
var confPass=$("#confirm_password").val();


if (newPass != "") {
	 if (($("#new_password").val()) != ($("#confirm_password").val())) {
   	$("#errMessageNewP").html("New and confirm password field should be same").show();
   	valid =1;
   }
   else {
   	valid = 0;
   }
   
}
else if (newPass == "") {
	 //document.getElementById("errMessageNewP").style.display = "inline";
   	$("#errMessageNewP").html("New password field cannot be blank").show();
   	valid =1;
   }

if (confPass != "") {
	 if (($("#new_password").val()) != ($("#confirm_password").val())) {
    	$("#errMessageConfP").html("New and confirm password field should be same").show();
    	valid =1;
    }
    else {
    	valid = 0;
    }
 }else{
	  $("#errMessageConfP").html("Confirm password field cannot be blank").show();
   	valid =1;
 }

    
if (valid == 0) {
	// alert("valid 0");
	 document.getElementById('form1').onsubmit = function() {
		    return true;
		};
	// verifyPassword(password,"VerifyPassword.do");
}
  else if(valid == 1)
	  {
	 // alert("valid 1");
	  document.getElementById('form1').onsubmit = function() {
		    return false;
		};
	  }

}

	 /*$('#form').on('submit', function(e) { 
		 alert("submit");
         debugger;
           e.preventDefault(); 
           var valid = 0;
           var newPass=$("#new_password").val();
           var confPass=$("#confirm_password").val();

           alert("new"+newPass);
           alert("conP"+confPass);

      
         if (newPass != "") {
		    if (($("#new_password").val()) != ($("#confirm_password").val())) {
		    	$("#errMessageNewP").html("new and confirm password field should be same").show();
		    	valid =1;
		    }
		    else {
		    	valid = 0;
		    }
		    
         }
         else if (newPass == "") {
        	 alert("klwjc");
		    	$("#errMessageNewP").html("New password field cannot be blank").show();
		    	valid =1;
		    }
        
         if (confPass != "") {
        	 if (($("#new_password").val()) != ($("#confirm_password").val())) {
 		    	$("#errMessageNewP").html("New and confirm password field should be same").show();
 		    	valid =1;
 		    }
 		    else {
 		    	valid = 0;
 		    }
          }else{
        	  $("#errMessageNewP").html("Confirm password field cannot be blank").show();
		    	valid =1;
          }
      
             
       if (valid == 0) {
    	   verifyPassword(password,"VerifyPassword.do");
         }
     });
         	 
});	    	 */
	    	 
	    	 
	    	 
	    	 

function checkedPassword() {
	alert("checked password");
	if ($('#old_password').hasClass("has-error")) {
		$('#old_password').css("border-color","#00695c");		
		$('#old_password').removeClass('has-error');
        $('#old_password').removeClass("dirty");        
        $('#old_password').attr("aria-required","false");
		$('#old_password').attr("aria-invalid","false");
		$('#old_password').attr("aria-describedby","false");
		$('#state-error-old').fadeOut();
	}
	$('#old_password').css("border-color","#00695c"); 
	$('#confirm_password').attr("disabled", false);
	$('#new_password').attr("disabled", false);
	$('#new_password').focus();
	var o = $('#old_password').val();
	var n = $('#new_password').val();
	var c = $('#confirm_password').val();
	 
	if (o != "" && n != "" && c != "") {
		if (!$('#old_password').hasClass("has-error") && n == c ) {
    		$('#submit').attr("disabled",false);
		} else {
    		$('#submit').attr("disabled",true);    			
		}
	} else {
		$('#submit').attr("disabled",true);
	}
}

function passwordNotFound () {
	alert("password not found");
		$('#old_password').css("border-color","red");		
		$('#old_password').addClass('has-error');
	    $('#old_password').addClass("dirty");        
	    $('#old_password').attr("aria-required","true");
		$('#old_password').attr("aria-invalid","true");
		$('#old_password').attr("aria-describedby","state-error-old");
		$('#old_password').after('<span id="state-error-old" class="help-block" style="color:#ff0000;opacity:80">Invalid Password.</span>');
		$('#confirm_password').attr("disabled", true);
		$('#new_password').attr("disabled", true);
		$('#submit').attr("disabled",true);
}
function verifyPassword(password,url) {
	alert("verify password");
	$.ajax({
		
		type: "POST",

		url: url,
		
		data:  {password:password},
					
		timeout:30000,
		
		cache : false,
		
		success: function (data) {
				if (data == "true") {
					checkedPassword();
				} else {
					passwordNotFound();				
				}
		},

		 error: function(xhr, status, error) {
			 //console.log(xhr.responseText);  
			   
			 }

		});
}
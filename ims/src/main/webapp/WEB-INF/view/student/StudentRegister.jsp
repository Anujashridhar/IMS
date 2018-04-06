<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link href="resources/css/registration.css"	rel="stylesheet">

</head>
<body>
    <div class="container" align="center">

    <form:form class="well form-horizontal" action="StudentRegistration" method="post"  id="contact_form" modelAttribute="studentobjects">
<fieldset>

<!-- Form Name -->
<legend><center><h2><b>Student Registration</b></h2></center></legend><br>
<div align="left">
    <label for="usrname">Full Name</label>
    <form:input type="text" path="studentname" required="required" />
    <label for="usrname">Email id</label>
    <form:input type="email" path="studentemailid" required="required" />
	<label for="usrname">Contact Number</label>
    <form:input type="number" path="studentcontactnumber" required="required" />
<label for="psw">Password</label>
<form:input type="password" id="psw" name="psw" path="studentpassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required="required" />
	<div id="message">
  <h3>Password must contain the following:</h3>
  <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
  <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
  <p id="number" class="invalid">A <b>number</b></p>
  <p id="length" class="invalid">Minimum <b>8 characters</b></p>
</div>   
<label for="psw">Confirm Password</label>

<input type="password" id="confirmpassword" name="confirmpassword">
<span id='message2'></span>
<div id="passwordontmatch">
  <p id="letter" class="invalid"> <b>password</b> dont match</p>
</div>
    <center><input type="submit" value="Submit" style="width:50%;height:48px; font-size:20px"></center>
  </form:form>
 </div>
</div>				
<script>
var myInput = document.getElementById("psw");
var confirmpassword = document.getElementById("confirmpassword");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box

myInput.onfocus = function() {
    document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
    document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}

$('#confirmpassword').on('keyup', function () {
  if ($('#psw').val() == $('#confirmpassword').val()) {
    $('#message2').html('Matching').css('color', 'green');
  } else 
    $('#message2').html('Not Matching').css('color', 'red');
});
// password dont match 

</script>
</body>
</html>

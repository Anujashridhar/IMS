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
<p style="color: red;">${message }</p>
    <form:form class="well form-horizontal" action="get_verification_link" method="POST"  id="contact_form" >
    	<label >Please provide Email Id to get verification Link</label>
    	<input type="text" name="emailId"/>
    	<input type="submit" name='submit'>
      </form:form>
 </div>

</body>
</html>

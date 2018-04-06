<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
 
  
  
  <form method='post' id="formSite" action="" >
  <div class="panel panel-default">
  <div class="panel-heading">Panel heading without title</div>
  <div class="panel-body">
   
  <div class="row" align="right">
  <div class="card border-dark mb-3" style="max-width: 30rem;" align="left">
   <div class="card-body text-dark">
   <div class="card-header">Header</div>
		  <div class="form-group">
		    <label for="name">Name</label>
		    <input type="text" class="form-control" id="name" name="name" aria-describedby="" placeholder="">
		   <!--  <small id="name" class="form-text text-muted">We'll never share your details with anyone else.</small> -->
		  </div>
		  <div class="form-group">
		    <label for="contactNumber">Contact Number</label>
		    <input type="text" class="form-control" id="contactNumber" name="contactNumber" aria-describedby="" placeholder="">
	      </div>
	      <div class="form-group">
		    <label for="contactEmail">Contact Email</label>
		    <input type="text" class="form-control" id="contactEmail" name="contactEmail" aria-describedby="" placeholder="">
	      </div>
	      <div class="form-group">
		    <label for="addressCountry">Country</label>
		    <input type="text" class="form-control" id="addressCountry" name="addressCountry" aria-describedby="" placeholder="">
	      </div>
	      <div class="form-group">
		    <label for="addressState">State</label>
		    <input type="text" class="form-control" id="addressState" name="addressState" aria-describedby="" placeholder="">
	      </div>
	      <div class="form-group">
		    <label for="addressCity">City</label>
		    <input type="text" class="form-control" id="addressCity" name="addressCity" aria-describedby="" placeholder="">
	      </div>
	      <div class="form-group">
		    <label for="addressLine1">Address line1</label>
		    <input type="text" class="form-control" id="addressLine1" name="addressLine1" aria-describedby="" placeholder="">
	      </div>
	      <div class="form-group">
		    <label for="addressLine2">Address line2</label>
		    <input type="text" class="form-control" id="addressLine2" name="addressLine2" aria-describedby="" placeholder="">
	      </div>
	      <div class="form-group">
		    <label for="pincode">Pincode</label>
		    <input type="text" class="form-control" id="pincode" name="pincode" aria-describedby="" placeholder="">
	      </div>
	     <!--  <div class="form_group">
	      	<label for="zipcode">Zipcode</label>
	      	<input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="" />
	      </div> -->
  
     <button type="button" class="btn btn-primary">Submit</button>
     </div>
   </div>
    </div>
 </div>
</div>
  </form>
</div>
<!-- /wrap -->
</body>
</html>
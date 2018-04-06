<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
	<script src="resources/js/siteRegistration.js"></script>
<title>Campus Registration</title>
<link href="resources/css/campus.css" rel="stylesheet">

</head>
<body>
<div class="wrapper" id="wrapper">
	<img name="slide" class="bgimg" src="resources/image/background3.jpg">
	<!-- <h1>Hello !</h1> -->
	<div class="header">
		<div class="header content">
			<img class="logo logo-w" src="resources/image/index.png" alt="cdac">
			<span class="signout-button"> <a id="link-signout"
				class="i-button i-button-signout" href="logout">Sign out</a>
			</span>
		</div>
	</div>

	<div class="main">
		<h1>Campus Registration</h1>
		<div class="clearfix">
			<div class="sign-up">
				<div class="signup-box">
				<form:form method='post' id="formSite" action="saveSiteRegistration" modelAttribute="site">
  <div class="panel panel-default" style="    background-color: initial;">
  <div class="panel-heading"  style="    background-color: initial;">Panel heading without title</div>
  <div class="panel-body">
   
  <div class="row" align="right">
  <div class="card border-dark mb-3" style="max-width: 30rem;" align="left">
   <div class="card-body text-dark">
   <p style="color: red">message:${resultDataMap.message }</p>
   <div class="card-header">Header</div>
		  <div class="form-group">
		    <label for="name">Name</label>
		    <form:input type="text" class="form-control" id="name" path="name" name="name" aria-describedby="" placeholder="" />
		   <form:errors path="name"></form:errors>
		    <small id="name" class="form-text text-muted">We'll never share your details with anyone else.</small>
		  </div>
		  <div class="form-group">
		    <label for="contactNumber">Contact Number</label>
		    <form:input type="text" class="form-control" id="contactNumber" path="contactNumber"  name="contactNumber" aria-describedby="" placeholder="" />
	      <form:errors path="contactNumber"></form:errors>
	      </div>
	      <div class="form-group">
		    <label for="contactEmail">Contact Email</label>
		    <form:input type="text" class="form-control" id="contactEmail" path="contactEmail"  name="contactEmail" aria-describedby="" placeholder="" />
	         <form:errors path="contactEmail"></form:errors>
	      </div>
	      <div class="form-group">
		    <label for="addressCountry">Country</label>
		    <form:input type="text" class="form-control" id="addressCountry" path="address.addressCountry"  name="addressCountry" aria-describedby="" placeholder="" />
	      </div>
	      <div class="form-group">
		    <label for="addressState">State</label>
		    <form:input type="text" class="form-control" id="addressState" path="address.addressState" name="addressState" aria-describedby="" placeholder="" />
	      </div>
	      <div class="form-group">
		    <label for="addressCity">City</label>
		    <form:input type="text" class="form-control" id="addressCity" path="address.addressCity" name="addressCity" aria-describedby="" placeholder="" />
	      </div>
	      <div class="form-group">
		    <label for="addressLine1">Address line1</label>
		    <form:input type="text" class="form-control" id="addressLine1" path="address.addressLine1"  name="addressLine1" aria-describedby="" placeholder="" />
	      </div>
	      <div class="form-group">
		    <label for="addressLine2">Address line2</label>
		    <form:input type="text" class="form-control" id="addressLine2" path="address.addressLine2" name="addressLine2" aria-describedby="" placeholder="" />
	      </div>
	      <div class="form-group">
		    <label for="pincode">Pincode</label>
		    <form:input type="text" class="form-control" id="pincode" path="address.pincode" name="pincode" aria-describedby="" placeholder="" />
	      </div>
	  
  
     <button type="submit" class="btn btn-primary">Submit</button>
     </div>
   </div>
    </div>
 </div>
</div>
  </form:form>
				</div>


			</div>
			<div class="side-content">
			<div id="templatemo-carousel" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
				<li data-target="#templatemo-carousel" data-slide-to="0" class="active"></li>
				<li data-target="#templatemo-carousel" data-slide-to="1"></li>
				<li data-target="#templatemo-carousel" data-slide-to="2"></li>
				</ol>
                <div class="carousel-inner" style=" margin-left: 10%; margin-right: 10%">
                    <div class="item active" id="item1">
			<div class="intro">
				<div class="slogan">			
					<div class="container">
						<div class="introContent">				
							<h2 style="color:#3b668b"><b>Item-1</b></h2>
							<p style="color:#000000;font-size:10%px;letter-spacing: 1%;">I am Item 1 </p>
							<button class="btn btn-success btn-sm btn-raised" data-toggle="modal" data-target="#aboutLep">Read More</button>						
						</div>
					</div>
				</div>
			</div>
                    </div>

		    <div class="item" id="item2">
			<div class="intro">
				<div class="slogan">			
				<div class="container">
				<div class="introContent">	
				<h2 style="color:#3b668b"><b>Item-2</b></h2>
				<p style="color:#000000;font-size:18px;letter-spacing: 1px;">I am Item 2</p>
				<button class="btn btn-success btn-sm btn-raised" data-toggle="modal" data-target="#eradicationOfLep">Read More</button>	
				</div>
				</div>
				</div>
			</div>
                    </div>

		    <div class="item" id="item3">
				<div class="intro">
					<div class="slogan">			
						<div class="container">
								<div class="introContent">	
								<h2 style="color:#3b668b"><b>Item-3</b></h2>
								<p style="color:#000000;font-size:18px;letter-spacing: 1px;">I am Item 3<br></p>
								<button class="btn btn-success btn-sm btn-raised" data-toggle="modal" data-target="#roleIcmr">Read More</button>	
							</div>
						</div>
					</div>
				</div>
          </div>



                </div>
                <!-- Controls -->
			<a class="left carousel-control" href="#templatemo-carousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
			<a class="right carousel-control" href="#templatemo-carousel" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
			</a>
			</div>
			
			
			</div>

		</div>

	</div>

<div class="i-footer">
	<div class="footer content clearfix">
  <p>Developed by <a href="www.cdac.in">cdac</a></p>
 </div>
</div>
</div>
</body>
</html>
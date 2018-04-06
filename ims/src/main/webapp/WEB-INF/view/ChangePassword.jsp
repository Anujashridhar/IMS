<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<!-- 	<link href='http://fonts.googleapis.com/css?family=Roboto:300italic,400italic,300,400,500,700,900' rel='stylesheet' type='text/css'/>
	<link href="resources/css/materialadmin.css" rel="stylesheet"> 
 	<link href="resources/css/font-awesome.min.css" rel="stylesheet"> 
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/material-design-iconic-font.min.css" rel="stylesheet">
    --> 
    <script src="resources/js/jquery.min.js"></script>
    
    
<title>Insert title here</title>
</head>
<body>

<section class="section-account">
	<div style="background-color: #3498db" align="center"><br>
		<div class="card contain-xs style-transparent">
				<div class="card-body">
					<div class="row">
		
	   <form:form class="form"  id="form1" action="${pageContext.request.contextPath }/dashboard/ChangePassword"  method="post">
								
				<div class="form-group floating-label">
				
				<div class="form-group">
									<input type="password" id="new_password" class="form-control" name="oldPassword">
									<label for="new_password">New Password</label>
							</div><!--end .form-group -->
							<div class="form-group">
									<input type="password" id="new_password" class="form-control" name="password1">
									<label for="new_password">New Password</label>
							</div><!--end .form-group -->
							<p style="color:#800000;margin-top:-15px;" id="errMessageNewP" hidden="hidden">Please enter new password</p>
							<div class="form-group">
									<div class="input-group">
										<div class="form-group">
									        <input type="password" id="confirm_password" class="form-control" name="password2">
									        <label for="confirm_password">Confirm Password</label>
							          	</div>
										<p style="color:#800000;margin-top:-15px;" id="errMessageConfP" hidden="hidden">Please enter confirm password</p>
										<div class="input-group-btn">
											<button id="submit" class="btn btn-floating-action btn-primary" type="submit" ><i class="fa fa-check"></i></button>
										</div>
										<div class="input-group-btn">
											<button id="cancel" class="btn btn-floating-action btn-danger" type="button" onclick="window.location.href = 'index.htm'"><i class="fa fa-close"></i></button>
										</div>
									 </div>	
							</div>
				  </div>
		</form:form>
		</div>
		</div>
		</div>
</div>
</section>

</body>
</html>
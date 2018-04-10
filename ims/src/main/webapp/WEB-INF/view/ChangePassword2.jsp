   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<html>
	<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    </head>
	
	
	

<body>
    
    
    	<div id="page-wrapper">
		  <div class="header"> 
          </div>
    
    <div id="page-inner">
			<h2>Change Password </h2><br>
			<br>

		
	   <form:form class="form"  id="form1" action="${pageContext.request.contextPath }/dashboard/ChangePassword"  method="post">
								
				<div class="form-group floating-label">
				
				<div class="form-group">
				
									 <div class="row">
					       <div class="col-xs-12 col-sm-6 col-md-4"> 
								  <div class="card-panel text-center">
									<input type="password" id="oldPassword" class="form-control" name="oldPassword">
									<label for="oldPassword">Old Password</label>
									</div>
									</div>
									</div>
						
							 <div class="row">
					       <div class="col-xs-12 col-sm-6 col-md-4"> 
								  <div class="card-panel text-center">
									<input type="password" id="password1" class="form-control" name="password1">
									<label for="password1">New Password</label>
							</div>
							</div>
							</div>
							 <div class="row">
					       <div class="col-xs-12 col-sm-6 col-md-4"> 
								  <div class="card-panel text-center">
							<p style="color:#800000;margin-top:-15px;" id="errMessageNewP" hidden="hidden">Please enter new password</p>
									        <input type="password" id="password2" class="form-control" name="password2">
									        <label for="password2">Confirm Password</label>
									        </div>
									        </div>
									        </div>
									        
								 <div class="row">
					       <div class="col-xs-12 col-sm-6 col-md-4"> 
								  <div class="card-panel text-center">			<p style="color:#800000;margin-top:-15px;" id="errMessageConfP" hidden="hidden">Please enter confirm password</p>
										<div class="input-group-btn">
											<button id="submit" class="btn btn-floating-action btn-primary" type="submit" ><i class="fa fa-check"></i></button>
										</div>
										<div class="input-group-btn">
											<button id="cancel" class="btn btn-floating-action btn-danger" type="button" onclick="window.location.href = 'index.htm'"><i class="fa fa-close"></i></button>
										</div>
									</div>
									</div>
									</div>
							</div>
				  </div>
		</form:form>
		</div>
		</div>
</body>
</html>
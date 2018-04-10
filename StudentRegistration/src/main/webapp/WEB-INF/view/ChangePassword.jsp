   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Change Password</title>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/form-elements.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/style.css">


    </head>

    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1>Change Password</h1>
                        
                        </div>
                    </div>
                      <form:form class="form"  id="form1" action="${pageContext.request.contextPath }/dashboard/ChangePassword"  method="post">
					
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Update</h3>
                            		<p>Enter your old and new password to update:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-Opassword">Old password</label>
			                        	<input type="password" name="oldPassword" placeholder="old password..." class="form-password form-control" id="form-Opassword">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-Npassword">new Password</label>
			                        	<input type="password" name="password1" placeholder="New Password..." class="form-password form-control" id="form-Npassword">
			                        <p style="color:#800000;margin-top:-15px;" id="errMessageNewP" hidden="hidden">Please enter new password</p>
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Re-type Password</label>
			                        	<input type="password" name="password2" placeholder="Re-type Password..." class="form-password form-control" id="form-RTpassword">
			                        <p style="color:#800000;margin-top:-15px;" id="errMessageConfP" hidden="hidden">Please enter confirm password</p>
			                        </div>
			                        <button type="submit" class="btn btn-danger" onclick="window.location.href = 'index.htm'">Close</button>
			                        <button type="submit" class="btn pull-right" onclick="validateChangePassword()" >Update</button>
			                   </div>
                        </div>
                    </div>
                </form:form>
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
    
        
   
</html>
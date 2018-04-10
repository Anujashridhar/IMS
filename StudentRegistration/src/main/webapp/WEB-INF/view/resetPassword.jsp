<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Password Reset </title>
  <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">

 <!-- <link href="resources/css/font-awesome.css" rel="stylesheet"> -->
  <link href="resources/css/style.css" rel="stylesheet">
  
  <link rel='stylesheet prefetch' href='resources/css/font.css'>

</head>

<body style="background-color: blacl;">

<div class="wrap">
  
 
    
      <div style="background-image: url('resources/image/cdacLogo.png');height: 100%;width: 100%;" ></div>
    
 
  
  <h1 class="text" id="welcome">Welcome. <span>please Enter New Password</span>
  
  <c:if test="${param.error != null}">

									<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										Invalid  password.
									</div>
								
								</c:if>
								
								
  
  
  
  </h1>
  
  <form:form method='post' id="formNew"  action="${pageContext.request.contextPath }/resetPasswordSave">
  <p style="color: red">${message }</p>
  <input type="hidden" name="tocken_no" value="${tocken_no }">
    <input type='password' id="password1" name="password1" placeholder='New Password'>
    <p style="color: red;"><form:errors  path="password1"></form:errors></p>
    <input type='password' id='password2' name="password2" placeholder='Re-Enter Password'>
       <p style="color: red;"><form:errors  path="password2"></form:errors></p>
   
    <div class='login'>
     
       <input type='submit' id="submitName"  value='submit'>
  </div><!-- /login -->
  </form:form>
</div><!-- /wrap -->


  <script src='resources/js/jquery.min.js'></script>
  <script src='resources/js/adminLogin.js'></script>
  <script src="resources/js/AppVendor.js"></script>		
  <script src="resources/js/sweet-alert/sweet-alert.min.js"></script>
  <script src="resources/js/sweet-alert/sweet-alert.init.js"></script>         
  

</body>
</html>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
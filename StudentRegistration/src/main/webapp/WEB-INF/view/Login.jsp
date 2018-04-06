<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Login - Animation - NoEdit </title>
  <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">

 <!-- <link href="resources/css/font-awesome.css" rel="stylesheet"> -->
  <link href="resources/css/style.css" rel="stylesheet">
  
  <link rel='stylesheet prefetch' href='resources/css/font.css'>

</head>

<body style="background-color: blacl;">

<div class="wrap">
  
 
    
      <div style="background-image: url('resources/image/cdacLogo.png');height: 100%;width: 100%;" ></div>
    
 
  
  <h1 class="text" id="welcome">Welcome. <span>please login.</span>
  
  <c:if test="${param.error != null}">

									<div class="alert alert-danger col-xs-offset-1 col-xs-10">
									<p style="color: red;">	${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</p>
									</div>
								
								</c:if>
								
								<c:if test="${param.logout != null}">

									<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										You have been logged out.
									</div>
								
								</c:if>
  
  
  
  </h1>
  
  <form:form method='post' id="formNew"  >
  

    <p style="color: green">${sucessMessage }</p>
  <p style="color: red">${message }</p>
    <input type='text' id="userid" name='username' placeholder='Username'>
    <p style="color: red;"><form:errors  path="username"></form:errors></p>
    <input type='password' id='password' name='password' placeholder='Password'>
       <p style="color: red;"><form:errors  path="password"></form:errors></p>
   
    <div class='login'>
      <a href="${pageContext.request.contextPath }/forgotPassword"><i class="icon-cog"></i> I've forgotten my password</a>
       <input type='submit' id="submitName"  value='submit'>
<!--       <input type='button' id="submitName" onclick="doAjaxPost()" value='Login'>
 -->    </div><!-- /login -->
  </form:form>
</div><!-- /wrap -->


  <script src='resources/js/jquery.min.js'></script>
  <script src='resources/js/adminLogin.js'></script>
  <script src="resources/js/AppVendor.js"></script>		
  <script src="resources/js/sweet-alert/sweet-alert.min.js"></script>
  <script src="resources/js/sweet-alert/sweet-alert.init.js"></script>         
  

</body>
</html>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
<!-- <!DOCTYPE html>
[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]
[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]
[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]
[if gt IE 8]><! <html lang="en"> <![endif]
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
  <link rel="stylesheet" href="resources/css/style.css">
  [if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]
</head>
<body>
  <section class="container">
    <div class="login">
      <h1>Login to Web App</h1>
      <form method="post" action="SubmitLoginForm">
        <p><input type="text" name="userid" value="" placeholder="Username or Email"></p>
        <p><input type="password" name="password" value="" placeholder="Password"></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            Remember me on this computer
          </label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="Login"></p>
      </form>
    </div>

    <div class="login-help">
      <p>Forgot your password? <a href="#">Click here to reset it.</a></p>
    </div>
  </section>

  <section class="about">
    <p class="about-links">
      <a href="http://www.cssflow.com/snippets/login-form" target="_parent">View Article</a>
      <a href="http://www.cssflow.com/snippets/login-form.zip" target="_parent">Download</a>
    </p>
    <p class="about-author">
      &copy; 2012&ndash;2013 <a href="http://thibaut.me" target="_blank">Thibaut Courouble</a> -
      <a href="http://www.cssflow.com/mit-license" target="_blank">MIT License</a><br>
      Original PSD by <a href="http://www.premiumpixels.com/freebies/clean-simple-login-form-psd/" target="_blank">Orman Clark</a>
  </section>
</body>
</html>
 -->
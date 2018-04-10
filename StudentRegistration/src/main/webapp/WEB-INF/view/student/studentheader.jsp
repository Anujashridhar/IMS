<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
	<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
<!--       <a class="navbar-brand" href="#">WebSiteName</a> -->
    </div>
    <ul class="nav navbar-nav">
    <c:forEach items="${menus}" var="menuGroup">
					<c:forEach items="${menuGroup.menuList}" var="menu">

		 					<li>
		 					<a href="${pageContext.request.contextPath }${menu.url}">${menu.menuName }</a>
		                    	<%-- <a onclick="getContent('${pageContext.request.contextPath }${menu.url}')">${menu.menuName }</a> --%>
		                    	<!-- <a href="ChooseTemplate" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Select Template</a> -->
		                    </li>
                    
                    </c:forEach>
                    </c:forEach>
                    
           <form:form id="form-id" method="post" action="${pageContext.request.contextPath}/logout">
<input type="submit" name="logout" value="Logout">
</form:form>



<!--       <li><a href="#">Home</a></li>
      <li><a href="#">Page 1</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
      <li><a href="#">Page 3</a></li>
      <li><a href="#">Page 3</a></li>
      <li><a href="#">Page 3</a></li>
      <li><a href="#">Page 3</a></li>
      <li><a href="#">Page 3</a></li>
      <li><a href="#">Page 3</a></li>
      <li><a href="#">Page 3</a></li><li><a href="#">Page 3</a></li>
      <li><a href="#">Page 3</a></li> -->
    </ul>

  </div>
</nav>

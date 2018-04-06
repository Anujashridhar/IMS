<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/templates/template1/css/index.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/templates/template1/css/design.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/templates/template1/css/nav.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class= "body-color">

<div class="topnav" id="myTopnav">

         <h5><a  href="#">  <img    
           src="${pageContext.request.contextPath }/${site.siteData.logo }" style="height:80px; width:80px"></a>
    <a  href="#"> ${site.siteData.name }
    </a></h5>
        <div class="navbar-menu" id="showMenu">
      
		<div class="dropdown">
		
         <c:forEach items="${site.menuSubmenuData }" var="menu">
       
<c:if test="${fn:length(menu.value) > 0}">       
     
       <a class="dropdown-toggle" data-toggle="dropdown" href="${pageContext.request.contextPath }${menu.key.menuUrl }"> ${menu.key.menuName }</a>
        </c:if>
         <c:if test="${fn:length(menu.value) <= 0}">       
      <a href="${pageContext.request.contextPath }${menu.key.menuUrl }"> ${menu.key.menuName }</a>
        </c:if>
			
			<c:forEach items="${menu.value }" var="submenu">
			<a href="${pageContext.request.contextPath }${submenu.subMenuUrl }"> ${submenu.subMenuName }</a>
			</c:forEach>
			
			
			<!-- <a href="#news">News</a>
			<a href="#contact">Contact</a>
			<a href="#about">About</a>
			<a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a> -->
			</c:forEach>
			</div>  
			 <ul class="nav navbar-nav navbar-right">
         <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li> 
        <li><a href="${pageContext.request.contextPath }/loginForm"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
	 </div> 
</div>

<script>
function myFunction() {
    var x = document.getElementById("showMenu");
    if (x.className === "navbar-menu") {
        x.className += " responsive";
    } else {
        x.className = "navbar-menu";
    }
}
</script>
<!-- <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
            <h5>
           <a href="index.html"><img    
           src="/resources/templates/template1/images/logo3.png" style="width:8%;height=10%"> &nbsp;&nbsp;Ministry of Electronics & Information Technology</a>
       </h5>
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <div class ="collapse navbar-collapse" id="myNavbar" >
      <div class="collapse navbar-collapse" id="myNavbar">
      <div class="cssmenu"> 
      <ul class="nav navbar-nav">
    <ul>
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Page 1-1</a></li>
            <li><a href="#">Page 1-2</a></li>
            <li><a href="#">Page 1-3</a></li>
          </ul>
        </li>
        <li><a href="#">Page 2</a></li>
        <li><a href="#">Page 3</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <ul>
         <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li> 
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
      </div>
    </div>
    </div>
  </div> 
</nav>
   -->
  <!--  
   
   <nav class="navbar navbar-default">
  <div class="container-fluid">
    Brand and toggle get grouped for better mobile display
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <h5>
           <a href="index.html"><img    
           src="/resources/templates/template1/images/logo3.png" style="width:8%;height=10%"> &nbsp;&nbsp;Ministry of Electronics & Information Technology</a>
       </h5>
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>

    Collect the nav links, forms, and other content for toggling
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
   
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div>/.navbar-collapse
  </div>/.container-fluid
</nav> -->
   
   
   
   
<div class="container">  
  <div id="myCarousel" class="carousel slide" data-ride="carousel" >
    <!-- Indicators -->
    <ol class="carousel-indicators">
    <c:forEach items="${site.imageList }" var="imageDetails" varStatus="count">
    <c:if test="${count.index==0 }">
     <li data-target="#myCarousel" data-slide-to="${count.index }" class="active"></li>
    </c:if>
    <c:if test="${count.index!=0 }">
     <li data-target="#myCarousel" data-slide-to="${count.index }" ></li>
    </c:if>
     
    
      </c:forEach>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" >
    <c:forEach items="${site.imageList }" var="imageDetails" varStatus="count">
    <c:if test="${count.index==0 }">
    <div class="item active">
     <img src="${pageContext.request.contextPath }/${imageDetails.imageUrl}" alt="/resources/templates/template1/images1" style="width:100%;">
      </div>
    </c:if>
     <c:if test="${count.index!=0 }">
     <div class="item ">
     <img src="${pageContext.request.contextPath }/${imageDetails.imageUrl}" alt="/resources/templates/template1/images1" style="width:100%;">
      </div>
       </c:if>
    </c:forEach>
    
<!--       <div class="item active">
        <img src="/resources/templates/template1/images/4.jpg" alt="/resources/templates/template1/images1" style="width:100%;">
      </div>

      <div class="item">
        <img src="/resources/templates/template1/images/22.jpg" alt="IMAGES2" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="/resources/templates/template1/images/33.jpg" alt="IMAGES3" style="width:100%;">
      </div>
      <div class="item">
        <img src="/resources/templates/template1/images/EDUCATION3.jpg" alt="IMAGES4" style="width:100%;">
      </div>
       <div class="item">
        <img src="/resources/templates/template1/images/4.jpg" alt="IMAGES1" style="width:100%;">
      </div>

      <div class="item">
        <img src="/resources/templates/template1/images/22.jpg" alt="IMAGES2" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="/resources/templates/template1/images/33.jpg" alt="IMAGES3" style="width:100%;">
      </div>
      <div class="item">
        <img src="/resources/templates/template1/images/EDUCATION3.jpg" alt="IMAGES4" style="width:100%;">
      </div>
       <div class="item">
        <img src="/resources/templates/template1/images/4.jpg" alt="IMAGES1" style="width:100%;">
      </div>

      <div class="item">
        <img src="/resources/templates/template1/images/22.jpg" alt="IMAGES2" style="width:100%;">
      </div> -->
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<div><h1 class="deepshadow1">Programs</h1></div>
<main class="flex">
<div>
<c:set var="count" value="0"></c:set>
<c:forEach items="${site.divDetails }" var="divDetail" varStatus="divStatus">
<c:if test="${count==0 }">
<br><br>
<div class="row">
 <div class="col-sm-3" style="background-color:#dbdbe4;">
       <div class="card">
        <h2 class="card-title"> ${divDetail.divName }</h2>
        ${divDetail.divContent }
      
         <h3>A New Subsection</h3>
         </div>
      </div> 

</c:if>

<c:if test="${count >=1 and count < 4}">
<div class="col-sm-3" style="background-color:#dbdbe4;">
       <div class="card">
        <h2 class="card-title"> ${divDetail.divName }</h2>
        ${divDetail.divContent }
      
         <h3>A New Subsection</h3>
         </div>
      </div> 
</c:if>
<c:if test="${count==4 }">

	<div class="col-sm-3" style="background-color:#dbdbe4;">
       <div class="card">
        <h2 class="card-title"> ${divDetail.divName }</h2>
        ${divDetail.divContent }
      
         <h3>A New Subsection</h3>
         </div>
      </div> 
      </div>
</c:if>

<c:choose>
<c:when test="${count==4 }">
<c:set var="count" value="0"></c:set>
</c:when>
<c:when test="${count==3 }">
<c:set var="count" value="4"></c:set>
</c:when>
<c:when test="${count==2 }">
<c:set var="count" value="3"></c:set>
</c:when>
<c:when test="${count==1 }">
<c:set var="count" value="2"></c:set>
</c:when>
<c:when test="${count==0 }">
<c:set var="count" value="1"></c:set>
</c:when>
</c:choose>

</c:forEach>

</div>
	
    </main>
     <footer class="navbar-default navbar-fixed-bottom">
  <div class="container-fluid">
    <span>Designed & Developed By CDAC</span>
  </div>
</footer>
 </body>
</html>

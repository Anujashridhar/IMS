<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                             Upload Sliding Images
                        </h1>
		 </div>
		<form:form class="col s12" modelAttribute="site" commandName="site" action="saveSiteImages" enctype="multipart/form-data">
                         	  
            <div id="page-inner"> 
			
              <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-action">
                            Basic Form Elements
                        </div>
                        <div class="card-content">
                        	<c:set var="cnt" value="0"></c:set>
                         		<c:forEach items="${site.imageList }" var="imageDetail" >
                         		
								  <div class="row">
								
								   <div class="file-field input-field col s6">
								      
								        <img alt="no image uploaded" src="${imageDetail.imageUrl }" width="200" height="200">
								     
								    </div>
								    <div class="file-field input-field col s6">
								      <div class="btn">
								        <span>Choose Image</span>
								        <form:hidden path="imageList[${cnt }].siteId"/>
								        <form:hidden path="imageList[${cnt }].imageType"/>
								        <form:input type="file" path="imageList[${cnt }].file"  />
								         <form:input type="file" path="menuDetails[${cnt }].menuId"  />
								      
								      </div>
								      <div class="file-path-wrapper">
								        <input class="file-path validate" type="text" placeholder="choose image">
								      </div>
								    </div>
									
									<div class="input-field col s6">
									  <input id="seqNO" type="text" class="validate">
									  <label for="icon_telephone">Order No of Image</label>
									</div>
									
									<button class="btn waves-effect waves-light" type="submit" name="action">Upload
				   					 <i class="material-icons right">send</i>
				  					</button>
				  				 </div>
								  <c:set var="cnt" value="${cnt+1 }"></c:set>
								  </c:forEach>
							
								
							
							<div class="clearBoth"></div>
							</div>
							</div>
							</div>
						
                        <!-- /.panel-body -->
                    </div> 
                <!-- /.col-lg-12 --> 
			
			</div>
             <!-- /. PAGE INNER  -->
             	 </form:form>
								 
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>

</body>
</html>
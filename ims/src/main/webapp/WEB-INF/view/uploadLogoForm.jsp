   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<html>
	<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    </head>
	
	<script src="resources/js/FormSubmit.js"></script> 
	
	

<body>
    
    
    	<div id="page-wrapper">
		  <div class="header"> 
          </div>
    
    <div id="page-inner">
			<h2>Upload new Logo</h2><br>
			<br>
				<form:form class="col s12" 
						action="${pageContext.request.contextPath }/site/content/uploadLogoSubmit?${_csrf.parameterName}=${_csrf.token}" 
							method="post" enctype="multipart/form-data" id="formMultipart">
				       <div class="row">
					       <div class="col-xs-12 col-sm-6 col-md-4"> 
								  <div class="card-panel text-center">
					       				<p><input type="file"  name="logo" 
					       							required="required" />
	                                 
	                                    <label for="countryId">Logo File</label></p>
	                       		  </div>
	                        </div>
							
					   </div>	
					   <button class="btn waves-effect waves-light" type="submit" name="action" onclick="formSubmit(this)">Upload
				   			<i class="material-icons right">upload</i>
				  	   </button>
        		</form:form>

     </div>

     </div>
     
   </body>
   </html>
      
      
      
      
      
      
      
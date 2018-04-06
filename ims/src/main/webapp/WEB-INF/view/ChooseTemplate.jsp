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
			<h2>Choose Template</h2><br>
			<br>
			
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-4">
	                    <div class="card horizontal cardIcon waves-effect waves-dark">
	                    <a href ="resources/templates/template1/theme1.html" target="_blank">
						<img class="responsive-img" src="resources/assets/img/theme1.jpg">
						</a>
						</div>
					</div>
                    <div class="col-xs-12 col-sm-6 col-md-4">
						<div class="card horizontal cardIcon waves-effect waves-dark">
						<a href ="resources/templates/template2/theme2.html" target="_blank">
						<img class="responsive-img" src="resources/assets/img/theme2.jpg">
						</a>
						</div> 
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-4">
						<div class="card horizontal cardIcon waves-effect waves-dark">
						<a href ="resources/templates/template3/theme3.html" target="_blank">
						<img class="responsive-img" src="resources/assets/img/theme3.jpg">
						</a>
						</div> 
					</div>
                  
                </div>
				<p style="color: red">${message}</p>
                <!-- /. ROW  --> 
                 <form:form class="col s12" action="${pageContext.request.contextPath }/site/admin/saveSelectedTemplate" id="form" method="post">
				       <div class="row">
							<div class="col-xs-12 col-sm-6 col-md-4"> 
									<div class="card-panel text-center">
										  <p>
										  		<c:if test="${templateId == 1 }">
										  		<input name="templateId" type="radio" id="test1" value="1" checked="checked" />
										  		</c:if>
										  		<c:if test="${templateId != 1 }">
										  		<input name="templateId" type="radio" id="test1" value="1"  />
										  		</c:if>
										      <label for="test1">Select this theme</label>
				    					  </p>
									</div>
							</div>
							 <div class="col-xs-12 col-sm-6 col-md-4"> 
									<div class="card-panel text-center">
										 <p>
										 	<c:if test="${templateId == 2 }">
										  		<input name="templateId" type="radio" id="test2" value="2" checked="checked" />
										  		</c:if>
										  		<c:if test="${templateId != 2 }">
										  		<input name="templateId" type="radio" id="test2" value="2"  />
										  		</c:if>
										
										      <label for="test2">Select this theme</label>
				    					</p>
									</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4"> 
									<div class="card-panel text-center">
										 <p>
										 <c:if test="${templateId == 3 }">
										  		<input name="templateId" type="radio" id="test3" value="3" checked="checked" />
										  		</c:if>
										  		<c:if test="${templateId != 3 }">
										  		<input name="templateId" type="radio" id="test3" value="3"  />
										  		</c:if>
										 		
										      <label for="test3">Select this theme</label>
				    					</p>
				    					
									</div>
							</div> 
					   </div>	
								 <button class="btn waves-effect waves-light right" type="submit" name="action" >Submit
				   					 <i class="material-icons right">send</i>
				  				</button>
        </form:form>

     </div>

     </div>
     
   </body>
   </html>
      
      
      
      
      
      
      
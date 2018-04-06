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
			<h2>Add New State</h2><br>
			<br>
			
            
                 <form:form class="col s12" action="saveNewState" method="post" commandName="state">
				       <div class="row">
				       <div class="col-xs-12 col-sm-6 col-md-4"> 
							<div class="card-panel text-center">
				       				<p><form:select id="countryId" path="countryId" items="${countryList}" class="form-control mustRequired" 
				       							required="required">
                                                <option value=""></option>
                                    </form:select><br>
                                    <label for="countryId">Country Name</label></p>
                       		</div>
                       </div>
							<div class="col-xs-12 col-sm-6 col-md-4"> 
									<div class="card-panel text-center">
										  <p><input name="stateName" type="text" id="stateName" />
										      <label for="stateName">State Name</label>
				    					  </p>
									</div>
							</div>
					   </div>	
					   <button class="btn waves-effect waves-light" type="submit" name="action">Submit
				   			<i class="material-icons right">send</i>
				  	   </button>
        		</form:form>

     </div>

     </div>
     
   </body>
   </html>
      
      
      
      
      
      
      
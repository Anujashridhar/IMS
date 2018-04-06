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
			<h2>Add New Country</h2><br>
			<br>
			
            
                 <form class="col s12" action="saveNewCountry" method="post">
				       <div class="row">
							<div class="col-xs-12 col-sm-6 col-md-4"> 
									<div class="card-panel text-center">
										  <p><input name="countryName" type="text" id="countryName" />
										      <label for="countryName">Country Name</label>
				    					  </p>
									</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4"> 
									<div class="card-panel text-center">
										  <p><input name="countryCode" type="text" id="countryCode" />
										      <label for="countryCode">Country Code</label>
				    					  </p>
									</div>
							</div>
					   </div>	
					   <button class="btn waves-effect waves-light" type="submit" name="action">Submit
				   			<i class="material-icons right">send</i>
				  	   </button>
        		</form>

     </div>

     </div>
     
   </body>
   </html>
      
      
      
      
      
      
      
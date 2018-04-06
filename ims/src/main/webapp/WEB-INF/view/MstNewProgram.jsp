   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<script src="resources/js/programMaster.js"></script>
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
			<h2>Program Details </h2><br>
			<br>
				<form:form class="col s12" action="saveProgramDetails" method="post" commandName="program">
				       <div class="row">
					       <div class="col-xs-12 col-sm-6 col-md-4"> 
								  <div class="card-panel text-center">
					       				<p><form:select id="branchId" path="branchId" items="${branchList}" class="form-control mustRequired" 
					       							required="required">
	                                                <option value=""></option>
	                                    </form:select><br>
	                                    <label for="branchId">Branch Name</label></p>
	                       		  </div>
	                        </div>
	                        
	                        <div class="col-xs-12 col-sm-6 col-md-4"> 
								  <div class="card-panel text-center">
					       				<p><form:select id="subBranchId" path="subBranchId" class="form-control mustRequired" 
					       							required="required">
	                                                <option value=""></option>
	                                    </form:select><br>
	                                    <label for="branchId">SubBranch Name</label></p>
	                       		  </div>
	                        </div>
						
							<div class="col-xs-12 col-sm-6 col-md-4"> 
									<div class="card-panel text-center">
										  <p><form:input path="programName" id="programName" class="form-control mustRequired" required="required" /> 
										      <label for="programName">Program Name</label>
				    					  </p>
									</div>
							</div>
					   </div>	
					   <div class="row">
					   		<div class="col-xs-12 col-sm-6 col-md-4"> 
									<div class="card-panel text-center">
										  <p><form:input path="programCode" id="programCode" class="form-control mustRequired" required="required" /> 
										      <label for="programCode">Program Code</label>
				    					  </p>
									</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4"> 
									<div class="card-panel text-center">
										  <p><form:input path="durationOfCourse" id="durationOfCourse" class="form-control mustRequired" required="required" /> 
										      <label for="durationOfCourse">Duration Of Course</label>
				    					  </p>
									</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4"> 
									<div class="card-panel text-center">
										  <p><form:input path="semYearly" id="semYearly" class="form-control mustRequired" required="required" /> 
										      <label for="semYearly">Semester/Yearly</label>
				    					  </p>
									</div>
							</div>
					    </div>
					    <div class="row">
					   		<div class="col-xs-12 col-sm-6 col-md-6"> 
									<div class="card-panel text-center">
										  <p><form:textarea path="description" id="description" class="form-control mustRequired" required="required" /> 
										      <label for="description">Description</label>
				    					  </p>
									</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6"> 
									<div class="card-panel text-center">
										  <p><form:textarea path="eligibility" id="eligibility" class="form-control mustRequired" required="required" /> 
										      <label for="eligibility">Eligibility</label>
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
      
      
      
      
      
      
      
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet">	
<script src="resources/js/datatables.min.js"></script>


<script type="text/javascript">

$(document).ready(function() {
	
	
    $('#datatable1').DataTable( {
        "scrollY":        "500px",
        "scrollCollapse": true,
        "paging":         false
    } );



});
</script>


<div id="page-wrapper">
		  <div class="header"> 
          </div>
    
    <div id="page-inner">
			<h2>Country List</h2><br>
			<br>
			
                 <form:form class="col s12" action="saveNewCountry" method="post" modelAttribute="country">
                 <div class="card-body floating-label">
				       <div class="row">
				       
				       		<div class="table-responsive">
																<table id="datatable1" class="table table-striped table-hover">
																	<thead>
																		<tr>
																			<th>S.no.</th>
																			<th>Country Name</th>
																			<th>Select</th>
																		</tr>
																	</thead>
					
																	<tbody>
																		<c:set var="count" value="0"></c:set>
																		<c:forEach items="${countryList }" var="location">
																			<c:if test="${count!=0 }">
																					<tr>
																						<td>${count }</td>
																						<td>${location.value}<input type="hidden" id="locationId${count }" name="locationId" value="${location.key}" class="form-control "  style="text-align: center;" ></td>
																						<td><input name="countryId" type="radio" id="countryId${count }" value="${location.key}" /><label for="countryId${count }">Select</label></td>
																					</tr>
																			</c:if>
																		<c:set var="count" value="${count+1}"></c:set>
																		
																		</c:forEach>
																		
																</tbody>
															  </table>
																<input type="hidden" id="maxCount" value="${count}" />
														
															 </div>
				       				<div class="row" align="right">
											   <button class="btn waves-effect waves-light" type="button" onclick=" getContent('${pageContext.request.contextPath}/site/admin/ChooseCountry') ">Add
										   			<i class="material-icons right">add</i>
										  	   </button>
										  	   <button class="btn waves-effect waves-light" type="submit" name="action">Modify
										   			<i class="material-icons right">update</i>
										  	   </button>
										  	   <button class="btn waves-effect waves-light red" type="button" onclick=" window.location.href='dashboard' ">Cancel
										   			<i class="material-icons right">cancel</i>
										  	   </button>
								    </div>
				  	   </div>
				  	   </div>
        		</form:form>

     </div>

     </div>
     
   </body>
   </html>
   
   
   
   

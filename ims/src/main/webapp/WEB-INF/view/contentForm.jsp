<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<meta charset="UTF-8">
<title>IMS</title>
<!-- <script src="resources/js/jquery.min.js"></script> -->
<script src="resources/assets/js/bootstrap.min.js"></script>
<!-- <script src="resources/js/editor.js"></script> -->
<script>
/* 	$(document).ready(function() {
		debugger;
		var i=1;
		for(i=1;i<=4;i++)
			{
				$("#txtEditor"+i).Editor();
			}
		
	}); */
</script>
<!--  <link rel="stylesheet"
	href="resources/assets/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="resources/assets/css/font-awesome.css">-->
<link href="resources/css/editor.css" type="text/css"
	rel="stylesheet" />

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="resources/js/siteDetailForm.js">
	
</script>
<div id="page-wrapper">
	<div class="header">
		<h1 class="page-header">Form Inputs Page</h1>
	</div>

	<div id="page-inner">

		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-action">Basic Form Elements</div>
					<div class="card-content">

						<form:form class="col s12" modelAttribute="site" id="contentDetailForm" action="${pageContext.request.contextPath }/site/content/saveContentDetail">
							<input type="hidden" name="countdivs" value="${cnt }" />
							<input type="hidden" name="siteId" value="${siteId }" />
							
							<c:set var="count" value="1"></c:set>
							<input type="hidden" name="divs" value="${noOfDiv }" />
								<c:forEach var = "i" begin = "0" end = "${noOfDiv }">
								 <c:if test="${count!=0 }">
							<p style="color: red;">${message }</p>
							<c:set var="cunt" value="0"></c:set>
								<form:hidden path="divDetails[${i }].divId"/>
								
							<div class="row">
								<div class="input-field col s6">
									<form:input id="DivHeading${count }" path="divDetails[${i }].divName" type="text" class="validate" /> 
									<label for="DivHeading${count }" class="active">Division Heading</label>
								</div>

							</div>
							<!-- <div class="container-fluid">
								<div class="row">
									<div class="container"> -->
										<div class="row">
											<div class="col-lg-12 nopadding">
												<label for="txtEditor${count }"  class="active">Division Description</label>
												<form:textarea id="txtEditor${count }" path="divDetails[${i }].divContent" class="textEditor"></form:textarea>
											</div>

										</div>
									<!-- </div>
								</div>
							</div> -->
							</c:if>
							<c:set var="count" value="${count+1}"></c:set>
							</c:forEach>
						
							 <button class="btn waves-effect waves-light" type="submit" name="action">Submit
				   			 <i class="material-icons right">send</i>
				  	         </button>
						</form:form>

						<div class="clearBoth"></div>
					</div>
				</div>
			</div>

			<!-- /.panel-body -->
		</div>
		<!-- /.col-lg-12 -->

	</div>
	<!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->


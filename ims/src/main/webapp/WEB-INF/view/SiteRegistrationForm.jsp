<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>site data registration</title>
<link href="resources/assets/sweet-alert/sweet-alert.min.css"
	rel="stylesheet">

<script src="resources/js/siteRegistration.js"></script>

</head>
<body>

	<div id="page-wrapper">
		<div class="header">
			<h1 class="page-header">Site Registration</h1>
		</div>

		<div id="page-inner">

			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-action">Please fill site's details</div>
						<div class="card-content">

							<form:form method='post' id="formSite"
								action="${pageContext.request.contextPath }/site/saveSiteRegistration" modelAttribute="site"
								class="col s12">
								<p style="color: red">${message }</p>


								<div class="row" id="row1">
									<%--   <p style="color: red">message:${resultDataMap.message }</p> --%>
									<div class="input-field col s6">
										<label for="name">Name</label>
										<form:input class="validate" id="name" path="name" name="name"
											aria-describedby="" placeholder="" />
										<p style="color: red;">
											<form:errors path="name"></form:errors>
										</p>
										<small id="name" class="form-text text-muted">Name of
											the Organization</small>
									</div>
									<div class="input-field col s6">
										<label for="contactNumber">Contact Number</label>
										<form:input type="text" class="form-control"
											id="contactNumber" maxlength="10" path="contactNumber"
											name="contactNumber" aria-describedby="" placeholder="" 
											data-toggle="tooltip"
										title="please provide a valid and working Mobile nO as password will be sent on this Number for Site Administration  "/>
										<p style="color: red;">
											<form:errors path="contactNumber"></form:errors>
										</p>
									</div>
									<div class="input-field col s6">
										<label for="contactEmail">Contact Email</label>
										<form:input type="text" class="form-control" id="contactEmail"
											path="contactEmail" name="contactEmail" aria-describedby=""
											placeholder="" />
										<p style="color: red;">
											<form:errors path="contactEmail"></form:errors>
										</p>
									</div>
									<div class="input-field col s6">
										<label for="addressCountry">Country</label>
										<form:input type="text" class="form-control"
											id="addressCountry" path="address.addressCountry"
											name="addressCountry" aria-describedby="" placeholder="" />
									</div>
									<div class="input-field col s6">
										<label for="addressState">State</label>
										<form:input type="text" class="form-control" id="addressState"
											path="address.addressState" name="addressState"
											aria-describedby="" placeholder="" />
									</div>
									<div class="input-field col s6">
										<label for="addressCity">City</label>
										<form:input type="text" class="form-control" id="addressCity"
											path="address.addressCity" name="addressCity"
											aria-describedby="" placeholder="" />
									</div>
									<div class="input-field col s6">
										<label for="addressLine1">Address line1</label>
										<form:input type="text" class="form-control" id="addressLine1"
											path="address.addressLine1" name="addressLine1"
											aria-describedby="" placeholder="" />
									</div>
									<div class="input-field col s6">
										<label for="addressLine2">Address line2</label>
										<form:input type="text" class="form-control" id="addressLine2"
											path="address.addressLine2" name="addressLine2"
											aria-describedby="" placeholder="" />
									</div>
									<div class="input-field col s6">
										<label for="pincode">Pincode</label>
										<form:input type="text" class="form-control" id="pincode"
											path="address.pincode" name="pincode" aria-describedby=""
											placeholder="" />
									</div>


									<button type="button" class="btn waves-effect waves-light"
										onclick="register(event)">
										Submit <i class="material-icons right">send</i>
									</button>

								</div>

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


</body>
<script src="assets/libs/wizard/jquery.bootstrap.wizard.min.js"></script>
<script src="assets/core/demo/DemoFormWizard.js"></script>
<script src="resources/assets/core/source/AppForm.js"></script>
<script src="resources/assets/core/source/AppVendor.js"></script>
<script src="resources/assets/sweet-alert/sweet-alert.min.js"></script>
<script src="resources/assets/sweet-alert/sweet-alert.init.js"></script>


</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>site data registration</title>
<link href="resources/assets/sweet-alert/sweet-alert.min.css"
	rel="stylesheet">

</head>
<body>

	<div id="page-wrapper">
		<div class="header">
			<h1 class="page-header">User Details</h1>
		</div>

		<div id="page-inner">

			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-action">Fill User Details</div>
						<div class="card-content">

							<form:form method='post' id="form"
								action="${pageContext.request.contextPath }/auth/saveUser" modelAttribute="user"
								class="col s12">
								<p style="color: red">${message }</p>


								<div class="row" >
									<%--   <p style="color: red">message:${resultDataMap.message }</p> --%>
									<div class="col s6">
										<label for="name">User Role</label>
										<form:select class="form-control" id="userType" path="userType" items="${roles }"> 
											
											</form:select>
										<p style="color: red;">
											<form:errors path="userType"></form:errors>
										</p>
										<!-- <small id="name" class="form-text text-muted">Name of
											the User</small> -->
									</div>
									
									<div class="col s6">
										<label for="name">Department</label>
										<form:select class="form-control" id="userType" path="departmentId" items="${department }"> 
											
											</form:select>
										<p style="color: red;">
											<form:errors path="departmentId"></form:errors>
										</p>
										<!-- <small id="name" class="form-text text-muted">Name of
											the User</small> -->
									</div>
									
									<div class="row" >
								<div class="input-field col s4">
										<c:if test="${empty user.userName}">
											<label for="name">Name${ user.userName}</label>
										
										</c:if>
										<c:if test="${not empty user.userName}">
											<label for="name" class="active">Name${ user.userName}</label>
										
										</c:if>
											<form:input class="validate" id="name" path="userName" 
											aria-describedby="" placeholder="" />
										
										<p style="color: red;">
											<form:errors path="userName"></form:errors>
										</p>
										<!-- <small id="name" class="form-text text-muted">Name of
											the User</small> -->
									</div>
									<div class="input-field col s4">
									<c:if test="${empty user.userContactNo}">
											<label for="contactNumber">Contact Number</label>
										
										</c:if>
										<c:if test="${not empty user.userContactNo}">
											<label for="contactNumber" class="active">Contact Number</label>
										
										</c:if>
										
										<form:input type="text" class="form-control"
											id="userContactNo" maxlength="10" path="userContactNo"
											 aria-describedby="" placeholder="" />
										<p style="color: red;">
											<form:errors path="userContactNo"></form:errors>
										</p>
									</div>
									<div class="input-field col s4">
									<c:if test="${empty user.userEmail}">
											<label for="contactEmail">Contact Email</label>
										
										</c:if>
										<c:if test="${not empty user.userEmail}">
											<label for="contactEmail" class="active">Contact Email</label>
										
										</c:if>
										
										<form:input type="text" class="form-control" id="userEmail"
											path="userEmail"  aria-describedby=""
											placeholder="" />
										<p style="color: red;">
											<form:errors path="userEmail"></form:errors>
										</p>
									</div>
									</div>
									<div class="row" >
								
									<div class="input-field col s6">
									<c:if test="${empty user.address.addressCountry}">
											<label for="addressCountry">Country</label>
										
										</c:if>
										<c:if test="${not empty user.address.addressCountry}">
											<label for="addressCountry" class="active">Country</label>
										
										</c:if>
										
										<form:input type="text" class="form-control"
											id="addressCountry" path="address.addressCountry"
											name="addressCountry" aria-describedby="" placeholder="" />
									</div>
									<div class="input-field col s6">
									<c:if test="${empty user.address.addressState}">
										<label for="addressState">State</label>
										
										</c:if>
										<c:if test="${not empty user.address.addressState}">
											<label for="addressState" class="active">State</label>
										
										</c:if>
									
									
										<form:input type="text" class="form-control" id="addressState"
											path="address.addressState" name="addressState"
											aria-describedby="" placeholder="" />
									</div>
									</div>
									<div class="row" >
								
									<div class="input-field col s4">
									
									
									<c:if test="${empty user.address.addressCity}">
										<label for="addressCity">City</label>
										
										</c:if>
										<c:if test="${not empty user.address.addressCity}">
											<label for="addressCity" class="active">City</label>
										
										</c:if>
									
										<form:input type="text" class="form-control" id="addressCity"
											path="address.addressCity" name="addressCity"
											aria-describedby="" placeholder="" />
									</div>
									<div class="input-field col s8">
									<c:if test="${empty user.address.addressLine1}">
										<label for="addressLine1">Address line1</label>
										
										</c:if>
										<c:if test="${not empty user.address.addressLine1}">
											<label for=addressLine1 class="active">Address line1</label>
										
										</c:if>
										<form:input type="text" class="form-control" id="addressLine1"
											path="address.addressLine1" name="addressLine1"
											aria-describedby="" placeholder="" />
									</div>
									</div>
									<div class="row" >
								
									<div class="input-field col s8">
									<c:if test="${empty user.address.addressLine2}">
										<label for="addressLine2">Address line2</label>
										
										</c:if>
										<c:if test="${not empty user.address.addressLine2}">
											<label for=addressLine2 class="active">Address line2</label>
										
										</c:if>
										<form:input type="text" class="form-control" id="addressLine2"
											path="address.addressLine2" name="addressLine2"
											aria-describedby="" placeholder="" />
									</div>
									<div class="input-field col s4">
									<c:if test="${empty user.address.pincode}">
										<label for="pincode">Pincode</label>
										
										</c:if>
										<c:if test="${not empty user.address.pincode}">
											<label for=pincode class="active">Pincode</label>
										
										</c:if>
										<form:input type="text" class="form-control" id="pincode"
											path="address.pincode" name="pincode" aria-describedby=""
											placeholder="" />
									</div>
</div>
								<div class="row" >
									<button type="submit" class="btn waves-effect waves-light">
							
										Submit <i class="material-icons right">send</i>
									</button>
								</div>
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

<script src="resources/js/FormSubmit.js"></script>


</html>
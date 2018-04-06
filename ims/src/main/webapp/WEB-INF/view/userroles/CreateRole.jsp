<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <link href="${pageContext.request.contextPath }/resources/css/multi-select.css" media="screen" rel="stylesheet" type="text/css">
 
<div id="page-wrapper">
	<div class="header">
		<h1 class="page-header">Create /Modify Role</h1>
	</div>

	<div id="page-inner">
		<div class="row">
			<div class="col-lg-12">
				<div class="card">


					<form:form
						action="${pageContext.request.contextPath }/auth/saveRole" method="post"
						modelAttribute="roleWrapper" id="form">
						<div class="row" id="row1">
							<div class="input-field col s6">
									<form:hidden path="role.roleId" />
								<form:input path="role.roleName" />
								<p style="color: red;">
									<form:errors path="roleName"></form:errors>
								</p>
								<label for="icon_prefix" class="active">Role Name</label>
							</div>
						</div>
						 <div class="row" id="row1">
							<div class="input-field col s8">

								<form:select path="selectedAuthorities"
									items="${roleWrapper.allauthoritiesMap}" id="authorities"
									multiple="multiple"></form:select>

								<p style="color: red;">
									<form:errors path="authoritiesNotAssignedMap"></form:errors>
								</p>
								<label for="icon_prefix" class="active">Choose
									Authorities</label>
							</div>
							
						</div> 
						
						<div class="row text-right" id="row1" >
							<div class="input-field col s4">

								<input type="submit" value="Save" class="btn-success" >
							</div>
						</div>
					</form:form>
					<%-- <form action="${pageContext.request.contextPath }/auth/test" method="POST">
						<div class="row" id="row1">
							<div class="input-field col s8">

								<select name="selectName"
									
										 id="authorities"
									multiple="multiple">
									<option value="1">1212</option>
									<option value="12">1ewrwe2121</option>
									<option value="3">121wer2</option>
									<option value="4">12er12</option>
									<option value="5">1212werw</option>
									
									</select>
								<input type="hidden" name="_csrf" value="7cc1e5bc-7ba2-4528-994b-ec531ca43145">
								<p style="color: red;">
									<form:errors path="authoritiesNotAssigned"></form:errors>
								</p>
								<label for="icon_prefix" class="active">Choose
									Authorities</label>
							</div>
							<div class="input-field col s4">

								<input type="submit" value="Save" class="btn-success">
							</div>
						</div>
					</form> --%>
				</div>
			</div>
		</div>
	</div>
	
</div>
<script src="${pageContext.request.contextPath }/resources/js/role.js"></script>
 <script src="${pageContext.request.contextPath }/resources/js/FormSubmit.js"></script>
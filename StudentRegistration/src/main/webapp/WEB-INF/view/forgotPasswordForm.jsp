<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>


<div id="page-wrapper">
	<div class="header">
		<h1 class="page-header">Forgot Password</h1>
	</div>

	<div id="page-inner">

		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-action">Please provide your email Address to get an email for password reset</div>
					<div class="card-content">

						<form:form method="POST" class="col s12"    action="${pageContext.request.contextPath }/forgotPassword">
	
							<input name="email"/>
						</form:form>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	
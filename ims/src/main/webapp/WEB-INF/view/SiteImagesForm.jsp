<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload image</title>
<script type="text/javascript" src="resources/js/siteImageForm.js"></script>
<script type="text/javascript" src="resources/js/FormSubmit.js" ></script>


<script>
	function imageValidation(id) {
		debugger;
		// $(file).val(''); //for clearing with Jquery

		var fileInput = document.getElementById(id);
		var filePath = fileInput.value;
		var FileSize = fileInput.files[0].size / 4024 / 4024; // in MB
		var allowedExtension = /(\.jpg|\.jpeg)$/i;
		if (!allowedExtension.exec(filePath)) {
			alert("Image file type is not valid");
			fileInput.value = '';
			return false;

		} else {
			if (FileSize > 1) {
				alert('File size exceeds 1 MB');
				fileInput.value = '';
			} else {
				
				alert("success");
			}
			return true;
		}

	}
</script>
</head>
<body>

	<div id="page-wrapper">
		<div class="header">
			<h1 class="page-header">Upload Sliding Images</h1>
		</div>
		<form:form class="col s12"  modelAttribute="imageForm"
			action="${pageContext.request.contextPath }/site/content/saveSiteImages?${_csrf.parameterName}=${_csrf.token}" 
			enctype="multipart/form-data" id="formMultipart">

			<div id="page-inner">

				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-action">Basic Form Elements</div>
							<div class="card-content">
								<c:set var="cnt" value="0"></c:set>
								<c:forEach items="${imageForm.imageList }" var="imageDetail" varStatus="listCounter">
									<div id="imageBar">
										<div class="row" id="row_1">

											<div class="file-field input-field col s6">

												<img alt="no image uploaded" src="${imageDetail.imageUrl }"
													width="200" height="200">

											</div>
											<div class="file-field input-field col s6">
												<div class="btn">
													<span>Choose Image</span>
													<form:hidden path="imageList[${listCounter.index }].imageId" />
													<form:hidden path="imageList[${listCounter.index }].imageType" />
													<form:input type="file" path="imageList[${cnt }].file" />
													
												</div>
												<div class="file-path-wrapper">
													<input class="file-path validate" type="text"
														placeholder="choose image">
												</div>
											</div>

											<div class="input-field col s6">
												<form:input id="orderno${listCounter.index }"  class="validate" path="imageList[${listCounter.index }].imageSequence" /> <label
													for="icon_telephone">Order No of Image</label>
											</div>

											<button class="btn waves-effect waves-light red right"
												type="button" name="action" id="remove_1"
												onclick="removeDiv(this.id)">
												Remove <i class="material-icons right">remove_from_queue</i>
											</button>
										</div>
										<c:set var="cnt" value="${listCounter.index }"></c:set>
									</div>
								</c:forEach>
								<c:set var="cnt" value="${cnt+1 }"></c:set>
			<input type="hidden" name="imageCount" id="imageCount" value="${cnt }">
								<div id="imageBar">
									<div class="row" id="row_1">

										<div class="file-field input-field col s6">

											<img alt="no image uploaded" src="${imageDetail.imageUrl }"
												width="200" height="200">

										</div>
										<div class="file-field input-field col s6">
											<div class="btn">
												<span>Choose Image</span>
												<form:hidden path="imageList[${cnt }].siteId" />
												<form:hidden path="imageList[${cnt }].imageType" />
												<form:input type="file" path="imageList[${cnt }].file" />
												
											</div>
											<div class="file-path-wrapper">
												<input class="file-path validate" type="text"
													placeholder="choose image">
											</div>
										</div>

										<div class="input-field col s6">
											<form:input id="orderno${cnt }" type="text" class="validate" path="imageList[${cnt }].imageSequence" /> <label
												for="icon_telephone">Order No of Image</label>
										</div>

										<button class="btn waves-effect waves-light red right"
											type="button" name="action" id="remove_1"
											onclick="removeDiv(this.id)">
											Remove <i class="material-icons right">remove_from_queue</i>
										</button>
									</div>
									<c:set var="cnt" value="${cnt+1 }"></c:set>
								</div>
								<div class="row" id="rowadd">
									<div class=" col s12">
										<button class="btn waves-effect waves-light right"
											id="addButton" type="button" name="action" onclick="addDiv()">
											Add more <i class="material-icons right">add</i>
										</button>
									</div>
								</div>

							 <button class="btn waves-effect waves-light right" type="submit" name="action" >Submit
				   					 <i class="material-icons right">send</i>
				  				</button>
						</div>
					</div>

					<!-- /.panel-body -->
				</div>
				<!-- /.col-lg-12 -->

			</div>
			<!-- /. PAGE INNER  -->
			
		</form:form>

	</div>
	<!-- /. PAGE WRAPPER  -->
	</div>

</body>
</html>
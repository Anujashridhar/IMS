<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="resources/js/siteDetailForm.js">
	
</script>
<style>
.menu
{
	border: threedface;
}

.locdivcss
{
  display: none;
}

</style>
<div id="page-wrapper">
	<div class="header">
		<h1 class="page-header">Form Inputs Page</h1>
	</div>

	<div id="page-inner">
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<!-- <div class="card-content"> -->
						<form:form class="col s12" modelAttribute="site" action="${pageContext.request.contextPath}/site/admin/siteTemplateSetup"
							id="siteDetailForm">
							<p style="color: red;">${message }</p>

							<div class="row" id="row1">
								<div class="input-field col s6">
									<form:input id="icon_prefix" path="siteData.name"
										class="validate" />
									<p style="color: red;">
										<form:errors path="siteData.name"></form:errors>
									</p>
									<label for="icon_prefix" class="active">Main Heading</label>


								</div>

								<div class="input-field col s4">
									<form:input id="icon_prefix" path="siteData.urlName"
										class="validate" data-toggle="tooltip"
										title="A unique Name to be added for site on central server. e.g. to get   wwww.cdac.com/mysite url type 'mysite' " />
									<p style="color: red;">
										<form:errors path="siteData.urlName"></form:errors>
									</p>
									<label for="icon_prefix" class="active">Url Name</label>


								</div>
								<div class="input-field col s2">
									<input type="button" value="Check Availability">


								</div>
							</div>


							<!-- location row  start -->
							<div class="row" id="row2">
								<div class="input-field col s4">
									<form:input id="icon_prefix" path="siteData.noOfDivs"
										class="validate" type="number" max="6" min="0" />
									<p style="color: red;">
										<form:errors path="siteData.noOfDivs"></form:errors>
									</p>
									<label for="icon_prefix" class="active">No of boxes of
										contents as shown in demo Template</label>


								</div>

								<div class="input-field col s3" data-toggle="tooltip"
									title="Hierarchy levels for address locations in forms (for e.g. State and city are two hierarchy levels, state being level1 and city being level2)">
									<form:input id="locLevelCount" type="number" max="4" min="0"
										class="validate" path="siteData.noOfHierarchyLevels"
										onchange="addLocationFields(this.id)" />

									<p style="color: red;" id="hierarchy_count_error">
										<form:errors path="siteData.noOfHierarchyLevels"></form:errors>
									</p>
									<label for="locLevelCount">No.of Hierarchy Levels for
										Locations</label>

								</div>
								<div id="loc_div" class="input-field col s3">
									<c:choose>
										<c:when
											test="${site.siteData.noOfHierarchyLevels ==null || site.siteData.noOfHierarchyLevels ==0  }">
											<div class="input-field locdivcss" id="locNameDiv1"
												>
												<form:input path="siteData.locLevel1" id="inputLocLevel1" />
												<br> <label for="icon_telephone" class="active">Name
													of Location level 1</label>
											</div>
											<div class="input-field locdivcss" 
												id="locNameDiv2">
												<form:input path="siteData.locLevel2" id="inputLocLevel2" />
												<label for="icon_telephone" class="active">Name of
													Location level 2</label>
											</div>
											<div class="input-field locdivcss" 
												id="locNameDiv3">
												<form:input path="siteData.locLevel3" id="inputLocLevel3" />
												<label for="icon_telephone" class="active">Name of
													Location level 3</label>
											</div>
											<div class="input-field locdivcss" 
												id="locNameDiv4">
												<form:input path="siteData.locLevel4" id="inputLocLevel4" />
												<label for="icon_telephone" class="active">Name of
													Location level 4</label>
											</div>
										</c:when>
										<c:when test="${site.siteData.noOfHierarchyLevels==1 }">
											<div class="input-field " id="locNameDiv1">
												<form:input path="siteData.locLevel1" id="inputLocLevel1" />
												<br> <label for="icon_telephone" class="active">Name
													of Location level 1</label>
											</div>
											<div class="input-field locdivcss" 
												id="locNameDiv2">
												<form:input path="siteData.locLevel2" id="inputLocLevel2" />
												<label for="icon_telephone" class="active">Name of
													Location level 2</label>
											</div>
											<div class="input-field locdivcss" 
												id="locNameDiv3">
												<form:input path="siteData.locLevel3" id="inputLocLevel3" />
												<label for="icon_telephone" class="active">Name of
													Location level 3</label>
											</div>
											<div class="input-field locdivcss" 
												id="locNameDiv4">
												<form:input path="siteData.locLevel4" id="inputLocLevel4" />
												<label for="icon_telephone" class="active">Name of
													Location level 4</label>
											</div>
										</c:when>
										<c:when test="${site.siteData.noOfHierarchyLevels==2 }">
											<div class="input-field" id="locNameDiv1">
												<form:input path="siteData.locLevel1" id="inputLocLevel1" />
												<label for="icon_telephone" class="active">Name of
													Location level 1</label>
											</div>
											<div class="input-field " id="locNameDiv2">
												<form:input path="siteData.locLevel2" id="inputLocLevel2" />
												<label for="icon_telephone" class="active">Name of
													Location level 2</label>
											</div>

											<div class="input-field locdivcss" 
												id="locNameDiv3">
												<form:input path="siteData.locLevel3" id="inputLocLevel3" />
												<label for="icon_telephone" class="active">Name of
													Location level 3</label>
											</div>
											<div class="input-field locdivcss" 
												id="locNameDiv4">
												<form:input path="siteData.locLevel4" id="inputLocLevel4" />
												<label for="icon_telephone" class="active">Name of
													Location level 4</label>
											</div>
										</c:when>
										<c:when test="${site.siteData.noOfHierarchyLevels==3 }">
											<div class="input-field " id="locNameDiv1">
												<form:input path="siteData.locLevel1" id="inputLocLevel1" />
												<label for="icon_telephone" class="active">Name of
													Location level 1</label>
											</div>
											<div class="input-field " id="locNameDiv2">
												<form:input path="siteData.locLevel2" id="inputLocLevel2" />
												<label for="icon_telephone" class="active">Name of
													Location level 2</label>
											</div>
											<div class="input-field" id="locNameDiv3">
												<form:input path="siteData.locLevel3" id="inputLocLevel3" />
												<label for="icon_telephone" class="active">Name of
													Location level 3</label>
											</div>

											<div class="input-field locdivcss" 
												id="locNameDiv4">
												<form:input path="siteData.locLevel4" id="inputLocLevel4" />
												<label for="icon_telephone" class="active">Name of
													Location level 4</label>
											</div>
										</c:when>
										<c:when test="${site.siteData.noOfHierarchyLevels==4 }">
											<div class="input-field" id="locNameDiv1">
												<form:input path="siteData.locLevel1" id="inputLocLevel1" />
												<label for="icon_telephone">Name of Location level 1</label>
											</div>
											<div class="input-field" id="locNameDiv2">
												<form:input path="siteData.locLevel2" id="inputLocLevel2" />
												<label for="icon_telephone" class="active">Name of
													Location level 2</label>
											</div>
											<div class="input-field " id="locNameDiv3">
												<form:input path="siteData.locLevel3" id="inputLocLevel3" />
												<label for="icon_telephone" class="active">Name of
													Location level 3</label>
											</div>
											<div class="input-field " id="locNameDiv4">
												<form:input path="siteData.locLevel4" id="inputLocLevel4" />
												<label for="icon_telephone" class="active">Name of
													Location level 4</label>
											</div>
										</c:when>

									</c:choose>

								</div>
							</div>
							<!-- location row end  -->
							
							<!-- menu box start -->
							
							<div class="row" id="menusTopDiv">
							
								<c:set var="menu_count" value="0"></c:set>
								<c:set var="submenu_count" value="0"></c:set>
								<c:set var="total_submenu_count" value="0"></c:set>
								
								<!-- iteration for menus  -->	
								<c:forEach items="${site.menuSubmenuData }" var="menu"	varStatus="cnt">
								
									<div class="row menu" id="menu_row_${cnt.index }">
									
										<div class="input-field col s3">
												<%-- <input id="icon_telephone" type="tel" value="${menu.key }" name="menuDetails[${cnt.index}].menuName" id="menu_${cnt.index }" class="validate active">  --%>
												<form:input value="${menu.key.menuName }"
													path="menuDetails[${cnt.index}].menuName"
													id="menu_name_${cnt.index  }" class="validate active" />
												<form:hidden value="${menu.key.menuUrl }"
													path="menuDetails[${cnt.index}].menuUrl"
													id="menu_url_${cnt.index  }" />
												<form:hidden value="${menu.key.parentId }"
													path="menuDetails[${cnt.index}].parentId"
													id="menu_parent_${cnt.index  }" class="validate active" />
												<form:hidden value="${menu_count }"
													path="menuDetails[${cnt.index}].menuId"
													id="menu_id_${cnt.index  }" class="validate active" />
												<label for="icon_telephone" class="active">Menu name</label>
											</div>
											
											<c:if test="${empty menu.value }">
												<div class="col s2" id="check_div_${cnt.index }">
													<input type="checkbox" id="check_${cnt.index}"
														onchange="checkChange(this.id)" /> <label
														for="check_${cnt.index}">Sub menu</label>
												</div>
											</c:if>
											<c:if test="${not empty menu.value }">
												<div class="col s2" id="check_div_${cnt.index }">
													<input type="checkbox" class="filled-in"
														id="check_${cnt.index}" checked="checked"
														onchange="checkChange(this.id)" /> <label
														for="check_${cnt.index}">Sub menu</label>
												</div>
											</c:if>
											<div class="col s6" id="submenu_container_${cnt.index }">
											<c:forEach items="${menu.value}" var="submenu"	varStatus="submenucnt">
													<div id="submenu_row_${cnt.index }_${submenucnt.index}" class="row">
														
														
														<div id="submenu_div_${cnt.index }" class="input-field col s6">
															<form:input value="${submenu.subMenuName }"
																	path="submenu[${total_submenu_count }].subMenuName"
																	id="submenu_name_${cnt.index  }_${submenucnt.index }" class="validate active" />
															<%-- <form:hidden value="${submenu.subMenuUrl }"
																path="submenu[${total_submenu_count }].subMenuUrl"
																id="submenu_url_${cnt.index }_${submenucnt.index }" /> --%>
															<form:hidden value="${menu_count }"
																path="submenu[${total_submenu_count }].parentId"
																id="submenu_parentId_${cnt.index}_${submenucnt.index }" class="validate active" />
															<%-- <form:hidden value="${submenu.subMenuId }"
																path="submenu[${total_submenu_count }].subMenuId"
																id="submenu_id_${cnt.index}_${submenucnt.index }" class="validate active" /> --%>
														</div>
														<div id="button_div_${cnt.index }_${submenucnt.index }"	class="input-field col s6">
																
											 	<button id="remove_button_${cnt.index }_${submenucnt.index }" class="btn add-more" type="button" onclick="deleteSubmenu(this.id)" >-</button>
											 	<c:if test="${submenucnt.last}">
												<button id="add_button_${cnt.index }" class="btn add-more"	type="button" onclick="addMoreSubmenu(this.id)">+</button>
												</c:if>
												
														</div>	
															
														<c:set var="submenu_count" value="${ submenucnt.index}"></c:set>
														<c:set var="total_submenu_count" value="${ total_submenu_count+1}"></c:set>
													</div>
													
											</c:forEach>
											<c:set var="menu_count" value="${menu_count+1 }"></c:set>
										
											</div>	<input type="hidden" value="${submenu_count}" id="no_of_submenus_in_${cnt.index }">
											<div class="col s1">
												<button id="delete_button_${cnt.index }" class="btn add-more glyphicon glyphicon-remove"	type="button" onclick="deleteMenu(this.id)"></button>
											
											</div>
									</div>
									<c:set var="menuCount" value="${ cnt.index}"></c:set>
								</c:forEach>
							
							
							<!-- menu box end -->
							
							<!-- new Menu Box -->
							 <c:set var="menu_count" value="${menu_count+1 }"></c:set> 
							<%-- <c:set var="menu_count" value="10"></c:set> --%>
							<input type="hidden" value="${menu_count}" id="no_of_menus">
							
							<div class="row menu" id="menu_row_${menu_count }">
									
										<div class="input-field col s3">
												<%-- <input id="icon_telephone" type="tel" value="${menu.key }" name="menuDetails[${cnt.index}].menuName" id="menu_${cnt.index }" class="validate active">  --%>
												<form:input value=""
													path="menuDetails[${menu_count }].menuName"
													id="menu_name_${menu_count }" class="validate active" />
													<label for="menu_name_${menu_count }" class="active">Menu name</label>
												<form:hidden value=""
													path="menuDetails[${menu_count }].menuUrl"
													id="menu_url_${menu_count }" />
												<form:hidden value="0"
													path="menuDetails[${menu_count }].parentId"
													id="menu_parent_${menu_count }" class="validate active" />
												<form:hidden 
													path="menuDetails[${menu_count }].menuId" value="${menu_count }" 
													id="menu_id_${menu_count }" class="validate active" />
												
											</div>
											<div class="col s2" id="check_div_${menu_count}">
													<input type="checkbox" id="check_${menu_count}"
														onchange="checkChange(this.id)" /> <label
														for="check_${menu_count}">Sub menu</label>
											</div>
											
											<div class="col s6" id="submenu_container_${menu_count}">
											
											</div>
											 <input type="hidden" value="10" id="no_of_submenus_in_${menu_count }"> 
											<div class="col s1">
												<%-- <button id="delete_button_${menu_count }" class="btn add-more glyphicon glyphicon-remove"	type="button" onclick="deleteMenu(this.id)"></button> --%>
												<input type="hidden" value="0" id="no_of_submenus_in_${menu_count }">
											</div>		
							</div>
							
									
							
							</div>
							 
							<div class="row">
							<button type="button" class="btn waves-effect waves-light"  onclick="addDiv()">Add Menu <i class="material-icons ">send</i></button>
							</div>
							<div class="row">
							<button class="btn waves-effect waves-light" type="button"
								name="action" onclick="submitForm(this.id)">
								Submit <i class="material-icons right">send</i>
							</button>
							</div>
							
							<!-- new Menu Box  -->
							
							<input type="hidden" value="${total_submenu_count }" id="no_of_total_submenus">
						</form:form>
					</div>
					
				<!-- </div> -->
			</div>
		</div>
	</div>
</div>
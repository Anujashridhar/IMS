<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript" src="resources/js/siteDetailForm.js">
  
    </script>
    

        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                             Form Inputs Page
                        </h1>
		 </div>
		
            <div id="page-inner"> 
			
              <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-action">
                            Basic Form Elements
                        </div>
                        <div class="card-content">
                         	<form:form class="col s12" modelAttribute="site" id="siteDetailForm" >
								
								  
								   
								   <p style="color: red;">${message }</p>
								    
								    
								    <div class="row" id="row1">
									<div class="input-field col s6">
									 <form:input id="icon_prefix" path="siteData.name" class="validate" />
									 <p style="color: red;"><form:errors path="siteData.name"></form:errors></p>
									  <label for="icon_prefix" class="active">Main Heading</label>
									</div>
									<div  class="input-field col s3" data-toggle="tooltip" title="Hierarchy levels for address locations in forms (for e.g. State and city are two hierarchy levels, state being level1 and city being level2)">
									  <form:input id="locLevelCount" type="number" max="4" min="0" class="validate" path="siteData.noOfHierarchyLevels" onchange="addLocationFields(this.id)"/>
									 
									  <p style="color: red;" id="hierarchy_count_error"> <form:errors path="siteData.noOfHierarchyLevels"></form:errors></p>
									  <label for="locLevelCount">No.of Hierarchy Levels for Locations</label>
									 
									</div> 
										<div id="loc_div" class="input-field col s3">
											<c:choose  >
											<c:when test="${site.siteData.noOfHierarchyLevels==1 }">
											 	<div class="input-field " id="locNameDiv1" >
												   <form:input  path="siteData.locLevel1"  id="inputLocLevel1"/><br>
												  <label for="icon_telephone" class="active">Name of Location level 1</label>
												</div>
												 <div class="input-field" style="display: none;" id="locNameDiv2">
												 <form:input  path="siteData.locLevel2" id="inputLocLevel2"/>
												 <label for="icon_telephone" class="active">Name of Location level 2</label>
												</div>
												  <div class="input-field " style="display: none;" id="locNameDiv3">
												 <form:input  path="siteData.locLevel3"  id="inputLocLevel3"/>
												 <label for="icon_telephone" class="active">Name of Location level 3</label>
												</div>
												  <div class="input-field " style="display: none;" id="locNameDiv4">
												 <form:input  path="siteData.locLevel4"  id="inputLocLevel4"/>
												 <label for="icon_telephone" class="active" >Name of Location level 4</label>
												</div>
											</c:when>
											<c:when test="${site.siteData.noOfHierarchyLevels==2 }">
											 <div class="input-field" id="locNameDiv1">
											     <form:input  path="siteData.locLevel1"  id="inputLocLevel1"/>
											     <label for="icon_telephone" class="active">Name of Location level 1</label>
												</div>
											      <div class="input-field " id="locNameDiv2">
												 <form:input  path="siteData.locLevel2"  id="inputLocLevel2"/>
												 <label for="icon_telephone" class="active">Name of Location level 2</label>
												</div>
												 
												  <div class="input-field " style="display: none;" id="locNameDiv3">
												 <form:input  path="siteData.locLevel3"  id="inputLocLevel3"/>
												 <label for="icon_telephone" class="active">Name of Location level 3</label>
												</div>
												  <div class="input-field " style="display: none;" id="locNameDiv4">
												 <form:input  path="siteData.locLevel4"  id="inputLocLevel4"/>
												 <label for="icon_telephone" class="active" >Name of Location level 4</label>
												</div> 
											</c:when>
											<c:when test="${site.siteData.noOfHierarchyLevels==3 }">
											 <div class="input-field " id="locNameDiv1">
												<form:input  path="siteData.locLevel1"  id="inputLocLevel1"/>
												<label for="icon_telephone" class="active">Name of Location level 1</label>
												</div>
												 <div class="input-field " id="locNameDiv2">
												 <form:input  path="siteData.locLevel2"  id="inputLocLevel2"/>
												 <label for="icon_telephone" class="active">Name of Location level 2</label>
												</div>
												  <div class="input-field" id="locNameDiv3">
												 <form:input  path="siteData.locLevel3"  id="inputLocLevel3"/>
												 <label for="icon_telephone" class="active">Name of Location level 3</label>
												</div>
												
												  <div class="input-field " style="display: none;" id="locNameDiv4">
												 <form:input  path="siteData.locLevel4"  id="inputLocLevel4"/>
												 <label for="icon_telephone" class="active" >Name of Location level 4</label>
												</div>
											</c:when>
											<c:when test="${site.siteData.noOfHierarchyLevels==4 }">
											 <div class="input-field" id="locNameDiv1" >
											<form:input  path="siteData.locLevel1"  id="inputLocLevel1"/>
											<label for="icon_telephone">Name of Location level 1</label>
												</div>
											 <div class="input-field" id="locNameDiv2" >
												 <form:input  path="siteData.locLevel2"  id="inputLocLevel2"/>
												 <label for="icon_telephone" class="active">Name of Location level 2</label>
												</div>
												  <div class="input-field " id="locNameDiv3">
												 <form:input  path="siteData.locLevel3"  id="inputLocLevel3"/>
												 <label for="icon_telephone" class="active">Name of Location level 3</label>
												</div>
												  <div class="input-field " id="locNameDiv4">
												 <form:input  path="siteData.locLevel4"  id="inputLocLevel4"/>
												 <label for="icon_telephone" class="active" >Name of Location level 4</label>
												</div>
											</c:when>
											
											</c:choose>
											
									 	</div>
									   </div>
									   <div  id="menuBar">
									   
									  <%--  <c:if test="${not empty menuMap } "> --%>
									  	<c:set var="menu_count" value="0"></c:set>
									  	<c:set var="submenu_count" value="0"></c:set>
											   <c:forEach items="${site.menuSubmenuData }" var="menu" varStatus="cnt">
											   
											   <br>
											   
											    		 <div class="row" id="row${cnt.index }">
														 <div class="input-field col s3">
														   <%-- <input id="icon_telephone" type="tel" value="${menu.key }" name="menuDetails[${cnt.index}].menuName" id="menu_${cnt.index }" class="validate active">  --%>
														    <form:input value="${menu.key }" path="menuDetails[${menu_count }].menuName" id="menu_${menu_count }" class="validate active"/> 
														     <form:hidden value="${menu.value.url }" path="menuDetails[${menu_count }].menuUrl" id="menu_${menu_count }"/> 
														      <form:hidden value="${menu.value.parentId }" path="menuDetails[${menu_count }].parentId" id="menu_${menu_count }" class="validate active"/> 
														       <form:hidden value="${menu.value.menuId }" path="menuDetails[${menu_count }].menuId" id="menu_${menu_count }" class="validate active"/> 
														  <label for="icon_telephone" class="active">Menu name</label>
														</div>
														<c:if test="${empty menu.value.sumenuList }">
															<div class="col s2" id="check_div_${cnt.index }">
														      <input type="checkbox" id="check_${cnt.index}"  />
														      <label for="test6">Sub menu</label>
														    </div>
														
														</c:if>
														<c:if test="${not empty menu.value.sumenuList }">
															<div class="col s2" id="check_div_${cnt.index }">
														      <input type="checkbox" id="check_${cnt.index}"  checked="checked"/>
														      <label for="test6">Sub menu</label>
														    </div>
														
														</c:if>
														
															    <div class="input-field col s3" id="sub_cnt_${cnt.index }">
																  <input id="submenu_1" type="tel" class="validate active" value=" ${fn:length(menu.value.sumenuList)}" onchange="addinputFields(this.id)" ><br />
																  <label for="icon_telephone" class="active">No.of sub menu</label>
																</div>
																
																<div id="container_${cnt.index }" class="input-field col s3">
														<c:forEach items="${menu.value.sumenuList }" var="submenu" varStatus="submenucnt">
														 	<c:set var="menu_count" value="${menu_count+1 }"></c:set>
									  	
														  			<div  class="input-field " id="sub_div_${menu_cnt.index }_${submenucnt.index}">
																	    <form:input value="${submenu.menuName }" path="menuDetails[${menu_count }].menuName" id="menu_${menu_count }" class="validate active"/> 
														     <form:hidden value="${submenu.url }" path="menuDetails[${menu_count }].menuUrl" id="menu_${menu_count }"/> 
														      <form:hidden value="${submenu.parentId }" path="menuDetails[${menu_count }].parentId" id="menu_${menu_count }" class="validate active"/> 
														       <form:hidden value="${submenu.menuId }" path="menuDetails[${menu_count }].menuId" id="menu_${menu_count }" class="validate active"/> 
													
																	  <%-- 
																	  <input id="submenu_1" type="tel" class="validate active" value="${submenu.menuName }" name="subMenu" onchange="addinputFields(this.id)" ><br />
																	 --%>  
																	  <label for="icon_telephone" class="active">sub menu</label>
																  </div>
																  <c:set var="submenu_count" value="${ submenucnt.index}"></c:set>
														</c:forEach>
													    </div>
														</div>
																   <c:set var="menu_count" value="${menu_count+1}"></c:set>
									  							
											   </c:forEach>
											  
									   <%-- </c:if> --%>
									    <div class="row" id="row${menu_count }">
									 <div class="input-field col s3">
									   <form:input  path="menuDetails[${menu_count }].menuName" id="menu_${cnt.index }" class="validate active"/> 
														     <form:hidden path="menuDetails[${menu_count }].menuUrl" id="menu_${menu_count }"/> 
														      <form:hidden path="menuDetails[${menu_count }].parentId" value="0" id="menu_${menu_count }" class="validate active"/> 
														       <form:hidden path="menuDetails[${menu_count }].menuId" id="menu_${menu_count }" class="validate active"/> 
														 
									  <input id="icon_telephone" type="tel" id="menu_${menu_count }" class="validate">
									  <label for="icon_telephone">Menu name</label>
									</div>
									<div class="col s2" id="check_div_${menu_count}">
								      <input type="checkbox" id="check_${menu_count}"  />
								      <label for="test6">Sub menu</label>
								    </div>
								    <div class="input-field col s3" id="sub_cnt_${menu_count }">
									  <input id="submenu_1" type="tel" class="validate" onchange="addinputFields(this.id)" ><br />
									  <label for="icon_telephone">No.of sub menu</label>
									</div>
									 <c:set var="menu_count" value="${menu_count+1}"></c:set>
									  <div id="container_1" class="input-field col s3">
									    <form:input  path="menuDetails[${menu_count }].menuName" id="menu_${cnt.index }" class="validate active"/> 
									   <form:hidden path="menuDetails[${menu_count }].parentId" value="-1" id="menu_${menu_count }" class="validate active"/> 
														     
									  </div>
									</div>
									</div>
									<div class="row" id="rowadd">
									<div class=" col s12">
									<button class="btn waves-effect waves-light" id="addButton" type="button" name="action" onclick="addDiv()">Add more
					   					 <i class="material-icons right">add</i>
					  				</button>
									</div>
									</div>
									
								
									<button class="btn waves-effect waves-light" type="button" name="action" onclick="submitForm(this.id)">Submit
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
        
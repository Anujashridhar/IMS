 <%@include file="studentheader.jsp" %>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${pageContext.request.contextPath }/resources/js/studentupdate.js" type="text/javascript"></script>

<div class="container">
<h2>Student Admission</h2>  
  <div class="row">

    	<section>
        <div class="wizard">
            <div class="wizard-inner">
                <div class="connecting-line"></div>
                <ul class="nav nav-tabs" role="tablist">
					<c:if test="${activeTab == 'tab1'}">
					 <li role="presentation" id="tab1" class="active">
					  <a href="#step1" data-toggle="tab" aria-controls="step1" role="tab" title="Step 1" aria-expanded="true">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-folder-open"></i>
                            </span>
                        </a>
                    </li>
					</c:if>
					<c:if test="${activeTab != 'tab1'}">
					 <li role="presentation" id="tab1" class="disabled">
					  <a href="#step1" data-toggle="tab" aria-controls="step1" role="tab" title="Step 1" aria-expanded="false">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-folder-open"></i>
                            </span>
                        </a>
                    </li>
					</c:if>
                      
				<c:if test="${activeTab=='tab2'}">
					 <li role="presentation" id="tab2" class="active">
					  <a href="#step2" data-toggle="tab" aria-controls="step2" role="tab" title="Step 2" aria-expanded="true">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-pencil"></i>
                            </span>
                        </a>
                    </li>
					</c:if>
					<c:if test="${activeTab!='tab2'}">
					 <li role="presentation" id="tab2" class="disabled">
					 <a href="#step2" data-toggle="tab" aria-controls="step2" role="tab" title="Step 2" aria-expanded="false">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-pencil"></i>
                            </span>
                        </a>
                    </li>
					</c:if>
                       
                    <li role="presentation" id="tab3" class="disabled">
                        <a href="#step3" data-toggle="tab" aria-controls="step3" role="tab" title="Step 3">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-picture"></i>
                            </span>
                        </a>
                    </li>

                    <li role="presentation" id="tab4" class="disabled">
                        <a href="#complete" data-toggle="tab" aria-controls="complete" role="tab" title="Complete">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-ok"></i>
                            </span>
                        </a>
                    </li>
                </ul>
            </div>

            <form:form role="form" data-toggle="validator" method="post" modelAttribute="studentWrapper"  action="${pageContext.request.contextPath}/student/savedata">
                <div class="tab-content">
                <c:if test="${activeTab == 'tab1'}">
  <div class="tab-pane active" role="tabpanel" id="step1">
  </c:if>
                 <c:if test="${activeTab != 'tab1'}">
  <div class="tab-pane " role="tabpanel" id="step1">
  </c:if>
                        <div class="step1">
<div class="row" style="background-color: lightblue;margin-top:1%;padding-left:1%;">
<h2 class="col-sm- control-label" style="color:white">Personal Information</h2>
</div>


                            <div class="row">
                            <div class="col-md-6">
                                <label for="exampleInputEmail1">First Name</label>
                                <form:input type="text" class="form-control" id="firstName" placeholder="First Name" path="user.userName" required="required" />
                            </div>
                            <div class="col-md-6">
                                <label for="exampleInputEmail1">Last Name</label>
                                <form:input type="text" class="form-control" id="lastName" path="user.lastName" placeholder="Last Name"  required="required"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label for="exampleInputEmail1">Email address</label>
                                <form:input type="email" class="form-control" id="emailAddress" path="user.userEmail" placeholder="Email"  /> 
                            	<form:errors path="user.userEmail" />
                            </div>
			         <div class="col-md-6">
                                <label for="exampleInputEmail1">Mobile Number</label>
                                <form:input type="number" class="form-control" id="mobileNumber" path="user.userContactNo" placeholder="Mobile No." />
                                <form:errors path="user.userContactNo" />
                            </div>                   
     </div>

                        <div class="row">
                   
                            <div class="col-md-6">
    				<label for="registration-date">Date of birth:</label>
   			<div class="input-group registration-date-time">
     		   	<span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></span>
		    <form:input class="form-control" name="registration_date" id="dateOfBirth"  path="studentPersonalDetails.dateOfBirth" />
        </div>
    </div>    
                        </div>
                        </div>
<div class="row" style="background-color: lightblue;margin-top:1%;padding-left:1%;">
<h2 style="color:white">Location</h2>
</div>
  <legend>Current Address Details</legend>
   <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">Line 1</label>
            <div class="col-sm-10">
              <form:input type="text" placeholder="Address Line 1" id="currentAddressLine1" path="studentPersonalDetails.currentAddressLine1" class="form-control"/>
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">Line 2</label>
            <div class="col-sm-10">
              <form:input type="text" placeholder="Address Line 2" class="form-control" id="currentAddressLine2" path="studentPersonalDetails.currentAddressLine2" />
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">City</label>
            <div class="col-sm-10">
              <form:input type="text" placeholder="City" class="form-control" path="studentPersonalDetails.currentCity" id="currentCity"/>
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">State</label>
            <div class="col-sm-5">
              <form:input type="text" placeholder="State" class="form-control" path="studentPersonalDetails.currentState" id="currentState"/>
            </div>

            <label class="col-sm-1 control-label" for="textinput">Postcode</label>
            <div class="col-sm-4">
              <form:input type="text" placeholder="Post Code" class="form-control" path="studentPersonalDetails.currentPostcode" id="currentPostcode" />
            </div>
          </div>
<div style="margin-top:5%"> 
<legend>Permant Address Details</legend>
</div>
         <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">Line 1</label>
            <div class="col-sm-10">
              <form:input type="text" placeholder="Address Line 1" class="form-control" path="studentPersonalDetails.permantAddressLine1" id="permantAddressLine1" />
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">Line 2</label>
            <div class="col-sm-10">
              <form:input type="text" placeholder="Address Line 2" class="form-control" path="studentPersonalDetails.permantAddressLine2" id="permantAddressLine2" />
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">City</label>
            <div class="col-sm-10">
              <form:input type="text" placeholder="City" class="form-control" path="studentPersonalDetails.permantCity" id="permantCity"/>
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">State</label>
            <div class="col-sm-5">
              <form:input type="text" placeholder="State" class="form-control" path="studentPersonalDetails.permantState" id="permantState"/>
            </div>

            <label class="col-sm-1 control-label" for="textinput">Postcode</label>
            <div class="col-sm-4">
              <form:input type="text" placeholder="Post Code" class="form-control" path="studentPersonalDetails.permantPostcode" id="permantPostcode"/>
            </div>
          </div>

                        <ul class="list-inline pull-right" style="padding:1%">
                            <li><button type="submit" class="btn btn-primary next-step">Save and continue</button></li>
                          <li><button type="submit" class="btn btn-primary">Submit</button>
</li>
                        </ul>
                    </div>

</form:form>
           <c:if test="${activeTab == 'tab2'}">
  <div class="tab-pane active" role="tabpanel" id="step2">
  </c:if>
                 <c:if test="${activeTab != 'tab2'}">
  <div class="tab-pane " role="tabpanel" id="step2">
  </c:if>
<!--                     <div class="tab-pane" role="tabpanel" id="step2"> -->
                        <div class="step2">
                            <div class="">
                                <div class="row" style="background-color: lightblue;margin-top:1%;padding-left:1%;">
					<h2 class="col-sm- control-label" style="color:white">Programme Details</h2>
				</div>     
				 <div class="form-group">
				    <label for="exampleFormControlSelect1">Choose Level</label>
  					  <select class="form-control" id="exampleFormControlSelect1">
  					    <option>Graduate</option>
    					  <option>POST Graduate</option>
    					  <option>Diploma</option>
    				</select>
  			</div>

			 <div class="form-group">
				    <label for="exampleFormControlSelect1">Choose Course</label>
  					  <select class="form-control" id="exampleFormControlSelect1">
  					    <option>B.tech</option>
    					  <option>BCA</option>
    					  <option>b.com</option>
    					  <option>B.A.</option>
      				
    				</select>
  			</div>
 			<div class="form-group">
				    <label for="exampleFormControlSelect1">Choose Course Field</label>
  					  <select class="form-control" id="exampleFormControlSelect1">
  					    <option>Electronic</option>
    					  <option>Mechanical</option>
    					  <option>Information Technology</option>
    			
    				</select>
  			</div>

                            </div>
                        </div>
                        <ul class="list-inline pull-right">
                            <li><button type="button" class="btn btn-default prev-step">Previous</button></li>
                            <li><button type="button" class="btn btn-primary next-step">Save and continue</button></li>
                        </ul>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="step3">
                        <div class="step33">
                                <div class="row" style="background-color: lightblue;margin-top:1%;padding-left:1%;">
					<h2 class="col-sm- control-label" style="color:white">Qualification Details</h2>
				</div> 				
             <div class="panel panel-default">
<!--   <div class="panel-heading">Dynamic Form Fields - Add & Remove Multiple fields</div>
  <div class="panel-heading">Education Experience</div> -->
  <div class="panel-body">
  <div class="col-sm-12 nopadding">
   	         <div class="col-sm-2 nopadding">
                <label for="exampleFormControlSelect1">Certificate / Degree Name</label>
            </div>
   	         <div class="col-sm-2 nopadding">
                <label for="exampleFormControlSelect1">Roll no</label>
            </div>
	        <div class="col-sm-2 nopadding">
                <label for="exampleFormControlSelect1">Passing Year</label>
            </div>
	       <div class="col-sm-2 nopadding">
                <label for="exampleFormControlSelect1">Mark obtained</label>
            </div>
	
	            <div class="col-sm-2 nopadding">
                <label for="exampleFormControlSelect1">%age / CGPA</label>
            </div>
	
		            <div class="col-sm-2 nopadding">
                <label for="exampleFormControlSelect1">Board / University</label>
            </div>
	</div>
  <div id="education_fields">
          </div>
       <div class="col-sm-2 nopadding">
  <div class="form-group">
    <input type="text" class="form-control" id="degreename" name="degreename" value="" placeholder="Certificate / Degree Name">
  </div>
</div>
<div class="col-sm-2 nopadding">
  <div class="form-group">
    <input type="text" class="form-control" id="Rollno" name="Rollno" value="" placeholder="Roll no">
  </div>
</div>
<div class="col-sm-2 nopadding">
  <div class="form-group">
    <input type="text" class="form-control" id="Passingyear" name="passingyear" value="" placeholder="Passing Year">
  </div>
</div>
<div class="col-sm-2 nopadding">
  <div class="form-group">
    <input type="text" class="form-control" id="markobtained" name="markobtained" value="" placeholder="Mark Obtained">
  </div>
</div>
<div class="col-sm-2 nopadding">
  <div class="form-group">
    <input type="text" class="form-control" id="percentage" name="percentage" value="" placeholder="%age / CGPA">
  </div>
</div>
<!-- <div class="col-sm-2 nopadding">
  <div class="form-group">
    <input type="text" class="form-control" id="board" name="board" value="" placeholder="Board / University">
  </div>
</div>
<div class="col-sm-1 nopadding">
        <div class="input-group-btn">
        <button class="btn btn-success" type="button"  onclick="education_fields();"> <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> </button>
      </div>
</div> -->
 <div class="col-sm-2 nopadding">
  <div class="form-group">
    <div class="input-group">
      <div class="form-group">
    <input type="text" class="form-control" id="board" name="board" value="" placeholder="Board">
  </div>
     
      <div class="input-group-btn">
        <button class="btn btn-success" type="button"  onclick="education_fields();"> <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> </button>
      </div>
    </div>
  </div>
</div> 
<div class="clear"></div>
  
  </div>
  <div class="panel-footer"><small>Press <span class="glyphicon glyphicon-plus gs"></span> to add another form field :)</small>, <small>Press <span class="glyphicon glyphicon-minus gs"></span> to remove form field :)</small></div>
</div>
             
<!-- <table class="table table-bordered">
<tr>
<th>
</th>
			
   	<th>         <div class="">
                <label for="exampleFormControlSelect1">Roll no.</label>
            </div>
	</th>
	<th>
            <div class="">
                <label for="exampleFormControlSelect1">Session</label>
            </div>
	</th>
	<th> 
           <div class="">
                <label for="exampleFormControlSelect1">Mark obtained</label>
            </div>
	</th>
		<th>
	            <div>
                <label for="exampleFormControlSelect1">%age / CGPA</label>
            </div>
	</th>
	<th>
		            <div>
                <label for="exampleFormControlSelect1">Board / University</label>
            </div>
	</th>
	</tr>
   <div class="controls">
<tr class ="form">		
   <th>        
 <div >
                <label>10TH.</label>
            </div>
</th>
<th>
         <div class="form-group " style="">
            <div class="">
              <input type="text" placeholder="Roll no" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Session" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Mark obtained" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="%age / CGPA" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Board / University" class="form-control">
            </div>
          </div>
</th>
<th>
		   	<span class="input-group-btn">
                            <button class="btn btn-success btn-add" type="button">
                                <span class="glyphicon glyphicon-plus"></span>
                            </button>
                        </span>
 </th>
 
</tr>
</div>
<tr>
			
   <th>         <div class="">
                <label>12TH.</label>
            </div>
</th>
	<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Roll no" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Session" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Mark obtained" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="%age / CGPA" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Board / University" class="form-control">
            </div>
          </div>
</th>
</tr>
<tr>
			
   <th>         <div class="">
                <label>Graduation</label>
            </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Roll no" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Session" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Mark obtained" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="%age / CGPA" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Board / University" class="form-control">
            </div>
          </div>
</th>
</tr>
<tr>
			
   <th>         <div class="">
                <label>Post Graduation</label>
            </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Roll no" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Session" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Mark obtained" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="%age / CGPA" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Board / University" class="form-control">
            </div>
          </div>
</th>
</tr>
</table>
                                <div class="row" style="margin-top:1%;padding-left:1%;">
					<h2 class="col-sm- control-label" style="">Other</h2>
				</div> 

		<table class="table table-bordered">
<tr>

<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Roll no" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Session" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Mark obtained" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="%age / CGPA" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Board / University" class="form-control">
            </div>
          </div>
</th>
</tr>
<tr>

<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Roll no" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Session" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Mark obtained" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="%age / CGPA" class="form-control">
            </div>
          </div>
</th>
<th>
         <div class="form-group" style="">
            <div class="">
              <input type="text" placeholder="Board / University" class="form-control">
            </div>
          </div>
</th>
</tr>

		</table>
 -->

                            <div class="row mar_ned">
                               
                            </div>
                        </div>

                        <ul class="list-inline pull-right">
                            <li><button type="button" class="btn btn-default prev-step">Previous</button></li>
                            <li><button type="button" class="btn btn-default next-step">Skip</button></li>
                            <li><button type="button" class="btn btn-primary btn-info-full next-step">Save and continue</button></li>
                        </ul>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="complete">
                        <div class="step44">
                            <h5>Completed</h5>
                            
                          
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </form>
        </div>
    </section>
   </div>
</div>
</body>
</html>


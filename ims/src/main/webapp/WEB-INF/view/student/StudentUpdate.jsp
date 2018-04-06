<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
  <script>
$(document).ready(function () {
    //Initialize tooltips
    $('.nav-tabs > li a[title]').tooltip();
    
    //Wizard
    $('a[data-toggle="tab"]').on('show.bs.tab', function (e) {

        var $target = $(e.target);
    
        if ($target.parent().hasClass('disabled')) {
            return false;
        }
    });

    $(".next-step").click(function (e) {

        var $active = $('.wizard .nav-tabs li.active');
        $active.next().removeClass('disabled');
        nextTab($active);

    });
    $(".prev-step").click(function (e) {

        var $active = $('.wizard .nav-tabs li.active');
        prevTab($active);

    });
});

function nextTab(elem) {
    $(elem).next().find('a[data-toggle="tab"]').click();
}
function prevTab(elem) {
    $(elem).prev().find('a[data-toggle="tab"]').click();
}


//according menu

$(document).ready(function()
{
    //Add Inactive Class To All Accordion Headers
    $('.accordion-header').toggleClass('inactive-header');
	
	//Set The Accordion Content Width
	var contentwidth = $('.accordion-header').width();
	$('.accordion-content').css({});
	
	//Open The First Accordion Section When Page Loads
	$('.accordion-header').first().toggleClass('active-header').toggleClass('inactive-header');
	$('.accordion-content').first().slideDown().toggleClass('open-content');
	
	// The Accordion Effect
	$('.accordion-header').click(function () {
		if($(this).is('.inactive-header')) {
			$('.active-header').toggleClass('active-header').toggleClass('inactive-header').next().slideToggle().toggleClass('open-content');
			$(this).toggleClass('active-header').toggleClass('inactive-header');
			$(this).next().slideToggle().toggleClass('open-content');
		}
		
		else {
			$(this).toggleClass('active-header').toggleClass('inactive-header');
			$(this).next().slideToggle().toggleClass('open-content');
		}
	});
	
	return false;
});
</script>

<div class="container">
<h2>Student Admission</h2>  
  <div class="row">
    	<section>
        <div class="wizard">
            <div class="wizard-inner">
                <div class="connecting-line"></div>
                <ul class="nav nav-tabs" role="tablist">

                    <li role="presentation" class="active">
                        <a href="#step1" data-toggle="tab" aria-controls="step1" role="tab" title="Step 1">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-folder-open"></i>
                            </span>
                        </a>
                    </li>

                    <li role="presentation" class="disabled">
                        <a href="#step2" data-toggle="tab" aria-controls="step2" role="tab" title="Step 2">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-pencil"></i>
                            </span>
                        </a>
                    </li>
                    <li role="presentation" class="disabled">
                        <a href="#step3" data-toggle="tab" aria-controls="step3" role="tab" title="Step 3">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-picture"></i>
                            </span>
                        </a>
                    </li>

                    <li role="presentation" class="disabled">
                        <a href="#complete" data-toggle="tab" aria-controls="complete" role="tab" title="Complete">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-ok"></i>
                            </span>
                        </a>
                    </li>
                </ul>
            </div>

            <form role="form" data-toggle="validator">
                <div class="tab-content">
  <div class="tab-pane active" role="tabpanel" id="step1">
                        <div class="step1">
<div class="row" style="background-color: lightblue;margin-top:1%;padding-left:1%;">
<h2 class="col-sm- control-label" style="color:white">Personal Information</h2>
</div>

                            <div class="row">
                            <div class="col-md-6">
                                <label for="exampleInputEmail1">First Name</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="First Name" required>
                            </div>
                            <div class="col-md-6">
                                <label for="exampleInputEmail1">Last Name</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Last Name">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label for="exampleInputEmail1">Email address</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                            </div>
			         <div class="col-md-6">
                                <label for="exampleInputEmail1">Mobile Number</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                            </div>                   
     </div>

                        <div class="row">
                   
                            <div class="col-md-6">
    				<label for="registration-date">Date of birth:</label>
   			<div class="input-group registration-date-time">
     		   	<span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></span>
		    <input class="form-control" name="registration_date" id="registration-date" type="date">
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
              <input type="text" placeholder="Address Line 1" class="form-control">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">Line 2</label>
            <div class="col-sm-10">
              <input type="text" placeholder="Address Line 2" class="form-control">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">City</label>
            <div class="col-sm-10">
              <input type="text" placeholder="City" class="form-control">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">State</label>
            <div class="col-sm-5">
              <input type="text" placeholder="State" class="form-control">
            </div>

            <label class="col-sm-1 control-label" for="textinput">Postcode</label>
            <div class="col-sm-4">
              <input type="text" placeholder="Post Code" class="form-control">
            </div>
          </div>
<div style="margin-top:5%"> 
<legend>Permant Address Details</legend>
</div>
         <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">Line 1</label>
            <div class="col-sm-10">
              <input type="text" placeholder="Address Line 1" class="form-control">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">Line 2</label>
            <div class="col-sm-10">
              <input type="text" placeholder="Address Line 2" class="form-control">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">City</label>
            <div class="col-sm-10">
              <input type="text" placeholder="City" class="form-control">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group" style="padding:1%">
            <label class="col-sm-1 control-label" for="textinput">State</label>
            <div class="col-sm-5">
              <input type="text" placeholder="State" class="form-control">
            </div>

            <label class="col-sm-1 control-label" for="textinput">Postcode</label>
            <div class="col-sm-4">
              <input type="text" placeholder="Post Code" class="form-control">
            </div>
          </div>

                        <ul class="list-inline pull-right" style="padding:1%">
                            <li><button type="submit" class="btn btn-primary next-step">Save and continue</button></li>
                          <li><button type="submit" class="btn btn-primary">Submit</button>
</li>
                        </ul>
                    </div>

</form>
                    <div class="tab-pane" role="tabpanel" id="step2">
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
                        <hr>
<table class="table table-bordered">
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
<tr>
			
   <th>        
 <div class="">
                <label>10TH.</label>
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


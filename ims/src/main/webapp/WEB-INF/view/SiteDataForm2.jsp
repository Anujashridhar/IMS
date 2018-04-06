<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>site data registration</title>
<script type="text/javascript">
    var counter = 2;
function addDiv(){
	 
	   debugger;
	   if(counter > 6){
		   alert("Only 6 menu allow")
		   return false;
	   }
	 			var html = '<div class="input-field col s3">'
	 			+'<input id="icon_telephone" type="tel" class="validate">'
	 			+'<label for="icon_telephone">Menu name</label>'
	 			+'</div>'
	 			+'<div class="col s2">'
	 			+'<input type="checkbox" id="test6" checked="checked" />'
	 			+'<label for="test6">Sub menu</label>'
	 			+'</div>'
	 			+'<div class="input-field col s3">'
	 			+'<input id="submenu_'+counter+'" type="tel" class="validate" onchange="addinputFields(this.id)" ><br/>'
	 			+'<label for="icon_telephone">No.of sub menu</label>'
	 			+'</div>'
	 			+'<div id="container_'+counter+'" class="input-field col s3">'
	 			+'</div>';
	   
	   
				 var divBox = document.createElement("Div");
				 divBox.id="row_"+counter;
				 divBox.className +="row";
				 divBox.innerHTML=html;
	
		    	document.getElementById("form").appendChild(divBox); 
		    	form.appendChild(divBox);
		    	
		   	 counter++;
	  
}
    function addinputFields(id){
    	debugger;
    	var temp=id.split("_");
    	var counter=temp[1];
    	/* $("container")
    	.empty()
        .remove(); */ 
        var counterId="container_"+counter;
    	document.getElementById(counterId).innerHTML = "";
        var number = document.getElementById(id).value;

        for (i=0;i<number;i++){

            var input = document.createElement("input");
            input.type = "text";
            
            document.getElementById(counterId).appendChild(input);
            document.getElementById(counterId).appendChild(document.createElement("br"));
        }
    }
    
    
    </script>
    
</head>
<body>

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
                         	<form class="col s12"  id="form" >
								  <div class="row"  id="row1">
								    <div class="file-field input-field col s6">
								      <div class="btn">
								        <span>File Logo</span>
								        <input type="file" multiple>
								      </div>
								      <div class="file-path-wrapper">
								        <input class="file-path validate" type="text" placeholder="Upload logo image">
								      </div>
								    </div>
									<div class="input-field col s6">
									 <input id="icon_prefix" type="text" class="validate">
									  <label for="icon_prefix">Main Heading</label>
									</div>
										   <div class="input-field col s3">
									  <input id="icon_telephone" type="tel" class="validate">
									  <label for="icon_telephone">Menu name</label>
									</div>
									<div class="col s2">
								      <input type="checkbox" id="test6" checked="checked" />
								      <label for="test6">Sub menu</label>
								    </div>
								    <div class="input-field col s3">
									  <input id="submenu_1" type="tel" class="validate" onchange="addinputFields(this.id)" ><br />
									  <label for="icon_telephone">No.of sub menu</label>
									</div>
									
									  <div id="container_1" class="input-field col s3">
									  </div>
									</div>
									<button class="btn waves-effect waves-light" id="addButton" type="button" name="action" onclick="addDiv()">Add more
					   					 <i class="material-icons right">add</i>
					  				</button>
									<div class="input-field col s6">
									  <input id="icon_telephone" type="tel" class="validate">
									  <label for="icon_telephone">No.of sliding image</label>
									</div>
									    <div class="file-field input-field col s6">
								      <div class="btn">
								        <span>Select sliding images</span>
								        <input type="file" multiple>
								      </div>
								      <div class="file-path-wrapper">
								        <input class="file-path validate" type="text" placeholder="Upload images">
								      </div>
								    </div>
								    <div class="input-field col s6">
									  <input id="icon_telephone" type="tel" class="validate">
									  <label for="icon_telephone">No.of side menu</label>
									</div>
									<div class="col s3">
								      <input type="checkbox" id="test6" checked="checked" />
								      <label for="test6">Sub menu</label>
								    </div>
								    <div class="input-field col s3">
									  <input id="icon_telephone" type="tel" class="validate">
									  <label for="icon_telephone">sub menu</label>
									</div>
									<button class="btn waves-effect waves-light" type="button" name="action">Submit
				   					 <i class="material-icons right">send</i>
				  					</button>
								  </div>
								</form>
								
							
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
        </div>

</body>
</html>
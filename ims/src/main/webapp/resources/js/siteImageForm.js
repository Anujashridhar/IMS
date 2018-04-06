/*******************************************siteImageform.js*****************************************/
var counter = 2;

function addDiv(){
	   debugger;
	counter=$("#imageCount").val();
	counter=parseInt(counter);
	counter=counter+1;
	$("#imageCount").val(counter);
	   if(counter >= 11){
		   alert("Only 10 images allow");
		   return false;
	   }
	 			var html = '<div class="file-field input-field col s6">'
				      
	 				+'<img alt="no image uploaded" width="200" height="200">'
			     
	 				+'</div>'
	 				+'<div class="file-field input-field col s6">'
	 				+'<div class="btn">'
	 				+'<span>Choose Image</span>'
	 				+'<input  id="imageList'+counter+'.file" type="file" name="imageList['+counter+'].file" onchange="imageValidation(this.id)"/>'
	 				+'<input  id="imageList'+counter+'.imageId" type="hidden" name="imageList['+counter+'].imageId" />'
	 				+'<input  id="imageList'+counter+'.imageType" type="hidden" name="imageList['+counter+'].imageType" />'
	 				+'</div>'
	 				+'<div class="file-path-wrapper">'
	 				+'<input class="file-path validate" type="text" placeholder="choose image" id="imageList'+counter+'.showname">'
	 				+'</div>'
	 				+'</div>'
	 				+'<div class="input-field col s6">'
	 				+'<input  id="orderNo'+counter+'" type="text" name="imageList['+counter+'].imageSequence" />'
	 				+'<label for="icon_telephone">Order No of Image</label>'
	 				+'</div>'
	 				+'<button class="btn waves-effect waves-light red right" type="button" name="action" id="remove_'+counter+'" onclick="removeDiv(this.id)">Remove'
	 				+'<i class="material-icons right">remove_from_queue</i>'
	 				+'</button> ';
	   
	   
	 			var divBox = document.createElement("Div");
	 			 divBox.id="row_"+counter;
	 			 divBox.className +="row";
	 			 divBox.innerHTML=html;
	
		    	document.getElementById("imageBar").appendChild(divBox); 
		    	imageBar.appendChild(divBox);
		    	
		   	 counter++;
	  
}

	

function removeDiv(id){
	debugger;
	var temp=id.split("_");
	var divIdCounter=temp[1];
	
	var divId = "#row_"+divIdCounter;
	 $(divId).remove();
	 counter--;
	
}
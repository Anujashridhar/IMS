var counter = 2;
var locLevelCount=0;
var count = 1;

	  $(".add-more").click(function(e){
		  debugger;
		  var id=this.id;
		  var temp=id.split("_");
			var c=temp.length-1;
			var rowcounter=temp[c];
			var menuCount=document.getElementById("menuCount").value;
			var parent="menu_id_"+rowcounter;
			var parentId=document.getElementById(parent).value;
			var container="container_"+rowcounter;
		  var html1=	
			'<input id="submenu_'+menuCount+'" name="menuDetails['+menuCount+'].menuName" value="" class="validate active valid" type="text">'
			+'<label for="submenu_'+menuCount+'">submenu</label>'
			+'<input id="submenu_u_'+menuCount+'" name="menuDetails['+menuCount+'].menuUrl" type="hidden" value="">'
			+'<input id="submenu_p_'+menuCount+'" name="menuDetails['+menuCount+'].parentId" value="'+parentId+'" class="validate active" type="hidden">'
			+'<input id="submenu_a_'+menuCount+'" name="menuDetails['+menuCount+'].menuId" value="" class="validate active" type="hidden">'
			
			var html2='<button id="add_button_'+menuCount+'" class="btn add-more" type="button" >+</button>'
				+'<button id="remove_button_'+menuCount+'" class="btn remove" type="button" >-</button>';
		  var divBox1 = document.createElement("Div");
			 divBox1.id="submenu_"+rowcounter+"_";
			
			 divBox1.innerHTML=html1;
	
	    	document.getElementById(container).appendChild(divBox1);
	    	  var divBox2 = document.createElement("Div");
			 divBox2.id="container_c_"+menuCount+"_";
			
			 divBox2.innerHTML=html2;
			 var container2="container_b_"+rowcounter;
	    	document.getElementById(container2).appendChild(divBox2)
	
	  });

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
	 			+'<input type="checkbox" id="test'+counter+'" checked="checked" />'
	 			+'<label for="test'+counter+'">Sub menu</label>'
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
	
		    	document.getElementById("menuBar").appendChild(divBox); 
		    	menuBar.appendChild(divBox);
		    	
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

        for (i=1;i<=number;i++){

            var input = document.createElement("input");
            var label = document.createElement("label");
            input.id="submenuName_"+i;
            var div= document.createElement("div");
            div.classList.add('input-field');
            div.id="sub_div_"+counter+"_"+i;

            input.type = "text";
            label.setAttribute("for",input.id);
            label.innerHTML = "Name of SubMenu "+i;
            document.getElementById(counterId).appendChild(div);
            document.getElementById("sub_div_"+counter+"_"+i).appendChild(input);
            document.getElementById("sub_div_"+counter+"_"+i).appendChild(label);
            document.getElementById("sub_div_"+counter+"_"+i).appendChild(document.createElement("br"));
        }
    }
    

    function addLocationFields(id){
    	debugger;
    	
        var number = document.getElementById(id).value;
        number=parseInt(number);
        switch(number)
        {
          case 0:

        	  $("#inputLocLevel1").val("");
        	  $("#inputLocLevel2").val("");
        	  $("#inputLocLevel3").val("");
        	  $("#inputLocLevel4").val("");
        	  $("#locNameDiv1").hide();
        	  $("#locNameDiv2").hide();
        	  $("#locNameDiv3").hide();
        	  $("#locNameDiv4").hide();
        	  break;
          case 1:
        	
        	 
        	  $("#inputLocLevel2").val("");
        	  $("#inputLocLevel3").val("");
        	  $("#inputLocLevel4").val("");
        	  $("#locNameDiv1").show();
        	  $("#locNameDiv2").hide();
        	  $("#locNameDiv3").hide();
        	  $("#locNameDiv4").hide();
        	  break;
          case 2:
        	
        	  $("#inputLocLevel3").val("");
        	  $("#inputLocLevel4").val("");
        	  $("#locNameDiv1").show();
        	  $("#locNameDiv2").show();
        	  $("#locNameDiv3").hide();
        	  $("#locNameDiv4").hide();
        	  break;
          case 3:
        	
        	  $("#inputLocLevel4").val("");
        	  $("#locNameDiv1").show();
        	  $("#locNameDiv2").show();
        	  $("#locNameDiv3").show();
        	  $("#locNameDiv4").hide();
        	  break;
          case 4:
        	
        	  $("#locNameDiv1").show();
        	  $("#locNameDiv2").show();
        	  $("#locNameDiv3").show();
        	  $("#locNameDiv4").show();
        	  break;
        }
        
        // document.getElementById("loc_div").innerHTML="";
       
    }
	function submitForm(e)
	{
		debugger;
	
		//e.preventDefault();
		
		//alert($(e).attr('action'));
		 var formData = $("#siteDetailForm").serialize();
         
         $.ajax({ url : $("#siteDetailForm").attr('action') , 
              type: "POST", 
              data: formData,
          
               success: function (data) { 
               		debugger;
               		
               			console.log(data);
               		
                      $("#frame_div").html(data);
                      
                   }, 
               error: function (jXHR, textStatus, errorThrown) {
                      console.log(textStatus+jXHR+errorThrown)
                   } 
          });
		
	}

	function checkChange(checkId)
	{
		debugger;
		/*if(document.getElementById(checkId).checked)
			{
				var temp=checkId.split("_");
				var c=temp.length-1;
				var rowcounter=temp[c];
				var container="submenu_container_"+rowcounter;}
				var menuCount=document.getElementById("no_of_menus").value;
				var parent="menu_id_"+rowcounter;
				var parentId=document.getElementById(parent).value;
				var submenuCount=document.getElementById("no_of_submenus_in_"+rowcounter).value;
					var html='<div id="submenu_row_'+rowcounter+'_'+submenuCount+'" class="row">'
														
											+'			<div id="submenu_div_'+submenuCount+'" class="input-field col s6">'
															
															+'	<input name="submenu['+submenuCount+'].subMenuName"'
															+'		id="submenu_name_'+menuCount+'_'+submenuCount+'" class="validate active" />'
															+'<input type="hidden" '
															+'	path="submenu['+menuCount+'].subMenuUrl"'
															+'	id="submenu_url_'+menuCount+'_'+submenuCount+'" />'
															+'<input type="hidden"  value="'+parentId+'"'
															+'	path="submenu['+submenuCount+'].parentId"'
															+'	id="submenu_parentId_'+menuCount+'_'+submenuCount+'" class="validate active" />'
															+'<input type="hidden" '
															+'	path="submenu['+submenuCount+'].subMenuId"'
															+'	id="submenu_id_'+menuCount+'_'+submenuCount+'" class="validate active" />'
														+'</div>'
														+'<div id="button_div_'+menuCount+'"	class="input-field col s6">'
																
												+'<button id="remove_button_'+menuCount+'" class="btn add-more" type="button">-</button>'
												+'<button id="add_button_'+menuCount+'" class="btn add-more"	type="button">+</button>'
												+'</div>'	
												+'</div>';
				document.getElementById("menuCount").value=menuCount+1;
				document.getElementById("no_of_submenus_in_"+rowcounter).value=submenuCount+1;
				
				 var divBox = document.createElement("Div");
				 divBox.id="submenu_"+rowcounter+"_";
				
				 divBox.innerHTML=html;
		
		    	//document.getElementById(container).appendChild(divBox); 
		    	document.getElementById(container).innerHTML=html;
			}else{
				var temp=checkId.split("_");
				var c=temp.length-1;
				var rowcounter=temp[c];
				var container="container_b_"+rowcounter;
				document.getElementById(container).innerHTML="";
			}*/
	}

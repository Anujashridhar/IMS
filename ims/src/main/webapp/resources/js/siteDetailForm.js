


function checkChange(checkId)
	{
	var temp=checkId.split("_");
	var c=temp.length-1;
	var rowcounter=temp[c];
	var container="submenu_container_"+rowcounter;
//	var menuCount=document.getElementById("no_of_menus").value;
	var menuCount=rowcounter;
	var parent="menu_id_"+rowcounter;
	var parentId=document.getElementById(parent).value;
	var submenuCount=document.getElementById("no_of_submenus_in_"+rowcounter).value;
		debugger;
		if(document.getElementById(checkId).checked)
			{
				
				var exlsubmenuCount=document.getElementById("no_of_total_submenus").value;
				exlsubmenuCount=parseInt(exlsubmenuCount)+1;
				document.getElementById("no_of_total_submenus").value=exlsubmenuCount;
				submenuCount=parseInt(submenuCount)+1
				document.getElementById("no_of_submenus_in_"+rowcounter).value=submenuCount;
				
					var html='<div id="submenu_row_'+rowcounter+'_'+submenuCount+'" class="row">'
														
											+'			<div id="submenu_div_'+submenuCount+'" class="input-field col s6">'
															
															+'	<input name="submenu['+exlsubmenuCount+'].subMenuName"'
															+'		id="submenu_name_'+menuCount+'_'+submenuCount+'" class="validate active" />'
															+'<input type="hidden" '
															+'	name="submenu['+exlsubmenuCount+'].subMenuUrl"'
															+'	id="submenu_url_'+menuCount+'_'+submenuCount+'" />'
															+'<input type="hidden"  value="'+parentId+'"'
															+'	name="submenu['+exlsubmenuCount+'].parentId"'
															+'	id="submenu_parentId_'+menuCount+'_'+submenuCount+'" class="validate active" />'
															+'<input type="hidden" '
															+'	name="submenu['+exlsubmenuCount+'].subMenuId"'
															+'	id="submenu_id_'+menuCount+'_'+submenuCount+'" class="validate active" />'
														+'</div>'
														+'<div id="button_div_'+menuCount+'_'+submenuCount+'"	class="input-field col s6">'
																
												+'<button id="remove_button_'+menuCount+'_'+submenuCount+'" class="btn add-more" type="button" onclick="deleteSubmenu(this.id)">-</button>'
												+'<button id="add_button_'+menuCount+'" class="btn add-more"	type="button" onclick="addMoreSubmenu(this.id)">+</button>'
												+'</div>'
												
												+'</div>';
					/*var idtoappend="#no_of_submenus_in_"+menuCount;
					
					$(html).insertBefore(idtoappend);
		    	*/
					
					var replaceId="#submenu_container_"+menuCount;
					$(replaceId).html(html);
					
			}else{
				var temp=checkId.split("_");
				var c=temp.length-1;
				var rowcounter=temp[c];
				var container="submenu_container_"+rowcounter;
				document.getElementById(container).innerHTML="";
				
				/*var idToRemove="#submenu_row_"+menuCount+"_"+submenuCount;
				$(idToRemove).remove();
				document.getElementById("no_of_submenus_in_"+rowcounter).value=0;
				*/
			}
	}

function addDiv(){
	 var oldMenuCount=document.getElementById("no_of_menus").value;
		var menuCount=parseInt(oldMenuCount)+1;
	   debugger;
	   var i="#menu_row_"+oldMenuCount;
	   var l=$(i).siblings('.menu').length;
	   l=l+1;//count himself
	   if(l >= 6){
		   alert("Only 6 menu allow")
		   return false;
	   }
	   
	   document.getElementById("no_of_menus").value=menuCount;
	 			var html = '<div class="row menu" id="menu_row_'+menuCount+'">'
					
							+'<div class="input-field col s3">'
							+'<input name="menuDetails['+menuCount+'].menuName"'
							+'	id="menu_name_'+menuCount+' }" class="validate active" />'
							+'	<label for="menu_name_'+menuCount+'" class="active">Menu name</label>'
							+'<input type="hidden" name="menuDetails['+menuCount+'].menuUrl"'
							+'	id="menu_url_'+menuCount+'" />'
							+'<input type="hidden" value="0"'
							+'	name="menuDetails['+menuCount+'].parentId"'
							+'	id="menu_parent_'+menuCount+'" class="validate active" />'
							+'<input type="hidden" name="menuDetails['+menuCount+'].menuId"'
							+'	id="menu_id_'+menuCount+'" class="validate active" value="'+menuCount+'"/>'
							
						+'</div>'
						+'<div class="col s2" id="check_div_'+menuCount+'">'
							+'	<input type="checkbox" id="check_'+menuCount+'"'
								+'	onchange="checkChange(this.id)" />'
								+'<label for="check_'+menuCount+'">Sub menu</label>'
						+'</div>'
						
						+'<div class="col s6" id="submenu_container_'+menuCount+'">'
						+'</div>'
						+'<input type="hidden" value="0" id="no_of_submenus_in_'+menuCount+'">'
						
						+' <div class="col s1">'
						+' <button id="delete_button_'+menuCount+'" class="btn add-more glyphicon glyphicon-remove"	type="button" onclick="deleteMenu(this.id)"></button>'
					
					+' </div>'		
		+'</div>';
	   
	   
	 			 var divBox = document.createElement("Div");
				 divBox.id="row_"+menuCount;
				 divBox.className +="row";
				 divBox.innerHTML=html;
				 var id="#menu_row_"+oldMenuCount;
		    	//$(html).insertAfter(id); 
		    	$("#menusTopDiv").append(html);
}



function addMoreSubmenu(buttonId){
	  debugger;
	  var temp=buttonId.split("_");
		var c=temp.length-1;
		var rowcounter=temp[c];
		var menuCount=rowcounter;
		var parent="menu_id_"+rowcounter;
		var parentId=document.getElementById(parent).value;
		var prevSubmenuCount=document.getElementById("no_of_submenus_in_"+rowcounter).value;
		
		var submenuCount=parseInt(prevSubmenuCount)+1;
		document.getElementById("no_of_submenus_in_"+rowcounter).value=submenuCount;
		var exlsubmenuCount=document.getElementById("no_of_total_submenus").value;
		exlsubmenuCount=parseInt(exlsubmenuCount)+1;
		document.getElementById("no_of_total_submenus").value=exlsubmenuCount;
		
		var addbuttonid="#add_button_"+menuCount;
		$(addbuttonid).remove();
	  var html='<div id="submenu_row_'+menuCount+'_'+submenuCount+'" class="row">	'
	  				+'<div id="submenu_div_'+submenuCount+'" class="input-field col s6">'
	  				+'<input name="submenu['+exlsubmenuCount+'].subMenuName" id="submenu_name_'+menuCount+'_'+submenuCount+'" class="validate active">'
	  				+'<input type="hidden" name="submenu['+exlsubmenuCount+'].subMenuUrl" id="submenu_url_'+menuCount+'_'+submenuCount+'">'
	  				+'<input type="hidden" value="'+parentId+'" name="submenu['+exlsubmenuCount+'].parentId" id="submenu_parentId_'+menuCount+'_'+submenuCount+'" class="validate active">'
	  				+'<input type="hidden" name="submenu['+exlsubmenuCount+'].subMenuId" id="submenu_id_'+menuCount+'_'+submenuCount+'" class="validate active">'
	  				+'</div>'
	  				+'<div id="button_div_'+menuCount+'_'+submenuCount+'" class="input-field col s6">'
	  				+'<button id="remove_button_'+menuCount+'_'+submenuCount+'" class="btn add-more" type="button" onclick="deleteSubmenu(this.id)">-</button>'
	  				+'<button id="add_button_'+menuCount+'" class="btn add-more" type="button" onclick="addMoreSubmenu(this.id)">+</button>'
	  				+'</div>'
	  				+'</div>';

	  var id="#submenu_row_"+menuCount+"_"+prevSubmenuCount;
		
		$(html).insertAfter(id);

}

function deleteSubmenu(buttonId)
{
	debugger;
	var temp=buttonId.split("_");
	var c=temp.length-1;
	var submenuCount=temp[c];
	c=c-1;
	var menuCount=temp[c];
	var lastSubmenuCount=document.getElementById("no_of_submenus_in_"+menuCount).value;
	if(submenuCount==lastSubmenuCount &&  submenuCount!=1)
		{
		var prevSubmenuCount=parseInt(submenuCount)-1;
	
		var divid="#submenu_row_"+menuCount+"_"+submenuCount;
		var d= $(divid).prev();
		var prevId=d.attr('id');
		var arr=prevId.split("_");
		var d=arr.length-1;
		var pSubmenuCount=arr[d];
		d=d-1;
		var pMenuCount=arr[d];
		var pButtonDivId="#button_div_"+pMenuCount+"_"+pSubmenuCount;
		 $(pButtonDivId).append('<button id="add_button_'+menuCount+'" class="btn add-more" type="button" onclick="addMoreSubmenu(this.id)">+</button>');
		 
		}
	var id="#submenu_row_"+menuCount+"_"+submenuCount;
	
	$(id).remove();

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

function deleteMenu(deleteButtonId)
{
	debugger;
	var temp=deleteButtonId.split("_");
	var c=temp.length-1;
	
	var menuCount=temp[c];
	var idToDelete="#menu_row_"+menuCount;
	var l=$(idToDelete).siblings('.row').length;
	if(l==0)
		{
		
		}else{
	$(idToDelete).remove();
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
    	  $("#locNameDiv1").addClass("locdivcss");
    	  $("#locNameDiv2").addClass("locdivcss");
    	  $("#locNameDiv3").addClass("locdivcss");
    	  $("#locNameDiv4").addClass("locdivcss");
    	  /*
    	  $("#locNameDiv1").hide();
    	  $("#locNameDiv2").hide();
    	  $("#locNameDiv3").hide();
    	  $("#locNameDiv4").hide();
    	  */break;
      case 1:
    	
    	 
    	  $("#inputLocLevel2").val("");
    	  $("#inputLocLevel3").val("");
    	  $("#inputLocLevel4").val("");
    	  
    	  $("#locNameDiv1").removeClass("locdivcss");
    	  $("#locNameDiv2").addClass("locdivcss");
    	  $("#locNameDiv3").addClass("locdivcss");
    	  $("#locNameDiv4").addClass("locdivcss");
    	  
    	 /* $("#locNameDiv1").show();
    	  $("#locNameDiv2").hide();
    	  $("#locNameDiv3").hide();
    	  $("#locNameDiv4").hide();*/
    	  break;
      case 2:
    	
    	  $("#inputLocLevel3").val("");
    	  $("#inputLocLevel4").val("");
    	  
    	  $("#locNameDiv1").removeClass("locdivcss");
    	  $("#locNameDiv2").removeClass("locdivcss");
    	  $("#locNameDiv3").addClass("locdivcss");
    	  $("#locNameDiv4").addClass("locdivcss");
    	  
    	  /*$("#locNameDiv1").show();
    	  $("#locNameDiv2").show();
    	  $("#locNameDiv3").hide();
    	  $("#locNameDiv4").hide();*/
    	  break;
      case 3:
    	
    	  $("#inputLocLevel4").val("");
    	  
    	  $("#locNameDiv1").removeClass("locdivcss");
    	  $("#locNameDiv2").removeClass("locdivcss");
    	  $("#locNameDiv3").removeClass("locdivcss");
    	  $("#locNameDiv4").addClass("locdivcss");
    	  
    	  
    	  /*$("#locNameDiv1").show();
    	  $("#locNameDiv2").show();
    	  $("#locNameDiv3").show();
    	  $("#locNameDiv4").hide();*/
    	  break;
      case 4:
    	  $("#locNameDiv1").removeClass("locdivcss");
    	  $("#locNameDiv2").removeClass("locdivcss");
    	  $("#locNameDiv3").removeClass("locdivcss");
    	  $("#locNameDiv4").removeClass("locdivcss");
    	  
    	  /*
    	  $("#locNameDiv1").show();
    	  $("#locNameDiv2").show();
    	  $("#locNameDiv3").show();
    	  $("#locNameDiv4").show();
    	  */break;
    	  
    default :
    	alert("only four levels are allowed");
    }
  /*  var l=$("#loc_div > div").length;
    document.getElementById(id).value=l;*/
    // document.getElementById("loc_div").innerHTML="";
   
}
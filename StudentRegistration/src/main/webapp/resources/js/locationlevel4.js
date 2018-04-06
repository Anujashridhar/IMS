$("#countryId").on("change",function(e) 
	{
	 //alert("hi");
	 var a=$("#countryId").val();  
	// alert("country"+a);
	 getvalues("GetLocationLevel1?countryId="+a, "locLevel1Id");
     $("#locLevel1Id").prop("disabled", false);
     //alert("vye");
    });

$("#locLevel1Id").on("change",function(e) 
		{
	 	 var a=$("#countryId").val(); 
		 var b=$("#locLevel1Id").val();  
		// alert("country"+a);
		 getvalues("GetLocationLevel2?countryId="+a+"&locLevel1Id="+b, "locLevel2Id");
	     $("#locLevel2Id").prop("disabled", false);
	     //alert("vye");
	    });

$("#locLevel2Id").on("change",function(e) 
		{
	 	 var a=$("#countryId").val(); 
		 var b=$("#locLevel1Id").val();  
		 var c=$("#locLevel2Id").val();
		 getvalues("GetLocationLevel3?countryId="+a+"&locLevel1Id="+b+"&locLevel2Id="+c, "locLevel3Id");
	     $("#locLevel3Id").prop("disabled", false);
	    });


function getvalues(url,id) 
{
	debugger;

		$.ajax({

			type: "GET",
			url: url,
			success: function (data) {
				debugger;//alert(data);
				var abc = "<option value='0'></option>";
				for( var a = 0; a<data.datamap.length;a++)
					{
					abc += "<option value='"+data.datamap[a].IntegerKey+"'>"
					+data.datamap[a].value+"</option>";
					}
				$("#"+id).html(abc);
					
					
			},

			 error: function(xhr, status, error) {
				  debugger;//  alert(xhr.responseText);
				 }

			});
}

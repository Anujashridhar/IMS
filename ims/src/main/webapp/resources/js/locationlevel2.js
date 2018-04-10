$("#countryId").on("change",function(e) 
	{
	 //alert("hi");
	 var a=$("#countryId").val();  
	 //alert("country"+a);
	 getvalues(ctx+"/site/admin/GetLocationLevel1?countryId="+a, "locLevel1Id");
     $("#locLevel1Id").prop("disabled", false);
     //alert("vye");
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
				for( var a = 0; a<data.dataMap.length;a++)
					{
					abc += "<option value='"+data.dataMap[a].IntegerKey+"'>"
					+data.dataMap[a].value+"</option>";
					}
				$("#"+id).html(abc);
					
					
			},

			 error: function(xhr, status, error) {
				  debugger;//  alert(xhr.responseText);
				 }

			});
}

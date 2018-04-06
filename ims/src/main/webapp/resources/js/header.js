 
        function getContent(url)
        {
        	debugger;
        	$.ajax({url: url, success: function(result){
            	debugger;
                $("#frame_div").html(result);
               
            }});
        }
    